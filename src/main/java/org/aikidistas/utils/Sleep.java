package org.aikidistas.utils;

import java.util.concurrent.TimeUnit;

public class Sleep {
    public static void seconds(int s) {
        try {
            TimeUnit.SECONDS.sleep(s);
        } catch (InterruptedException e) {
            // JUST IGNORE
        }
    }

    public static void milliseconds(int m) {
        try {
            TimeUnit.MILLISECONDS.sleep(m);
        } catch (InterruptedException e) {
            // JUST IGNORE
        }
    }
}
