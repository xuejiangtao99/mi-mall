package com.xjt.mimall.util;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class CopyUtil {

    public static <T> List<T> copyList(List source, Class<T> clazz) {
        List<T> target = new ArrayList<>();
        if (!CollectionUtils.isEmpty(source)){
            if (!CollectionUtils.isEmpty(source)){
                for (Object c: source) {
                    T obj = copyObject(c, clazz);
                    target.add(obj);
                }
            }
        }
        return target;
    }

    /**
     * @param source 需要拷贝的值
     * @param clazz  需要转换类型
     * @param <T>
     * @return
     */
    public static <T> T copyObject(Object source, Class<T> clazz) {
        if (source == null) {

            return null;
        }

        T obj = null;

        try {
            obj = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        BeanUtils.copyProperties(source, obj);
        return obj;
    }
}
