package com.p3.service.packages.infrastructure.client.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class ForecastExpressReceiptDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -2633369820043678833L;

    private String requestId;
    private Integer id;
    private String expressNumber;
    private Double length;
    private Double width;
    private Double height;
    private Double weight;
    private Double volume;
    private List<String> receivedImg;
    private String machine;
    private String receivedTime;
    private String updateBy;
}
