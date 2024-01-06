package com.p3.service.packages.domain.model.factory;

import com.p3.service.packages.domain.model.entity.QualityControlSheet;
import com.p3.service.packages.domain.model.entity.QualityControlSheetGoodsInfo;
import com.p3.service.packages.domain.model.entity.QualityControlSheetPackage;
import com.p3.service.packages.domain.model.entity.QualityControlSheetServiceItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class QualityControlSheetFactory {

    public static QualityControlSheet create(String id, String expressBillNumber, List<QualityControlSheetPackage> packages, List<QualityControlSheetServiceItem> services, String customerCode, String customerNickname, String customerLevel, String customerType, String thirdPartyCustomerCode, String thirdPartyCustomerLevel, String storageLocation, Integer expectedPackageCount, Integer actualPackageCount, Integer expectedProductCount, Integer actualProductCount, BigDecimal totalProductValue, String warehouseCode, String warehouseName, String destinationRegionCode, String destinationRegionName, String expressCompanyCode, String expressCompanyName, Boolean exceptional, String itemImage, String originalProductRemarks, String packageStatus, String transportMethodCode, String transportMethodName, String inspectorId, String inspectorName, LocalDateTime inspectionTime, List<QualityControlSheetGoodsInfo> goodsInfos) {
        return new QualityControlSheet(id, expressBillNumber, packages, services, customerCode, customerNickname, customerLevel, customerType, thirdPartyCustomerCode, thirdPartyCustomerLevel, storageLocation, expectedPackageCount, actualPackageCount, expectedProductCount, actualProductCount, totalProductValue, warehouseCode, warehouseName, destinationRegionCode, destinationRegionName, expressCompanyCode, expressCompanyName, exceptional, itemImage, originalProductRemarks, packageStatus, transportMethodCode, transportMethodName, inspectorId, inspectorName, inspectionTime, goodsInfos);
    }
}
