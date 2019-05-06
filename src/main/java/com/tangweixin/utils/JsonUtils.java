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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;

/**
 * fastjson工具类.
 *
 * @author thomas
 * @date 2019-04-30
 */
public final class JsonUtils {

    /**
     * 将Java对象转换为json字符串.
     *
     * @param obj
     * @return
     */
    public static String toJson(Object obj) {
        return JSON.toJSONString(obj,
                SerializerFeature.PrettyFormat,             // 美化输出
                SerializerFeature.WriteMapNullValue,        // 空值输出
                SerializerFeature.WriteDateUseDateFormat    // 日期格式化: yyyy-MM-dd HH:mm:ss
        );
    }

    /**
     * 将Java对象转换为json字符串(最小化输出: 空值不输出，不换行).
     *
     * @param obj
     * @return
     */
    public static String toJsonMin(Object obj) {
        return JSON.toJSONString(obj);
    }

    /**
     * 将json字符串转换为Java对象.
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String json, Class<T> clazz) {
        return JSONObject.parseObject(json, clazz);
    }

    /**
     * 将json字符串转换为Java的Map对象.
     *
     * @param json
     * @return
     */
    public static JSONObject fromJsonMap(String json) {
        return JSONObject.parseObject(json);
    }

    /**
     * 将json字符串转换为Java数组.
     *
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> fromJsonList(String json, Class<T> clazz) {
        return JSONArray.parseArray(json, clazz);
    }

}
