package org.tustcs.lockers.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Airmacx on 2017/11/3.
 */
public class IOUtils {

    public static void closeCloseable(Closeable... closeable) {
        try {
            if (closeable != null && closeable.length > 0) {
                for (Closeable c : closeable) {
                    if (c != null) {
                        c.close();
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}