package com.p3.service.packages.infrastructure.repository.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * 集包信息主表
 * @TableName composite_package_main_info
 */
@TableName(value ="composite_package_main_info")
@Data
public class CompositePackageMainInfoEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -373920536172451794L;

    /**
     * 主键ID
     */
    @TableId(value = "id")
    private String id;

    /**
     * 集包编号
     */
    @TableField(value = "composite_package_code")
    private String compositePackageCode;

    /**
     * 集包方式
     */
    @TableField(value = "composite_method")
    private String compositeMethod;

    /**
     * 集包数量
     */
    @TableField(value = "composite_quantity")
    private Integer compositeQuantity;

    /**
     * 集包包装类型
     */
    @TableField(value = "composite_packaging_type")
    private String compositePackagingType;

    /**
     * 运输方式
     */
    @TableField(value = "transport_method")
    private String transportMethod;

    /**
     * 一级货品类型
     */
    @TableField(value = "primary_goods_type")
    private String primaryGoodsType;

    /**
     * 二级货品类型
     */
    @TableField(value = "secondary_goods_type")
    private String secondaryGoodsType;

}