package com.p3.service.packages.application.handler;

import com.p3.service.packages.application.assembler.QualityControlSheetAssembler;
import com.p3.service.packages.application.query.PackageQualityControlSheetQuery;
import com.p3.service.packages.application.result.QualityControlSheetResult;
import com.p3.service.packages.domain.model.entity.QualityControlSheet;
import com.p3.service.packages.domain.service.QualityControlSheetDomainService;
import com.p3.service.packages.infrastructure.client.P3WmsClient;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
public class QualityControlSheetQueryHandler {

    @Resource
    private QualityControlSheetDomainService qualityControlSheetDomainService;
    @Lazy
    @Resource
    private P3WmsClient p3WmsClient;

    public QualityControlSheetResult info(PackageQualityControlSheetQuery query) {
        Optional<QualityControlSheet> packageQualityControlSheetOptional = Optional.ofNullable(qualityControlSheetDomainService.getBuyExpressBillNumber(query.getExpressBillNumber()));

        return packageQualityControlSheetOptional.map(QualityControlSheetAssembler::toResult)
                .orElse(Optional.ofNullable(p3WmsClient.getExpressBill(query.getExpressBillNumber()).getData()).map(QualityControlSheetAssembler::toResult).orElse(null));
    }
}
