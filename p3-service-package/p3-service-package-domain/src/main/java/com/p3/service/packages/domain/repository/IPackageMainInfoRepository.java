package com.p3.service.packages.domain.repository;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.p3.service.packages.domain.model.entity.PackageMainInfo;
import com.p3.service.packages.domain.model.entity.PackageStatusEnum;

import java.util.List;

public interface IPackageMainInfoRepository {

    PackageMainInfo infoById(String id);

    PackageMainInfo infoByCxNumber(String cxNumber);

    <T extends IPage<String>> IPage<String> idPage(T page, PackageStatusEnum packageStatus, String customerCode, String customerNickname, String cxNumber);

    List<PackageMainInfo> listByExpressBillNumber(String expressBillNumber);

    String create(PackageMainInfo packageMainInfo);

    void createBatch(List<PackageMainInfo> packageMainInfos);
}
