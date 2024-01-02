package com.p3.service.packages.domain.model.factory;

import com.p3.service.packages.domain.model.entity.QualityControlSheetServiceItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class QualityControlSheetServiceItemFactory {

    public static QualityControlSheetServiceItem create(String id, String sheetId, String serviceType, String serviceName, BigDecimal fee, Integer activated, LocalDateTime creationTime) {
        return new QualityControlSheetServiceItem(id, sheetId, serviceType, serviceName, fee, activated, creationTime);
    }
}
