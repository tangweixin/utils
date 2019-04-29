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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author thomas
 * @date 2019-04-30
 */
public class UUIDTest {

    public static void main(String[] args) throws Exception {
//        testNext8();
        System.out.println(UUID.next8());
        System.out.println(UUID.next16());
        System.out.println(UUID.next32());
        System.out.println(UUID.next(10));
    }

    public static void testNext8() throws Exception {
        Map<String, Byte> m = new ConcurrentHashMap<String, Byte>();
        int max = 10000 * 300;    // 1KW
        for (int i = 0; i < max; i++) {
            String uuid = UUID.next8();
            if (m.containsKey(uuid)) {
                show(i, uuid);
                // 600W的时候有重复
            }
            m.put(uuid, (byte) 0);
        }
    }

    private static void show(int row, String uuid) {
        System.err.println(row + "=" + uuid);
    }
}
