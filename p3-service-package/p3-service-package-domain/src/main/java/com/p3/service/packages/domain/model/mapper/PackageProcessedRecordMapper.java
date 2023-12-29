package com.p3.service.packages.domain.model.mapper;

@FunctionalInterface
public interface PackageProcessedRecordMapper<T> {

    T map(Integer id, String ticketsNum, Double weight, Double length, Double width, Double height, Double volume, String machine);

}
