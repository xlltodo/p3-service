package com.p3.service.packages.infrastructure.repository.impl;

import com.p3.service.packages.domain.model.entity.PackageProcessedRecord;
import com.p3.service.packages.domain.repository.IPackageProcessedRecordRepository;
import com.p3.service.packages.infrastructure.repository.convertor.PackageProcessedRecordEntityConvertor;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

@Repository
public class PackageProcessedRecordRepositoryImpl implements IPackageProcessedRecordRepository {

    @Resource
    private PackageProcessedRecordMapper packageProcessedRecordMapper;

    @Override
    public PackageProcessedRecord save(PackageProcessedRecord packageProcessedRecord) {

        PackageProcessedRecordEntity packageProcessedRecordEntity = PackageProcessedRecordEntityConvertor.convertToDataEntity(packageProcessedRecord);
        packageProcessedRecordMapper.insert(packageProcessedRecordEntity);
        return PackageProcessedRecordEntityConvertor.convertToDomainEntity(packageProcessedRecordEntity);
    }
}
