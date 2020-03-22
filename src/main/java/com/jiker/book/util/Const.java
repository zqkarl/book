package com.jiker.book.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 常量
 */
public class Const {
    public static final Map<String, String> BOOK_TYPE_MAP = new HashMap<String, String>();

    /**
     * 静态代码块，随着类的加载而执行，静态代码块中的代码只执行一次，不需要每次调用这个变量都给它赋值。
     */
    static{
        BOOK_TYPE_MAP.put("1","文化类");
        BOOK_TYPE_MAP.put("2","科技类");
        BOOK_TYPE_MAP.put("3","生活类");
        BOOK_TYPE_MAP.put("4","少儿类");
        BOOK_TYPE_MAP.put("5","综合类");
    }
}
