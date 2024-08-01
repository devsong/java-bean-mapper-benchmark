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
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Warmup(iterations = 3)
@Fork(value = 1, warmups = 0)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Measurement(iterations = 3, batchSize = 10000, time = 5)
public class BeanMapBenchmarkForOrder {

    public static final OrderDto src = OrderDto.builder()
            .orderId(1L)
            .bt(1)
            .id(1L)
            .ct(1)
            .adt(new Date())
            .dt(1)
            .oid("oid")
            .did(1L)
            .eoid(1L)
            .ea("endAdcode")
            .ead("endAddress")
            .gmc(new Date())
            .gm(new Date())
            .op(1L)
            .mu("modifiedUser")
            .obf(1L)
            .os(1)
            .ot(1)
            .pct(new Date())
            .pid(1L)
            .pt(1)
            .ps(1)
            .rtt(1)
            .st(1)
            .source("source")
            .sa("startAdcode")
            .sad("startAddress")
            .tid(1L)
            .build();

    @State(value = Scope.Thread)
    public static class DemoState {
        private final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

        private final BoundMapperFacade<OrderDto, OrderResponse> boundMapper = mapperFactory.getMapperFacade(OrderDto.class, OrderResponse.class);

        private final Mapper dozerMapper = DozerBeanMapperBuilder.buildDefault();

        private final ModelMapper modelMapper = new ModelMapper();

        private final JMapper<OrderResponse, OrderDto> jMapper = new JMapper<>(OrderResponse.class, OrderDto.class);
    }

    @Benchmark
    public OrderResponse mapStruct() {
        OrderDto dto = createDto();
        return MapStructMapper.INSTANCE.convertTo(dto);

    }

    @Benchmark
    public OrderResponse selma() {
        OrderDto dto = createDto();
        return SelmaMapper.INST.convertTo(dto);

    }

    @Benchmark
    public OrderResponse orika(DemoState state) {
        OrderDto dto = createDto();
        return state.boundMapper.map(dto);

    }

    @Benchmark
    public OrderResponse dozer(DemoState state) {
        OrderDto dto = createDto();
        return state.dozerMapper.map(dto, OrderResponse.class);
    }

    @Benchmark
    public OrderResponse apacheCommonsBeanUtils() throws InvocationTargetException, IllegalAccessException {
        OrderDto dto = createDto();
        OrderResponse response = new OrderResponse();
        BeanUtils.copyProperties(response, dto);
        return response;
    }

    @Benchmark
    public OrderResponse springBeanUtils() {
        OrderDto dto = createDto();
        OrderResponse response = new OrderResponse();
        org.springframework.beans.BeanUtils.copyProperties(dto, response);
        return response;
    }

    @Benchmark
    public OrderResponse modelMapper(DemoState demoState) {
        OrderDto dto = createDto();
        return demoState.modelMapper.map(dto, OrderResponse.class);
    }

    @Benchmark
    public OrderResponse jMapper(DemoState demoState) {
        OrderDto dto = createDto();
        return demoState.jMapper.getDestination(dto);
    }

    public static OrderDto createDto() {
        return src;
    }

    @Benchmark
    public OrderResponse setterGetter() {
        OrderDto dto = createDto();
        OrderResponse response = new OrderResponse();
        response.setOrderId(dto.getOrderId());
        response.setOrderState(dto.getOs());
        response.setBizType(dto.getBt());
        response.setSource(dto.getSource());
        response.setId(dto.getId());
        response.setTenantId(dto.getTid());
        response.setDriverId(dto.getDid());
        response.setPassengerId(dto.getPid());
        response.setEtravelOrderId(dto.getEoid());
        response.setOid(dto.getOid());
        response.setModifiedUser(dto.getMu());
        response.setRealTimeType(dto.getRtt());
        response.setOrderType(dto.getOt());
        response.setServiceType(dto.getSt());
        response.setPassengerType(dto.getPt());
        response.setCancelType(dto.getCt());
        response.setDispatchType(dto.getDt());
        response.setPaymentState(dto.getPs());
        response.setPassCreateTime(dto.getPct());
        response.setDepartTime(dto.getAdt());
        response.setStartAdcode(dto.getSa());
        response.setEndAdcode(dto.getEa());
        response.setEndAddress(dto.getEad());
        response.setGmtModified(dto.getGm());
        response.setGmtCreate(dto.getGmc());
        response.setOrderProperties(dto.getOp());
        response.setOrderBizFlag(dto.getObf());
        return response;
    }
}
