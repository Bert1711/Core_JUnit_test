public class ShoppingCart {
    private Product[] products;
    private int totalCost;

    public ShoppingCart(Product[] products) {
        this.products = products;
        this.totalCost = 0;
    }

    public int addProduct(Integer product, Integer amount) {
        totalCost = products[product].getPrice() * amount;
        return totalCost;
    }

    public Product[] getCart() {
        return this.products;
    }

    public void printCart(int totalCost) {
        System.out.println("Ваша корзина:");
        for (Product product : products) {
            if (product.getAmount() > 0) {
                System.out.println("Наименование товара: " + product.getName());
                System.out.println("Количество: " + product.getAmount());
                System.out.println("Цена/за.ед: " + product.getPrice());
                System.out.println("Общая стоимость: " + product.getCost());
                System.out.println();
            }
        }
        System.out.println("Итого: " + totalCost);
    }

    public String getErrorNoNumberProduct(int number) {
        return "Неверный ввод. Товар не найден с номером " + number;
    }

    public String getErrorNumberFormat() {
        return "Неверный ввод. Пожалуйста, для выбора товара и количества используйте цифры.";
    }

    public String getErrorNoQuantity() {
        return "Неверный ввод. Пожалуйста, выберите количество товара";
    }
}


