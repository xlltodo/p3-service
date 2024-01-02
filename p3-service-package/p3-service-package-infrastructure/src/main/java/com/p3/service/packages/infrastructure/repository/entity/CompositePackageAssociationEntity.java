package com.p3.service.packages.infrastructure.repository.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 集包包裹关联表
 * @TableName composite_package_association
 */
@TableName(value ="composite_package_association")
@Data
@Accessors(chain = true)
public class CompositePackageAssociationEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -4561939415982132814L;

    /**
     * 主键ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 集包编号
     */
    @TableField(value = "composite_package_code")
    private String compositePackageCode;

    /**
     * 包裹编号
     */
    @TableField(value = "package_code")
    private String packageCode;

}