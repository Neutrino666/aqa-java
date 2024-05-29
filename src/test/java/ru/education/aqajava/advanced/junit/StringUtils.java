/*
 * Copyright 2015-2021 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * https://www.eclipse.org/legal/epl-v20.html
 */

package ru.education.aqajava.advanced.junit;

public class StringUtils {

    public static boolean isPalindrome(String str) {
        boolean a;
        a = str.equals(
                new StringBuilder(str)
                        .reverse()
                        .toString()
        );
        return a;
    }

    public static int divide(int a, int b) {
        return a / b;
    }


}
