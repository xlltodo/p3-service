package com.p3.service.packages.domain.model.mapper;

public interface CompositePackageAssociationMapper<T> {

    T map(Integer id, String compositePackageCode, String packageCode);
}
