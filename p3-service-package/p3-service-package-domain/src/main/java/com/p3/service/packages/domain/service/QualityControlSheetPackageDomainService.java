package com.p3.service.packages.domain.service;

import com.p3.service.packages.domain.model.entity.QualityControlSheetPackage;
import com.p3.service.packages.domain.repository.IQualityControlSheetPackageRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QualityControlSheetPackageDomainService {

    @Resource
    private IQualityControlSheetPackageRepository qualityControlSheetPackageRepository;

    public Boolean cleanBySheetId(String sheetId) {
        return qualityControlSheetPackageRepository.cleanBySheetId(sheetId);
    }

    public Boolean createBatch(List<QualityControlSheetPackage> packages) {
        return qualityControlSheetPackageRepository.createBatch(packages);
    }

}
