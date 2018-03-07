# Java Bean Mapper Bechmark

This project is developed for performance benchmark for Java bean mapper libraries. 

I used five library for compare which are:

1. MapStruct
2. Selma
3. Orika
4. Dozer
5. Apache BeanUtils

And of course there is good old Setter-Getter. 

## Result of the benchmark for 100.000 iterations of simple object mapping:

```
Benchmark                      Mode  Cnt    Score      Error  Units
BeanMapBenchmark.beanUtils     avgt    3  501,090 ±    3,345  ms/op
BeanMapBenchmark.dozer         avgt    3  556,256 ± 1761,162  ms/op
BeanMapBenchmark.orika         avgt    3   29,662 ±   27,655  ms/op
BeanMapBenchmark.selma         avgt    3    0,766 ±    0,261  ms/op
BeanMapBenchmark.mapStruct     avgt    3    0,716 ±    0,887  ms/op
BeanMapBenchmark.setterGetter  avgt    3    0,710 ±    0,698  ms/op
```
