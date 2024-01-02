package com.p3.service.packages.domain.model.factory;

import com.p3.service.packages.domain.model.entity.PackageMainInfo;
import com.p3.service.packages.domain.model.entity.PackageServiceItem;
import com.p3.service.packages.domain.model.entity.PackageSpatialAttribute;
import com.p3.service.packages.domain.model.entity.PackageTrackingNumber;

import java.math.BigDecimal;
import java.util.List;

public class PackageMainInfoFactory {

    public static PackageMainInfo create(String id, String packageCode,
                                         List<PackageTrackingNumber> trackingNumbers,
                                         List<PackageSpatialAttribute> attributes,
                                         List<PackageServiceItem> serviceItems,
                                         String customerCode, String customerNickname,
                                         String customerLevel, String customerType, String thirdPartyCustomerCode,
                                         String thirdPartyCustomerLevel,
                                         String shippingWarehouse, String destinationCountry,
                                         String primaryGoodsType, String secondaryGoodsType,
                                         BigDecimal goodsValue, Boolean composited,
                                         String shippingMethod) {
        return new PackageMainInfo(id, packageCode, trackingNumbers, attributes, serviceItems, customerCode,
                customerNickname, customerLevel, customerType, thirdPartyCustomerCode, thirdPartyCustomerLevel, shippingWarehouse,
                destinationCountry, primaryGoodsType, secondaryGoodsType,
                goodsValue, composited, shippingMethod);
    }
}
