package com.p3.service.packages.application.handler;

import com.p3.service.packages.application.assembler.PackageProcessedRecordAssembler;
import com.p3.service.packages.application.command.DevicePackageDataCommand;
import com.p3.service.packages.domain.model.entity.PackageProcessedRecord;
import com.p3.service.packages.domain.repository.IPackageProcessedRecordRepository;
import com.p3.service.packages.infrastructure.client.ForecastExpressClient;
import com.p3.service.packages.infrastructure.client.dto.ForecastExpressReceiptDTO;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class DevicePackageDataCommandHandler {

    @Resource
    private IPackageProcessedRecordRepository repository;
    @Lazy
    @Resource
    private ForecastExpressClient forecastExpressClient;

    public Boolean passAndSign(DevicePackageDataCommand command) {

        Optional<PackageProcessedRecord> packageProcessedRecordOptional = Optional.ofNullable(repository.save(PackageProcessedRecordAssembler.toEntity(command)));
        packageProcessedRecordOptional.ifPresent(PackageProcessedRecord::sendExpressPackageReceipt);
        log.info("签收包裹：{}", forecastExpressClient.expressReceipt(new ForecastExpressReceiptDTO().setExpressNumber(command.getMachine())));
        return packageProcessedRecordOptional.isPresent();
    }

}
