package com.p3.service.packages.domain.model.mapper;

import java.math.BigDecimal;

public interface QualityControlSheetGoodsInfoMapper<T> {

    T map(String id, String sheetCode, String productName, String goodsName, String goodsType, String specification, Integer shipmentQuantity, BigDecimal unitPrice, BigDecimal totalPrice, String imageUrl);
}
