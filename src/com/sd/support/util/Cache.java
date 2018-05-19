package com.sd.support.util;


import java.util.*;

/**
 *
 * @author subha
 */
public class Cache {

    static HashMap< String, String> entries;

    static {
        entries = new HashMap<>();
    }

    public static boolean add(String key, String value) {
        if (entries.containsKey(key)) {
            return false;
        } else {
            entries.put(key, value);
            return true;
        }
    }

    public static boolean remove(String key) {
        if (entries.containsKey(key)) {
            return false;
        } else {
            entries.remove(key);
            return true;
        }
    }

    public static String get(String key) {
        return entries.get(key);
    }
}
