package com.p3.service.packages.application.handler;

import com.p3.service.packages.application.assembler.PackageMainInfoAssembler;
import com.p3.service.packages.application.command.PackageAddTrackingNumberCommand;
import com.p3.service.packages.application.query.PackageQuery;
import com.p3.service.packages.application.result.PackageMainInfoResult;
import com.p3.service.packages.domain.model.entity.PackageMainInfo;
import com.p3.service.packages.domain.repository.IPackageMainInfoRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class PackageQueryHandler {

    @Resource
    private IPackageMainInfoRepository packageMainInfoRepository;

    public PackageMainInfoResult info(PackageQuery packageQuery) {

        return PackageMainInfoAssembler.toResult(packageMainInfoRepository.info(packageQuery.getCxNumber()));
    }

}
