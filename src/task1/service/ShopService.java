package task1.service;


import task1.*;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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

    //    public Product findProduct(final Predicate<? super Product> predicate) {
//        return shop.getProducts()
//                .stream()
//                .filter(predicate)
//                .findAny()
//                .orElse(null);
//    }
    public void addHistorySell(final Product product, final LocalDateTime localDateTime, final Customer customer) {
        shop.getHistorySells().add(new HistorySell(product, localDateTime, customer));
    }

    public void sellProduct(final Customer customer, final Product product) {
        final Product foundProduct = shop.getProducts()
                .stream()
                .filter(e -> e.equals(product))
                .findAny()
                .orElseThrow();
        shop.getProducts().remove(foundProduct);
        addHistorySell(foundProduct, LocalDateTime.now(), customer);
        customer.buyProduct(foundProduct);
    }

    public static Shop getEmptyShop() {
        return new Shop(new ArrayList<>(), new ArrayList<>());
    }
}
