package com.p3.service.packages.domain.service;

import com.p3.service.packages.domain.model.mapper.PackageProcessedRecordMapper;
import com.p3.service.packages.domain.repository.IPackageProcessedRecordRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class PackageProcessedRecordDomainService {

    @Resource
    private IPackageProcessedRecordRepository packageProcessedRecordRepository;
}
