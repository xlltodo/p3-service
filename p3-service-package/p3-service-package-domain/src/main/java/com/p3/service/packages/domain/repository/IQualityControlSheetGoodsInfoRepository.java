package com.p3.service.packages.domain.repository;

import com.p3.service.packages.domain.model.entity.QualityControlSheetGoodsInfo;

import java.util.List;

public interface IQualityControlSheetGoodsInfoRepository {

    Boolean cleanBySheetId(String sheetId);

    Boolean createBatch(List<QualityControlSheetGoodsInfo> goodsInfos);
}
