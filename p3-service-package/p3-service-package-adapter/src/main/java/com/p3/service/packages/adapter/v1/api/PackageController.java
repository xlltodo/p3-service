package com.p3.service.packages.adapter.v1.api;

import com.p3.service.packages.adapter.bean.ApiResponse;
import com.p3.service.packages.application.command.PackageAddTrackingNumberCommand;
import com.p3.service.packages.application.handler.PackagePageQueryHandler;
import com.p3.service.packages.application.handler.PackageQueryHandler;
import com.p3.service.packages.application.handler.PackageTrackingNumberHandler;
import com.p3.service.packages.application.query.PackagePageQuery;
import com.p3.service.packages.application.query.PackageQuery;
import com.p3.service.packages.application.result.PackageMainInfoResult;
import com.p3.service.packages.application.result.PackagePageResult;
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
    @Resource
    private PackagePageQueryHandler packagePageQueryHandler;
    @Resource
    private PackageTrackingNumberHandler packageTrackingNumberHandler;

    @Operation(summary = "获取包裹信息")
    @GetMapping("/")
    public ApiResponse<PackageMainInfoResult> info(PackageQuery packageQuery) {

        return ApiResponse.success(packageQueryHandler.info(packageQuery));
    }

    @Operation(summary = "获取包裹信息")
    @GetMapping("/page")
    public ApiResponse<PackagePageResult> page(PackagePageQuery packagePageQuery) {

        return ApiResponse.success(packagePageQueryHandler.page(packagePageQuery));
    }
    @Operation(summary = "添加单号")
    @PostMapping("/tracking_number")
    public ApiResponse<Boolean> addTrackingNumber(@RequestBody PackageAddTrackingNumberCommand command) {

        return ApiResponse.success(packageTrackingNumberHandler.addTrackingNumber(command));
    }
}
