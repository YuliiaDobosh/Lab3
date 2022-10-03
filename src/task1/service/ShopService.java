package task1.service;


import task1.Product;
import task1.ProductProvider;
import task1.Shop;

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

    public void getProduct(final ProductProvider productProvider) {
        shop.getProducts().add(productProvider.provideProduct());
    }
}
