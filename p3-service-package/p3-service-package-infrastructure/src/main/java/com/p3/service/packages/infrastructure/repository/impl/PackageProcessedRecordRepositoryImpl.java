package com.p3.service.packages.infrastructure.repository.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.p3.service.packages.domain.model.entity.PackageProcessedRecord;
import com.p3.service.packages.domain.repository.IPackageProcessedRecordRepository;
import com.p3.service.packages.infrastructure.repository.convertor.PackageProcessedRecordEntityConvertor;
import com.p3.service.packages.infrastructure.repository.entity.PackageProcessedRecordEntity;
import com.p3.service.packages.infrastructure.repository.mapper.PackageProcessedRecordMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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

    @Override
    public PackageProcessedRecord getByExpressBillNumber(String expressBillNumber) {

        Optional<PackageProcessedRecordEntity> packageProcessedRecordEntityOptional = Optional.ofNullable(packageProcessedRecordMapper.selectOne(Wrappers.lambdaQuery(PackageProcessedRecordEntity.class).eq(PackageProcessedRecordEntity::getTicketsNum, expressBillNumber)));
        return packageProcessedRecordEntityOptional.map(PackageProcessedRecordEntityConvertor::convertToDomainEntity).orElse(null);
    }
}
