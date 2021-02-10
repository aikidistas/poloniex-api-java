package org.aikidistas.highfrequencytrading.domain;

import org.cactoos.Scalar;

import java.math.BigDecimal;

public class AtLeastMinimumOrException implements Scalar<BigDecimal> {
    private final Scalar<BigDecimal> source;
    private final BigDecimal minimum;

    public AtLeastMinimumOrException(BigDecimal source, BigDecimal minimum) {
        this.source = () -> source;
        this.minimum = minimum;
    }

    public AtLeastMinimumOrException(Scalar<BigDecimal> source, BigDecimal minimum) {
        this.source = source;
        this.minimum = minimum;
    }

    @Override
    public BigDecimal value() throws Exception {
        final BigDecimal result = source.value();
        if (minimum.compareTo(result) > 0) {
            throw new Exception("At least minimum amount not satisfied. Received: " + result.toPlainString() + ". Minimum expected: " + minimum.toPlainString());
        }
        return result;
    }
}
