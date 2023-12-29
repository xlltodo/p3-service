package com.p3.service.packages.domain.repository;

import com.p3.service.packages.domain.model.entity.QualityControlSheet;

public interface IQualityControlSheetRepository {

    QualityControlSheet getBuyExpressBillNumber(String expressBillNumber);

    Boolean checkExist(String expressBillNumber);

    Boolean create(QualityControlSheet qualityControlSheet);

    Boolean update(QualityControlSheet qualityControlSheet);
}
