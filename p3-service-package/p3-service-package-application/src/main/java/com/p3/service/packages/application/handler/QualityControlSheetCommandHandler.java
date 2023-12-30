package com.p3.service.packages.application.handler;

import com.p3.service.packages.application.assembler.QualityControlSheetAssembler;
import com.p3.service.packages.application.command.QualityControlSheetCommand;
import com.p3.service.packages.application.query.PackageQualityControlSheetQuery;
import com.p3.service.packages.application.result.QualityControlSheetResult;
import com.p3.service.packages.domain.model.entity.QualityControlSheet;
import com.p3.service.packages.domain.service.QualityControlSheetDomainService;
import com.p3.service.packages.infrastructure.client.ForecastExpressClient;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@Component
public class QualityControlSheetCommandHandler {

    @Resource
    private QualityControlSheetDomainService qualityControlSheetDomainService;
    @Lazy
    @Resource
    private ForecastExpressClient forecastExpressClient;

    public QualityControlSheetResult info(PackageQualityControlSheetQuery query) {
        Optional<QualityControlSheet> packageQualityControlSheetOptional = Optional.ofNullable(qualityControlSheetDomainService.getBuyExpressBillNumber(query.getExpressBillNumber()));

        return packageQualityControlSheetOptional.map(QualityControlSheetAssembler::toResult)
                .orElse(Optional.ofNullable(forecastExpressClient.getExpressBill(query.getExpressBillNumber()).getData()).map(QualityControlSheetAssembler::toResult).orElse(null));
    }

    public Boolean save(QualityControlSheetCommand command) {

        command.setInspectionTime(LocalDateTime.now());
        return qualityControlSheetDomainService.createOrUpdate(QualityControlSheetAssembler.toEntity(command));
    }

    public Boolean submit(QualityControlSheetCommand command) {
        this.save(command);
        return qualityControlSheetDomainService.submit(QualityControlSheetAssembler.toEntity(command));
    }
}
