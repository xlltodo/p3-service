package com.p3.service.packages.domain.service;

import com.p3.service.packages.domain.model.entity.QualityControlSheet;
import com.p3.service.packages.domain.publisher.ISyncInProcessEventPublisher;
import com.p3.service.packages.domain.repository.IQualityControlSheetRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class QualityControlSheetDomainService {

    @Resource
    private IQualityControlSheetRepository packageQualityControlSheetRepository;

    @Resource
    private ISyncInProcessEventPublisher syncInProcessEventPublisher;


    public QualityControlSheet getBuyExpressBillNumber(String expressBillNumber) {

        return packageQualityControlSheetRepository.getBuyExpressBillNumber(expressBillNumber);
    }

    public Boolean create(QualityControlSheet qualityControlSheet) {
        return packageQualityControlSheetRepository.create(qualityControlSheet);
    }

    public Boolean update(QualityControlSheet qualityControlSheet) {
        return packageQualityControlSheetRepository.update(qualityControlSheet);
    }

    public Boolean submit(QualityControlSheet qualityControlSheet) {
        this.publishPackageDeliveryEvent(qualityControlSheet);
        return packageQualityControlSheetRepository.update(qualityControlSheet);
    }

    public Boolean createOrUpdate(QualityControlSheet qualityControlSheet) {

        if(packageQualityControlSheetRepository.checkExist(qualityControlSheet.getUniqueIdentifier())) {
            return this.update(qualityControlSheet);
        }else {
            return this.create(qualityControlSheet);
        }
    }

    public void publishPackageDeliveryEvent(QualityControlSheet qualityControlSheet) {
        syncInProcessEventPublisher.publish(qualityControlSheet.submit());
    }
}
