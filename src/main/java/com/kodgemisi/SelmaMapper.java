package com.kodgemisi;


import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Selma;

@Mapper
public interface SelmaMapper {

    SelmaMapper INST = Selma.mapper(SelmaMapper.class);

    MySimpleResponse convertTo(MySimpleDto dto);

    OrderResponse convertTo(OrderDto orderDto);

}
