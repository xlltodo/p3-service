package com.p3.service.packages.infrastructure.repository.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.p3.service.packages.domain.model.entity.PackageMainInfo;
import com.p3.service.packages.domain.model.entity.PackageStatusEnum;
import com.p3.service.packages.domain.model.entity.PackageTrackingNumberTypeEnum;
import com.p3.service.packages.domain.repository.IPackageMainInfoRepository;
import com.p3.service.packages.infrastructure.common.IPageConvertor;
import com.p3.service.packages.infrastructure.repository.convertor.PackageMainInfoConvertor;
import com.p3.service.packages.infrastructure.repository.entity.*;
import com.p3.service.packages.infrastructure.repository.mapper.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public PackageMainInfo infoById(String id) {

        PackageMainInfoEntity packageMainInfoEntity = packageMainInfoMapper.selectById(id);
        if(ObjectUtils.isEmpty(packageMainInfoEntity)) {
            return null;
        }
        List<PackageTrackingNumberEntity> packageTrackingNumberEntities = packageTrackingNumberMapper.selectList(Wrappers.lambdaQuery(PackageTrackingNumberEntity.class).eq(PackageTrackingNumberEntity::getPackageCode, packageMainInfoEntity.getPackageCode()));
        List<PackageSpatialAttributeEntity> packageSpatialAttributeEntities = packageSpatialAttributeMapper.selectList(Wrappers.lambdaQuery(PackageSpatialAttributeEntity.class).eq(PackageSpatialAttributeEntity::getPackageCode, packageMainInfoEntity.getPackageCode()));
        List<PackageServiceItemEntity> packageServiceItemEntities = packageServiceItemMapper.selectList(Wrappers.lambdaQuery(PackageServiceItemEntity.class).eq(PackageServiceItemEntity::getPackageCode, packageMainInfoEntity.getPackageCode()));
        List<PackageGoodsInfoEntity> packageGoodsInfoEntities = packageGoodsInfoMapper.selectList(Wrappers.lambdaQuery(PackageGoodsInfoEntity.class).eq(PackageGoodsInfoEntity::getPackageCode, packageMainInfoEntity.getPackageCode()));
        return PackageMainInfoConvertor.convertToDomainEntity(packageMainInfoEntity, packageTrackingNumberEntities, packageSpatialAttributeEntities, packageServiceItemEntities, packageGoodsInfoEntities);
    }

    @Override
    public PackageMainInfo infoByCxNumber(String cxNumber) {

        PackageTrackingNumberEntity packageTrackingNumberEntity = packageTrackingNumberMapper.selectOne(Wrappers.lambdaQuery(PackageTrackingNumberEntity.class).eq(PackageTrackingNumberEntity::getNumberType, PackageTrackingNumberTypeEnum.CX_NUMBER.getCode()).eq(PackageTrackingNumberEntity::getTrackingNumber, cxNumber).last("LIMIT 1"));
        if(ObjectUtils.isEmpty(packageTrackingNumberEntity)) {
            return null;
        }
        PackageMainInfoEntity packageMainInfoEntity = packageMainInfoMapper.selectOne(Wrappers.lambdaQuery(PackageMainInfoEntity.class).eq(PackageMainInfoEntity::getPackageCode, packageTrackingNumberEntity.getPackageCode()).last("LIMIT 1"));
        List<PackageTrackingNumberEntity> packageTrackingNumberEntities = packageTrackingNumberMapper.selectList(Wrappers.lambdaQuery(PackageTrackingNumberEntity.class).eq(PackageTrackingNumberEntity::getPackageCode, packageMainInfoEntity.getPackageCode()));
        List<PackageSpatialAttributeEntity> packageSpatialAttributeEntities = packageSpatialAttributeMapper.selectList(Wrappers.lambdaQuery(PackageSpatialAttributeEntity.class).eq(PackageSpatialAttributeEntity::getPackageCode, packageMainInfoEntity.getPackageCode()));
        List<PackageServiceItemEntity> packageServiceItemEntities = packageServiceItemMapper.selectList(Wrappers.lambdaQuery(PackageServiceItemEntity.class).eq(PackageServiceItemEntity::getPackageCode, packageMainInfoEntity.getPackageCode()));
        List<PackageGoodsInfoEntity> packageGoodsInfoEntities = packageGoodsInfoMapper.selectList(Wrappers.lambdaQuery(PackageGoodsInfoEntity.class).eq(PackageGoodsInfoEntity::getPackageCode, packageMainInfoEntity.getPackageCode()));
        return PackageMainInfoConvertor.convertToDomainEntity(packageMainInfoEntity, packageTrackingNumberEntities, packageSpatialAttributeEntities, packageServiceItemEntities, packageGoodsInfoEntities);
    }

    @Override
    public <T extends IPage<String>> IPage<String> idPage(T page, PackageStatusEnum packageStatus, String customerCode, String customerNickname, String cxNumber) {

        return packageMainInfoMapper.idPages(IPageConvertor.convertor(page), packageStatus, customerCode, customerNickname, cxNumber);
    }

    @Override
    public List<PackageMainInfo> listByExpressBillNumber(String expressBillNumber) {

        List<PackageTrackingNumberEntity> packageTrackingNumberEntityList = packageTrackingNumberMapper.selectList(Wrappers.lambdaQuery(PackageTrackingNumberEntity.class).eq(PackageTrackingNumberEntity::getNumberType, PackageTrackingNumberTypeEnum.EXPRESS_NUMBER.getCode()).eq(PackageTrackingNumberEntity::getTrackingNumber, expressBillNumber));
        if(CollectionUtils.isEmpty(packageTrackingNumberEntityList)) {
            return null;
        }
        return packageTrackingNumberEntityList.stream().map(packageTrackingNumberEntity -> {

            PackageMainInfoEntity packageMainInfoEntity = packageMainInfoMapper.selectOne(Wrappers.lambdaQuery(PackageMainInfoEntity.class).eq(PackageMainInfoEntity::getPackageCode, packageTrackingNumberEntity.getPackageCode()).last("LIMIT 1"));
            List<PackageTrackingNumberEntity> packageTrackingNumberEntities = packageTrackingNumberMapper.selectList(Wrappers.lambdaQuery(PackageTrackingNumberEntity.class).eq(PackageTrackingNumberEntity::getPackageCode, packageMainInfoEntity.getPackageCode()));
            List<PackageSpatialAttributeEntity> packageSpatialAttributeEntities = packageSpatialAttributeMapper.selectList(Wrappers.lambdaQuery(PackageSpatialAttributeEntity.class).eq(PackageSpatialAttributeEntity::getPackageCode, packageMainInfoEntity.getPackageCode()));
            List<PackageServiceItemEntity> packageServiceItemEntities = packageServiceItemMapper.selectList(Wrappers.lambdaQuery(PackageServiceItemEntity.class).eq(PackageServiceItemEntity::getPackageCode, packageMainInfoEntity.getPackageCode()));
            List<PackageGoodsInfoEntity> packageGoodsInfoEntities = packageGoodsInfoMapper.selectList(Wrappers.lambdaQuery(PackageGoodsInfoEntity.class).eq(PackageGoodsInfoEntity::getPackageCode, packageMainInfoEntity.getPackageCode()));
            return PackageMainInfoConvertor.convertToDomainEntity(packageMainInfoEntity, packageTrackingNumberEntities, packageSpatialAttributeEntities, packageServiceItemEntities, packageGoodsInfoEntities);
        }).collect(Collectors.toList());
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
