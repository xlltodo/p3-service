package com.p3.service.packages.infrastructure.client;

import com.p3.service.packages.infrastructure.client.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "p3-wms")
public interface P3WmsClient {

    @GetMapping("/web/forecast/express/get")
    P3ApiResult<ForecastExpressDTO> getExpressBill(@RequestParam(value = "expressNumber") String expressNumber);

    @PutMapping("/web/forecast/express/batch/receive")
    P3ApiResult<String> expressReceipt(@RequestBody List<ForecastExpressReceiptDTO> forecastExpressReceipts);

    @GetMapping("/internal/customer/get")
    P3ApiResult<CustomerInfoDTO> getCustomerInfo(@RequestParam(value = "masterCustomerCode") String customerCode, @RequestParam(value = "thirdPartyCustomerCode") String thirdPartyCustomerCode);

    @PostMapping("/web/user/info")
    P3ApiResult<LoginUserInfoDTO> loginUserInfo();
}
