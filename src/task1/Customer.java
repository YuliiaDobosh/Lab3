package task1;

import java.util.List;
import java.util.Objects;

public class Customer {
    private String name;

    public void buyProduct(final Product product) {

    }

    public void buyProducts(final List<Product> products) {

    }

    public Customer() {
    }

    public Customer(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Customer customer = (Customer) o;
        return Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

