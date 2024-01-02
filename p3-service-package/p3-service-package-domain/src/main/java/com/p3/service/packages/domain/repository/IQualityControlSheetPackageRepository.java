package com.p3.service.packages.domain.repository;

import com.p3.service.packages.domain.model.entity.QualityControlSheetPackage;

import java.util.List;

public interface IQualityControlSheetPackageRepository {

    Boolean cleanBySheetId(String sheetId);

    Boolean createBatch(List<QualityControlSheetPackage> packages);
}
