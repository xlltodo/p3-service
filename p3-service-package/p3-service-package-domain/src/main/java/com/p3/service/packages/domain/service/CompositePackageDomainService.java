package com.p3.service.packages.domain.service;

import com.p3.service.packages.domain.model.entity.CompositePackageMainInfo;
import com.p3.service.packages.domain.model.entity.CompositePackageTrackingNumber;
import com.p3.service.packages.domain.model.entity.CompositePackageTrackingNumberTypeEnum;
import com.p3.service.packages.domain.repository.ICompositePackageMainInfoRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class CompositePackageDomainService {

    @Resource
    private ICompositePackageMainInfoRepository compositePackageMainInfoRepository;
    @Resource
    private CompositePackageTrackingNumberDomainService compositePackageTrackingNumberDomainService;

    public CompositePackageMainInfo createCompositePackage(CompositePackageMainInfo compositePackageMainInfo) {

        CompositePackageTrackingNumber trackingNumber = compositePackageTrackingNumberDomainService.createTrackingNumber(compositePackageMainInfo.getCompositePackageCode(), CompositePackageTrackingNumberTypeEnum.CJM_NUMBER);
        compositePackageMainInfo.addTrackingNumber(trackingNumber);
        return compositePackageMainInfoRepository.createCompositePackage(compositePackageMainInfo);
    }
}
