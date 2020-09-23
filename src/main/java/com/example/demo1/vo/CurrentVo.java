package com.example.demo1.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author shaoyayu
 * @date 2020/9/22
 * @E_Mail
 * @Version 1.0.0
 * @readme ：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CurrentVo {
    private int code;
    private String theme;
    private String msg;
}
