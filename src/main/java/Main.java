import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Product[] products = {
                new Product("Хлеб", 30),
                new Product("Яйцо", 10),
                new Product("Молоко", 50)
        };

        ShoppingCart cart = new ShoppingCart(products);
        System.out.println("Список доступных продуктов:");
        for (Product product : products) {
            System.out.println(product.getName() + " - " + product.getPrice() + " руб/шт");
        }

        int totalCost = 0;
        while (true) {
            System.out.println("Выберите товар и количество или введите <<end>>");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            String[] parts = input.split(" ");
            try {
                int product = Integer.parseInt(parts[0]) - 1;
                Integer amount = Integer.parseInt(parts[1]);
                if (amount < 0)
                    System.out.println(cart.getErrorNoQuantity());
                if (product >= 0 && product < products.length)
                    totalCost += cart.addProduct(product, amount);
                else {
                    System.out.println(cart.getErrorNoNumberProduct(product));
                }

            } catch (NumberFormatException e) {
                System.out.println(cart.getErrorNumberFormat());
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println(cart.getErrorNoQuantity());
            }
        }

        cart.printCart(totalCost);
    }
}
