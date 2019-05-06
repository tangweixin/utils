/*
 * Copyright (C) 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tangweixin.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * Json工具类
 *
 * @author thomas
 * @date 2019-04-29
 */
public final class GsonUtils {

    private static Gson gson;
    private static Gson gsonMin;

    static {

        gson = new GsonBuilder().disableHtmlEscaping() // 禁用HTML特殊符号转义
//				.setDateFormat("yyyy-MM-dd") // 指定日期格式
                .setDateFormat("yyyy-MM-dd HH:mm:ss") // 指定日期格式
                .setPrettyPrinting() // 美化打印
                .serializeNulls()    // 序列号null值
                .create(); // 创建实例

        gsonMin = new GsonBuilder().disableHtmlEscaping() // 禁用HTML特殊符号转义
//				.setDateFormat("yyyy-MM-dd") // 指定日期格式
                .setDateFormat("yyyy-MM-dd HH:mm:ss") // 指定日期格式
//                .setPrettyPrinting() // 美化打印
//                .serializeNulls()    // 序列号null值
                .create(); // 创建实例

    }

    /**
     * 将Java对象转换为json字符串.
     *
     * @param obj
     * @return
     */
    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * 将Java对象转换为json字符串(最小化输出: 空值不输出，不换行).
     *
     * @param obj
     * @return
     */
    public static String toJsonMin(Object obj) {
        return gsonMin.toJson(obj);
    }

    /**
     * 将json字符串转换为Java对象.
     *
     * @param json
     * @param classOfT
     * @return
     */
    public static <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    /**
     * 将json字符串转换为Java对象.
     *
     * <pre>
     * List<User> list = GsonUtils.fromJson(json, new TypeToken<List<User>>() {}.getType());
     * </pre>
     *
     * @param json
     * @param typeOfT
     * @return
     */
    public static <T> T fromJson(String json, Type typeOfT) {
        return gson.fromJson(json, typeOfT);
    }

    /**
     * 将json字符串转换为Java的Map对象.
     *
     * @param json
     * @return
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> fromJsonMap(String json) {
        return gson.fromJson(json, Map.class);
    }

}
