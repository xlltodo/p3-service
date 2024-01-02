package com.p3.service.packages.domain.model.entity;

import com.p3.service.packages.domain.event.ExpressPackageReceiptDomainEvent;
import com.p3.service.packages.domain.model.mapper.PackageProcessedRecordMapper;

public class PackageProcessedRecord {

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 原始票据号码或条码
     */
    private String ticketsNum;

    /**
     * 重量（千克）
     */
    private Double weight;

    /**
     * 长度（毫米）
     */
    private Double length;

    /**
     * 宽度（毫米）
     */
    private Double width;

    /**
     * 高度（毫米）
     */
    private Double height;

    /**
     * 体积（立方毫米）
     */
    private Double volume;

    /**
     * 设备名称
     */
    private String machine;

    public PackageProcessedRecord(Integer id, String ticketsNum, Double weight, Double length, Double width, Double height, Double volume, String machine) {
        this.id = id;
        this.ticketsNum = ticketsNum;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
        this.volume = volume;
        this.machine = machine;
    }

    public <T> T mapWith(PackageProcessedRecordMapper<T> mapper) {
        return mapper.map(this.id, this.ticketsNum, this.weight, this.length, this.width, this.height, this.volume, this.machine);
    }

    public void sendExpressPackageReceipt() {
        ExpressPackageReceiptDomainEvent event = new ExpressPackageReceiptDomainEvent(this.ticketsNum, this.weight, this.length, this.width, this.height, this.volume);
    }
}