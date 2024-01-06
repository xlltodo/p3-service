package com.p3.service.packages.domain.model.factory;

import com.p3.service.packages.domain.model.entity.*;

import java.math.BigDecimal;
import java.util.List;

public class PackageMainInfoFactory {

    public static PackageMainInfo create(String id, String packageCode, List<PackageTrackingNumber> trackingNumbers, List<PackageSpatialAttribute> spatialAttributes, List<PackageServiceItem> serviceItems, String customerCode, String customerNickname, String customerLevel, String customerType, String thirdPartyCustomerCode, String thirdPartyCustomerLevel, String shippingWarehouse, String destinationCountry, String primaryGoodsType, String secondaryGoodsType, BigDecimal goodsValue, String transportMethodCode, String transportMethodName, PackageStatusEnum packageStatus, Boolean composited, List<PackageGoodsInfo> goodsInfos) {
        return new PackageMainInfo(id, packageCode, trackingNumbers, spatialAttributes, serviceItems, customerCode, customerNickname, customerLevel, customerType, thirdPartyCustomerCode, thirdPartyCustomerLevel, shippingWarehouse, destinationCountry, primaryGoodsType, secondaryGoodsType, goodsValue, transportMethodCode, transportMethodName, packageStatus, composited, goodsInfos);
    }
}
