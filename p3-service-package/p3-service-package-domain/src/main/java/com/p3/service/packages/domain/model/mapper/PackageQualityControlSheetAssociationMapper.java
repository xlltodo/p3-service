package com.p3.service.packages.domain.model.mapper;

@FunctionalInterface
public interface PackageQualityControlSheetAssociationMapper<T> {

    T map(String id, String sheetId, Double weight, Double length, Double width, Double height, Double volume, Integer quantity, String productName, String brandName, String primaryGoodsType, String secondaryGoodsType);
}
