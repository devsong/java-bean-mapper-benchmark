package com.kodgemisi;

import com.googlecode.jmapper.annotations.JMap;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class MySimpleResponse {

    @JMap
    private int id;
    @JMap
    private String name;
    @JMap
    private String surname;
    @JMap
    private int age;
}
