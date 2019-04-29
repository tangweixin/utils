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

import java.util.HashMap;
import java.util.Map;

/**
 * 简化的响应对象. 提供一些快捷操作.
 * <p>
 * 就是一个HashMap对象.
 *
 * @author thomas
 * @date 2019-04-30
 */
public class R extends HashMap<String, Object> {

    /**
     *
     */
    private static final long serialVersionUID = 8607298644792029192L;

    public R() {
        put("code", 0);
    }

    /**
     * 返回一个空的错误的响应对象.
     *
     * @return
     */
    public static R error() {
        return R.error(400, "未知错误");
    }

    /**
     * 返回一个错误的响应对象.
     *
     * @param msg
     * @return
     */
    public static R error(String msg) {
        return R.error(400, msg);
    }

    /**
     * 返回一个错误的响应对象.
     *
     * @param msg
     * @return
     */
    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    /**
     * 返回一个空的正确的响应.
     *
     * @return
     */
    public static R ok() {
        return R.ok("操作成功");
    }

    /**
     * 返回一个正确的响应.
     *
     * @param msg
     * @return
     */
    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    /**
     * 返回一个正确的响应.
     *
     * @param name
     * @param value
     * @return
     */
    public static R ok(String name, Object value) {
        return R.ok().add(name, value);
    }

    /**
     * 返回一个正确的响应.
     *
     * @param map
     * @return
     */
    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    /**
     * 添加一个属性.
     * <p>
     * 链式编程.
     *
     * @param name
     * @param value
     * @return
     */
    public R add(String name, Object value) {
        super.put(name, value);
        return this;
    }

    /**
     * 分页
     *
     * @param value
     * @return
     */
    public static R page(Object value) {
        return R.ok("page", value);
    }

}
