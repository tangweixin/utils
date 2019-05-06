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
 * 生成各种UUID
 *
 * @author thomas
 * @date 2019-04-30
 */
public final class UUID {

    // next8：该方法使用
    public static String[] chars = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    /**
     * 生成唯一的UUID[36位].
     * <p>
     * 示例数据：75912dc1-4f67-4a56-a71b-cab338627929
     *
     * @return String UUID.
     */
    public static String next36() {
        return java.util.UUID.randomUUID().toString();
    }

    /**
     * 生成唯一的UUID[32位].
     * <p>
     * 示例数据：43788d0516824b23a4fe4e2e2076bc7f
     *
     * @return
     */
    public static String next32() {
        return java.util.UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 生成唯一的UUID[8位].（可用来生成一个临时短链）
     * <p>
     * 示例数据：xdsSws3q
     * <p>
     * 测试过，生成100W木有重复！耗时：6~8s（足够一般的业务场景使用）
     *
     * @return
     */
    public static String next8() {
//		StringBuffer sb = new StringBuffer();
//		String uuid = next32();
//		for (int i = 0; i < 8; i++) {
//			String str = uuid.substring(i * 4, i * 4 + 4);
//			int strInteger = Integer.parseInt(str, 16);
//			sb.append(chars[strInteger % 0x3E]);	// //除62取余
//		}
//		return sb.toString();
        return next(8);
    }

    /**
     * 生成唯一的UUID[16位].（可用来生成一个临时短链）
     *
     * @return
     */
    public static String next16() {
        return next(16);
    }

    /**
     * 生成指定位数的UUID.
     *
     * @param length
     * @return
     */
    public static String next(int length) {
        return next(next32(), length);
    }

    /**
     * 生成指定的位数（8，16）的UUID
     * 性能最优
     *
     * @param uuid
     * @param length
     * @return
     */
    public static String next(String uuid, int length) {
        int groupLength = 32 / length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            String str = uuid.substring(i * groupLength, i * groupLength + groupLength);
            int x = Integer.parseInt(str, 16);
            sb.append(chars[x % 0x3E]);
        }
        return sb.toString();
    }

}