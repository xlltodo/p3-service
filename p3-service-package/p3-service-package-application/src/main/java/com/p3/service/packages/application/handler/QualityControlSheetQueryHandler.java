package com.p3.service.packages.application.handler;

import com.p3.service.packages.application.assembler.QualityControlSheetAssembler;
import com.p3.service.packages.application.query.PackageQualityControlSheetQuery;
import com.p3.service.packages.application.result.QualityControlSheetResult;
import com.p3.service.packages.domain.model.entity.PackageProcessedRecord;
import com.p3.service.packages.domain.model.entity.QualityControlSheet;
import com.p3.service.packages.domain.repository.IPackageProcessedRecordRepository;
import com.p3.service.packages.domain.service.QualityControlSheetDomainService;
import com.p3.service.packages.infrastructure.client.P3WmsClient;
import com.p3.service.packages.infrastructure.client.dto.ForecastExpressDTO;
import com.p3.service.packages.infrastructure.client.dto.P3ApiResult;
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
    @Resource
    private IPackageProcessedRecordRepository packageProcessedRecordRepository;
    @Lazy
    @Resource
    private P3WmsClient p3WmsClient;

    public QualityControlSheetResult info(PackageQualityControlSheetQuery query) {

        // 检查是否有QC单记录
        Optional<QualityControlSheet> packageQualityControlSheetOptional = Optional.ofNullable(qualityControlSheetDomainService.getBuyExpressBillNumber(query.getExpressBillNumber()));
        if (packageQualityControlSheetOptional.isPresent()) {

            return QualityControlSheetAssembler.toResult(packageQualityControlSheetOptional.get());
        }

        // 没有QC单记录获取预报单记录和包裹过机
        Optional<ForecastExpressDTO> forecastExpressOptional = Optional.ofNullable(p3WmsClient.getExpressBill(query.getExpressBillNumber())).map(P3ApiResult::getData);
        Optional<PackageProcessedRecord> packageProcessedRecordOptional = Optional.ofNullable(packageProcessedRecordRepository.getByExpressBillNumber(query.getExpressBillNumber()));

        return forecastExpressOptional.map(forecastExpress ->
                        packageProcessedRecordOptional.map(packageProcessedRecord ->
                                        QualityControlSheetAssembler.toResult(forecastExpress, packageProcessedRecord))
                                .orElse(QualityControlSheetAssembler.toResult(forecastExpress)))
                .orElse(null);
    }
}
