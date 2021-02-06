package api.rest;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class ApiResultPrintHelper {
    @SneakyThrows
    public static void printAndWait(String text) {
        System.out.println(text);
        TimeUnit.SECONDS.sleep(1);
    }

    public static void printAndWait(Object object) {
        printAndWait(object.toString());
    }
}
