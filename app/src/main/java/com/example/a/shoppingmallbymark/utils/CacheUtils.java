package com.example.a.shoppingmallbymark.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Mark栋 on 2018/5/6.
 * purpose:缓存工具类
 */

public class CacheUtils {
    /**
    * purpose:得到保持String类型的数据
    * Note:
    */
    public static String getString(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences("atguigu",Context.MODE_PRIVATE);
        return sp.getString(key,"");
    }

    /**
     * 保存String类型数据
     * @param context 上下文
     * @param key
     * @param value 保存的值
     */
    public static void saveString(Context context, String key, String value) {
        SharedPreferences sp = context.getSharedPreferences("atguigu",Context.MODE_PRIVATE);
        sp.edit().putString(key,value).commit();
    }
}
