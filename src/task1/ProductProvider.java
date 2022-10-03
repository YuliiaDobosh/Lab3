package task1;

public class ProductProvider {
    private String name;
    private Product product;

    public ProductProvider() {
    }

    public ProductProvider(final String name, final Product product) {
        this.name = name;
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(final Product product) {
        this.product = product;
    }

    public Product provideProduct() {
        final Product providedProduct = new Product();
        providedProduct.setName(product.getName());
        providedProduct.setCount(product.getCount());
        providedProduct.setPrice(product.getPrice());
        return providedProduct;
    }
}
