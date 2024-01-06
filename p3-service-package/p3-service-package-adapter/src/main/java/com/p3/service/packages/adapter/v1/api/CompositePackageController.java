package com.p3.service.packages.adapter.v1.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.p3.service.packages.adapter.bean.ApiResponse;
import com.p3.service.packages.application.command.CompositePackageCommand;
import com.p3.service.packages.application.command.CompositePackageRejectCommand;
import com.p3.service.packages.application.handler.CompositePackageCommandHandler;
import com.p3.service.packages.application.result.CompositePackageInfoResult;
import com.p3.service.packages.application.result.CompositePackageOrderInfoResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Tag(name = "集包")
@RestController
@RequestMapping("/composite/package")
public class CompositePackageController {

    @Resource
    private CompositePackageCommandHandler compositePackageCommandHandler;

    @Operation(summary = "保存集包")
    @PostMapping("/")
    public ApiResponse<CompositePackageOrderInfoResult> save(@RequestBody CompositePackageCommand command) {

        return ApiResponse.success(compositePackageCommandHandler.createCompositePackage(command));
    }

    @Operation(summary = "集包详情")
    @GetMapping("/")
    public ApiResponse<IPage<CompositePackageInfoResult>> info(@RequestParam(required = false) String cjmNumber) {

        return ApiResponse.success(null);
    }

    @Operation(summary = "集包列表")
    @GetMapping("/page")
    public ApiResponse<IPage<CompositePackageInfoResult>> page(@RequestParam(required = false) String cjmNumber,
                                                               @RequestParam(required = false) LocalDate packagingStartTime,
                                                               @RequestParam(required = false) LocalDate pageSize,
                                                               @RequestParam(required = false) LocalDate pageCurrent) {

        return ApiResponse.success(null);
    }

    @Operation(summary = "删除集包")
    @DeleteMapping("/")
    public ApiResponse<String> delete(@RequestBody CompositePackageCommand command) {

        return ApiResponse.success(null);
    }

    @Operation(summary = "拒收集包")
    @DeleteMapping("/reject")
    public ApiResponse<String> reject(@RequestBody CompositePackageRejectCommand command) {

        return ApiResponse.success(null);
    }
}
