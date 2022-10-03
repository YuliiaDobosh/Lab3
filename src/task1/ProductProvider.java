package task1;

public class ProductProvider {
    private String name;
    private Product product;

    private int CountOfProduct;

    public ProductProvider() {
    }

    public ProductProvider(final String name, final Product product, final int countOfProduct) {
        this.name = name;
        this.product = product;
        CountOfProduct = countOfProduct;
    }

    public int getCountOfProduct() {
        return CountOfProduct;
    }

    public void setCountOfProduct(final int countOfProduct) {
        CountOfProduct = countOfProduct;
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
        providedProduct.setPrice(product.getPrice());
        return providedProduct;
    }
}
