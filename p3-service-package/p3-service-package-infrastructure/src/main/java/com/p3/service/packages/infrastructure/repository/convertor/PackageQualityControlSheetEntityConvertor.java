package com.p3.service.packages.infrastructure.repository.convertor;

import com.p3.service.packages.domain.model.entity.QualityControlSheet;
import com.p3.service.packages.domain.model.factory.QualityControlSheetFactory;
import com.p3.service.packages.infrastructure.repository.entity.PackageQualityControlSheetEntity;

public class PackageQualityControlSheetEntityConvertor {

    public static PackageQualityControlSheetEntity convertToDataEntity(QualityControlSheet qualityControlSheet) {
        return qualityControlSheet.mapWith((id, expressBillNumber, packages, customerCode, storageLocation, expectedPackageCount, actualPackageCount, expectedProductCount, actualProductCount, totalProductValue, warehouseCode, warehouseName, destinationRegionCode, destinationRegionName, expressCompanyCode, expressCompanyName, packageStatus, inspectorId, inspectorName, inspectionTime, originalProductRemarks) ->
                new PackageQualityControlSheetEntity()
                        .setId(id)
                        .setExpressBillNumber(expressBillNumber)
                        .setCustomerCode(customerCode)
                        .setStorageLocation(storageLocation)
                        .setExpectedPackageCount(expectedPackageCount)
                        .setActualPackageCount(actualPackageCount)
                        .setExpectedProductCount(expectedProductCount)
                        .setActualProductCount(actualProductCount)
                        .setTotalProductValue(totalProductValue)
                        .setWarehouseCode(warehouseCode)
                        .setWarehouseName(warehouseName)
                        .setDestinationRegionCode(destinationRegionCode)
                        .setDestinationRegionName(destinationRegionName)
                        .setExpressCompanyCode(expressCompanyCode)
                        .setExpressCompanyName(expressCompanyName)
                        .setPackageStatus(packageStatus)
                        .setInspectorId(inspectorId)
                        .setInspectorName(inspectorName)
                        .setInspectionTime(inspectionTime)
                        .setOriginalProductRemarks(originalProductRemarks));
    }

    public static QualityControlSheet convertToDomainEntity(PackageQualityControlSheetEntity entity) {
        return QualityControlSheetFactory.create(entity.getId(), entity.getExpressBillNumber(), null, entity.getCustomerCode(), entity.getStorageLocation(), entity.getExpectedPackageCount(), entity.getActualPackageCount(), entity.getExpectedProductCount(), entity.getActualProductCount(), entity.getTotalProductValue(), entity.getWarehouseCode(), entity.getWarehouseName(), entity.getDestinationRegionCode(), entity.getDestinationRegionName(), entity.getExpressCompanyCode(), entity.getExpressCompanyName(), entity.getPackageStatus(), entity.getInspectorId(), entity.getInspectorName(), entity.getInspectionTime(), entity.getOriginalProductRemarks());
    }
}
