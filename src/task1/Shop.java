package task1;

import task2.ProductInStorage;

import java.util.List;

public class Shop {
    private List<Product> products;
    private List<HistorySell> historySells;
    private ProductInStorage productInStorage;

    public List<Product> getProducts() {
        return products;
    }

    public ProductInStorage getProductInStorage() {
        return productInStorage;
    }

    public void setProductInStorage(final ProductInStorage productInStorage) {
        this.productInStorage = productInStorage;
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
        this.productInStorage = new ProductInStorage(products);
    }
}
