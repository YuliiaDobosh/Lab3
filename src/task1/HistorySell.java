package task1;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class HistorySell {
    private Product product;
    private LocalDateTime localDateTime;
    private Customer customer;

    private int count;

    public HistorySell() {
    }

    public HistorySell(final Product product, final LocalDateTime localDateTime, final Customer customer, final int count) {
        this.product = product;
        this.localDateTime = localDateTime;
        this.customer = customer;
        this.count = count;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(final Product product) {
        this.product = product;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(final LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(final Customer customer) {
        this.customer = customer;
    }

    public int getCount() {
        return count;
    }

    public void setCount(final int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return product + " " + count + " " + localDateTime + " " + customer + " ";
    }
}
