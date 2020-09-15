package com.code.yhz;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 枚举
 * @Author yhz
 * @Date 2020/9/8 14:58
 */

enum CodeEnum {
    ONE(1,10,"余昊泽"),TWO(2,10,"余昊泽1");
    @Getter @Setter
    private int id;
    @Getter @Setter
    private int age;
    @Getter @Setter
    private String name;

    CodeEnum( int id, int age, String name ) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public static void main( String[] args ) {
        CodeEnum[] values = CodeEnum.values ();

    }
}
