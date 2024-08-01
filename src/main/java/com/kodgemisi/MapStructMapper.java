package com.kodgemisi;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapStructMapper {

    MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);

    MySimpleResponse convertTo(MySimpleDto dto);

    OrderResponse convertTo(OrderDto orderDto);
}
