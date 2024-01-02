package com.p3.service.packages.application.assembler;

import com.p3.service.packages.application.command.QualityControlSheetPackageCommand;
import com.p3.service.packages.application.result.QualityControlSheetPackageResult;
import com.p3.service.packages.domain.model.entity.QualityControlSheetPackage;
import com.p3.service.packages.domain.model.mapper.QualityControlSheetPackageMapper;

import java.util.List;
import java.util.stream.Collectors;

public class QualityControlSheetPackageAssembler {

    public static QualityControlSheetPackage toEntity(String sheetId, QualityControlSheetPackageCommand command) {
        return new QualityControlSheetPackage(
                null,
                sheetId,
                command.getWeight(),
                command.getLength(),
                command.getWidth(),
                command.getHeight(),
                command.getVolume(),
                command.getQuantity(),
                command.getProductName(),
                command.getBrandName(),
                command.getPrimaryGoodsType(),
                command.getSecondaryGoodsType()
        );
    }

    public static List<QualityControlSheetPackage> toEntities(String sheetId, List<QualityControlSheetPackageCommand> commands) {

        return commands.stream().map(command -> QualityControlSheetPackageAssembler.toEntity(sheetId, command)).collect(Collectors.toList());
    }

    public static QualityControlSheetPackageResult toResult(QualityControlSheetPackage entity) {

        return entity.mapWith((id, sheetId, weight, length, width, height, volume, quantity, productName, brandName, primaryGoodsType, secondaryGoodsType) ->
                new QualityControlSheetPackageResult()
                        .setId(id)
                        .setSheetId(sheetId)
                        .setWeight(weight)
                        .setLength(length)
                        .setWidth(width)
                        .setHeight(height)
                        .setVolume(volume)
                        .setQuantity(quantity)
                        .setProductName(productName)
                        .setBrandName(brandName)
                        .setPrimaryGoodsType(primaryGoodsType)
                        .setSecondaryGoodsType(secondaryGoodsType));
    }

    public static List<QualityControlSheetPackageResult> toResults(List<QualityControlSheetPackage> entities) {

        return entities.stream().map(QualityControlSheetPackageAssembler::toResult).collect(Collectors.toList());

    }
}
