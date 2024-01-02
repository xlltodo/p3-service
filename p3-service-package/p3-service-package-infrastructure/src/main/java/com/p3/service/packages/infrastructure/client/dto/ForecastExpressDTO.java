package com.p3.service.packages.infrastructure.client.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class ForecastExpressDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 5225367308933373972L;

    private String id;
    private String customerCode;
    private String customerNickname;
    private String customerLevel;
    private String thirdPartyCustomerCode;
    private String thirdPartyCustomerLevel;
    private String expressNo;
    private String expressCompany;
    private String sendAddress;
    private String receiveAddress;
    private String typeOfShipping;
    private String status;
    private Double weight;
    private Double volume;
    private Integer numberOfPackages;
    private String preWarehousingNumber;
    private Integer internationalShippingFeeFlag;
    private String soNumber;
    private List<String> receivedImg;
    private String reason;
    private String remark;
    private String receivedTime;
    private String stockInTime;
    private String createBy;
    private String createTime;
    private String updateBy;
    private String updateTime;
    private List<Commodity> commodityLists;

    @Data
    public static class Commodity implements Serializable {

        @Serial
        private static final long serialVersionUID = 2533465747598864777L;

        private String id;
        private String goodsName;
        private String goodsSpecification;
        private String goodsTypeId;
        private String goodsTypeNo;
        private String e3GoodsTypeName;
        private String goodsNo;
        private String goodsDesc;
        private String productTypeId;
        private String productTypeName;
        private Integer productTypeStandard;
        private Integer productTypeCommodity;
        private Integer quantityShipped;
        private BigDecimal unitPrice;
        private BigDecimal totalPrice;
        private String remark;
        private String customerCode;
        private String customerNickname;
        private String customerLevel;
        private String thirdPartyCustomerCode;
        private String thirdPartyCustomerLevel;
        private String productImg;
    }
}
