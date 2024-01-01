package com.p3.service.packages.infrastructure.repository.impl;

import com.p3.service.packages.domain.model.entity.PackageMainInfo;
import com.p3.service.packages.domain.repository.IPackageMainInfoRepository;
import com.p3.service.packages.infrastructure.repository.convertor.PackageMainInfoEntityConvertor;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PackageMainInfoRepositoryImpl implements IPackageMainInfoRepository {

    @Resource
    private PackageMainInfoMapper packageMainInfoMapper;
    @Override
    @Transactional(rollbackFor = Exception.class)
    public String create(PackageMainInfo packageMainInfo) {

        PackageMainInfoEntity packageMainInfoEntity = PackageMainInfoEntityConvertor.convertToDataEntity(packageMainInfo);
        if(packageMainInfoMapper.insert(packageMainInfoEntity) > 0) {

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
