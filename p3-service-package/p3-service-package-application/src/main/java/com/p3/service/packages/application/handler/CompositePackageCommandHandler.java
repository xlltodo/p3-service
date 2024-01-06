package com.p3.service.packages.application.handler;

import com.p3.service.packages.application.assembler.CompositePackageMainInfoAssembler;
import com.p3.service.packages.application.command.CompositePackageCommand;
import com.p3.service.packages.application.result.CompositePackageOrderInfoResult;
import com.p3.service.packages.domain.model.entity.CompositePackageMainInfo;
import com.p3.service.packages.domain.model.entity.CompositePackageTrackingNumberTypeEnum;
import com.p3.service.packages.domain.service.CompositePackageDomainService;
import com.p3.service.packages.domain.service.common.IIdentityGenerator;
import com.p3.service.packages.infrastructure.client.P3WmsClient;
import com.p3.service.packages.infrastructure.client.dto.LoginUserInfoDTO;
import com.p3.service.packages.infrastructure.client.dto.P3ApiResult;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.Optional;

@Component
public class CompositePackageCommandHandler {

    @Resource
    private IIdentityGenerator identityGenerator;
    @Resource
    private CompositePackageDomainService compositePackageDomainService;
    @Resource
    private P3WmsClient p3WmsClient;

    @Transactional(rollbackFor = Exception.class)
    public CompositePackageOrderInfoResult createCompositePackage(CompositePackageCommand command) {

        String compositePackageCode = identityGenerator.generateSnowflakeId();
        CompositePackageMainInfo compositePackageMainInfo = compositePackageDomainService.createCompositePackage(CompositePackageMainInfoAssembler.toEntity(compositePackageCode, command));
        if(ObjectUtils.isEmpty(compositePackageMainInfo)) {
            return null;
        }
        LoginUserInfoDTO loginUserInfo = Optional.ofNullable(p3WmsClient.loginUserInfo()).map(P3ApiResult::getData).orElse(null);
        String userName = Optional.ofNullable(loginUserInfo).map(userInfo -> userInfo.getUser().getUserName()).orElse(null);
        return compositePackageMainInfo.getOrderInfo((String cjmNumber, String transportMethodCode, String primaryGoodsType, String secondaryGoodsType) -> new CompositePackageOrderInfoResult()
                .setCjmNumber(compositePackageMainInfo.getTrackingNumber(CompositePackageTrackingNumberTypeEnum.CJM_NUMBER))
                .setOperatorName(userName)
                .setTransportMethodCode(transportMethodCode)
                .setPrimaryGoodsType(primaryGoodsType)
                .setSecondaryGoodsType(secondaryGoodsType));
    }
}
