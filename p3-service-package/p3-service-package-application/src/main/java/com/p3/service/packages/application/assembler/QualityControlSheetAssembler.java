package com.p3.service.packages.application.assembler;

import com.p3.service.packages.application.command.QualityControlSheetCommand;
import com.p3.service.packages.application.result.QualityControlSheetResult;
import com.p3.service.packages.domain.model.entity.QualityControlSheet;
import com.p3.service.packages.domain.model.factory.QualityControlSheetFactory;
import com.p3.service.packages.infrastructure.client.dto.ForecastExpressDTO;

import java.util.Optional;

public class QualityControlSheetAssembler {


    public static QualityControlSheet toEntity(QualityControlSheetCommand command) {
        return QualityControlSheetFactory.create(
                command.getId(),
                command.getExpressBillNumber(),
                QualityControlSheetPackageAssembler.toEntities(command.getPackages()),
                command.getCustomerCode(),
                command.getStorageLocation(),
                null,
                command.getActualPackageCount(),
                command.getExpectedProductCount(),
                command.getActualProductCount(),
                command.getTotalProductValue(),
                command.getWarehouseCode(),
                command.getWarehouseName(),
                command.getDestinationRegionCode(),
                command.getDestinationRegionName(),
                command.getExpressCompanyCode(),
                command.getExpressCompanyName(),
                command.getPackageStatus(),
                command.getInspectorId(),
                command.getInspectorName(),
                command.getInspectionTime(),
                command.getOriginalProductRemarks()
        );
    }

    public static QualityControlSheetResult toResult(QualityControlSheet qualityControlSheet) {
        return qualityControlSheet.mapWith(((id, expressBillNumber, packages, customerCode, storageLocation,
                                             expectedPackageCount, actualPackageCount, expectedProductCount,
                                             actualProductCount, totalProductValue, warehouseCode,
                                             warehouseName, destinationRegionCode, destinationRegionName,
                                             expressCompanyCode, expressCompanyName, packageStatus,
                                             inspectorId, inspectorName, inspectionTime, originalProductRemarks) -> new QualityControlSheetResult()
                .setId(id)
                .setExpressBillNumber(expressBillNumber)
                .setPackages(Optional.ofNullable(packages).map(QualityControlSheetPackageAssembler::toResults).orElse(null))
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
                .setOriginalProductRemarks(originalProductRemarks))
        );
    }

    public static QualityControlSheetResult toResult(ForecastExpressDTO forecastExpressDTO) {
        return new QualityControlSheetResult()
                .setExpressBillNumber(forecastExpressDTO.getExpressNo())
                .setPackages(null)
                .setCustomerCode(forecastExpressDTO.getCustomerCode())
                .setStorageLocation(null)
                .setExpectedPackageCount(forecastExpressDTO.getNumberOfPackages())
                .setActualPackageCount(null)
                .setExpectedProductCount(null)
                .setActualProductCount(null)
                .setTotalProductValue(null)
                .setWarehouseCode(null)
                .setWarehouseName(null)
                .setDestinationRegionCode(null)
                .setDestinationRegionName(forecastExpressDTO.getReceiveAddress())
                .setExpressCompanyCode(null)
                .setExpressCompanyName(forecastExpressDTO.getExpressCompany())
                .setPackageStatus(null)
                .setInspectorId(null)
                .setInspectorName(null)
                .setInspectionTime(null)
                .setOriginalProductRemarks(forecastExpressDTO.getRemark());
    }
}
