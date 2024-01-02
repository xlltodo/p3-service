package com.p3.service.packages.domain.repository;

import com.p3.service.packages.domain.model.entity.QualityControlSheetServiceItem;

import java.util.List;

public interface IQualityControlSheetServiceItemRepository {

    Boolean cleanBySheetId(String sheetId);

    Boolean createBatch(List<QualityControlSheetServiceItem> serviceItems);
}
