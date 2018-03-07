package com.kodgemisi;


import fr.xebia.extras.selma.Mapper;

@Mapper
public interface SelmaMapper {

    MySimpleResponse convertTo(MySimpleDto dto);

}
