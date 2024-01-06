package com.p3.service.packages.application.result;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.p3.service.packages.domain.model.entity.PackageStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.Map;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class PackagePageResult extends Page<PackageMainInfoResult> implements Serializable {

    @Serial
    private static final long serialVersionUID = 4873528516844095375L;

    @Schema(description = "包裹状态统计")
    private Map<PackageStatusEnum, Integer> countByPackageStatus;

    public PackagePageResult(Page<PackageMainInfoResult> page) {
        super(page.getCurrent(), page.getSize(), page.getTotal());
        super.setRecords(page.getRecords());
    }

}