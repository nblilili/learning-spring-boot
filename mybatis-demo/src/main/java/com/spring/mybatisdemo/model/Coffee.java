package com.spring.mybatisdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import java.util.Date;

/**
 * @author nblilili@163.com
 * @date 2020/1/10 15:00
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Coffee {
    private Long id;
    private String name;
    private Money price;
    private Date createTime;
    private Date updateTime;
}
