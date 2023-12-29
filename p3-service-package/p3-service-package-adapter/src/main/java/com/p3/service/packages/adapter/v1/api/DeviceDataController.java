package com.p3.service.packages.adapter.v1.api;

import com.p3.service.packages.application.command.DevicePackageDataCommand;
import com.p3.service.packages.application.handler.DevicePackageDataCommandHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serial;
import java.util.HashMap;
import java.util.Map;

@Tag(name = "外部接口-过机扫描")
@RestController
@RequestMapping("/device")
public class DeviceDataController {

    @Resource
    private DevicePackageDataCommandHandler devicePackageDataCommandHandler;

    @Operation(summary = "接收过机包裹数据")
    @PostMapping("/post")
    public Map<String, String> post(@Validated @RequestBody DevicePackageDataCommand command, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {

            Map<String, String> errors = new HashMap<>();
            bindingResult.getAllErrors().forEach(error -> {
                String fieldName = error.getObjectName();
                String errorMessage = error.getDefaultMessage();

                errors.put(fieldName, errorMessage);
            });
            return new HashMap<>(){
                @Serial
                private static final long serialVersionUID = 1483033905763535912L;
                {
                    put("result", "false");
                    put("message", "签入失败-" + errors);
                    put("channelcode", "1");
                }};
        }

        if(devicePackageDataCommandHandler.passAndSign(command)) {
            return new HashMap<>(){
                @Serial
                private static final long serialVersionUID = -7361026928024051611L;
                {
                    put("result", "true");
                    put("message", "签入成功");
                    put("channelcode", "1");
            }};
        }else {
            return new HashMap<>(){
                @Serial
                private static final long serialVersionUID = 1483033905763535912L;
                {
                    put("result", "false");
                    put("message", "签入失败");
                    put("channelcode", "1");
            }};
        }
    }
}
