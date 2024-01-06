package com.p3.service.packages.domain.model.mapper;

import com.p3.service.packages.domain.model.entity.*;

import java.math.BigDecimal;
import java.util.List;

@FunctionalInterface
public interface PackageMainInfoMapper<T> {

    T map(String id, String packageCode, List<PackageTrackingNumber> trackingNumbers, List<PackageSpatialAttribute> spatialAttributes, List<PackageServiceItem> serviceItems, String customerCode, String customerNickname, String customerLevel, String customerType, String thirdPartyCustomerCode, String thirdPartyCustomerLevel, String shippingWarehouse, String destinationCountry, String primaryGoodsType, String secondaryGoodsType, BigDecimal goodsValue, String transportMethodCode, String transportMethodName, Boolean composited, PackageStatusEnum packageStatus, List<PackageGoodsInfo> goodsInfos);
}
