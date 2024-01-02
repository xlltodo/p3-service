package com.p3.service.packages.infrastructure.repository.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.p3.service.packages.domain.model.entity.QualityControlSheetServiceItem;
import com.p3.service.packages.domain.repository.IQualityControlSheetServiceItemRepository;
import com.p3.service.packages.infrastructure.repository.convertor.QualityControlSheetServiceItemEntityConvertor;
import com.p3.service.packages.infrastructure.repository.entity.QualityControlSheetServiceItemEntity;
import com.p3.service.packages.infrastructure.repository.mapper.QualityControlSheetServiceItemMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class QualityControlSheetServiceItemRepository implements IQualityControlSheetServiceItemRepository {

    @Resource
    private QualityControlSheetServiceItemMapper qualityControlSheetServiceItemMapper;

    @Override
    public Boolean cleanBySheetId(String sheetId) {

        qualityControlSheetServiceItemMapper.delete(Wrappers.lambdaQuery(QualityControlSheetServiceItemEntity.class).eq(QualityControlSheetServiceItemEntity::getSheetId, sheetId));
        return null;
    }

    @Override
    public Boolean createBatch(List<QualityControlSheetServiceItem> serviceItems) {

        if(CollectionUtils.isEmpty(serviceItems)) {
            return true;
        }
        serviceItems.stream().map(serviceItem -> qualityControlSheetServiceItemMapper.insert(QualityControlSheetServiceItemEntityConvertor.convertToDataEntity(serviceItem)));
        return true;
    }
}
