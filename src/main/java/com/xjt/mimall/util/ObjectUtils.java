package com.xjt.mimall.util;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class ObjectUtils {


    /**
     * 判断对象是否为空
     * @param obj
     * @return
     */
    public static boolean isNull(Object obj) {
        return obj == null;
    }

    /**
     * 判断对象是否不为空
     * @param obj
     * @return
     */
    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    /**
     *
     * @param obj
     * @return
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null) return true;
        else if (obj instanceof CharSequence) return ((CharSequence) obj).length() == 0;
        else if (obj instanceof Collection) return ((Collection) obj).isEmpty();
        else if (obj instanceof Map) return ((Map) obj).isEmpty();
        else if (obj.getClass().isArray()) return Array.getLength(obj) == 0;

        return false;
    }

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    /**
     * 判断字符串不为空
     * @param str
     * @return
     */
    public static boolean notEmpty(String str){


        return str != null && !"".equals(str);
    }

    /**
     * 判断字符串不为空
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    /**
     * 判断字符串为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        return str == null || str.length() == 0;
    }

    /**
     * 集合判断是否为空
     * @param collection 使用泛型
     * @return
     */
    public static <T> boolean notEmpty(Collection<T> collection){
        if(collection != null){
            Iterator<T> iterator = collection.iterator();
            if(iterator != null){
                while(iterator.hasNext()){
                    Object next = iterator.next();
                    if(next != null){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * map集合不为空的判断
     * @param map 使用泛型，可以传递不同的类型参数
     * @return
     */
    public static <T> boolean notEmpty(Map<T, T> map){
        return map != null && !map.isEmpty();
    }

    /**
     * byte类型数组判断不为空
     * @param t
     * @return
     */
    public static boolean notEmpty(byte[] t){
        return t != null && t.length > 0;
    }

    /**
     * short类型数组不为空判断
     * @param t
     * @return
     */
    public static boolean notEmpty(short[] t){
        return t != null && t.length > 0;
    }

    /**
     * 数组判断不为空,没有泛型数组,所以还是分开写吧
     * @param t 可以是int,short,byte,String,Object,long
     * @return
     */
    public static boolean notEmpty(int[] t){
        return t != null && t.length > 0;
    }

    /**
     * long类型数组不为空
     * @param t
     * @return
     */
    public static boolean notEmpty(long[] t){
        return t != null && t.length > 0;
    }

    /**
     * String类型的数组不为空
     * @param t
     * @return
     */
    public static boolean notEmpty(String[] t){
        return t != null && t.length > 0;
    }

    /**
     * Object类型数组不为空
     * @param t
     * @return
     */
    public static boolean notEmpty(Object[] t){
        return t != null && t.length > 0;
    }

    /**
     *
     * @param o
     * @return
     */
    public static boolean notEmpty(Object o){
        return o != null && !"".equals(o) && !"null".equals(o);
    }


}