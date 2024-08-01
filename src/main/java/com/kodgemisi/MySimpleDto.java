package com.kodgemisi;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class MySimpleDto {

    private int id;
    private String name;
    private String surname;
    private int age;

    public MySimpleDto(int id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
