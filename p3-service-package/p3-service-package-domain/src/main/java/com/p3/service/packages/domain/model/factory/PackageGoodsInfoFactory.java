package com.p3.service.packages.domain.model.factory;

import com.p3.service.packages.domain.model.entity.PackageGoodsInfo;

import java.math.BigDecimal;

public class PackageGoodsInfoFactory {
    
    public static PackageGoodsInfo create(String id, String packageCode, String productName, String goodsName, String goodsType, String specification, Integer shipmentQuantity, BigDecimal unitPrice, BigDecimal totalPrice, String imageUrl) {
        return new PackageGoodsInfo(id, packageCode, productName, goodsName, goodsType,
                specification, shipmentQuantity, unitPrice, totalPrice, imageUrl);
    }
}
