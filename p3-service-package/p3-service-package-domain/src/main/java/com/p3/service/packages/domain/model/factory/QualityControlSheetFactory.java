package com.p3.service.packages.domain.model.factory;

import com.p3.service.packages.domain.model.entity.QualityControlSheet;
import com.p3.service.packages.domain.model.entity.QualityControlSheetPackage;
import com.p3.service.packages.domain.model.entity.QualityControlSheetServiceItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class QualityControlSheetFactory {

    public static QualityControlSheet create(String id, String expressBillNumber,
                                             List<QualityControlSheetPackage> packages,
                                             List<QualityControlSheetServiceItem> services,
                                             String customerCode, String storageLocation,
                                             Integer expectedPackageCount, Integer actualPackageCount,
                                             Integer expectedProductCount, Integer actualProductCount,
                                             BigDecimal totalProductValue, String warehouseCode,
                                             String warehouseName, String destinationRegionCode,
                                             String destinationRegionName, String expressCompanyCode,
                                             String expressCompanyName, String packageStatus,
                                             String inspectorId, String inspectorName,
                                             LocalDateTime inspectionTime, String originalProductRemarks) {
        return new QualityControlSheet(id, expressBillNumber, packages, services, customerCode, storageLocation,
                expectedPackageCount, actualPackageCount, expectedProductCount,
                actualProductCount, totalProductValue, warehouseCode, warehouseName,
                destinationRegionCode, destinationRegionName, expressCompanyCode,
                expressCompanyName, packageStatus, inspectorId, inspectorName,
                inspectionTime, originalProductRemarks);
    }
}
