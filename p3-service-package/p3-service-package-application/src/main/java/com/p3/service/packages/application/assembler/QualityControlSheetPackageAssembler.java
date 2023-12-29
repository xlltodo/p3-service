package com.p3.service.packages.application.assembler;

import com.p3.service.packages.application.command.QualityControlSheetPackageCommand;
import com.p3.service.packages.application.result.QualityControlSheetPackageResult;
import com.p3.service.packages.domain.model.entity.QualityControlSheetPackage;
import com.p3.service.packages.domain.model.mapper.PackageQualityControlSheetAssociationMapper;

import java.util.List;
import java.util.stream.Collectors;

public class QualityControlSheetPackageAssembler {

    public static QualityControlSheetPackage toEntity(QualityControlSheetPackageCommand command) {
        return new QualityControlSheetPackage(
                command.getId(),
                command.getSheetId(),
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

    public static List<QualityControlSheetPackage> toEntities(List<QualityControlSheetPackageCommand> commands) {

        return commands.stream().map(qualityControlSheetPackageCommand -> {
            return new QualityControlSheetPackage(
                    qualityControlSheetPackageCommand.getId(),
                    qualityControlSheetPackageCommand.getSheetId(),
                    qualityControlSheetPackageCommand.getWeight(),
                    qualityControlSheetPackageCommand.getLength(),
                    qualityControlSheetPackageCommand.getWidth(),
                    qualityControlSheetPackageCommand.getHeight(),
                    qualityControlSheetPackageCommand.getVolume(),
                    qualityControlSheetPackageCommand.getQuantity(),
                    qualityControlSheetPackageCommand.getProductName(),
                    qualityControlSheetPackageCommand.getBrandName(),
                    qualityControlSheetPackageCommand.getPrimaryGoodsType(),
                    qualityControlSheetPackageCommand.getSecondaryGoodsType()
            );
        }).collect(Collectors.toList());
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

        return entities.stream().map(qualityControlSheetPackage -> {
            PackageQualityControlSheetAssociationMapper<QualityControlSheetPackageResult> mapper = (id, sheetId, weight, length, width, height, volume, quantity, productName, brandName, primaryGoodsType, secondaryGoodsType) ->
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
                            .setSecondaryGoodsType(secondaryGoodsType);

            return qualityControlSheetPackage.mapWith(mapper);
        }).collect(Collectors.toList());

    }
}
