import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Как показала практика - написание unit-тестов вынуждает исправлять и модернизировать код программы.
 * Предыдущее представление кода в файле "PreviousCodeView.txt".
 *
 * Тест-1 - Имитация правильного ввода пользователя. Пример ввода: ["1_2"] (Хлеб 2 шт). Ожидание итога: 60 (рублей).
 *
 * Тест-2 - Имитация правильного ввода пользователя. Выбраны несколько продуктов, с разным количеством.
 * Пример ввода: ["1_2"]  ["2_3"]  ["3_4"] (Хлеб 2шт, Яйцо 3шт, Молоко 4шт). Ожидание итога: 290 (рублей).
 *
 * Тест-3 - Имитация неправильного ввода пользователя. Пользователь для выбора продукта вместо числа ввел текст("Хлеб").
 * Ожидание: отработка метода getErrorNumberFormat() - с выводом строки:
 *     "Неверный ввод. Пожалуйста, для выбора товара и количества используйте цифры."
 *
 * Тест-4 - Имитация неправильного ввода пользователя. Пользователь ввел одно значение,
 * тем самым сработало исключение ArrayIndexOutOfBoundsException.
 * Ожидание: отработка метода getErrorNoQuantity - с выводом строки:
 *     "Неверный ввод. Пожалуйста, выберите количество товара".
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
        int amount = 2;
        int totalCost = 0;
        for (int i = 0; i < cart.getCart().length; i++) {
            totalCost += cart.addProduct(i, amount);
            amount++;
        }
        assertEquals(290, totalCost);
    }

    @Test
    public void testInvalidInputFormat() {
        Product[] products = {
                new Product("Хлеб", 30),
                new Product("Яйцо", 10),
                new Product("Молоко", 50)
        };
        ShoppingCart cart = new ShoppingCart(products);
        StringBuilder builder = new StringBuilder();
        String input = "Хлеб 2";
        try {
            String[] parts = input.split(" ");
            int product = Integer.parseInt(parts[0]) - 1;
            int amount = Integer.parseInt(parts[1]);
            cart.addProduct(product, amount);
        } catch (NumberFormatException e) {
            builder.append(cart.getErrorNumberFormat());
        }
        assertEquals("Неверный ввод. Пожалуйста, для выбора товара и количества используйте цифры.", builder.toString());
    }

    @Test
    public void testAddingNullAmountOfProduct() {
        Product[] products = new Product[3];
        products[0] = new Product("Хлеб", 30);
        products[1] = new Product("Яйцо", 10);
        products[2] = new Product("Молоко", 50);

        ShoppingCart cart = new ShoppingCart(products);
        StringBuilder builder = new StringBuilder();
        String input = "2";
        try {
            String[] parts = input.split(" ");
            int product = Integer.parseInt(parts[0]) - 1;
            int amount = Integer.parseInt(parts[1]);
            cart.addProduct(product, amount);
        } catch (ArrayIndexOutOfBoundsException e) {
            builder.append(cart.getErrorNoQuantity());
        }
        String error = builder.toString();
        assertEquals("Неверный ввод. Пожалуйста, выберите количество товара", error);
    }
}
