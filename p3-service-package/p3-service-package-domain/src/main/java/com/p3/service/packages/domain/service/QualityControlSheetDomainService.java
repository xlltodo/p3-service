package com.p3.service.packages.domain.service;

import com.p3.service.packages.domain.model.entity.QualityControlSheet;
import com.p3.service.packages.domain.publisher.ISyncInProcessEventPublisher;
import com.p3.service.packages.domain.repository.IQualityControlSheetRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class QualityControlSheetDomainService {

    @Resource
    private IQualityControlSheetRepository packageQualityControlSheetRepository;

    @Resource
    private ISyncInProcessEventPublisher syncInProcessEventPublisher;

    @Resource
    private QualityControlSheetPackageDomainService qualityControlSheetPackageDomainService;
    @Resource
    private QualityControlSheetServiceItemDomainService qualityControlSheetServiceItemDomainService;
    @Resource
    private QualityControlSheetGoodsInfoDomainService qualityControlSheetGoodsInfoDomainService;

    public QualityControlSheet getBuyExpressBillNumber(String expressBillNumber) {

        return packageQualityControlSheetRepository.getBuyExpressBillNumber(expressBillNumber);
    }

    @Transactional(rollbackFor = Exception.class)
    public QualityControlSheet create(QualityControlSheet qualityControlSheet) {

        qualityControlSheetPackageDomainService.cleanBySheetId(qualityControlSheet.getUniqueIdentifier());
        qualityControlSheetPackageDomainService.createBatch(qualityControlSheet.getPackages());

        qualityControlSheetServiceItemDomainService.cleanBySheetId(qualityControlSheet.getUniqueIdentifier());
        qualityControlSheetServiceItemDomainService.createBatch(qualityControlSheet.getServices());

        qualityControlSheetGoodsInfoDomainService.cleanBySheetId(qualityControlSheet.getUniqueIdentifier());
        qualityControlSheetGoodsInfoDomainService.createBatch(qualityControlSheet.getGoodsInfos());
        return packageQualityControlSheetRepository.create(qualityControlSheet) ? qualityControlSheet : null;
    }

    @Transactional(rollbackFor = Exception.class)
    public QualityControlSheet update(QualityControlSheet qualityControlSheet) {

        packageQualityControlSheetRepository.delete(qualityControlSheet.getExpressBillNumber());
        return this.create(qualityControlSheet);
    }


    @Transactional(rollbackFor = Exception.class)
    public QualityControlSheet createOrUpdate(QualityControlSheet qualityControlSheet) {

        if(packageQualityControlSheetRepository.checkExist(qualityControlSheet.getExpressBillNumber())) {
            return this.update(qualityControlSheet);
        }else {
            return this.create(qualityControlSheet);
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public Boolean submit(QualityControlSheet qualityControlSheet) {
        this.publishPackageDeliveryEvent(qualityControlSheet);
        return this.createOrUpdate(qualityControlSheet) != null;
    }

    public void publishPackageDeliveryEvent(QualityControlSheet qualityControlSheet) {
        syncInProcessEventPublisher.publish(qualityControlSheet.submit());
    }
}
