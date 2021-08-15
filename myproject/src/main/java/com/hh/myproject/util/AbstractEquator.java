package com.hh.myproject.util;

import java.util.*;
import java.util.stream.Collectors;

public abstract class AbstractEquator implements Equator {
    //基本数据类型 string也算进去
    private static final List<Class<?>> WRAPPER = Arrays.asList(Byte.class,Short.class,Integer.class,Long.class,
                                                                Float.class,Double.class,Boolean.class,Character.class
                                                                ,String.class);
    private List<String> includeFields;
    private List<String> excludeFields;
    private boolean bothExistFieldOnly = true;//默认只取交集

    public AbstractEquator() {
        includeFields = Collections.emptyList();
        excludeFields = Collections.emptyList();
    }

    /**
     * @param bothExistFieldOnly 是否只对比两个类都包含的字段
     */
    public AbstractEquator(boolean bothExistFieldOnly) {
        includeFields = Collections.emptyList();
        excludeFields = Collections.emptyList();
        this.bothExistFieldOnly = bothExistFieldOnly;
    }

    /**
     * 指定包含或排除某些字段
     *
     * @param includeFields 包含字段，若为 null 或空集，则不指定
     * @param excludeFields 排除字段，若为 null 或空集，则不指定
     */
    public AbstractEquator(List<String> includeFields, List<String> excludeFields) {
        this.includeFields = includeFields;
        this.excludeFields = excludeFields;
    }

    /**
     * 指定包含或排除某些字段
     *
     * @param includeFields      包含字段，若为 null 或空集，则不指定
     * @param excludeFields      排除字段，若为 null 或空集，则不指定
     * @param bothExistFieldOnly 是否只对比两个类都包含的字段，默认为 true
     */
    public AbstractEquator(List<String> includeFields, List<String> excludeFields, boolean bothExistFieldOnly) {
        this.includeFields = includeFields;
        this.excludeFields = excludeFields;
        this.bothExistFieldOnly = bothExistFieldOnly;
    }
    /**
     * 接口中的方法
     * 只要没有不相等的属性，两个对象就全相等
     *
     * @param first  对象1
     * @param second 对象2
     * @return 两个对象是否全相等
     */
    @Override
    public boolean isEquals(Object first, Object second) {
        List<FieldInfo> diff = getDiffFields(first, second);
        return diff == null || diff.isEmpty();
    }

    /**
     * 根据配置的规则决定取两个对象字段的交集或并集
     */
    Set<String> getAllFieldNames (Set<String> firstFileds , Set<String> secondFileds ){
        Set<String> allFields;
        //根据参数决定是否只取交集
        if (isBothExistFieldOnly()){
            allFields = firstFileds.stream().filter(secondFileds::contains).collect(Collectors.toSet());
        }else {
            allFields = new HashSet<>(firstFileds);
            allFields.addAll(secondFileds);
        }
        return allFields;
    }
    /**
     * 判断是否为原始数据类型
     *
     * @param first  对象1
     * @param second 对象2
     * @return 是否为原始数据类型
     */
    boolean isSimpleField(Object first,Object second){
        Object obj = first == null ? second : first;
        Class<?> clazz = obj.getClass();
        return clazz.isPrimitive() || WRAPPER.contains(clazz);
    }

    /**
     * 如果简单数据类型的对象则直接进行比对
     *
     * @param first  对象1
     * @param second 对象2
     * @return 不同的字段信息，相等返回空集，不等则 FieldInfo 的字段名为对象的类型名称
     */
    List<FieldInfo> compareSimpleField (Object first, Object second){
        boolean eq = Objects.equals(first,second);
        if (eq){
            return Collections.EMPTY_LIST;
        }else {
            Object obj = first == null ? second:first;
            Class<?> clazz = obj.getClass();
            //如果基本类型比较还不相同 那么直接返回 基本类型作为名字的集合
            return Collections.singletonList(new FieldInfo(clazz.getSimpleName(),clazz,first,second));
        }
    }

    /**
     * 对比两个对象的指定属性是否相等，默认为两个对象是否 equals
     * <p>
     * 子类可以通过覆盖此方法对某些特殊属性进行比对
     *
     * @param fieldInfo 当前比对属性信息
     * @return 属性是否相等
     */
    protected boolean isFieldEquals(FieldInfo fieldInfo) {
        //比对是否在排除名单内
        if (isExclude(fieldInfo)){
            return true;
        }
        //是否在包含名单内 不包含则放弃
        if (!isInclude(fieldInfo)){
            return true;
        }
        return nullableEquals(fieldInfo.getFirstVal(),fieldInfo.getSecondVal());
    }
    protected  boolean isInclude(FieldInfo fieldInfo){
        //
        return includeFields == null || includeFields.isEmpty() || includeFields.contains(fieldInfo.getFieldName());
    }
    protected boolean isExclude(FieldInfo fieldInfo){
        //excludeFields.stream().allMatch(fieldInfo.getFieldName()::equals);
        //如果是需要排除的 直接返回true
        return excludeFields != null && !excludeFields.isEmpty() && excludeFields.contains(fieldInfo.getFieldName());
    }
    private boolean nullableEquals(Object fisrtVal,Object secondVal){
        //比较具体字段的 值是否相等  如果类型是集合 需要转换为数组后深度比较 默认Arrays.deepEquals0 中没有比较集合的内容
        if (fisrtVal instanceof Collection &&
            secondVal instanceof Collection){
            return Objects.deepEquals(((Collection) fisrtVal).toArray(),((Collection) secondVal).toArray());
        }
        return Objects.deepEquals(fisrtVal,secondVal);
    }
    boolean isBothExistFieldOnly(){
        return this.bothExistFieldOnly;
    }
}