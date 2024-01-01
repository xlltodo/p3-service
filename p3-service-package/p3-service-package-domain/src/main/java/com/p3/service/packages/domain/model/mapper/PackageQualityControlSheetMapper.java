package com.p3.service.packages.domain.model.mapper;

import com.p3.service.packages.domain.model.entity.QualityControlSheetPackage;
import com.p3.service.packages.domain.model.entity.QualityControlSheetServiceItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@FunctionalInterface
public interface PackageQualityControlSheetMapper<T> {

    T map(String id, String expressBillNumber, List<QualityControlSheetPackage> packages,
          List<QualityControlSheetServiceItem> services,
          String customerCode, String storageLocation, Integer expectedPackageCount,
          Integer actualPackageCount, Integer expectedProductCount,
          Integer actualProductCount, BigDecimal totalProductValue,
          String warehouseCode, String warehouseName, String destinationRegionCode,
          String destinationRegionName, String expressCompanyCode,
          String expressCompanyName, String packageStatus, String inspectorId,
          String inspectorName, LocalDateTime inspectionTime, String originalProductRemarks);
}
