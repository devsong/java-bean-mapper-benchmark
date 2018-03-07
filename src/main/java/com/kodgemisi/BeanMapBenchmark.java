package com.kodgemisi;

import fr.xebia.extras.selma.Selma;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.apache.commons.beanutils.BeanUtils;
import org.dozer.DozerBeanMapperBuilder;
import org.dozer.Mapper;
import org.openjdk.jmh.annotations.*;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

@Warmup(iterations = 5)
@Fork(value = 1, warmups = 0)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Measurement(iterations = 3, batchSize = 100000, time = 5)
public class BeanMapBenchmark {

    @State(value = Scope.Thread)
    public static class DemoState {

        private MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        private BoundMapperFacade<MySimpleDto, MySimpleResponse> boundMapper = mapperFactory.getMapperFacade(MySimpleDto.class, MySimpleResponse.class);

        private SelmaMapper selmaMapper = Selma.mapper(SelmaMapper.class);

        private Mapper dozerMapper = DozerBeanMapperBuilder.buildDefault();
    }

    @Benchmark
    public MySimpleResponse mapStruct() {

        MySimpleDto dto = new MySimpleDto(1, "Fatih", "ERDEM", 25);

        MySimpleResponse response = MapStructMapper.INSTANCE.convertTo(dto);

        return response;

    }

    @Benchmark
    public MySimpleResponse selma(DemoState state) {

        MySimpleDto dto = new MySimpleDto(1, "Fatih", "ERDEM", 25);

        MySimpleResponse response = state.selmaMapper.convertTo(dto);

        return response;

    }

    @Benchmark
    public MySimpleResponse orika(DemoState state) {

        MySimpleDto dto = new MySimpleDto(1, "Fatih", "ERDEM", 25);

        MySimpleResponse response = state.boundMapper.map(dto);

        return response;

    }

    @Benchmark
    public MySimpleResponse dozer(DemoState state) {

        MySimpleDto dto = new MySimpleDto(1, "Fatih", "ERDEM", 25);

        MySimpleResponse response = state.dozerMapper.map(dto, MySimpleResponse.class);

        return response;

    }

    @Benchmark
    public MySimpleResponse beanUtils() throws InvocationTargetException, IllegalAccessException {

        MySimpleDto dto = new MySimpleDto(1, "Fatih", "ERDEM", 25);

        MySimpleResponse response = new MySimpleResponse();
        BeanUtils.copyProperties(response, dto);

        return response;

    }

    @Benchmark
    public MySimpleResponse setterGetter() {

        MySimpleDto dto = new MySimpleDto(1, "Fatih", "ERDEM", 25);

        MySimpleResponse response = new MySimpleResponse();

        response.setId(dto.getId());
        response.setName(response.getName());
        response.setSurname(response.getSurname());
        response.setAge(response.getAge());

        return response;
    }
}
