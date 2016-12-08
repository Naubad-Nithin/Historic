package com.historic;

import java.lang.reflect.Field;

/**
 * Created by Nithin on 12/6/2016.
 */
public class Utils {
    public static int getResId(String variableName, Class<?> c) {

        try {
            Field idField = c.getDeclaredField(variableName);
            return idField.getInt(idField);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
}
