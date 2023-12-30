package com.p3.service.packages.infrastructure.cache;

import jakarta.annotation.Resource;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Repository
public class RedissonService {

    @Resource
    private RedissonClient redissonClient;

    public long generateUniqueId(String moduleName, int idLength) {
        String key = moduleName + ":" + LocalDate.now().format(DateTimeFormatter.ISO_DATE);
        RAtomicLong atomicLong = redissonClient.getAtomicLong(key);

        long nextId = atomicLong.incrementAndGet();
        if (String.valueOf(nextId).length() > idLength) {
            throw new IllegalArgumentException("ID长度超过了设定的最大长度: " + idLength);
        }
        return nextId;
    }
}
