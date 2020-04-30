package service;

import com.company.entity.Product;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceTest {

    @Test
    public void testGetProducts() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "Czekolada", 2.80F, 0.200F, "brown", 328));
        products.add(new Product(2L, "Coca-Cola", 4.50F, 1.750F, "black", 218));


    }
}
