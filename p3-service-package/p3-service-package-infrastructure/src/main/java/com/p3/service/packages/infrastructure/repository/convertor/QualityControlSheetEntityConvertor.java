package com.p3.service.packages.infrastructure.repository.convertor;

import com.p3.service.packages.domain.model.entity.QualityControlSheet;
import com.p3.service.packages.infrastructure.repository.entity.QualityControlSheetEntity;
import com.p3.service.packages.infrastructure.repository.entity.QualityControlSheetGoodsInfoEntity;
import com.p3.service.packages.infrastructure.repository.entity.QualityControlSheetPackageEntity;
import com.p3.service.packages.infrastructure.repository.entity.QualityControlSheetServiceItemEntity;

import java.util.List;

public class QualityControlSheetEntityConvertor {

    public static QualityControlSheetEntity convertToDataEntity(QualityControlSheet qualityControlSheet) {
        return qualityControlSheet.mapWith((id, expressBillNumber, packages, services, customerCode, storageLocation, expectedPackageCount, actualPackageCount, expectedProductCount, actualProductCount, totalProductValue, warehouseCode, warehouseName, destinationRegionCode, destinationRegionName, expressCompanyCode, expressCompanyName, packageStatus, inspectorId, inspectorName, inspectionTime, originalProductRemarks) ->
                new QualityControlSheetEntity()
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

    public static QualityControlSheet convertToDomainEntity(QualityControlSheetEntity entity, List<QualityControlSheetPackageEntity> packageEntities, List<QualityControlSheetServiceItemEntity> serviceItemEntities, List<QualityControlSheetGoodsInfoEntity> goodsInfoEntities) {
        return new QualityControlSheet(entity.getId(), entity.getExpressBillNumber(), QualityControlSheetPackageEntityConvertor.convertToDomainEntities(packageEntities), QualityControlSheetServiceItemEntityConvertor.convertToDomainEntities(serviceItemEntities), entity.getCustomerCode(), entity.getStorageLocation(), entity.getExpectedPackageCount(), entity.getActualPackageCount(), entity.getExpectedProductCount(), entity.getActualProductCount(), entity.getTotalProductValue(), entity.getWarehouseCode(), entity.getWarehouseName(), entity.getDestinationRegionCode(), entity.getDestinationRegionName(), entity.getExpressCompanyCode(), entity.getExpressCompanyName(), entity.getPackageStatus(), entity.getInspectorId(), entity.getInspectorName(), entity.getInspectionTime(), QualityControlSheetGoodsInfoEntityConvertor.convertToDomainEntities(goodsInfoEntities), entity.getOriginalProductRemarks());
    }
}
