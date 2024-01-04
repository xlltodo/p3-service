package com.p3.service.packages.application.handler;

import com.p3.service.packages.application.command.PackageAddTrackingNumberCommand;
import com.p3.service.packages.domain.model.entity.PackageMainInfo;
import com.p3.service.packages.domain.model.entity.PackageTrackingNumber;
import com.p3.service.packages.domain.model.factory.PackageTrackingNumberFactory;
import com.p3.service.packages.domain.repository.IPackageMainInfoRepository;
import com.p3.service.packages.domain.repository.IPackageTrackingNumberRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PackageTrackingNumberHandler {

    @Resource
    private IPackageMainInfoRepository packageMainInfoRepository;
    @Resource
    private IPackageTrackingNumberRepository packageTrackingNumberRepository;

    public Boolean addTrackingNumber(PackageAddTrackingNumberCommand command) {

        PackageMainInfo packageMainInfo = packageMainInfoRepository.info(command.getCxNumber());
        String packageCode = packageMainInfo.getPackageCode();
        PackageTrackingNumber packageTrackingNumber = PackageTrackingNumberFactory.create(null, packageCode, command.getNumberType(), command.getTrackingNumber(), LocalDateTime.now());

        return packageTrackingNumberRepository.addTrackingNumber(packageTrackingNumber);
    }

}
