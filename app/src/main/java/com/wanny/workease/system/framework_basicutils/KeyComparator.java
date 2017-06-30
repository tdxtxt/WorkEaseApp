package com.wanny.workease.system.framework_basicutils;

import java.util.Comparator;
import java.util.Map;

/**
 * 文件名： KeyComparator
 * 功能：
 * 作者： wanny
 * 时间： 16:59 2017/6/23
 */
public class KeyComparator implements Comparator<Map.Entry<String, String>> {
    public int compare(Map.Entry<String, String> m,
                       Map.Entry<String, String> n) {
        return m.getValue().compareTo(n.getValue());
    }
}
