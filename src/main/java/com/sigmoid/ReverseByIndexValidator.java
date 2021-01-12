package com.sigmoid;

import java.util.List;

public class ReverseByIndexValidator {

    public static boolean validate(int m, int n, List<Integer> list) {
        if (list == null || list.isEmpty())
            return false;
        if (m < 0 || n < 0)
            return false;
        if (m > list.size())
            return false;
        if (n > list.size() - 1)
            return false;
        if (m > n)
            return false;

        return true;
    }
}
