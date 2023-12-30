package com.p3.service.packages.infrastructure.common;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.p3.service.packages.domain.service.common.IIdentityGenerator;
import com.p3.service.packages.infrastructure.cache.RedissonService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class IdentityGenerator implements IIdentityGenerator {

    @Resource
    private RedissonService redissonService;

    @Override
    public String generateSnowflakeId() {
        return IdWorker.getIdStr();
    }

    @Override
    public String generateCxNumber() {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        String formattedDate = currentDate.format(formatter);
        long uniqueId = redissonService.generateUniqueId("CX_NUMBER", 4);
        return "CX" + formattedDate + String.format("%0" + 4 + "d", uniqueId);
    }
}
