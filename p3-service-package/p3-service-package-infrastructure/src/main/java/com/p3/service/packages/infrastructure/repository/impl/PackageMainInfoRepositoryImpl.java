package com.p3.service.packages.infrastructure.repository.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.p3.service.packages.domain.model.entity.PackageMainInfo;
import com.p3.service.packages.domain.model.entity.PackageSpatialAttribute;
import com.p3.service.packages.domain.model.entity.PackageTrackingNumberTypeEnum;
import com.p3.service.packages.domain.repository.IPackageMainInfoRepository;
import com.p3.service.packages.infrastructure.repository.convertor.PackageMainInfoConvertor;
import com.p3.service.packages.infrastructure.repository.entity.PackageMainInfoEntity;
import com.p3.service.packages.infrastructure.repository.entity.PackageServiceItemEntity;
import com.p3.service.packages.infrastructure.repository.entity.PackageSpatialAttributeEntity;
import com.p3.service.packages.infrastructure.repository.entity.PackageTrackingNumberEntity;
import com.p3.service.packages.infrastructure.repository.mapper.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class PackageMainInfoRepositoryImpl implements IPackageMainInfoRepository {

    @Resource
    private PackageMainInfoMapper packageMainInfoMapper;
    @Resource
    private PackageTrackingNumberMapper packageTrackingNumberMapper;
    @Resource
    private PackageSpatialAttributeMapper packageSpatialAttributeMapper;
    @Resource
    private PackageServiceItemMapper packageServiceItemMapper;
    @Resource
    private PackageGoodsInfoMapper packageGoodsInfoMapper;

    @Override
    public PackageMainInfo info(String cxNumber) {

        PackageTrackingNumberEntity packageTrackingNumberEntity = packageTrackingNumberMapper.selectOne(Wrappers.lambdaQuery(PackageTrackingNumberEntity.class).eq(PackageTrackingNumberEntity::getNumberType, PackageTrackingNumberTypeEnum.CX_NUMBER.getCode()).eq(PackageTrackingNumberEntity::getTrackingNumber, cxNumber).last("LIMIT 1"));
        PackageMainInfoEntity packageMainInfoEntity = packageMainInfoMapper.selectOne(Wrappers.lambdaQuery(PackageMainInfoEntity.class).eq(PackageMainInfoEntity::getPackageCode, packageTrackingNumberEntity.getPackageCode()).last("LIMIT 1"));
        List<PackageTrackingNumberEntity> packageTrackingNumberEntities = packageTrackingNumberMapper.selectList(Wrappers.lambdaQuery(PackageTrackingNumberEntity.class).eq(PackageTrackingNumberEntity::getPackageCode, packageMainInfoEntity.getPackageCode()));
        List<PackageSpatialAttributeEntity> packageSpatialAttributeEntities = packageSpatialAttributeMapper.selectList(Wrappers.lambdaQuery(PackageSpatialAttributeEntity.class).eq(PackageSpatialAttributeEntity::getPackageCode, packageMainInfoEntity.getPackageCode()));
        List<PackageServiceItemEntity> packageServiceItemEntities = packageServiceItemMapper.selectList(Wrappers.lambdaQuery(PackageServiceItemEntity.class).eq(PackageServiceItemEntity::getPackageCode, packageMainInfoEntity.getPackageCode()));
        return PackageMainInfoConvertor.convertToDomainEntity(packageMainInfoEntity, packageTrackingNumberEntities, packageSpatialAttributeEntities, packageServiceItemEntities);
    }

    @Override
    public List<PackageMainInfo> listByExpressBillNumber(String expressBillNumber) {
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String create(PackageMainInfo packageMainInfo) {

        PackageMainInfoEntity packageMainInfoEntity = PackageMainInfoConvertor.convertToDataEntity(packageMainInfo);
        if(packageMainInfoMapper.insert(packageMainInfoEntity) > 0) {

            Optional.ofNullable(PackageMainInfoConvertor.convertToPackageTrackingNumberDataEntities(packageMainInfo.getTrackingNumbers()))
                    .ifPresent(list -> list.forEach(packageTrackingNumberMapper::insert));

            Optional.ofNullable(PackageMainInfoConvertor.convertToPackageServiceItemDataEntities(packageMainInfo.getServiceItems()))
                    .ifPresent(list -> list.forEach(packageServiceItemMapper::insert));

            Optional.ofNullable(PackageMainInfoConvertor.convertToPackageSpatialAttributeDataEntities(packageMainInfo.getSpatialAttributes()))
                    .ifPresent(list -> list.forEach(packageSpatialAttributeMapper::insert));

            Optional.ofNullable(PackageMainInfoConvertor.convertToPackageGoodsInfoDataEntities(packageMainInfo.getGoodsInfos()))
                    .ifPresent(list -> list.forEach(packageGoodsInfoMapper::insert));

            return packageMainInfoEntity.getId();
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void createBatch(List<PackageMainInfo> packageMainInfos) {

        packageMainInfos.forEach(this::create);
    }
}
