package com.p3.service.packages.domain.service;

import com.p3.service.packages.domain.event.QualityControlSheetSubmitDomainEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PackageDomainService {

    @EventListener
    public void packageDeliveryEventListener(QualityControlSheetSubmitDomainEvent event) {

    }
}
