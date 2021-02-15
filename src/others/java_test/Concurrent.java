package others.java_test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Concurrent {
    private final AtomicLong count = new AtomicLong(0);
    public long getCount(){
        BigDecimal bigDecimal = new BigDecimal("12.3E+6");
        BigInteger bigInteger = new BigInteger("232245");
        count.incrementAndGet();
        return count.get();
    }
}
