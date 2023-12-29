package com.p3.service.packages.domain.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 包裹追踪编号表
 * @TableName package_tracking_number
 */
@TableName(value ="package_tracking_number")
@Data
public class PackageTrackingNumber implements Serializable {
    /**
     * 主键ID
     */
    @TableField(value = "id")
    private String id;

    /**
     * 包裹编号
     */
    @TableField(value = "package_code")
    private String packageCode;

    /**
     * 单号类型
     */
    @TableField(value = "number_type")
    private String numberType;

    /**
     * 单号
     */
    @TableField(value = "tracking_number")
    private String trackingNumber;

    /**
     * 生成单号时间
     */
    @TableField(value = "creation_time")
    private LocalDateTime creationTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        PackageTrackingNumber other = (PackageTrackingNumber) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPackageCode() == null ? other.getPackageCode() == null : this.getPackageCode().equals(other.getPackageCode()))
            && (this.getNumberType() == null ? other.getNumberType() == null : this.getNumberType().equals(other.getNumberType()))
            && (this.getTrackingNumber() == null ? other.getTrackingNumber() == null : this.getTrackingNumber().equals(other.getTrackingNumber()))
            && (this.getCreationTime() == null ? other.getCreationTime() == null : this.getCreationTime().equals(other.getCreationTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPackageCode() == null) ? 0 : getPackageCode().hashCode());
        result = prime * result + ((getNumberType() == null) ? 0 : getNumberType().hashCode());
        result = prime * result + ((getTrackingNumber() == null) ? 0 : getTrackingNumber().hashCode());
        result = prime * result + ((getCreationTime() == null) ? 0 : getCreationTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", packageCode=").append(packageCode);
        sb.append(", numberType=").append(numberType);
        sb.append(", trackingNumber=").append(trackingNumber);
        sb.append(", creationTime=").append(creationTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}