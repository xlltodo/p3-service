package com.p3.service.packages.domain.service;

import com.p3.service.packages.domain.model.entity.QualityControlSheetGoodsInfo;
import com.p3.service.packages.domain.repository.IQualityControlSheetGoodsInfoRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QualityControlSheetGoodsInfoDomainService {

    @Resource
    private IQualityControlSheetGoodsInfoRepository qualityControlSheetGoodsInfoRepository;

    public Boolean cleanBySheetId(String sheetId) {
        return qualityControlSheetGoodsInfoRepository.cleanBySheetId(sheetId);
    }

    public Boolean createBatch(List<QualityControlSheetGoodsInfo> goodsInfos) {
        return qualityControlSheetGoodsInfoRepository.createBatch(goodsInfos);
    }

}