package com.code.yhz.annoDemo;

import lombok.Data;

/**
 * @Author yhz
 * @Date 2020/9/11 11:48
 */
@Data
public class Entity {
    @MapKeyForEntity(value = "AGE")
    private String age;
    @MapKeyForEntity(value = "NAME")
    private String name;
}
