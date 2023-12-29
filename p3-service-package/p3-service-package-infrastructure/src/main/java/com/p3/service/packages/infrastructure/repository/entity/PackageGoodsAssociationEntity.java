package com.p3.service.packages.infrastructure.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 包裹商品关联表
 * @TableName package_goods_association
 */
@Data
@TableName(value ="package_goods_association")
public class PackageGoodsAssociationEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -9144914153988331176L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 包裹编号
     */
    @TableField(value = "package_code")
    private String packageCode;

    /**
     * 商品ID
     */
    @TableField(value = "goods_id")
    private String goodsId;
}