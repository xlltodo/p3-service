package com.p3.service.packages.application.assembler;

import com.p3.service.packages.application.command.DevicePackageDataCommand;
import com.p3.service.packages.domain.model.entity.PackageProcessedRecord;
import com.p3.service.packages.domain.model.factory.PackageProcessedRecordFactory;
import com.p3.service.packages.infrastructure.client.dto.ForecastExpressReceiptDTO;

public class PackageProcessedRecordAssembler {

    public static PackageProcessedRecord toEntity(DevicePackageDataCommand command) {
        return PackageProcessedRecordFactory.create(
                null,
                command.getTicketsNum(),
                command.getWeight(),
                command.getLength(),
                command.getWidth(),
                command.getHeight(),
                command.getVolume(),
                command.getMachine()
        );
    }

    public static ForecastExpressReceiptDTO toDto(DevicePackageDataCommand command) {
        return new ForecastExpressReceiptDTO()
                ;
    }
}
