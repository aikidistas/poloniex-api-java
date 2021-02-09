package api.rest;

import lombok.SneakyThrows;
import org.aikidistas.utils.Sleep;

public class ApiResultPrintHelper {
    @SneakyThrows
    public static void printAndWait(String text) {
        System.out.println(text);
        Sleep.seconds(1);
    }

    public static void printAndWait(Object object) {
        printAndWait(object.toString());
    }
}
