import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Как показала практика - написание unit-тестов вынуждает исправлять и модернизировать код программы.
 * Предыдущее представление кода в файле "PreviousCodeView.txt".
 *
 * Тест-1 - Имитация правильного ввода пользователя. Пример ввода: ["1_2"] (Хлеб 2 шт). Ожидание итога: 60 (рублей).
 *
 * Тест-2 - Имитация правильного ввода пользователя. Выбраны несколько продуктов, с разным количеством.
 * Пример ввода: ["1_1"]  ["2_2"]  ["3_3"] (Хлеб 1шт, Яйцо 2шт, Молоко 3шт). Ожидание итога: 290 (рублей).
 *
 * Тест-3 - Имитация неправильного ввода пользователя. Пользователь ввел число превышающее количества елементов в массиве.
 * Ожидание: тест упадет с исключением ArrayIndexOutOfBoundsException.
 *
 * Тест-4 - Имитация неправильного ввода пользователя. Пользователь ввел текст вместо числа.
 *  * Ожидание: тест упадет с исключением ArrayIndexOutOfBoundsException.
 */
public class MainTest {
    @Test
    public void testAddingProductToShoppingCart() {
        Product[] products = new Product[3];
        products[0] = new Product("Хлеб", 30);
        products[1] = new Product("Яйцо", 10);
        products[2] = new Product("Молоко", 50);

        ShoppingCart cart = new ShoppingCart(products);
        int product = 0;
        int amount = 2;
        int result = cart.addProduct(product, amount);
        assertEquals(60, result);
    }

    @Test
    public void testGetTotalCost() {
        Product[] products = new Product[3];
        products[0] = new Product("Хлеб", 30);
        products[1] = new Product("Яйцо", 10);
        products[2] = new Product("Молоко", 50);

        ShoppingCart cart = new ShoppingCart(products);
        int product1 = 0;
        int amount1 = 1;
        int product2 = 1;
        int amount2 = 2;
        int product3 = 2;
        int amount3 = 3;
        int totalCost = 0;
        totalCost += cart.addProduct(product1, amount1);
        totalCost += cart.addProduct(product2, amount2);
        totalCost += cart.addProduct(product3, amount3);
        assertEquals(200, totalCost);
    }

    @Test
    public void testArrayIndexOutOfBoundsException() {
        Product[] products = {
                new Product("Хлеб", 30),
                new Product("Яйцо", 10),
                new Product("Молоко", 50)
        };
        ShoppingCart cart = new ShoppingCart(products);
        int product = 4;
        int amount = 2;
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> cart.addProduct(product, amount));
    }

    @Test
    public void testNumberFormatException() {
        Product[] products = {
                new Product("Хлеб", 30),
                new Product("Яйцо", 10),
                new Product("Молоко", 50)
        };
        ShoppingCart cart = new ShoppingCart(products);
        assertThrows(NumberFormatException.class, () -> cart.addProduct(Integer.parseInt("Хлеб"), 2));
    }

}
