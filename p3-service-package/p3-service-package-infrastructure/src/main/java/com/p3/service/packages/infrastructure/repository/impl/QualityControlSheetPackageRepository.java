package com.p3.service.packages.infrastructure.repository.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.p3.service.packages.domain.model.entity.QualityControlSheetPackage;
import com.p3.service.packages.domain.repository.IQualityControlSheetPackageRepository;
import com.p3.service.packages.infrastructure.repository.convertor.QualityControlSheetPackageEntityConvertor;
import com.p3.service.packages.infrastructure.repository.entity.QualityControlSheetPackageEntity;
import com.p3.service.packages.infrastructure.repository.mapper.QualityControlSheetPackageMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class QualityControlSheetPackageRepository implements IQualityControlSheetPackageRepository {

    @Resource
    private QualityControlSheetPackageMapper qualityControlSheetPackageMapper;

    @Override
    public Boolean cleanBySheetId(String sheetId) {

        qualityControlSheetPackageMapper.delete(Wrappers.lambdaQuery(QualityControlSheetPackageEntity.class).eq(QualityControlSheetPackageEntity::getSheetId, sheetId));
        return true;
    }

    @Override
    public Boolean createBatch(List<QualityControlSheetPackage> packages) {

        if(CollectionUtils.isEmpty(packages)) {
            return true;
        }
        packages.forEach(sheetPackage -> qualityControlSheetPackageMapper.insert(QualityControlSheetPackageEntityConvertor.convertToDataEntity(sheetPackage)));
        return true;
    }
}
