package api.rest.privateapi.read.tradehistory;

import api.rest.privateapi.read.tradehistory.dto.TradeHistoryDto;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.List;

import static api.rest.ApiResultPrintHelper.printAndWait;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TradeHistoryPrivateTest {


    @SneakyThrows
    @Test
    public void mapTradeHistory() {
        String data = "[{\n"
                + "		\"globalTradeID\": 84912521,\n"
                + "		\"tradeID\": \"1640236\",\n"
                + "		\"date\": \"2017-03-06 18:49:34\",\n"
                + "		\"rate\": \"1273.37202076\",\n"
                + "		\"amount\": \"0.53284726\",\n"
                + "		\"total\": \"678.51279222\",\n"
                + "		\"fee\": \"0.00150000\",\n"
                + "		\"orderNumber\": \"55510230325\",\n"
                + "		\"type\": \"buy\",\n"
                + "		\"category\": \"exchange\"\n"
                + "	}, {\n"
                + "		\"globalTradeID\": 84558071,\n"
                + "		\"tradeID\": \"1628053\",\n"
                + "		\"date\": \"2017-03-04 20:46:16\",\n"
                + "		\"rate\": \"1268.00099400\",\n"
                + "		\"amount\": \"0.52759685\",\n"
                + "		\"total\": \"668.99333023\",\n"
                + "		\"fee\": \"0.00150000\",\n"
                + "		\"orderNumber\": \"55201819045\",\n"
                + "		\"type\": \"sell\",\n"
                + "		\"category\": \"exchange\"\n"
                + "	}, {\n"
                + "		\"globalTradeID\": 83437549,\n"
                + "		\"tradeID\": \"1576412\",\n"
                + "		\"date\": \"2017-03-01 00:51:31\",\n"
                + "		\"rate\": \"1186.00000016\",\n"
                + "		\"amount\": \"0.13349834\",\n"
                + "		\"total\": \"158.32903126\",\n"
                + "		\"fee\": \"0.00150000\",\n"
                + "		\"orderNumber\": \"54147454465\",\n"
                + "		\"type\": \"buy\",\n"
                + "		\"category\": \"exchange\"\n"
                + "	}]";

        List<TradeHistoryDto> tradeHistory = new TradeHistoryPrivate(() -> data).data(); //mapper.mapTradeHistory(data);
        assertEquals(3, tradeHistory.size());

        TradeHistoryDto first = tradeHistory.get(0);
        assertEquals(84912521L, first.globalTradeID.longValue());
        assertEquals("1640236", first.tradeID);
        assertEquals("2017-03-06T18:49:34Z", first.date.toString());
        assertEquals("1273.37202076", first.rate.toPlainString());
        assertEquals("0.00150000", first.fee.toPlainString());
        assertEquals("55510230325", first.orderNumber);
        assertEquals("buy", first.type);
        assertEquals("exchange", first.category);
    }


    @SneakyThrows
    @Test
    public void tradeHistory() {
        printAndWait(
                new TradeHistoryPrivate("USDT_ETH").data()
        );
    }

    // TODO: fix json parse issue

    // TODO: continue documenting other usages
}