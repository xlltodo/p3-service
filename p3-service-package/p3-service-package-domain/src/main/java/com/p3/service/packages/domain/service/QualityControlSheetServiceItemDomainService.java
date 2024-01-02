package com.p3.service.packages.domain.service;

import com.p3.service.packages.domain.model.entity.QualityControlSheetServiceItem;
import com.p3.service.packages.domain.repository.IQualityControlSheetServiceItemRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QualityControlSheetServiceItemDomainService {

    @Resource
    private IQualityControlSheetServiceItemRepository qualityControlSheetServiceItemRepository;

    public Boolean cleanBySheetId(String sheetId) {
        return qualityControlSheetServiceItemRepository.cleanBySheetId(sheetId);
    }

    public Boolean createBatch(List<QualityControlSheetServiceItem> serviceItems) {
        return qualityControlSheetServiceItemRepository.createBatch(serviceItems);
    }

}
