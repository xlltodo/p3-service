package com.p3.service.packages.infrastructure.client.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class ForecastExpressReceiptDTO {

    private String requestId;
    private int id;
    private String expressNumber;
    private double length;
    private double width;
    private double height;
    private double weight;
    private double volume;
    private List<String> receivedImg;
    private String machine;
    private String receivedTime;
    private String updateBy;
}
