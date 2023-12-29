package com.p3.service.packages.domain.model.factory;

import com.p3.service.packages.domain.model.entity.PackageProcessedRecord;

public class PackageProcessedRecordFactory {

    public static PackageProcessedRecord create(Integer id, String ticketsNum, Double weight, Double length, Double width, Double height, Double volume, String machine) {

        return new PackageProcessedRecord(id, ticketsNum, weight, length, width, height, volume, machine);
    }
}
