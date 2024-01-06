package com.p3.service.packages.domain.model.mapper;

import com.p3.service.packages.domain.model.entity.CompositePackageAssociation;

import java.util.List;

public interface CompositePackageOrderInfoMapper<T> {

    T map(String cjmNumber, String transportMethodCode, String primaryGoodsType, String secondaryGoodsType);
}
