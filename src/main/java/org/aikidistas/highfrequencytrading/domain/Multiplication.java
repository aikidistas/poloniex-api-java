package org.aikidistas.highfrequencytrading.domain;

import org.cactoos.Scalar;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Multiplication implements Scalar<BigDecimal> {
    private final Scalar<BigDecimal> a;
    private final Scalar<BigDecimal> b;

    public Multiplication(BigDecimal a, BigDecimal b) {
        this(() -> a, () -> b);
    }

    public Multiplication(Scalar<BigDecimal> a, Scalar<BigDecimal> b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public BigDecimal value() throws Exception {
        return a.value()
                .multiply(b.value())
                .setScale(8, RoundingMode.HALF_UP);
    }
}
