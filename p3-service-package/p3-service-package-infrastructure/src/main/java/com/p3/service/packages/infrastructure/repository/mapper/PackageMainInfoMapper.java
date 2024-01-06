package com.p3.service.packages.infrastructure.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.p3.service.packages.domain.model.entity.PackageStatusEnum;
import com.p3.service.packages.infrastructure.repository.entity.PackageMainInfoEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PackageMainInfoMapper extends BaseMapper<PackageMainInfoEntity> {

    IPage<String> idPages(IPage<?> page,
                          @Param("packageStatus") PackageStatusEnum packageStatus,
                          @Param("customerCode") String customerCode,
                          @Param("customerNickname") String customerNickname,
                          @Param("cxNumber") String cxNumber);

}




