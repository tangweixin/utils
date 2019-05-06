package com.tangweixin.utils;

import java.math.BigDecimal;

import static com.tangweixin.utils.BigDecimalUtils.*;

/**
 * @author thomas
 * @date 2019-05-01
 */
public class BigDecimalUtilsTest {

    public static void main(String[] args) {

        System.out.println(ge(bg("10.00"), bg("10.01")));       // false
        System.out.println(lt(bg("10.02"), bg("10.01")));       // false
        System.out.println(bg("10.01").setScale(0, BigDecimal.ROUND_CEILING));  // 11
        System.out.println(bg("10.01").setScale(0, BigDecimal.ROUND_UP));       // 11
        System.out.println(yuan2fen(new BigDecimal("12.004")));         // 1200
        System.out.println(yuan2fen(new BigDecimal("12.005")));         // 1201
        System.out.println(fen2yuan(12004567));                      // 120045.67

    }
}
