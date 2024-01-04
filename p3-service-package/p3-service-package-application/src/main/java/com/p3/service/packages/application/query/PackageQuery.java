package com.p3.service.packages.application.query;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class PackageQuery implements Serializable {

    @Serial
    private static final long serialVersionUID = 6884650230434569085L;

    @Schema(description = "包裹CX号")
    private String cxNumber;
}
