package com.p3.service.packages.infrastructure.repository.convertor;

import com.p3.service.packages.domain.model.entity.PackageMainInfo;
import com.p3.service.packages.infrastructure.repository.entity.PackageMainInfoEntity;

public class PackageMainInfoEntityConvertor {

    public static PackageMainInfoEntity convertToDataEntity(PackageMainInfo mainInfo) {
        // 注意：此处未处理 trackingNumbers 和 attributes 字段
        return mainInfo.mapWith((id, packageCode, trackingNumbers, attributes, customerCode, customerRank, customerName, thirdPartyCode, shippingWarehouse, destinationCountry, primaryGoodsType, secondaryGoodsType, goodsValue, composited, shippingMethod) ->
                new PackageMainInfoEntity()
                        .setId(id)
                        .setPackageCode(packageCode)
                        .setCustomerCode(customerCode)
                        .setCustomerRank(customerRank)
                        .setCustomerName(customerName)
                        .setThirdPartyCode(thirdPartyCode)
                        .setShippingWarehouse(shippingWarehouse)
                        .setDestinationCountry(destinationCountry)
                        .setPrimaryGoodsType(primaryGoodsType)
                        .setSecondaryGoodsType(secondaryGoodsType)
                        .setGoodsValue(goodsValue)
                        .setComposited(composited)
                        .setShippingMethod(shippingMethod));
    }

    public static PackageMainInfo convertToDomainEntity(PackageMainInfoEntity entity) {
        // 注意：此处需要提供适当的方式来创建或处理 trackingNumbers 和 attributes 字段
        return new PackageMainInfo(entity.getId(), entity.getPackageCode(), null, null, entity.getCustomerCode(), entity.getCustomerRank(), entity.getCustomerName(), entity.getThirdPartyCode(), entity.getShippingWarehouse(), entity.getDestinationCountry(), entity.getPrimaryGoodsType(), entity.getSecondaryGoodsType(), entity.getGoodsValue(), entity.getComposited(), entity.getShippingMethod());
    }
}
