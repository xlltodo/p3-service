package com.p3.service.packages.application.handler;

import com.p3.service.packages.application.assembler.PackageMainInfoAssembler;
import com.p3.service.packages.application.result.PackageMainInfoResult;
import com.p3.service.packages.domain.model.entity.PackageMainInfo;
import com.p3.service.packages.domain.repository.IPackageMainInfoRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class PackageQueryHandler {

    @Resource
    private IPackageMainInfoRepository packageMainInfoRepository;

    public PackageMainInfoResult info(String cxNumber) {

        return PackageMainInfoAssembler.toResult(packageMainInfoRepository.info(cxNumber));
    }

}
