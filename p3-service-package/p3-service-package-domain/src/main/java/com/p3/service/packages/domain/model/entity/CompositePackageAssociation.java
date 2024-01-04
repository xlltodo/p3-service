package com.p3.service.packages.domain.model.entity;

import com.p3.service.packages.domain.model.mapper.CompositePackageAssociationMapper;

public class CompositePackageAssociation {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 集包编号
     */
    private String compositePackageCode;

    /**
     * 包裹编号
     */
    private String packageCode;

    public CompositePackageAssociation(Integer id, String compositePackageCode, String packageCode) {
        this.id = id;
        this.compositePackageCode = compositePackageCode;
        this.packageCode = packageCode;
    }

    public <T> T mapWith(CompositePackageAssociationMapper<T> mapper) {
        return mapper.map(this.id, this.compositePackageCode, this.packageCode);
    }
}