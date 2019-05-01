package com.tangweixin.utils;

import java.math.BigDecimal;

import static com.tangweixin.utils.BigDecimalUtils.*;

/**
 * @author thomas
 * @date 2019-05-01
 */
public class BigDecimalUtilsTest {

    public static void main(String[] args) {

        System.out.println(ge(bg("10.00"), bg("10.01")));
        System.out.println(lt(bg("10.02"), bg("10.01")));
        System.out.println(bg("10.01").setScale(0, BigDecimal.ROUND_CEILING));
        System.out.println(bg("10.01").setScale(0, BigDecimal.ROUND_UP));

    }
}
