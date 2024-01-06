package com.p3.service.packages.application.assembler;

import com.p3.service.packages.application.command.PackageAddTrackingNumberCommand;
import com.p3.service.packages.application.result.*;
import com.p3.service.packages.domain.model.entity.*;
import com.p3.service.packages.domain.model.factory.PackageTrackingNumberFactory;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PackageMainInfoAssembler {

    public static PackageMainInfoResult toResult(PackageMainInfo packageMainInfo) {
        if(ObjectUtils.isEmpty(packageMainInfo)) {
            return null;
        }
        return packageMainInfo.mapWith((id, packageCode, trackingNumbers, spatialAttributes, serviceItems, customerCode, customerNickname, customerLevel, customerType, thirdPartyCustomerCode, thirdPartyCustomerLevel, shippingWarehouse, destinationCountry, primaryGoodsType, secondaryGoodsType, goodsValue, transportMethodCode, transportMethodName, composited, packageStatus, goodsInfos) -> {

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
                    .setTransportMethodCode(transportMethodCode)
                    .setTransportMethodName(transportMethodName)
                    .setComposited(composited)
                    .setPackageStatus(packageStatus.toString())
                    .setGoodsInfos(PackageMainInfoAssembler.convertGoodsInfoResults(goodsInfos));
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
            return new ArrayList<>(0);
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
            return new ArrayList<>(0);
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
            return new ArrayList<>(0);
        }
        return serviceItems.stream()
                .map(PackageMainInfoAssembler::convertServiceItem).collect(Collectors.toList());
    }

    public static PackageGoodsInfoResult convertGoodsInfoResult(PackageGoodsInfo packageGoodsInfo) {

        return packageGoodsInfo.mapWith((String id, String packageCode, String productName, String goodsName, String goodsType, String specification,
                                         Integer shipmentQuantity, BigDecimal unitPrice, BigDecimal totalPrice, String imageUrl) ->
                new PackageGoodsInfoResult()
                        .setId(id)
                        .setPackageCode(packageCode)
                        .setProductName(productName)
                        .setGoodsName(goodsName)
                        .setGoodsType(goodsType)
                        .setSpecification(specification)
                        .setShipmentQuantity(shipmentQuantity)
                        .setUnitPrice(unitPrice)
                        .setTotalPrice(totalPrice)
                        .setImageUrl(imageUrl)
        );
    }

    public static List<PackageGoodsInfoResult> convertGoodsInfoResults(List<PackageGoodsInfo> packageGoodsInfos) {
        return Optional.ofNullable(packageGoodsInfos).map(list -> list.stream().map(PackageMainInfoAssembler::convertGoodsInfoResult).collect(Collectors.toList())).orElse(new ArrayList<>(0));
    }

}
