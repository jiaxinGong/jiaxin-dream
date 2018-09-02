package com.jiaxin.dream.utils;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: bufoon
 * @Email: song.anling@zyxr.com
 * @Datetime: Created In 2018/1/29 19:05
 * @Desc: as follows.
 */
public class ObjectMapUtils {


    private static final String JAVAP = "java.";
    private static final String JAVADATESTR = "java.util.Date";

    /**
     * 获取利用反射获取类里面的值和名称
     *
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, Object> objectToMap(Object obj) throws IllegalAccessException {
        return objectToMap(obj, false);
    }

    /**
     * 通过反射将对象转MAP
     * @param obj
     * @param isContain 是否包含 properties , true 生成properties， false 去除properties
     * @param properties
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, Object> objectToMap(Object obj, boolean isContain, Object ...properties) throws IllegalAccessException {
        Map<String, Object> map = new HashMap<>();
        Class<?> clazz = obj.getClass();
        for (Field field : fieldList(obj)) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(obj);
            if (properties != null && value != null && !"serialVersionUID".equalsIgnoreCase(fieldName)){
                if (isContain && contain(fieldName, properties)){
                    map.put(fieldName, value);
                } else if (!isContain && !contain(fieldName, properties)){
                    map.put(fieldName, value);
                }
            }
        }
        return map;
    }

    public static List<Field> fieldList(Object obj){
        List<Field> fieldList = new ArrayList<>() ;
        Class tempClass = obj.getClass();
        while (tempClass != null) {//当父类为null的时候说明到达了最上层的父类(Object类).
            fieldList.addAll(Arrays.asList(tempClass.getDeclaredFields()));
            tempClass = tempClass.getSuperclass(); //得到父类,然后赋给自己
        }
        return fieldList;
    }

    private static boolean contain(String field, Object ...args){
        boolean bool = false;
        for (int i = 0; i< args.length; i++){
            if (field.equals(args[i])){
                bool = true;
                break;
            }
        }
        return bool;
    }

    /**
     * 利用递归调用将Object中的值全部进行获取
     *
     * @param timeFormatStr 格式化时间字符串默认<strong>2017-03-10 10:21</strong>
     * @param obj           对象
     * @param excludeFields 排除的属性
     * @return
     * @throws IllegalAccessException
     */
    public static Map<String, String> objectToMapString(String timeFormatStr, Object obj, String... excludeFields) throws IllegalAccessException {
        Map<String, String> map = new HashMap<>();

        if (excludeFields.length!=0){
            List<String> list = Arrays.asList(excludeFields);
            objectTransfer(timeFormatStr, obj, map, list);
        }else{
            objectTransfer(timeFormatStr, obj, map,null);
        }
        return map;
    }


    /**
     * 递归调用函数
     *
     * @param obj           对象
     * @param map           map
     * @param excludeFields 对应参数
     * @return
     * @throws IllegalAccessException
     */
    private static Map<String, String> objectTransfer(String timeFormatStr, Object obj, Map<String, String> map, List<String> excludeFields) throws IllegalAccessException {
        boolean isExclude=false;
        //默认字符串
        String formatStr = "YYYY-MM-dd HH:mm:ss";
        //设置格式化字符串
        if (timeFormatStr != null && !timeFormatStr.isEmpty()) {
            formatStr = timeFormatStr;
        }
        if (excludeFields!=null){
            isExclude=true;
        }
        Class<?> clazz = obj.getClass();
        //获取值
        for (Field field : clazz.getDeclaredFields()) {
            String fieldName = clazz.getSimpleName() + "." + field.getName();
            //判断是不是需要跳过某个属性
            if (isExclude&&excludeFields.contains(fieldName)){
                continue;
            }
            //设置属性可以被访问
            field.setAccessible(true);
            Object value = field.get(obj);
            Class<?> valueClass = value.getClass();
            if (valueClass.isPrimitive()) {
                map.put(fieldName, value.toString());

            } else if (valueClass.getName().contains(JAVAP)) {//判断是不是基本类型
                if (valueClass.getName().equals(JAVADATESTR)) {
                    //格式化Date类型
                    SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
                    Date date = (Date) value;
                    String dataStr = sdf.format(date);
                    map.put(fieldName, dataStr);
                } else {
                    map.put(fieldName, value.toString());
                }
            } else {
                objectTransfer(timeFormatStr, value, map,excludeFields);
            }
        }
        return map;
    }
}
