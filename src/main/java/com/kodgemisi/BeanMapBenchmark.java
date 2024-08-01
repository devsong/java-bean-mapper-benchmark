package com.kodgemisi;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import com.googlecode.jmapper.JMapper;
import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.apache.commons.beanutils.BeanUtils;
import org.modelmapper.ModelMapper;
import org.openjdk.jmh.annotations.*;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

@Warmup(iterations = 3)
@Fork(value = 1, warmups = 0)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Measurement(iterations = 3, batchSize = 10000, time = 5)
public class BeanMapBenchmark {

    public static final MySimpleDto src = new MySimpleDto(1, "Fatih", "ERDEM", 25);

    @State(value = Scope.Thread)
    public static class DemoState {
        private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        private final BoundMapperFacade<MySimpleDto, MySimpleResponse> boundMapper = mapperFactory.getMapperFacade(MySimpleDto.class, MySimpleResponse.class);

        private final Mapper dozerMapper = DozerBeanMapperBuilder.buildDefault();

        private final ModelMapper modelMapper = new ModelMapper();

        private final JMapper<MySimpleResponse, MySimpleDto> jMapper = new JMapper<>(MySimpleResponse.class, MySimpleDto.class);
    }

    @Benchmark
    public MySimpleResponse mapStruct() {
        MySimpleDto dto = createDto();
        return MapStructMapper.INSTANCE.convertTo(dto);

    }

    @Benchmark
    public MySimpleResponse selma() {
        MySimpleDto dto = createDto();
        return SelmaMapper.INST.convertTo(dto);

    }

    @Benchmark
    public MySimpleResponse orika(DemoState state) {
        MySimpleDto dto = createDto();
        return state.boundMapper.map(dto);

    }

    @Benchmark
    public MySimpleResponse dozer(DemoState state) {
        MySimpleDto dto = createDto();
        return state.dozerMapper.map(dto, MySimpleResponse.class);
    }

    @Benchmark
    public MySimpleResponse apacheCommonsBeanUtils() throws InvocationTargetException, IllegalAccessException {
        MySimpleDto dto = createDto();
        MySimpleResponse response = new MySimpleResponse();
        BeanUtils.copyProperties(response, dto);
        return response;
    }

    @Benchmark
    public MySimpleResponse springBeanUtils() {
        MySimpleDto dto = createDto();
        MySimpleResponse response = new MySimpleResponse();
        org.springframework.beans.BeanUtils.copyProperties(dto, response);
        return response;
    }

    @Benchmark
    public MySimpleResponse modelMapper(DemoState demoState) {
        MySimpleDto dto = createDto();
        return demoState.modelMapper.map(dto, MySimpleResponse.class);
    }

    @Benchmark
    public MySimpleResponse jMapper(DemoState demoState) {
        MySimpleDto dto = createDto();
        return demoState.jMapper.getDestination(dto);
    }

    public static MySimpleDto createDto() {
        return src;
    }

    @Benchmark
    public MySimpleResponse setterGetter() {
        MySimpleDto dto = createDto();
        MySimpleResponse response = new MySimpleResponse();
        response.setId(dto.getId());
        response.setName(dto.getName());
        response.setSurname(dto.getSurname());
        response.setAge(dto.getAge());
        return response;
    }
}
