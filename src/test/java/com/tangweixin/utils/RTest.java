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

/**
 * @author thomas
 * @date 2019-04-30
 */
public class RTest {

    public static void main(String[] args) throws Exception {

        System.out.println(R.ok());
        System.out.println(R.ok("Finish!"));
        System.out.println(R.ok("name", "Thomas"));
        System.out.println(R.page(JsonUtils.fromJsonMap("{name: 'Thomas'}")));
        System.out.println(R.error());
        System.out.println(R.error("一个未知的异常!"));
        System.out.println(R.error(401, "出错啦!"));

    }

}
