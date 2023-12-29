package com.p3.service.packages.adapter.v1.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.p3.service.packages.adapter.bean.ApiResponse;
import com.p3.service.packages.application.command.CompositePackageMainInfoCommand;
import com.p3.service.packages.application.result.CompositePackageInfoResult;
import com.p3.service.packages.application.result.PackageMainInfoResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;

@Tag(name = "集包")
@RestController
@RequestMapping("/composite/package")
public class CompositePackageController {

    @Deprecated
    @Operation(summary = "获取包裹信息（弃用了！请用包裹->获取包裹信息接口）")
    @GetMapping("/package")
    public ApiResponse<PackageMainInfoResult> packageInfo(@RequestParam String expressBillNumber) {

        return ApiResponse.success(null);
    }

    @Operation(summary = "保存集包")
    @PostMapping("/")
    public ApiResponse<String> save(@RequestBody CompositePackageMainInfoCommand command) {

        return ApiResponse.success(null);
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
    public ApiResponse<String> delete(@RequestBody CompositePackageMainInfoCommand command) {

        return ApiResponse.success(null);
    }
}
