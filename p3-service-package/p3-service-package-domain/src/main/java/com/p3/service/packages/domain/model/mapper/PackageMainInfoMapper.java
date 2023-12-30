package com.p3.service.packages.domain.model.mapper;

import com.p3.service.packages.domain.model.entity.PackageSpatialAttribute;
import com.p3.service.packages.domain.model.entity.PackageTrackingNumber;

import java.math.BigDecimal;
import java.util.List;

@FunctionalInterface
public interface PackageMainInfoMapper<T> {

    T map(String id, String packageCode, List<PackageTrackingNumber> trackingNumbers, List<PackageSpatialAttribute> attributes, String customerCode, String customerRank, String customerName, String thirdPartyCode, String shippingWarehouse, String destinationCountry, String primaryGoodsType, String secondaryGoodsType, BigDecimal goodsValue, Boolean composited, String shippingMethod);
}
