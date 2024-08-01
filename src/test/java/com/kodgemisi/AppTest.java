package com.kodgemisi;

import lombok.SneakyThrows;
import org.junit.Test;

public class AppTest {

    @Test
    public void mapstruct_map_test() {
        BeanMapBenchmark beanMapBenchmark = new BeanMapBenchmark();
        MySimpleResponse resp = beanMapBenchmark.mapStruct();
        System.out.println(resp);
    }

    @Test
    public void selma_map_test() {
        BeanMapBenchmark beanMapBenchmark = new BeanMapBenchmark();
        MySimpleResponse resp = beanMapBenchmark.selma();
        System.out.println(resp);
    }

    @Test
    public void model_mapper_map_test() {
        BeanMapBenchmark beanMapBenchmark = new BeanMapBenchmark();
        BeanMapBenchmark.DemoState state = new BeanMapBenchmark.DemoState();
        MySimpleResponse resp = beanMapBenchmark.modelMapper(state);
        System.out.println(resp);
    }

    @Test
    public void dozer_map_test() {
        BeanMapBenchmark beanMapBenchmark = new BeanMapBenchmark();
        BeanMapBenchmark.DemoState state = new BeanMapBenchmark.DemoState();
        MySimpleResponse resp = beanMapBenchmark.dozer(state);
        System.out.println(resp);
    }

    @Test
    public void orika_map_test() {
        BeanMapBenchmark beanMapBenchmark = new BeanMapBenchmark();
        BeanMapBenchmark.DemoState state = new BeanMapBenchmark.DemoState();
        MySimpleResponse resp = beanMapBenchmark.orika(state);
        System.out.println(resp);
    }

    @Test
    public void jmapper_map_test() {
        BeanMapBenchmark beanMapBenchmark = new BeanMapBenchmark();
        BeanMapBenchmark.DemoState state = new BeanMapBenchmark.DemoState();
        MySimpleResponse resp = beanMapBenchmark.jMapper(state);
        System.out.println(resp);
    }

    @Test
    @SneakyThrows
    public void apache_bean_utils_map_test() {
        BeanMapBenchmark beanMapBenchmark = new BeanMapBenchmark();
        MySimpleResponse resp = beanMapBenchmark.apacheCommonsBeanUtils();
        System.out.println(resp);
    }

    @Test
    @SneakyThrows
    public void spring_bean_utils_map_test() {
        BeanMapBenchmark beanMapBenchmark = new BeanMapBenchmark();
        MySimpleResponse resp = beanMapBenchmark.springBeanUtils();
        System.out.println(resp);
    }

    @Test
    @SneakyThrows
    public void get_set_map_test() {
        BeanMapBenchmark beanMapBenchmark = new BeanMapBenchmark();
        MySimpleResponse resp = beanMapBenchmark.setterGetter();
        System.out.println(resp);
    }

}
