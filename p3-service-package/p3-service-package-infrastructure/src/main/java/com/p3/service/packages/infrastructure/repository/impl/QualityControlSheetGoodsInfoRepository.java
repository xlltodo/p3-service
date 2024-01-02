package com.p3.service.packages.infrastructure.repository.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.p3.service.packages.domain.model.entity.QualityControlSheetGoodsInfo;
import com.p3.service.packages.domain.repository.IQualityControlSheetGoodsInfoRepository;
import com.p3.service.packages.infrastructure.repository.convertor.QualityControlSheetGoodsInfoEntityConvertor;
import com.p3.service.packages.infrastructure.repository.entity.QualityControlSheetGoodsInfoEntity;
import com.p3.service.packages.infrastructure.repository.mapper.QualityControlSheetGoodsInfoMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class QualityControlSheetGoodsInfoRepository implements IQualityControlSheetGoodsInfoRepository {

    @Resource
    private QualityControlSheetGoodsInfoMapper qualityControlSheetGoodsInfoMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean cleanBySheetId(String sheetId) {

        qualityControlSheetGoodsInfoMapper.delete(Wrappers.lambdaQuery(QualityControlSheetGoodsInfoEntity.class).eq(QualityControlSheetGoodsInfoEntity::getSheetId, sheetId));
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean createBatch(List<QualityControlSheetGoodsInfo> goodsInfos) {

        if(CollectionUtils.isEmpty(goodsInfos)) {
            return true;
        }
        goodsInfos.stream().map(goodsInfo -> qualityControlSheetGoodsInfoMapper.insert(QualityControlSheetGoodsInfoEntityConvertor.convertToDataEntity(goodsInfo)));
        return true;
    }
}
