package com.p3.service.packages.application.assembler;

import com.p3.service.packages.domain.model.entity.QualityControlSheetGoodsInfo;
import com.p3.service.packages.infrastructure.client.dto.ForecastExpressDTO;

import java.util.List;
import java.util.stream.Collectors;

public class QualityControlSheetGoodsInfoAssembler {

    public static QualityControlSheetGoodsInfo toEntity(String sheetId, ForecastExpressDTO.Commodity commodity) {

        return new QualityControlSheetGoodsInfo(
                null,
                sheetId,
                commodity.getGoodsName(),
                commodity.getGoodsName(),
                commodity.getGoodsTypeId(),
                commodity.getGoodsSpecification(),
                commodity.getQuantityShipped(),
                commodity.getUnitPrice(),
                commodity.getTotalPrice(),
                commodity.getProductImg()
        );
    }

    public static List<QualityControlSheetGoodsInfo> toEntities(String sheetId, List<ForecastExpressDTO.Commodity> commodities) {

        return commodities.stream().map(commodity -> QualityControlSheetGoodsInfoAssembler.toEntity(sheetId, commodity)).collect(Collectors.toList());
    }
}
