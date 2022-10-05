package task2;

import task1.Product;
import task1.ProductProvider;

import java.util.List;

public class ProductInStorage {
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(final List<Product> products) {
        this.products = products;
    }

    public ProductInStorage(final List<Product> products) {
        this.products = products;
    }

    public void validate(final Product product) throws PriceException {
        if (product.getPrice() <= 0) {
            throw new PriceException();
        }
    }

    public void validate(final ProductProvider productProvider) throws CountOfProductException, PriceException {
        if (productProvider.getCountOfProduct() <= 0) {
            throw new CountOfProductException();
        }
        validate(productProvider.getProduct());
    }

    public void getProductInStorage(final ProductProvider productProvider) {
        try {
            validate(productProvider);
        } catch (final CountOfProductException | PriceException exception) {
            System.out.println("CountOfProductException or PriceException");
            return;
        }
        for (int i = 0; i < productProvider.getCountOfProduct(); i++) {
            products.add(productProvider.provideProduct());
        }
    }
}

