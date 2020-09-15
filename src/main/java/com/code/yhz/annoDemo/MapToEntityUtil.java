package com.code.yhz.annoDemo;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author yhz
 * @Date 2020/9/11 11:48
 */
public class MapToEntityUtil {
    public static<T> T mapToEntity( Map<String,Object> map,Class<T> tClass ) throws Exception{
        Field[] declaredFields = tClass.getDeclaredFields ();
        T t = tClass.newInstance ();
        for (Field field :declaredFields  ){
            MapKeyForEntity annotation = field.getAnnotation ( MapKeyForEntity.class );
            String value = annotation.value ();
            field.setAccessible(true);
            field.set ( t,map.get ( value ) );
        }
        return t;
    }

    public static void main( String[] args ) throws Exception {

    }
}
