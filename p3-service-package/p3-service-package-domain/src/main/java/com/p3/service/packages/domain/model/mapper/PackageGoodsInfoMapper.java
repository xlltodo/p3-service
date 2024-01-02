package com.p3.service.packages.domain.model.mapper;

import java.math.BigDecimal;

public interface PackageGoodsInfoMapper<T> {

    T map(String id, String packageCode, String productName, String goodsName, String goodsType, String specification, Integer shipmentQuantity, BigDecimal unitPrice, BigDecimal totalPrice, String imageUrl);
}
