package com.p3.service.packages.application.assembler;

import com.p3.service.packages.application.command.PackageAddTrackingNumberCommand;
import com.p3.service.packages.application.result.PackageMainInfoResult;
import com.p3.service.packages.application.result.PackageServiceItemResult;
import com.p3.service.packages.application.result.PackageSpatialAttributesResult;
import com.p3.service.packages.application.result.PackageTrackingNumberResult;
import com.p3.service.packages.domain.model.entity.PackageMainInfo;
import com.p3.service.packages.domain.model.entity.PackageServiceItem;
import com.p3.service.packages.domain.model.entity.PackageSpatialAttribute;
import com.p3.service.packages.domain.model.entity.PackageTrackingNumber;
import com.p3.service.packages.domain.model.factory.PackageTrackingNumberFactory;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
                    .setTrackingNumbers(trackingNumberResults)
                    .setSpatialAttributes(spatialAttributesResults)
                    .setServices(serviceItemsResults)
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

    private static PackageTrackingNumber convertTrackingNumber(String packageCode, PackageAddTrackingNumberCommand command) {

        return PackageTrackingNumberFactory.create(null, packageCode, command.getNumberType(), command.getTrackingNumber(), LocalDateTime.now());
    }

    public static PackageTrackingNumberResult toResult(PackageTrackingNumber packageTrackingNumber) {

        return packageTrackingNumber.mapWith((id, packageCode, numberType, trackingNumber, creationTime) -> new PackageTrackingNumberResult()
                .setId(id)
                .setPackageCode(packageCode)
                .setNumberType(numberType)
                .setTrackingNumber(trackingNumber)
                .setCreationTime(creationTime));
    }

    public static List<PackageTrackingNumberResult> convertTrackingNumbers(List<PackageTrackingNumber> trackingNumbers) {
        if(CollectionUtils.isEmpty(trackingNumbers)) {
            return null;
        }
        return trackingNumbers.stream()
                .map(PackageMainInfoAssembler::toResult).collect(Collectors.toList());
    }

    public static PackageSpatialAttributesResult convertSpatialAttribute(PackageSpatialAttribute spatialAttribute) {
        return spatialAttribute.mapWith((id, packageCode, length, width, height, volume, weight, measurementTime) -> new PackageSpatialAttributesResult()
                .setId(id)
                .setPackageCode(packageCode)
                .setLength(length)
                .setWeight(weight)
                .setHeight(height)
                .setVolume(volume)
                .setWeight(weight)
                .setMeasurementTime(measurementTime)
        );
    }

    public static List<PackageSpatialAttributesResult> convertSpatialAttributes(List<PackageSpatialAttribute> spatialAttribute) {
        if(CollectionUtils.isEmpty(spatialAttribute)) {
            return null;
        }
        return spatialAttribute.stream()
                .map(PackageMainInfoAssembler::convertSpatialAttribute).collect(Collectors.toList());
    }

    public static PackageServiceItemResult convertServiceItem(PackageServiceItem serviceItem) {
        return serviceItem.mapWith((id,packageCode, serviceType, serviceName, fee, activated, creationTime) -> new PackageServiceItemResult()
                .setId(id)
                .setPackageCode(packageCode)
                .setServiceType(serviceType)
                .setServiceName(serviceName)
                .setFee(fee)
                .setActivated(activated)
                .setCreationTime(creationTime)
        );
    }

    public static List<PackageServiceItemResult> convertServiceItems(List<PackageServiceItem> serviceItems) {
        if(CollectionUtils.isEmpty(serviceItems)) {
            return null;
        }
        return serviceItems.stream()
                .map(PackageMainInfoAssembler::convertServiceItem).collect(Collectors.toList());
    }
}
