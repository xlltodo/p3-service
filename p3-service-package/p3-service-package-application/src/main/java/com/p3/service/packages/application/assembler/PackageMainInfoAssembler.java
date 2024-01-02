package com.p3.service.packages.application.assembler;

import com.p3.service.packages.application.result.PackageMainInfoResult;
import com.p3.service.packages.application.result.PackageServiceItemResult;
import com.p3.service.packages.application.result.PackageSpatialAttributesResult;
import com.p3.service.packages.application.result.PackageTrackingNumberResult;
import com.p3.service.packages.domain.model.entity.PackageMainInfo;
import com.p3.service.packages.domain.model.entity.PackageServiceItem;
import com.p3.service.packages.domain.model.entity.PackageSpatialAttribute;
import com.p3.service.packages.domain.model.entity.PackageTrackingNumber;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.stream.Collectors;

public class PackageMainInfoAssembler {

    public static PackageMainInfoResult toResult(PackageMainInfo packageMainInfo) {
        if(ObjectUtils.isEmpty(packageMainInfo)) {
            return null;
        }
        return packageMainInfo.mapWith((id, packageCode, trackingNumbers, spatialAttributes, serviceItems,
                                        customerCode, customerNickname, customerLevel, customerType, thirdPartyCustomerCode, thirdPartyCustomerLevel,
                                        shippingWarehouse, destinationCountry, primaryGoodsType,
                                        secondaryGoodsType, goodsValue, composited, shippingMethod) -> {

            List<PackageTrackingNumberResult> trackingNumberResults =
                    convertTrackingNumbers(trackingNumbers);

            List<PackageSpatialAttributesResult> spatialAttributesResults =
                    convertSpatialAttributes(spatialAttributes);

            List<PackageServiceItemResult> serviceItemsResults =
                    convertServiceItems(serviceItems);

            return new PackageMainInfoResult()
                    .setId(id)
                    .setPackageCode(packageCode)
                    .setTrackingNumber(trackingNumberResults)
                    .setSpatialAttributes(spatialAttributesResults)
                    .setServiceItems(serviceItemsResults)
                    .setCustomerCode(customerCode)
                    .setCustomerNickname(customerNickname)
                    .setCustomerLevel(customerLevel)
                    .setCustomerType(customerType)
                    .setThirdPartyCustomerCode(thirdPartyCustomerCode)
                    .setThirdPartyCustomerLevel(thirdPartyCustomerLevel)
                    .setShippingWarehouse(shippingWarehouse)
                    .setDestinationCountry(destinationCountry)
                    .setPrimaryGoodsType(primaryGoodsType)
                    .setSecondaryGoodsType(secondaryGoodsType)
                    .setGoodsValue(goodsValue)
                    .setComposited(composited)
                    .setShippingMethod(shippingMethod);
        });
    }

    private static List<PackageTrackingNumberResult> convertTrackingNumbers(List<PackageTrackingNumber> trackingNumbers) {
        if(CollectionUtils.isEmpty(trackingNumbers)) {
            return null;
        }
        return trackingNumbers.stream()
                .map(trackingNumber -> new PackageTrackingNumberResult()
                        // 添加转换逻辑
                ).collect(Collectors.toList());
    }

    private static List<PackageSpatialAttributesResult> convertSpatialAttributes(List<PackageSpatialAttribute> spatialAttributes) {
        if(CollectionUtils.isEmpty(spatialAttributes)) {
            return null;
        }
        return spatialAttributes.stream()
                .map(spatialAttribute -> new PackageSpatialAttributesResult()
                        // 添加转换逻辑
                ).collect(Collectors.toList());
    }

    private static List<PackageServiceItemResult> convertServiceItems(List<PackageServiceItem> serviceItems) {
        if(CollectionUtils.isEmpty(serviceItems)) {
            return null;
        }
        return serviceItems.stream()
                .map(serviceItem -> new PackageServiceItemResult()
                        // 添加转换逻辑
                ).collect(Collectors.toList());
    }
}
