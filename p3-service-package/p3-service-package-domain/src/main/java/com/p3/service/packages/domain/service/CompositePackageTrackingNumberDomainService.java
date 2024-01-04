package com.p3.service.packages.domain.service;

import com.p3.service.packages.domain.model.entity.CompositePackageTrackingNumber;
import com.p3.service.packages.domain.model.entity.CompositePackageTrackingNumberTypeEnum;
import com.p3.service.packages.domain.model.factory.CompositePackageTrackingNumberFactory;
import com.p3.service.packages.domain.service.common.IIdentityGenerator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CompositePackageTrackingNumberDomainService {

    @Resource
    private IIdentityGenerator identityGenerator;

    public CompositePackageTrackingNumber createTrackingNumber(String compositePackageCode, CompositePackageTrackingNumberTypeEnum trackingNumberTypeEnum) {

        String cjmNumber = identityGenerator.generateCompositePackageTrackingNumber(CompositePackageTrackingNumberTypeEnum.CJM_NUMBER);

        return CompositePackageTrackingNumberFactory.create(null, compositePackageCode, trackingNumberTypeEnum.getCode(), cjmNumber, LocalDateTime.now());
    }
}
