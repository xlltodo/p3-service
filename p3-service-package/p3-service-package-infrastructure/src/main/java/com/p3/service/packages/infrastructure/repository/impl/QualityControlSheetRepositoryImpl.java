package com.p3.service.packages.infrastructure.repository.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.p3.service.packages.domain.model.entity.QualityControlSheet;
import com.p3.service.packages.domain.repository.IQualityControlSheetRepository;
import com.p3.service.packages.infrastructure.repository.convertor.PackageQualityControlSheetEntityConvertor;
import com.p3.service.packages.infrastructure.repository.entity.PackageQualityControlSheetEntity;
import com.p3.service.packages.infrastructure.repository.mapper.PackageQualityControlSheetMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Repository
public class QualityControlSheetRepositoryImpl implements IQualityControlSheetRepository {

    @Resource
    private PackageQualityControlSheetMapper packageQualityControlSheetMapper;

    @Override
    public QualityControlSheet getBuyExpressBillNumber(String expressBillNumber) {


        Optional<PackageQualityControlSheetEntity> packageQualityControlSheetOptional = Optional.ofNullable(packageQualityControlSheetMapper.selectOne(Wrappers.lambdaQuery(PackageQualityControlSheetEntity.class).eq(PackageQualityControlSheetEntity::getExpressBillNumber, expressBillNumber).last("LIMIT 1")));

        return packageQualityControlSheetOptional.map(PackageQualityControlSheetEntityConvertor::convertToDomainEntity).orElse(null);
    }

    @Override
    public Boolean checkExist(String expressBillNumber) {
        return packageQualityControlSheetMapper.exists(Wrappers.lambdaQuery(PackageQualityControlSheetEntity.class).eq(PackageQualityControlSheetEntity::getExpressBillNumber, expressBillNumber).last("LIMIT 1"));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean create(QualityControlSheet qualityControlSheet) {

        PackageQualityControlSheetEntity packageQualityControlSheetEntity = PackageQualityControlSheetEntityConvertor.convertToDataEntity(qualityControlSheet);
        if (this.checkExist(packageQualityControlSheetEntity.getExpressBillNumber())) {
            return false;
        }
        return packageQualityControlSheetMapper.insert(packageQualityControlSheetEntity) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean update(QualityControlSheet qualityControlSheet) {

        PackageQualityControlSheetEntity packageQualityControlSheetEntity = PackageQualityControlSheetEntityConvertor.convertToDataEntity(qualityControlSheet);
        if (this.checkExist(packageQualityControlSheetEntity.getExpressBillNumber())) {
            return false;
        }
        return packageQualityControlSheetMapper.insert(packageQualityControlSheetEntity) > 0;
    }
}
