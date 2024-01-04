package com.p3.service.packages.application.handler;

import com.p3.service.packages.application.assembler.CompositePackageMainInfoAssembler;
import com.p3.service.packages.application.command.CompositePackageCommand;
import com.p3.service.packages.domain.service.CompositePackageDomainService;
import com.p3.service.packages.domain.service.common.IIdentityGenerator;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class CompositePackageCommandHandler {

    @Resource
    private IIdentityGenerator identityGenerator;
    @Resource
    private CompositePackageDomainService compositePackageDomainService;

    public String createCompositePackage(CompositePackageCommand command) {

        String compositePackageCode = identityGenerator.generateSnowflakeId();
        return compositePackageDomainService.createCompositePackage(CompositePackageMainInfoAssembler.toEntity(compositePackageCode, command));
    }
}
