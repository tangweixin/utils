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

import java.math.BigDecimal;
import java.util.stream.Stream;

/**
 * 数据操作工具
 */
public final class BigDecimalUtils {

    /**
     * a 小于等于 b
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean le(BigDecimal a, BigDecimal b) {
        int scale = getScale(a, b, 2);
        return le(a, b, scale);
    }

    // 返回两个数中精度最大的
    private static int getScale(BigDecimal a, BigDecimal b, int defaultScale) {
        return Stream.of(a.scale(), b.scale(), defaultScale).mapToInt(e -> e).max().getAsInt();
    }

    /**
     * a 小于等于 b 指定精度
     *
     * @param a
     * @param b
     * @param scale 精度
     * @return
     */
    public static boolean le(BigDecimal a, BigDecimal b, int scale) {
        return a.setScale(scale, BigDecimal.ROUND_HALF_UP).compareTo(b.setScale(scale, BigDecimal.ROUND_HALF_UP)) <= 0;
    }

    /**
     * a 小于 b
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean lt(BigDecimal a, BigDecimal b) {
        int scale = getScale(a, b, 2);
        return lt(a, b, scale);
    }

    /**
     * a 小于 b  指定精度
     *
     * @param a
     * @param b
     * @param scale 精度
     * @return
     */
    public static boolean lt(BigDecimal a, BigDecimal b, int scale) {
        return a.setScale(scale, BigDecimal.ROUND_HALF_UP).compareTo(b.setScale(scale, BigDecimal.ROUND_HALF_UP)) < 0;
    }


    /**
     * a 大于等于 b
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean ge(BigDecimal a, BigDecimal b) {
        int scale = getScale(a, b, 2);
        return ge(a, b, scale);
    }

    /**
     * a 大于等于 b 指定精度
     *
     * @param a
     * @param b
     * @param scale 精度
     * @return
     */
    public static boolean ge(BigDecimal a, BigDecimal b, int scale) {
        return a.setScale(scale, BigDecimal.ROUND_HALF_UP).compareTo(b.setScale(scale, BigDecimal.ROUND_HALF_UP)) >= 0;
    }

    /**
     * a 大于 b
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean gt(BigDecimal a, BigDecimal b) {
        int scale = getScale(a, b, 2);
        return gt(a, b, scale);
    }

    /**
     * a 大于 b  指定精度
     *
     * @param a
     * @param b
     * @param scale 精度
     * @returng
     */
    public static boolean gt(BigDecimal a, BigDecimal b, int scale) {
        return a.setScale(scale, BigDecimal.ROUND_HALF_UP).compareTo(b.setScale(scale, BigDecimal.ROUND_HALF_UP)) > 0;
    }

    /**
     * a 等于 b
     *
     * @param a
     * @param b
     * @return
     */
    public static boolean eq(BigDecimal a, BigDecimal b) {
        int scale = getScale(a, b, 2);
        return eq(a, b, scale);
    }

    /**
     * a 等于 b  指定精度
     *
     * @param a
     * @param b
     * @param scale 精度
     * @return
     */
    public static boolean eq(BigDecimal a, BigDecimal b, int scale) {
//        System.out.println("a=" + a + ", b=" + b + ", scale=" + scale);
        return a.setScale(scale, BigDecimal.ROUND_HALF_UP).compareTo(b.setScale(scale, BigDecimal.ROUND_HALF_UP)) == 0;
    }

    /**
     * 返回对应的BigDecimal数
     *
     * @param value
     * @return
     */
    public static BigDecimal bg(String value) {
        return new BigDecimal(value);
    }

    /**
     * 元转分
     * 四舍五入
     * @param money
     * @return
     */
    public static Integer yuan2fen(BigDecimal money) {
        return money.multiply(new BigDecimal("100")).setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
    }

    /**
     * 分转元
     *
     * @param money
     * @return
     */
    public static BigDecimal fen2yuan(Integer money) {
        return new BigDecimal(money).divide(new BigDecimal("100"), 2, BigDecimal.ROUND_HALF_UP);
    }

}
