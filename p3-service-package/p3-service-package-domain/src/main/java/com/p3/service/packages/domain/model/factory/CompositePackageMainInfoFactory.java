package com.p3.service.packages.domain.model.factory;

import com.p3.service.packages.domain.model.entity.CompositePackageAssociation;
import com.p3.service.packages.domain.model.entity.CompositePackageMainInfo;
import com.p3.service.packages.domain.model.entity.CompositePackageSpatialAttribute;
import com.p3.service.packages.domain.model.entity.CompositePackageTrackingNumber;

import java.util.List;

public class CompositePackageMainInfoFactory {

    public static CompositePackageMainInfo create(String id, String compositePackageCode, String compositeMethod, Integer compositeQuantity, String compositePackagingType, String transportMethodCode, String transportMethodName, String primaryGoodsType, String secondaryGoodsType, List<CompositePackageTrackingNumber> trackingNumbers, List<CompositePackageSpatialAttribute> spatialAttributes, List<CompositePackageAssociation> packageAssociations) {
        return new CompositePackageMainInfo(id, compositePackageCode, compositeMethod, compositeQuantity, compositePackagingType, transportMethodCode, transportMethodName, primaryGoodsType, secondaryGoodsType, trackingNumbers, spatialAttributes, packageAssociations);
    }
}
