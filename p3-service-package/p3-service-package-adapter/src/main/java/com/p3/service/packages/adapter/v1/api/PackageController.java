package com.p3.service.packages.adapter.v1.api;

import com.p3.service.packages.adapter.bean.ApiResponse;
import com.p3.service.packages.application.handler.PackageQueryHandler;
import com.p3.service.packages.application.result.PackageMainInfoResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@Tag(name = "包裹")
@RestController
@RequestMapping("/package")
public class PackageController {

    @Resource
    private PackageQueryHandler packageQueryHandler;

    @Operation(summary = "获取包裹信息")
    @GetMapping("/")
    public ApiResponse<PackageMainInfoResult> info(@RequestParam String expressBillNumber) {

        return ApiResponse.success(packageQueryHandler.info(expressBillNumber));
    }
}
