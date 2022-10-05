package task1.service;


import task1.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        shop.getProductInStorage().getProductInStorage(productProvider);
    }

    public void addHistorySell(final Product product, final LocalDateTime localDateTime, final Customer customer, final int count) {
        shop.getHistorySells().add(new HistorySell(product, localDateTime, customer, count));
    }

    public void sellProduct(final Customer customer, final Product product) {
        final Product foundProduct = getAndRemoveProduct(product);
        addHistorySell(foundProduct, LocalDateTime.now(), customer, 1);
        customer.buyProduct(foundProduct);
    }

    public void sellProducts(final Customer customer, final Product product, final int count) {
        final List<Product> foundProducts = getAndRemoveProducts(new ArrayList<>(Collections.nCopies(count, product)));
        addHistorySell(product, LocalDateTime.now(), customer, count);
        customer.buyProducts(foundProducts);
    }

    public Product getAndRemoveProduct(final Product product) {
        final Product foundProduct = shop.getProducts()
                .stream()
                .filter(e -> e.equals(product))
                .findFirst()
                .orElseThrow();

        boolean isRepeat = false;
        final List<Product> products = new ArrayList<>();
        for (final Product shopProduct : shop.getProducts()) {
            if (shopProduct.equals(foundProduct) && !isRepeat) {
                isRepeat = true;
            } else {
                products.add(shopProduct);
            }
        }
        shop.setProducts(products);
        return foundProduct;
    }

    public List<Product> getAndRemoveProducts(final List<Product> products) {
        final List<Product> productList = new ArrayList<>();
        products.forEach(e -> productList.add(getAndRemoveProduct(e)));
        return productList;
    }

    public static Shop getEmptyShop() {
        return new Shop(new ArrayList<>(), new ArrayList<>());
    }


}
