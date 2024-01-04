package com.p3.service.packages.application.handler;

import com.p3.service.packages.application.assembler.QualityControlSheetAssembler;
import com.p3.service.packages.application.command.QualityControlSheetCommand;
import com.p3.service.packages.application.query.PackageQualityControlSheetQuery;
import com.p3.service.packages.application.result.QualityControlSheetResult;
import com.p3.service.packages.domain.model.entity.QualityControlSheet;
import com.p3.service.packages.domain.service.QualityControlSheetDomainService;
import com.p3.service.packages.domain.service.common.IIdentityGenerator;
import com.p3.service.packages.infrastructure.client.P3WmsClient;
import com.p3.service.packages.infrastructure.client.dto.CustomerInfoDTO;
import com.p3.service.packages.infrastructure.client.dto.ForecastExpressDTO;
import com.p3.service.packages.infrastructure.client.dto.P3ApiResult;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Slf4j
@Component
public class QualityControlSheetCommandHandler {

    @Resource
    private QualityControlSheetDomainService qualityControlSheetDomainService;
    @Lazy
    @Resource
    private P3WmsClient p3WmsClient;

    @Resource
    private IIdentityGenerator identityGenerator;

    public QualityControlSheetResult info(PackageQualityControlSheetQuery query) {
        Optional<QualityControlSheet> packageQualityControlSheetOptional = Optional.ofNullable(qualityControlSheetDomainService.getBuyExpressBillNumber(query.getExpressBillNumber()));

        return packageQualityControlSheetOptional.map(QualityControlSheetAssembler::toResult)
                .orElse(Optional.ofNullable(p3WmsClient.getExpressBill(query.getExpressBillNumber()).getData()).map(QualityControlSheetAssembler::toResult).orElse(null));
    }

    @Transactional(rollbackFor = Exception.class)
    public QualityControlSheet save(QualityControlSheetCommand command) {

        ForecastExpressDTO forecastExpress = Optional.ofNullable(p3WmsClient.getExpressBill(command.getExpressBillNumber())).map(P3ApiResult::getData).orElse(null);
        if(ObjectUtils.isEmpty(forecastExpress)) {
            return null;
        }
        CustomerInfoDTO customerInfo = Optional.ofNullable(p3WmsClient.getCustomerInfo(forecastExpress.getCustomerCode(), forecastExpress.getThirdPartyCustomerCode())).map(P3ApiResult::getData).orElse(null);
        if(ObjectUtils.isEmpty(customerInfo)) {
            return null;
        }
        QualityControlSheet qualityControlSheet = QualityControlSheetAssembler.toEntity(identityGenerator.generateSnowflakeId(), command, forecastExpress, customerInfo);
        return qualityControlSheetDomainService.createOrUpdate(qualityControlSheet) ? qualityControlSheet : null;
    }

    @Transactional(rollbackFor = Exception.class)
    public String submit(QualityControlSheetCommand command) {

        QualityControlSheet qualityControlSheet = this.save(command);
        qualityControlSheet.submitQualityControlSheet("", "");
        return qualityControlSheetDomainService.submit(qualityControlSheet) ? qualityControlSheet.getUniqueIdentifier() : null;
    }
}
