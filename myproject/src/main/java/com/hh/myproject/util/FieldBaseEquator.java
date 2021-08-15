package com.hh.myproject.util;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FieldBaseEquator extends AbstractEquator {
    private static final Map<Class<?>, Map<String, Field>> CACHE = new ConcurrentHashMap<>();

    public FieldBaseEquator() {
    }

    public FieldBaseEquator(boolean bothExistFieldOnly) {
        super(bothExistFieldOnly);
    }

    /**
     * @param includeFields 指定要包含的字段
     * @param excludeFields 指定排除的字段
     */
    public FieldBaseEquator(List<String> includeFields, List<String> excludeFields) {
        super(includeFields, excludeFields);
    }

    public FieldBaseEquator(List<String> includeFields, List<String> excludeFields, boolean bothExistFieldOnly) {
        super(includeFields, excludeFields, bothExistFieldOnly);
    }



    @Override
    public List<FieldInfo> getDiffFields(Object first, Object second) {
        //1 首先判断对象地址是否相同 是否为一个对象  为则返回空集合
        if (first == second) {
            return Collections.EMPTY_LIST;
        }
        //2 抽象类方法isSimpleField尝试判断是否为简单数据类型  是则 使用抽象类的  比较简单对象方法compareSimpleField
        if (isSimpleField(first, second)) {
            return compareSimpleField(first, second);
        }
        //3获取所有属性名  getAllFields 将所有的 属性名放入set
        Set<String> allFieldNames;
        Map<String, Field> firstFields = getAllFields(first);
        Map<String, Field> secondFields = getAllFields(second);
        if (firstFields == null) {
            allFieldNames = secondFields.keySet();
        } else if (secondFields == null) {
            allFieldNames = firstFields.keySet();
        } else {
            allFieldNames = getAllFieldNames(firstFields.keySet(), secondFields.keySet());
        }
        //4 通过一系列比较 得到 值不相同的属性信息对象  此对象中封装了本属性的类型 名称 值
        List<FieldInfo> diffFields = new LinkedList<>();
        for (String fieldName : allFieldNames) {
            try {
                Field firstFiled = firstFields.getOrDefault(fieldName, null);
                Field secondFiled = secondFields.getOrDefault(fieldName, null);
                Object firstVal = null;
                Object secondVal = null;
                Class<?> firstFieldType = null;
                Class<?> secondFieldType = null;
                if (firstFiled != null) {
                    firstFiled.setAccessible(true);
                    firstVal = firstFiled.get(first);
                    firstFieldType = firstFiled.getType();
                }
                if (secondFiled != null) {
                    secondFiled.setAccessible(true);
                    secondVal = secondFiled.get(second);
                    secondFieldType = secondFiled.getType();
                }
                FieldInfo fieldInfo = new FieldInfo(fieldName,firstFieldType,secondFieldType,firstVal,secondVal);
                //最后判断此属性是不是在排除 或者 包含集合内 以及 值是否相等 决定是否添加
                if(!isFieldEquals(fieldInfo)){
                    diffFields.add(fieldInfo);
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return diffFields;
    }

    public Map<String, Field> getAllFields(Object obj) {
        //1 如果入参为空 返回空map
        if (null == obj) {
            return Collections.EMPTY_MAP;
        }


        return CACHE.computeIfAbsent(obj.getClass(), k -> {
            Map<String, Field> fieldMap = new ConcurrentHashMap<>();
            Class<?> clazz = k;
            //保证获取除object外父类的所有属性
            while (clazz != Object.class) {
                Field[] declaredFields = k.getDeclaredFields();
                //Arrays.stream(declaredFields).filter(item->!item.isSynthetic()).forEach(item->fieldMap.put(item.getName(),item));
                for (Field field : declaredFields) {
                    //有些field 是框架转换的时候增加的 需要排除非原生属性
                    if (!field.isSynthetic()) {
                        fieldMap.put(field.getName(), field);
                    }
                }
                clazz = clazz.getSuperclass();
            }
            return fieldMap;
        });
    }
}