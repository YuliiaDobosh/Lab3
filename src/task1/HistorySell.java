package task1;

import java.time.LocalDateTime;

public class HistorySell {
    private Product product;
    private LocalDateTime localDateTime;
    private Customer customer;

    public HistorySell() {
    }

    public HistorySell(final Product product, final LocalDateTime localDateTime, final Customer customer) {
        this.product = product;
        this.localDateTime = localDateTime;
        this.customer = customer;
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

    @Override
    public String toString() {
        return product + " " + localDateTime + " " + customer + " ";
    }
}
