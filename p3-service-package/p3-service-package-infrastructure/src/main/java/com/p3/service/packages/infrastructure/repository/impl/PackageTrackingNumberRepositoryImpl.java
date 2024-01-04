package com.p3.service.packages.infrastructure.repository.impl;

import com.p3.service.packages.domain.model.entity.PackageTrackingNumber;
import com.p3.service.packages.domain.repository.IPackageTrackingNumberRepository;
import com.p3.service.packages.infrastructure.repository.convertor.PackageTrackingNumberConvertor;
import com.p3.service.packages.infrastructure.repository.mapper.PackageTrackingNumberMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class PackageTrackingNumberRepositoryImpl implements IPackageTrackingNumberRepository {

    @Resource
    private PackageTrackingNumberMapper packageTrackingNumberMapper;

    @Override
    public Boolean addTrackingNumber(PackageTrackingNumber packageTrackingNumber) {

        return packageTrackingNumberMapper.insert(PackageTrackingNumberConvertor.convertToDataEntity(packageTrackingNumber)) > 1;
    }
}
