package com.p3.service.packages.application.command;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class CompositePackageRejectCommand implements Serializable {

    @Serial
    private static final long serialVersionUID = 4794100118932581806L;

    @Schema(description = "集包CJM")
    private List<String> cjmNumber;

    @Schema(description = "原因")
    private String reason;

    @Schema(description = "备注")
    private String remark;

    @Schema(description = "图片地址")
    private String imageUrl;
}
