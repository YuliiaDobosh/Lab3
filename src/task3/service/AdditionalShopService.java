package task3.service;

import task1.Customer;
import task1.HistorySell;
import task1.Product;
import task1.Shop;


import java.time.LocalDateTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class AdditionalShopService {
    private Shop shop;

    public Shop getShop() {
        return shop;
    }

    public void setShop(final Shop shop) {
        this.shop = shop;
    }

    public AdditionalShopService(final Shop shop) {
        this.shop = shop;
    }

    public List<Product> sortByPrice() {
        return new ArrayList<>(shop.getProducts())
                .stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
    }

    public void printSortedByPrice() {
        sortByPrice().forEach(System.out::println);
    }

    public List<Product> filterByHighPrice(final double price) {
        return new ArrayList<>(shop.getProducts())
                .stream()
                .filter(e -> e.getPrice() <= price)
                .collect(Collectors.toList());
    }

    public void printFilterByHighPrice(final double price) {
        filterByHighPrice(price).forEach(System.out::println);
    }

    public double averagePrice() {
        return shop.getProducts()
                .stream()
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0);
    }

    public void printAveragePrice() {
        System.out.println("Average price of all products =  " + averagePrice());
    }

    public double spendingCustomer(final Customer customer, final LocalDateTime localDateTime1, final LocalDateTime localDateTime2) {
        return shop.getHistorySells()
                .stream()
                .filter(e -> e.getCustomer().equals(customer))
                .filter(e -> e.getLocalDateTime().isAfter(localDateTime1)
                        && e.getLocalDateTime().isBefore(localDateTime2))
                .mapToDouble(e -> e.getProduct().getPrice() * e.getCount())
                .sum();
    }

    public void printSpendingCustomer(final Customer customer, final LocalDateTime localDateTime1, final LocalDateTime localDateTime2) {
        System.out.println("Spending money by customer from " + localDateTime1.toString() +
                " to " + localDateTime2.toString() +
                " = " + spendingCustomer(customer, localDateTime1, localDateTime2));
    }

    public int countProductByCustomer(final Customer customer, final Product product) {
        return shop.getHistorySells()
                .stream()
                .filter(e -> e.getCustomer().equals(customer))
                .filter(e -> e.getProduct().equals(product))
                .mapToInt(HistorySell::getCount)
                .sum();
    }

    public void printCountProductByCustomer(final Customer customer, final Product product) {
        System.out.println("Summary count " + product.getName() + " by " + customer.getName()
                + " = " + countProductByCustomer(customer, product));
    }

    public Product findPopularProduct() {
        final Map<Product, List<HistorySell>> map = shop.getHistorySells()
                .stream()
                .collect(Collectors.groupingBy(HistorySell::getProduct));
        final Map<Product, Integer> map1 = map.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        e -> e.getValue().stream().mapToInt(HistorySell::getCount).sum()));
        return map1.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .orElseThrow()
                .getKey();
    }

    public void printFindPopularProduct() {
        System.out.println("Popular product is " + findPopularProduct());
    }

    public double maxIncome() {
        final Map<LocalDate, List<HistorySell>> map = shop.getHistorySells()
                .stream()
                .collect(Collectors.groupingBy(e -> e.getLocalDateTime().toLocalDate()));
        final Map<LocalDate, Double> map1 = map.entrySet()
                .stream()
                .collect(Collectors.toMap(Map.Entry::getKey,
                        e -> e.getValue()
                                .stream()
                                .mapToDouble(e1 -> e1.getProduct().getPrice() * e1.getCount())
                                .sum()));
        return map1.entrySet().stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .orElseThrow()
                .getValue();
    }

    public void printMaxIncome() {
        System.out.println("Max income of the day is " + maxIncome());
    }


}
