package com.p3.service.packages.infrastructure.repository.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.p3.service.packages.domain.model.entity.QualityControlSheet;
import com.p3.service.packages.domain.repository.IQualityControlSheetRepository;
import com.p3.service.packages.infrastructure.repository.convertor.QualityControlSheetEntityConvertor;
import com.p3.service.packages.infrastructure.repository.entity.QualityControlSheetEntity;
import com.p3.service.packages.infrastructure.repository.entity.QualityControlSheetGoodsInfoEntity;
import com.p3.service.packages.infrastructure.repository.entity.QualityControlSheetPackageEntity;
import com.p3.service.packages.infrastructure.repository.entity.QualityControlSheetServiceItemEntity;
import com.p3.service.packages.infrastructure.repository.mapper.QualityControlSheetGoodsInfoMapper;
import com.p3.service.packages.infrastructure.repository.mapper.QualityControlSheetMapper;
import com.p3.service.packages.infrastructure.repository.mapper.QualityControlSheetPackageMapper;
import com.p3.service.packages.infrastructure.repository.mapper.QualityControlSheetServiceItemMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
public class QualityControlSheetRepositoryImpl implements IQualityControlSheetRepository {

    @Resource
    private QualityControlSheetMapper packageQualityControlSheetMapper;
    @Resource
    private QualityControlSheetPackageMapper qualityControlSheetPackageMapper;
    @Resource
    private QualityControlSheetServiceItemMapper qualityControlSheetServiceItemMapper;
    @Resource
    private QualityControlSheetGoodsInfoMapper qualityControlSheetGoodsInfoMapper;

    @Override
    public QualityControlSheet getBuyExpressBillNumber(String expressBillNumber) {

        Optional<QualityControlSheetEntity> sheetEntityOptional = Optional.ofNullable(packageQualityControlSheetMapper.selectOne(Wrappers.lambdaQuery(QualityControlSheetEntity.class).eq(QualityControlSheetEntity::getExpressBillNumber, expressBillNumber).last("LIMIT 1")));
        if(sheetEntityOptional.isEmpty()){
            return null;
        }
        String sheetId = sheetEntityOptional.get().getId();
        Optional<List<QualityControlSheetPackageEntity>> packageEntitiesOptional = Optional.ofNullable(qualityControlSheetPackageMapper.selectList(Wrappers.lambdaQuery(QualityControlSheetPackageEntity.class).eq(QualityControlSheetPackageEntity::getSheetId, sheetId)));
        Optional<List<QualityControlSheetServiceItemEntity>> serviceItemEntitiesOptional = Optional.ofNullable(qualityControlSheetServiceItemMapper.selectList(Wrappers.lambdaQuery(QualityControlSheetServiceItemEntity.class).eq(QualityControlSheetServiceItemEntity::getSheetId, sheetId)));
        Optional<List<QualityControlSheetGoodsInfoEntity>> goodsInfoEntitiesOptional = Optional.ofNullable(qualityControlSheetGoodsInfoMapper.selectList(Wrappers.lambdaQuery(QualityControlSheetGoodsInfoEntity.class).eq(QualityControlSheetGoodsInfoEntity::getSheetId, sheetId)));

        return QualityControlSheetEntityConvertor.convertToDomainEntity(sheetEntityOptional.get(), packageEntitiesOptional.get(), serviceItemEntitiesOptional.get(), goodsInfoEntitiesOptional.get());
    }

    @Override
    public Boolean checkExist(String expressBillNumber) {
        return packageQualityControlSheetMapper.exists(Wrappers.lambdaQuery(QualityControlSheetEntity.class).eq(QualityControlSheetEntity::getExpressBillNumber, expressBillNumber).last("LIMIT 1"));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean create(QualityControlSheet qualityControlSheet) {

        QualityControlSheetEntity packageQualityControlSheetEntity = QualityControlSheetEntityConvertor.convertToDataEntity(qualityControlSheet);
        if (this.checkExist(packageQualityControlSheetEntity.getExpressBillNumber())) {
            return false;
        }
        return packageQualityControlSheetMapper.insert(packageQualityControlSheetEntity) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean update(QualityControlSheet qualityControlSheet) {

        QualityControlSheetEntity packageQualityControlSheetEntity = QualityControlSheetEntityConvertor.convertToDataEntity(qualityControlSheet);
        if (this.checkExist(packageQualityControlSheetEntity.getExpressBillNumber())) {
            packageQualityControlSheetMapper.delete(Wrappers.lambdaQuery(QualityControlSheetEntity.class).eq(QualityControlSheetEntity::getExpressBillNumber, packageQualityControlSheetEntity.getExpressBillNumber()));
        }
        return packageQualityControlSheetMapper.insert(packageQualityControlSheetEntity) > 0;
    }

    @Override
    public Boolean delete(String expressBillNumber) {
        return packageQualityControlSheetMapper.delete(Wrappers.lambdaQuery(QualityControlSheetEntity.class).eq(QualityControlSheetEntity::getExpressBillNumber, expressBillNumber)) > 0;
    }
}
