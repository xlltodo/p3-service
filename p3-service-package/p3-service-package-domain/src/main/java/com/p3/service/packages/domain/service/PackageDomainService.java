package com.p3.service.packages.domain.service;

import com.p3.service.packages.domain.event.QualityControlSheetSubmitDomainEvent;
import com.p3.service.packages.domain.model.entity.*;
import com.p3.service.packages.domain.model.factory.PackageMainInfoFactory;
import com.p3.service.packages.domain.model.factory.PackageServiceItemFactory;
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
import java.util.Optional;
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
            PackageTrackingNumber packageNumber = PackageTrackingNumberFactory.create(null, packageCode, PackageTrackingNumberTypeEnum.PACKAGE_CODE,
                    packageCode, localDateTime);
            PackageTrackingNumber cxNumber = PackageTrackingNumberFactory.create(null, packageCode, PackageTrackingNumberTypeEnum.CX_NUMBER,
                    identityGenerator.generatePackageTrackingNumber(PackageTrackingNumberTypeEnum.CX_NUMBER), localDateTime);
            PackageTrackingNumber expressBillNumber = PackageTrackingNumberFactory.create(null, packageCode, PackageTrackingNumberTypeEnum.EXPRESS_NUMBER,
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

            // 服务信息
            List<PackageServiceItem> packageServiceItems = Optional.ofNullable(event.getServices()).map(services -> services.stream().map(service -> PackageServiceItemFactory.create(null, packageCode, service.getServiceType(), service.getServiceName(), service.getFee(), service.getActivated(), LocalDateTime.now())).collect(Collectors.toList())).orElse(null);

            return PackageMainInfoFactory.create(null, packageCode, packageTrackingNumbers, packageSpatialAttributes, packageServiceItems,
                    event.getCustomerCode(), event.getCustomerLevel(), event.getCustomerNickname(), event.getCustomerType(),
                    event.getThirdPartyCustomerCode(), event.getThirdPartyCustomerLevel(), event.getWarehouseCode(),
                    event.getDestinationRegionCode(), p.getPrimaryGoodsType(), p.getSecondaryGoodsType(),
                    null, false, "");
        }).collect(Collectors.toList());

        packageMainInfoRepository.createBatch(packageMainInfos);
    }
}
