package service;

import com.company.entity.Boots;
import com.company.entity.Cloth;
import com.company.entity.Product;
import com.company.service.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {

    @Test
    public void testGetProductsPositive() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1l, "T-SHIRT", 35.0f, 0.3f, "Black", 4, "XL", "COTTON"));
        products.add(new Boots(1l, "T-SHIRT", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);

        List<Product> fetchedProducts = productService.getProducts();

        Assert.assertEquals(products, fetchedProducts);
    }

    @Test
    public void testGetAmountsOfProducts() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Cloth(1l, "T-SHIRT", 35.0f, 0.3f, "Black", 4, "XL", "COTTON"));
        products.add(new Boots(2l, "Boots", 35.0f, 0.3f, "Black", 4, 38, true));

        ProductServiceImpl productService = new ProductServiceImpl(products);

        final int fetchedAmount = productService.getAmountOfProducts();

        Assert.assertEquals(2, fetchedAmount);
    }

    @Test
    public void testGetProductByName() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Czekolada", 2.80F, 0.200F, "brown", 328));
        products.add(new Product(2L, "Coca-Cola", 4.50F, 1.750F, "black", 218));

        ProductServiceImpl productService = new ProductServiceImpl(products);

        Product product = products.get(0);
        Product fetchedProduct = productService.getProductByName("Czekolada");

        Assert.assertEquals(product, fetchedProduct);
    }

    @Test
    public void testIsExistByName() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Czekolada", 2.80F, 0.200F, "brown", 328));
        products.add(new Product(2L, "Coca-Cola", 4.50F, 1.750F, "black", 218));

        ProductServiceImpl productService = new ProductServiceImpl(products);

        boolean isExist = productService.isProductExist("Czekolada");

        Assert.assertEquals(true, isExist);
    }

    @Test
    public void testIsNotExistByName() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Czekolada", 2.80F, 0.200F, "brown", 328));
        products.add(new Product(2L, "Coca-Cola", 4.50F, 1.750F, "black", 218));

        ProductServiceImpl productService = new ProductServiceImpl(products);

        boolean isExist = productService.isProductExist("Kinder niespodzianka");

        Assert.assertNotEquals(true, isExist);
    }

    @Test
    public void testIsExistById() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Czekolada", 2.80F, 0.200F, "brown", 328));
        products.add(new Product(2L, "Coca-Cola", 4.50F, 1.750F, "black", 218));

        ProductServiceImpl productService = new ProductServiceImpl(products);

        boolean isExist = productService.isProductExist(1L);

        Assert.assertEquals(true, isExist);
    }

    @Test
    public void testIsNotExistById() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Czekolada", 2.80F, 0.200F, "brown", 328));
        products.add(new Product(2L, "Coca-Cola", 4.50F, 1.750F, "black", 218));

        ProductServiceImpl productService = new ProductServiceImpl(products);

        boolean isExist = productService.isProductExist(4L);

        Assert.assertNotEquals(true, isExist);
    }

    @Test
    public void testProductIsAvailable() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Czekolada", 2.80F, 0.200F, "brown", 328));
        products.add(new Product(2L, "Coca-Cola", 4.50F, 1.750F, "black", 218));

        ProductServiceImpl productService = new ProductServiceImpl(products);

        boolean isAvailable = productService.isProductAvailable("Czekolada");

        Assert.assertEquals(true, isAvailable);
    }

    @Test
    public void testProductIsNotAvailable() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Czekolada", 2.80F, 0.200F, "brown", 0));

        ProductServiceImpl productService = new ProductServiceImpl(products);

        boolean isAvailable = productService.isProductAvailable("Czekolada");

        Assert.assertNotEquals(true, isAvailable);
    }
}
