package task1;

import java.util.List;

public class Shop {
    private List<Product> products;
    private List<HistorySell> historySells;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(final List<Product> products) {
        this.products = products;
    }

    public List<HistorySell> getHistorySells() {
        return historySells;
    }

    public void setHistorySells(final List<HistorySell> historySells) {
        this.historySells = historySells;
    }

    public Shop() {

    }

    public Shop(final List<Product> products, final List<HistorySell> historySells) {
        this.products = products;
        this.historySells = historySells;
    }
}
