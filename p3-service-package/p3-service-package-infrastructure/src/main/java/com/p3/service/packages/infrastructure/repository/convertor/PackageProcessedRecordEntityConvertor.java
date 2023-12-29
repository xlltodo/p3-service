package com.p3.service.packages.infrastructure.repository.convertor;

import com.p3.service.packages.domain.model.entity.PackageProcessedRecord;
import com.p3.service.packages.domain.model.factory.PackageProcessedRecordFactory;
import com.p3.service.packages.infrastructure.repository.entity.PackageProcessedRecordEntity;

public class PackageProcessedRecordEntityConvertor {

    public static PackageProcessedRecordEntity convertToDataEntity(PackageProcessedRecord packageProcessedRecord) {

        return packageProcessedRecord.mapWith((id, ticketsNum, weight, length, width, height, volume, machine) -> new PackageProcessedRecordEntity()
                .setId(id)
                .setTicketsNum(ticketsNum)
                .setWeight(weight)
                .setLength(length)
                .setWidth(width)
                .setHeight(height)
                .setVolume(volume)
                .setMachine(machine));
    }

    public static PackageProcessedRecord convertToDomainEntity(PackageProcessedRecordEntity entity) {

        return PackageProcessedRecordFactory.create(entity.getId(), entity.getTicketsNum(), entity.getWeight(), entity.getLength(), entity.getWidth(), entity.getHeight(), entity.getVolume(), entity.getMachine());
    }
}
