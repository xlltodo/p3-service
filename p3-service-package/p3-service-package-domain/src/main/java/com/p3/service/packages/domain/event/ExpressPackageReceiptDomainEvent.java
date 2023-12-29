package com.p3.service.packages.domain.event;

import com.p3.service.packages.domain.event.base.SyncInProcessBaseDomainEvent;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


@Getter
@Setter
public class ExpressPackageReceiptDomainEvent extends SyncInProcessBaseDomainEvent implements Serializable {

    @Serial
    private static final long serialVersionUID = 1481068739704886029L;

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

    public ExpressPackageReceiptDomainEvent(String ticketsNum, Double weight, Double length, Double width, Double height, Double volume) {
        super(ticketsNum);
        this.ticketsNum = ticketsNum;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
        this.volume = volume;
    }
}
