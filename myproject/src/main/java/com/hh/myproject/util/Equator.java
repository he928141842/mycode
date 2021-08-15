package com.hh.myproject.util;

import java.util.List;

public interface Equator {
    /**
     * 比较对象是否完全相等
     * @return
     */
    boolean isEquals(Object first, Object second);

    /**
     * 获取不相等的属性
     *
     * @param first  对象1
     * @param second 对象2
     * @return 不相等的属性，键为属性名，值为属性类型
     */
    List<FieldInfo> getDiffFields(Object first, Object second);
}
