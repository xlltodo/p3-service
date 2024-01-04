package com.p3.service.packages.infrastructure.repository.impl;

import com.p3.service.packages.domain.model.entity.CompositePackageMainInfo;
import com.p3.service.packages.domain.repository.ICompositePackageMainInfoRepository;
import com.p3.service.packages.infrastructure.repository.convertor.CompositePackageMainInfoConvertor;
import com.p3.service.packages.infrastructure.repository.entity.CompositePackageAssociationEntity;
import com.p3.service.packages.infrastructure.repository.entity.CompositePackageSpatialAttributeEntity;
import com.p3.service.packages.infrastructure.repository.entity.CompositePackageTrackingNumberEntity;
import com.p3.service.packages.infrastructure.repository.mapper.CompositePackageAssociationMapper;
import com.p3.service.packages.infrastructure.repository.mapper.CompositePackageMainInfoMapper;
import com.p3.service.packages.infrastructure.repository.mapper.CompositePackageSpatialAttributeMapper;
import com.p3.service.packages.infrastructure.repository.mapper.CompositePackageTrackingNumberMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class CompositePackageMainInfoRepositoryImpl implements ICompositePackageMainInfoRepository {

    @Resource
    private CompositePackageMainInfoMapper compositePackageMainInfoMapper;
    @Resource
    private CompositePackageTrackingNumberMapper compositePackageTrackingNumberMapper;
    @Resource
    private CompositePackageSpatialAttributeMapper compositePackageSpatialAttributeMapper;
    @Resource
    private CompositePackageAssociationMapper compositePackageAssociationMapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String createCompositePackage(CompositePackageMainInfo compositePackageMainInfo) {

        List<CompositePackageTrackingNumberEntity> trackingNumberEntities = CompositePackageMainInfoConvertor.convertToTrackingNumberDataEntities(compositePackageMainInfo.getTrackingNumbers());
        Optional.ofNullable(trackingNumberEntities).ifPresent(list -> list.forEach(compositePackageTrackingNumberMapper::insert));

        List<CompositePackageSpatialAttributeEntity> spatialAttributeEntities = CompositePackageMainInfoConvertor.convertToSpatialAttributeDataEntities(compositePackageMainInfo.getSpatialAttributes());
        Optional.ofNullable(spatialAttributeEntities).ifPresent(list -> list.forEach(compositePackageSpatialAttributeMapper::insert));

        List<CompositePackageAssociationEntity> associationEntities = CompositePackageMainInfoConvertor.convertToAssociationDataEntities(compositePackageMainInfo.getPackageAssociations());
        Optional.ofNullable(associationEntities).ifPresent(list -> list.forEach(compositePackageAssociationMapper::insert));

        return compositePackageMainInfoMapper.insert(CompositePackageMainInfoConvertor.convertToDataEntity(compositePackageMainInfo)) > 0 ? compositePackageMainInfo.getCompositePackageCode() : null;
    }
}
