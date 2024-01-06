package com.p3.service.packages.application.handler;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.p3.service.packages.application.assembler.PackageMainInfoAssembler;
import com.p3.service.packages.application.query.PackagePageQuery;
import com.p3.service.packages.application.result.PackageMainInfoResult;
import com.p3.service.packages.application.result.PackagePageResult;
import com.p3.service.packages.domain.repository.IPackageMainInfoRepository;
import com.p3.service.packages.infrastructure.common.IPageConvertor;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PackagePageQueryHandler {

    @Resource
    private IPackageMainInfoRepository packageMainInfoRepository;

    public PackagePageResult page(PackagePageQuery packagePageQuery) {

        IPage<String> idPages = packageMainInfoRepository.idPage(packagePageQuery, packagePageQuery.getPackageStatus(), packagePageQuery.getCustomerCode(), packagePageQuery.getCustomerNickname(), packagePageQuery.getCxNumber());
        List<PackageMainInfoResult> packagePageResults = Optional.ofNullable(idPages.getRecords()).map(ids -> ids.stream().map(id -> PackageMainInfoAssembler.toResult(packageMainInfoRepository.infoById(id))).collect(Collectors.toList())).orElse(new ArrayList<>(0));
        PackagePageResult packagePageResult = IPageConvertor.convertor(idPages, packagePageResults, PackagePageResult::new);
        packagePageResult.setCountByPackageStatus(new HashMap<>());
        return packagePageResult;
    }

}
