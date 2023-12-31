package com.p3.service.packages.application.handler;

import com.p3.service.packages.application.assembler.PackageProcessedRecordAssembler;
import com.p3.service.packages.application.command.DevicePackageDataCommand;
import com.p3.service.packages.domain.model.entity.PackageProcessedRecord;
import com.p3.service.packages.domain.repository.IPackageProcessedRecordRepository;
import com.p3.service.packages.infrastructure.client.P3WmsClient;
import com.p3.service.packages.infrastructure.client.dto.ForecastExpressReceiptDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class DevicePackageDataCommandHandler {

    @Resource
    private IPackageProcessedRecordRepository repository;
    @Lazy
    @Resource
    private P3WmsClient p3WmsClient;

    public Boolean passAndSign(DevicePackageDataCommand command) {

        Optional<PackageProcessedRecord> packageProcessedRecordOptional = Optional.ofNullable(repository.save(PackageProcessedRecordAssembler.toEntity(command)));
        packageProcessedRecordOptional.ifPresent(PackageProcessedRecord::sendExpressPackageReceipt);
        List<ForecastExpressReceiptDTO> forecastExpressReceiptDTOS = Collections.singletonList(new ForecastExpressReceiptDTO()
                .setExpressNumber(command.getTicketsNum())
                .setLength(command.getLength())
                .setWidth(command.getWidth())
                .setHeight(command.getHeight())
                .setWeight(command.getWeight())
                .setVolume(command.getVolume())
                .setMachine(command.getMachine())
        );
        log.info("签收包裹参数：{}", forecastExpressReceiptDTOS);
        log.info("签收包裹响应：{}", p3WmsClient.expressReceipt(forecastExpressReceiptDTOS));
        return packageProcessedRecordOptional.isPresent();
    }

}
