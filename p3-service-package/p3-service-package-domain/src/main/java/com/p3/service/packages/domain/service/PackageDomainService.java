package com.p3.service.packages.domain.service;

import com.p3.service.packages.domain.event.QualityControlSheetSubmitDomainEvent;
import com.p3.service.packages.domain.model.entity.PackageMainInfo;
import com.p3.service.packages.domain.model.entity.PackageSpatialAttribute;
import com.p3.service.packages.domain.model.entity.PackageTrackingNumber;
import com.p3.service.packages.domain.model.factory.PackageMainInfoFactory;
import com.p3.service.packages.domain.model.factory.PackageSpatialAttributeFactory;
import com.p3.service.packages.domain.model.factory.PackageTrackingNumberFactory;
import com.p3.service.packages.domain.repository.IPackageMainInfoRepository;
import com.p3.service.packages.domain.service.common.IIdentityGenerator;
import jakarta.annotation.Resource;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PackageDomainService {

    @Resource
    private IPackageMainInfoRepository packageMainInfoRepository;
    @Resource
    private IIdentityGenerator identityGenerator;

    @EventListener
    public void packageDeliveryEventListener(QualityControlSheetSubmitDomainEvent event) {

        LocalDateTime localDateTime = LocalDateTime.now();

        List<PackageMainInfo> packageMainInfos = event.getPackages().stream().map(p -> {

            // 编号
            String packageCode = identityGenerator.generateSnowflakeId();
            PackageTrackingNumber packageNumber = PackageTrackingNumberFactory.create(null, packageCode, "PACKAGE_NUMBER",
                    packageCode, localDateTime);
            PackageTrackingNumber cxNumber = PackageTrackingNumberFactory.create(null, packageCode, "CX_NUMBER",
                    identityGenerator.generateCxNumber(), localDateTime);
            PackageTrackingNumber expressBillNumber = PackageTrackingNumberFactory.create(null, packageCode, "EXPRESS_NUMBER",
                    event.getExpressBillNumber(), localDateTime);
            List<PackageTrackingNumber> packageTrackingNumbers = new ArrayList<>(3);
            packageTrackingNumbers.add(packageNumber);
            packageTrackingNumbers.add(cxNumber);
            packageTrackingNumbers.add(expressBillNumber);

            // 空间信息
            PackageSpatialAttribute packageSpatialAttribute = PackageSpatialAttributeFactory.create(null, packageCode, p.getLength(),
                    p.getWidth(), p.getHeight(), p.getVolume(),
                    p.getWeight(), localDateTime);
            List<PackageSpatialAttribute> packageSpatialAttributes = new ArrayList<>(1);
            packageSpatialAttributes.add(packageSpatialAttribute);

            return PackageMainInfoFactory.create(null, packageCode, packageTrackingNumbers, packageSpatialAttributes, event.getCustomerCode(),
                    "", "", "", event.getWarehouseCode(),
                    event.getDestinationRegionCode(), p.getPrimaryGoodsType(), p.getSecondaryGoodsType(),
                    null, false, "");
        }).collect(Collectors.toList());

        packageMainInfoRepository.createBatch(packageMainInfos);
    }
}
