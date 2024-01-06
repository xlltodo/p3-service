package com.p3.service.packages.application.assembler;

import com.p3.service.packages.application.command.QualityControlSheetCommand;
import com.p3.service.packages.application.result.QualityControlSheetGoodsInfoResult;
import com.p3.service.packages.application.result.QualityControlSheetPackageResult;
import com.p3.service.packages.application.result.QualityControlSheetResult;
import com.p3.service.packages.domain.model.entity.PackageProcessedRecord;
import com.p3.service.packages.domain.model.entity.QualityControlSheet;
import com.p3.service.packages.domain.model.factory.QualityControlSheetFactory;
import com.p3.service.packages.infrastructure.client.dto.CustomerInfoDTO;
import com.p3.service.packages.infrastructure.client.dto.ForecastExpressDTO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class QualityControlSheetAssembler {


    public static QualityControlSheet toEntity(String sheetId, QualityControlSheetCommand command, ForecastExpressDTO forecastExpress, CustomerInfoDTO customerInfo) {
        return QualityControlSheetFactory.create(
                sheetId,
                command.getExpressBillNumber(),
                QualityControlSheetPackageAssembler.toEntities(sheetId, command.getPackages()),
                QualityControlSheetServiceItemAssembler.toEntities(sheetId, command.getServices()),
                command.getCustomerCode(),
                forecastExpress.getCustomerNickname(),
                forecastExpress.getCustomerLevel(),
                forecastExpress.getMasterCustomer().getType(),
                forecastExpress.getThirdPartyCustomerCode(),
                forecastExpress.getThirdPartyCustomerLevel(),
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
                command.getExceptional(),
                null,
                forecastExpress.getRemark(),
                null,
                forecastExpress.getTypeOfShipping(),
                forecastExpress.getTypeOfShipping(),
                null,
                null,
                null,
                QualityControlSheetGoodsInfoAssembler.toEntities(sheetId, forecastExpress.getCommodityLists())
        );
    }

    public static QualityControlSheetResult toResult(QualityControlSheet qualityControlSheet) {
        return qualityControlSheet.mapWith((id, expressBillNumber, packages, services,
                                            customerCode, customerNickname, customerLevel, customerType,
                                            thirdPartyCustomerCode, thirdPartyCustomerLevel, storageLocation,
                                            expectedPackageCount, actualPackageCount, expectedProductCount, actualProductCount,
                                            totalProductValue, warehouseCode, warehouseName, destinationRegionCode,
                                            destinationRegionName, expressCompanyCode, expressCompanyName, exceptional,
                                            itemImage, originalProductRemarks, packageStatus, transportMethodCode, transportMethodName,
                                            inspectorId, inspectorName, inspectionTime, goodsInfos) -> new QualityControlSheetResult()
                .setId(id)
                .setExpressBillNumber(expressBillNumber)
                .setPackages(Optional.ofNullable(packages).map(QualityControlSheetPackageAssembler::toResults).orElse(null))
                .setServices(Optional.ofNullable(services).map(QualityControlSheetServiceItemAssembler::toResults).orElse(null))
                .setCustomerCode(customerCode)
                .setCustomerNickname(customerNickname)
                .setCustomerLevel(customerLevel)
                .setCustomerType(customerType)
                .setThirdPartyCustomerCode(thirdPartyCustomerCode)
                .setThirdPartyCustomerLevel(thirdPartyCustomerLevel)
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
                .setExceptional(exceptional)
                .setItemImage(itemImage)
                .setPackageStatus(packageStatus)
                .setTransportMethodCode(transportMethodCode)
                .setTransportMethodName(transportMethodName)
                .setInspectorId(inspectorId)
                .setInspectorName(inspectorName)
                .setInspectionTime(inspectionTime)
                .setOriginalProductRemarks(originalProductRemarks)
        );
    }

    public static QualityControlSheetResult toResult(ForecastExpressDTO forecastExpressDTO) {
        return new QualityControlSheetResult()
                .setExpressBillNumber(forecastExpressDTO.getExpressNo())
                .setPackages(null)
                .setServices(null)
                .setCustomerCode(forecastExpressDTO.getCustomerCode())
                .setCustomerNickname(forecastExpressDTO.getCustomerNickname())
                .setCustomerLevel(forecastExpressDTO.getCustomerLevel())
                .setCustomerType(forecastExpressDTO.getMasterCustomer().getType())
                .setThirdPartyCustomerCode(forecastExpressDTO.getThirdPartyCustomerCode())
                .setThirdPartyCustomerLevel(forecastExpressDTO.getThirdPartyCustomerLevel())
                .setStorageLocation(null)
                .setExpectedPackageCount(forecastExpressDTO.getNumberOfPackages())
                .setActualPackageCount(1)
                .setExpectedProductCount(0)
                .setActualProductCount(0)
                .setTotalProductValue(Optional.ofNullable(forecastExpressDTO.getCommodityLists()).map(commodities -> commodities.stream().map(ForecastExpressDTO.Commodity::getTotalPrice).reduce(new BigDecimal("0.000"), BigDecimal::add)).orElse(BigDecimal.ZERO))
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
                .setOriginalProductRemarks(forecastExpressDTO.getRemark())
                .setGoods(Optional.ofNullable(forecastExpressDTO.getCommodityLists()).map(commodities -> commodities.stream().map(QualityControlSheetAssembler::toResult).collect(Collectors.toList())).orElse(null));
    }

    public static QualityControlSheetResult toResult(ForecastExpressDTO forecastExpressDTO, PackageProcessedRecord packageProcessedRecord) {

        return packageProcessedRecord.mapWith((id, ticketsNum, weight, length, width, height, volume, machine) -> {


            List<QualityControlSheetPackageResult> packageResults = new ArrayList<>();
            for (int i = forecastExpressDTO.getNumberOfPackages(); i > 0; i--) {
                packageResults.add(new QualityControlSheetPackageResult()
                        .setWeight(weight)
                        .setLength(length)
                        .setWidth(width)
                        .setHeight(height)
                        .setVolume(volume));
            }

            return new QualityControlSheetResult()
                    .setExpressBillNumber(forecastExpressDTO.getExpressNo())
                    .setPackages(packageResults)
                    .setServices(null)
                    .setCustomerCode(forecastExpressDTO.getCustomerCode())
                    .setCustomerNickname(forecastExpressDTO.getCustomerNickname())
                    .setCustomerLevel(forecastExpressDTO.getCustomerLevel())
                    .setCustomerType(forecastExpressDTO.getMasterCustomer().getType())
                    .setThirdPartyCustomerCode(forecastExpressDTO.getThirdPartyCustomerCode())
                    .setThirdPartyCustomerLevel(forecastExpressDTO.getThirdPartyCustomerLevel())
                    .setStorageLocation(null)
                    .setExpectedPackageCount(forecastExpressDTO.getNumberOfPackages())
                    .setActualPackageCount(1)
                    .setExpectedProductCount(0)
                    .setActualProductCount(0)
                    .setTotalProductValue(Optional.ofNullable(forecastExpressDTO.getCommodityLists()).map(commodities -> commodities.stream().map(ForecastExpressDTO.Commodity::getTotalPrice).reduce(new BigDecimal("0.000"), BigDecimal::add)).orElse(BigDecimal.ZERO))
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
                    .setOriginalProductRemarks(forecastExpressDTO.getRemark())
                    .setGoods(Optional.ofNullable(forecastExpressDTO.getCommodityLists()).map(commodities -> commodities.stream().map(QualityControlSheetAssembler::toResult).collect(Collectors.toList())).orElse(null));
        });
    }

    public static QualityControlSheetGoodsInfoResult toResult(ForecastExpressDTO.Commodity commodity) {
        return new QualityControlSheetGoodsInfoResult()
                .setId(commodity.getId())
                .setProductName(commodity.getGoodsName())
                .setGoodsName(commodity.getGoodsName())
                .setGoodsType(commodity.getE3GoodsTypeName())
                .setSpecification(commodity.getGoodsSpecification())
                .setShipmentQuantity(commodity.getQuantityShipped())
                .setUnitPrice(commodity.getUnitPrice())
                .setTotalPrice(commodity.getTotalPrice())
                .setImageUrl(commodity.getProductImg());

    }
}
