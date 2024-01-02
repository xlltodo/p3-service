package com.p3.service.packages.infrastructure.repository.convertor;

import com.p3.service.packages.domain.model.entity.QualityControlSheetServiceItem;
import com.p3.service.packages.infrastructure.repository.entity.QualityControlSheetServiceItemEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class QualityControlSheetServiceItemEntityConvertor {

    public static QualityControlSheetServiceItemEntity convertToDataEntity(QualityControlSheetServiceItem serviceItem) {
        return serviceItem.mapWith((id, sheetId, serviceType, serviceName, fee, activated, creationTime) ->
                new QualityControlSheetServiceItemEntity()
                        .setId(id)
                        .setSheetId(sheetId)
                        .setServiceType(serviceType)
                        .setServiceName(serviceName)
                        .setFee(fee)
                        .setActivated(activated)
                        .setCreationTime(creationTime));
    }

    public static QualityControlSheetServiceItem convertToDomainEntity(QualityControlSheetServiceItemEntity entity) {
        return new QualityControlSheetServiceItem(
                entity.getId(),
                entity.getSheetId(),
                entity.getServiceType(),
                entity.getServiceName(),
                entity.getFee(),
                entity.getActivated(),
                entity.getCreationTime());
    }

    public static List<QualityControlSheetServiceItem> convertToDomainEntities(List<QualityControlSheetServiceItemEntity> serviceItemEntities) {
        return Optional.ofNullable(serviceItemEntities).map(entities -> entities.stream().map(QualityControlSheetServiceItemEntityConvertor::convertToDomainEntity).collect(Collectors.toList())).orElse(null);
    }
}
