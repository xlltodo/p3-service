package com.p3.service.packages.infrastructure.client.dto;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
public class CustomerInfoDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1830111572805646133L;

    // 主客户相关属性
    private String masterNickname;  // 主客户昵称
    private String masterCode;      // 主客户代号
    private String masterLevel;     // 主客户等级
    private String masterType;      // 主客户类型
    private String masterRemark;    // 主客户备注

    // 第三方客户相关属性
    private String thirdPartyNickname;  // 第三方客户昵称
    private String thirdPartyCode;      // 第三方客户代号
    private String thirdPartyLevel;     // 第三方客户等级
    private String thirdPartyType;      // 第三方客户类型
    private String thirdPartyRemark;    // 第三方客户备注

}
