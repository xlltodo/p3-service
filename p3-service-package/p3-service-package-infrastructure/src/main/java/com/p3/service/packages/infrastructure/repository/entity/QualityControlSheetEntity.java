package com.p3.service.packages.infrastructure.repository.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 质检单
 * @TableName quality_control_sheet
 */
@TableName(value ="quality_control_sheet")
@Data
@Accessors(chain = true)
public class QualityControlSheetEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -1270332545863381934L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private String id;

    /**
     * 快递单号
     */
    @TableField(value = "express_bill_number")
    private String expressBillNumber;

    /**
     * 客户代号
     */
    @TableField(value = "customer_code")
    private String customerCode;

    /**
     * 客户昵称
     */
    @TableField(value = "customer_nickname")
    private String customerNickname;

    /**
     * 客户等级
     */
    @TableField(value = "customer_level")
    private String customerLevel;

    /**
     * 客户类型
     */
    @TableField(value = "customer_type")
    private String customerType;

    /**
     * 第三方客户代号
     */
    @TableField(value = "third_party_customer_code")
    private String thirdPartyCustomerCode;

    /**
     * 第三方客户等级
     */
    @TableField(value = "third_party_customer_level")
    private String thirdPartyCustomerLevel;

    /**
     * 存放库位
     */
    @TableField(value = "storage_location")
    private String storageLocation;

    /**
     * 应收包裹件数
     */
    @TableField(value = "expected_package_count")
    private Integer expectedPackageCount;

    /**
     * 实收包裹件数
     */
    @TableField(value = "actual_package_count")
    private Integer actualPackageCount;

    /**
     * 应收商品数量
     */
    @TableField(value = "expected_product_count")
    private Integer expectedProductCount;

    /**
     * 实收商品数量
     */
    @TableField(value = "actual_product_count")
    private Integer actualProductCount;

    /**
     * 商品总价值
     */
    @TableField(value = "total_product_value")
    private BigDecimal totalProductValue;

    /**
     * 仓库编号
     */
    @TableField(value = "warehouse_code")
    private String warehouseCode;

    /**
     * 仓库名称
     */
    @TableField(value = "warehouse_name")
    private String warehouseName;

    /**
     * 寄往地区编号
     */
    @TableField(value = "destination_region_code")
    private String destinationRegionCode;

    /**
     * 寄往地区名称
     */
    @TableField(value = "destination_region_name")
    private String destinationRegionName;

    /**
     * 快递公司编号
     */
    @TableField(value = "express_company_code")
    private String expressCompanyCode;

    /**
     * 快递公司名称
     */
    @TableField(value = "express_company_name")
    private String expressCompanyName;

    /**
     * 异常件标识（0否1是）
     */
    @TableField(value = "exceptional")
    private Boolean exceptional;

    /**
     * 物品图片
     */
    @TableField(value = "item_image")
    private String itemImage;

    /**
     * 原始商品备注
     */
    @TableField(value = "original_product_remarks")
    private String originalProductRemarks;

    /**
     * 包裹状态
     */
    @TableField(value = "package_status")
    private String packageStatus;

    /**
     * 运输方式CODE
     */
    @TableField(value = "transport_method_code")
    private String transportMethodCode;

    /**
     * 运输方式名称
     */
    @TableField(value = "transport_method_name")
    private String transportMethodName;

    /**
     * 质检员ID
     */
    @TableField(value = "inspector_id")
    private String inspectorId;

    /**
     * 质检员名称
     */
    @TableField(value = "inspector_name")
    private String inspectorName;

    /**
     * 质检时间
     */
    @TableField(value = "inspection_time")
    private LocalDateTime inspectionTime;

}