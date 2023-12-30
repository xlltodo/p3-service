package com.p3.service.packages.adapter.v1.api;

import com.p3.service.packages.adapter.bean.ApiResponse;
import com.p3.service.packages.application.command.QualityControlSheetCommand;
import com.p3.service.packages.application.handler.QualityControlSheetCommandHandler;
import com.p3.service.packages.application.query.PackageQualityControlSheetQuery;
import com.p3.service.packages.application.result.QualityControlSheetResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Tag(name = "QC入库")
@RestController
@RequestMapping("/quality/control/sheet")
public class QualityControlSheetController {

    @Resource
    private QualityControlSheetCommandHandler qualityControlSheetCommandHandler;

    @Operation(summary = "获取QC详情")
    @GetMapping("/")
    public ApiResponse<QualityControlSheetResult> info(@Validated PackageQualityControlSheetQuery query) {

        return ApiResponse.success(qualityControlSheetCommandHandler.info(query));
    }

    @Operation(summary = "保存")
    @PostMapping("/")
    public ApiResponse<Boolean> save(@Validated @RequestBody QualityControlSheetCommand command, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            Map<String, String> errors = new HashMap<>();
            bindingResult.getAllErrors().forEach(error -> {
                String fieldName = error.getObjectName();
                String errorMessage = error.getDefaultMessage();

                errors.put(fieldName, errorMessage);
            });
            log.info("错误：{}", errors);
            return ApiResponse.fail("参数校验失败！");
        }

        return ApiResponse.success(qualityControlSheetCommandHandler.save(command));
    }

    @Operation(summary = "保存并提交")
    @PostMapping("/submit")
    public ApiResponse<Boolean> submit(@Validated @RequestBody QualityControlSheetCommand command) {

        return ApiResponse.success(qualityControlSheetCommandHandler.submit(command));
    }
}
