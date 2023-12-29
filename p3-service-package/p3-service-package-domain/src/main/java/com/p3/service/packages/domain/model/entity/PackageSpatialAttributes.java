package com.p3.service.packages.domain.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * 包裹空间属性表
 * @TableName package_spatial_attributes
 */
@TableName(value ="package_spatial_attributes")
@Data
public class PackageSpatialAttributes implements Serializable {
    /**
     * 主键ID
     */
    @TableId(value = "id")
    private String id;

    /**
     * 包裹编号
     */
    @TableField(value = "package_code")
    private String packageCode;

    /**
     * 长
     */
    @TableField(value = "length")
    private Double length;

    /**
     * 宽
     */
    @TableField(value = "width")
    private Double width;

    /**
     * 高
     */
    @TableField(value = "height")
    private Double height;

    /**
     * 体积
     */
    @TableField(value = "volume")
    private Double volume;

    /**
     * 重量
     */
    @TableField(value = "weight")
    private Double weight;

    /**
     * 计量时间
     */
    @TableField(value = "measurement_time")
    private LocalDateTime measurementTime;

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
        PackageSpatialAttributes other = (PackageSpatialAttributes) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPackageCode() == null ? other.getPackageCode() == null : this.getPackageCode().equals(other.getPackageCode()))
            && (this.getLength() == null ? other.getLength() == null : this.getLength().equals(other.getLength()))
            && (this.getWidth() == null ? other.getWidth() == null : this.getWidth().equals(other.getWidth()))
            && (this.getHeight() == null ? other.getHeight() == null : this.getHeight().equals(other.getHeight()))
            && (this.getVolume() == null ? other.getVolume() == null : this.getVolume().equals(other.getVolume()))
            && (this.getWeight() == null ? other.getWeight() == null : this.getWeight().equals(other.getWeight()))
            && (this.getMeasurementTime() == null ? other.getMeasurementTime() == null : this.getMeasurementTime().equals(other.getMeasurementTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPackageCode() == null) ? 0 : getPackageCode().hashCode());
        result = prime * result + ((getLength() == null) ? 0 : getLength().hashCode());
        result = prime * result + ((getWidth() == null) ? 0 : getWidth().hashCode());
        result = prime * result + ((getHeight() == null) ? 0 : getHeight().hashCode());
        result = prime * result + ((getVolume() == null) ? 0 : getVolume().hashCode());
        result = prime * result + ((getWeight() == null) ? 0 : getWeight().hashCode());
        result = prime * result + ((getMeasurementTime() == null) ? 0 : getMeasurementTime().hashCode());
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
        sb.append(", length=").append(length);
        sb.append(", width=").append(width);
        sb.append(", height=").append(height);
        sb.append(", volume=").append(volume);
        sb.append(", weight=").append(weight);
        sb.append(", measurementTime=").append(measurementTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}