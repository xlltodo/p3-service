package com.p3.service.packages.infrastructure.client;

import com.p3.service.packages.infrastructure.client.dto.ForecastExpressApiResult;
import com.p3.service.packages.infrastructure.client.dto.ForecastExpressDTO;
import com.p3.service.packages.infrastructure.client.dto.ForecastExpressReceiptDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "p3-wms")
public interface ForecastExpressClient {

    @GetMapping("/web/forecast/express/get")
    ForecastExpressApiResult<ForecastExpressDTO> getExpressBill(@RequestParam(value = "expressNumber") String expressNumber);

    @PutMapping("/web/forecast/express/batch/receive")
    ForecastExpressApiResult<String> expressReceipt(@RequestBody ForecastExpressReceiptDTO forecastExpressReceiptDTO);
}
