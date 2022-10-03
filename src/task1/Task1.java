package task1;

import task1.service.ShopService;

public class Task1 {
    public static void main(final String[] args) {

        final ProductProvider productProviderOfBread =
                new ProductProvider("Bread International", new Product("Eco Bread", 1), 10);
        final ProductProvider productProviderOfIphone =
                new ProductProvider("Apple", new Product("Iphone 14", 1500), 3);

        final Customer customerYulia = new Customer("Yulia");
        final Customer customerDaniel = new Customer("Daniel");
        final Customer customerOleg = new Customer("Oleg");


        final Shop shop = ShopService.getEmptyShop();
        final ShopService shopService = new ShopService(shop);

        shopService.getProduct(productProviderOfBread);
        shopService.getProduct(productProviderOfIphone);

        shopService.sellProduct(customerYulia, new Product("Iphone 14", 1500));
        shopService.sellProduct(customerOleg, new Product("Eco Bread", 1));
        shopService.sellProduct(customerDaniel, new Product("Eco Bread", 1));

        shopService.printProduct();
        shopService.printHistorySells();
    }
}
