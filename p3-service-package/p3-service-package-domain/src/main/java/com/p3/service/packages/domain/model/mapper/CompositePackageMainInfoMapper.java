package com.p3.service.packages.domain.model.mapper;

import com.p3.service.packages.domain.model.entity.CompositePackageAssociation;

import java.util.List;

public interface CompositePackageMainInfoMapper<T> {

    T map(String id, String compositePackageCode, String compositeMethod, Integer compositeQuantity, String compositePackagingType, String transportMethod, String primaryGoodsType, String secondaryGoodsType, List<CompositePackageAssociation> packageAssociations);
}
