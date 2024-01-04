package com.p3.service.packages.domain.model.factory;

import com.p3.service.packages.domain.model.entity.CompositePackageAssociation;

public class CompositePackageAssociationFactory {

    public static CompositePackageAssociation create(Integer id, String compositePackageCode, String packageCode) {
        return new CompositePackageAssociation(id, compositePackageCode, packageCode);
    }
}
