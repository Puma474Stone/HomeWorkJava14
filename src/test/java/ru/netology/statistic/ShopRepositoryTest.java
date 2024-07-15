package ru.netology.statistic;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShopRepositoryTest {

    @Test
    public void testRemoveExistingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Product1", 100);
        Product product2 = new Product(2, "Product2", 200);
        repo.add(product1);
        repo.add(product2);

        repo.removeById(1);

        Product[] remainingProducts = repo.findAll();
        assertEquals(1, remainingProducts.length);
        assertEquals(product2, remainingProducts[0]);
    }

    @Test
    public void testRemoveNonExistingProduct() {
        ShopRepository repo = new ShopRepository();
        Product product1 = new Product(1, "Product1", 100);
        repo.add(product1);

        Exception exception = assertThrows(NotFoundException.class, () -> {
            repo.removeById(2);
        });

        String expectedMessage = "Element with id: 2 not found";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }
}

