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

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author thomas
 * @date 2019-04-29
 */
public class JsonUtilsTest {

    public static void main(String[] args) {

        String json = "[{name: 'Thomas', age: 10, x: null, money: 100.009, birth: '2019-04-30'}, {name: 'Bruce', age: 18, x:null, money: 100.009, birth: '2019-04-30'}]";

        List<User> list = JsonUtils.fromJsonList(json, User.class);
        list.forEach(e -> {
            System.out.println(e);
        });
        System.out.println(JsonUtils.toJsonMin(list));
        System.out.println(JsonUtils.toJson(list));
        System.out.println(">>>>>>>>>>>");

        json = "{name: 'Thomas', age: 100, x: null, money: 100.009, birth: '2019-04-30'}";
        User user = JsonUtils.fromJson(json, User.class);
        System.out.println(user);
        System.out.println(JsonUtils.toJson(user));

        JSONObject map = JsonUtils.fromJsonMap(json);       // class com.alibaba.fastjson.JSONObject
        System.out.println(map);
        System.out.println(map.getClass());

    }

}
