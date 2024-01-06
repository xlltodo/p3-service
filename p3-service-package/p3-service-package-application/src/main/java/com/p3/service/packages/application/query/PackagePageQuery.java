package com.p3.service.packages.application.query;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.p3.service.packages.domain.model.entity.PackageMainInfo;
import com.p3.service.packages.domain.model.entity.PackageStatusEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class PackagePageQuery extends Page<String> implements Serializable {

    @Serial
    private static final long serialVersionUID = -7640284040175705547L;

    @Schema(description = "包裹状态")
    private PackageStatusEnum packageStatus;

    @Schema(description = "客户代号")
    private String customerCode;

    @Schema(description = "客户昵称")
    private String customerNickname;

    @Schema(description = "包裹CX号")
    private String cxNumber;
}
