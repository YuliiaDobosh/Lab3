package task1.service;


import task1.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ShopService {
    protected Shop shop;


    public ShopService(final Shop shop) {
        this.shop = shop;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(final Shop shop) {
        this.shop = shop;
    }

    public void printProduct() {
        shop.getProducts().forEach(System.out::println);
    }

    public void printHistorySells() {
        shop.getHistorySells().forEach(System.out::println);

    }

    public void getProduct(final ProductProvider productProvider) {
        for (int i = 0; i < productProvider.getCountOfProduct(); i++) {
            shop.getProducts().add(productProvider.provideProduct());
        }
    }

    public void addHistorySell(final Product product, final LocalDateTime localDateTime, final Customer customer, final int count) {
        shop.getHistorySells().add(new HistorySell(product, localDateTime, customer, count));
    }

    public void sellProduct(final Customer customer, final Product product) {
        final Product foundProduct = getAndRemoveProduct(product);
        addHistorySell(foundProduct, LocalDateTime.now(), customer, 1);
        customer.buyProduct(foundProduct);
    }

    public void sellProduct(final Customer customer, final Product product, final int count) {
        final Product foundProduct = getAndRemoveProduct(product);
        addHistorySell(foundProduct, LocalDateTime.now(), customer, count);
        customer.buyProduct(foundProduct);
    }

    public Product getAndRemoveProduct(final Product product) {
        final Product foundProduct = shop.getProducts()
                .stream()
                .filter(e -> e.equals(product))
                .findAny()
                .orElseThrow();
        shop.setProducts(shop.getProducts().stream()
                .filter(e -> !e.equals(foundProduct))
                .collect(Collectors.toList()));
        return foundProduct;
    }

    public List<Product> getAndRemoveProducts(final List<Product> products) {
        final Product foundProducts = shop.getProducts()
                .stream()
                .filter(e -> products.)
                .findAny()
                .orElseThrow();
        shop.setProducts(shop.getProducts().stream()
                .filter(e -> !e.equals(foundProducts))
                .collect(Collectors.toList()));
        return foundProducts;
    }

    public static Shop getEmptyShop() {
        return new Shop(new ArrayList<>(), new ArrayList<>());
    }


}
