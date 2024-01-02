package com.p3.service.packages.domain.model.mapper;

import com.p3.service.packages.domain.model.entity.QualityControlSheetGoodsInfo;
import com.p3.service.packages.domain.model.entity.QualityControlSheetPackage;
import com.p3.service.packages.domain.model.entity.QualityControlSheetServiceItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface QualityControlSheetMapper<T> {

    T map(String id, String expressBillNumber, List<QualityControlSheetPackage> packages, List<QualityControlSheetServiceItem> services, String customerCode, String customerNickname, String customerLevel, String customerType, String thirdPartyCustomerCode, String thirdPartyCustomerLevel, String storageLocation, Integer expectedPackageCount, Integer actualPackageCount, Integer expectedProductCount, Integer actualProductCount, BigDecimal totalProductValue, String warehouseCode, String warehouseName, String destinationRegionCode, String destinationRegionName, String expressCompanyCode, String expressCompanyName, Boolean exceptional, String itemImage, String originalProductRemarks, String packageStatus, String inspectorId, String inspectorName, LocalDateTime inspectionTime, List<QualityControlSheetGoodsInfo> goodsInfos);
}
