package com.p3.service.packages.domain.repository;

import com.p3.service.packages.domain.model.entity.PackageMainInfo;

import java.util.List;

public interface IPackageMainInfoRepository {

    String create(PackageMainInfo packageMainInfo);
    void createBatch(List<PackageMainInfo> packageMainInfos);
}
