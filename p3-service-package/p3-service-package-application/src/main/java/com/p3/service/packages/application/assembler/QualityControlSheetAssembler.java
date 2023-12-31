package com.p3.service.packages.application.assembler;

import com.p3.service.packages.application.command.QualityControlSheetCommand;
import com.p3.service.packages.application.result.QualityControlSheetResult;
import com.p3.service.packages.domain.model.entity.QualityControlSheet;
import com.p3.service.packages.domain.model.factory.QualityControlSheetFactory;
import com.p3.service.packages.infrastructure.client.dto.CustomerInfoDTO;
import com.p3.service.packages.infrastructure.client.dto.ForecastExpressDTO;

import java.util.Optional;
import java.util.stream.Collectors;

public class QualityControlSheetAssembler {


    public static QualityControlSheet toEntity(QualityControlSheetCommand command, ForecastExpressDTO forecastExpress, CustomerInfoDTO customerInfo) {
        return QualityControlSheetFactory.create(
                command.getId(),
                command.getExpressBillNumber(),
                QualityControlSheetPackageAssembler.toEntities(command.getPackages()),
                command.getCustomerCode(),
                command.getStorageLocation(),
                forecastExpress.getNumberOfPackages(),
                command.getActualPackageCount(),
                forecastExpress.getCommodityLists().stream().mapToInt(ForecastExpressDTO.Commodity::getQuantityShipped).sum(),
                command.getActualProductCount(),
                command.getTotalProductValue(),
                command.getWarehouseCode(),
                command.getWarehouseName(),
                command.getDestinationRegionCode(),
                command.getDestinationRegionName(),
                command.getExpressCompanyCode(),
                command.getExpressCompanyName(),
                null,
                null,
                null,
                null,
                forecastExpress.getRemark()
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
