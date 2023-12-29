package com.p3.service.packages.domain.model.mapper;

import java.math.BigDecimal;

@FunctionalInterface
public interface PackageMainInfoMapper<T> {

    T map(String id, String packageCode, String customerCode, String customerRank, String customerName, String thirdPartyCode, String shippingWarehouse, String destinationCountry, String primaryGoodsType, String secondaryGoodsType, BigDecimal goodsValue, Integer composited, String shippingMethod);
}
