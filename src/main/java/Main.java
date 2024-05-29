import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Ввод количества людей
        int persons;
        while (true) {
            try {
                System.out.println("Введите количество людей:");
                persons = sc.nextInt();
                if (persons > 1) {
                    sc.nextLine(); // Под вопросом почему без него пропускает следующий ввод
                    break;
                } else {
                    System.out.println("Неправильное количество людей!");
                }
            } catch (Exception e) {
                System.out.println("Введите целое число!");
                sc.nextLine(); // Под вопросом почему без него пропускает следующий ввод
            }
        }

        // Ввод товаров

        Products products = new Products();

        while (true) {

            System.out.println("Введите название продукта:");
            String name = sc.nextLine();

            while (true) {
                System.out.println("Введите цену продукта в формате [рубли.копейки]:");
                try {
                    // По причине того что цену в задаче просят вводить через "." а консолька этого
                    // не понимает
                    String priceLine = sc.nextLine();
                    double price = Double.parseDouble(priceLine);
                    // Добавляем продукт
                    products.addProduct(name, price);
                    System.out.println("Продукт добавлен!");
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Неправильно указана цена!");
                }
            }

            // Проверка желания добавить еще
            System.out.println("Хотите добавить еще один продукт?");
            String nextOrEnd = sc.nextLine();
            if (nextOrEnd.equalsIgnoreCase("Завершить")) {
                break;
            }

        }

        // Выводим список товаров и сумму взноса
        products.printProducts();
        products.getTotal(persons);

    }
}

class Products {

    private static class Product {
        String name;
        double price;

        Product(String name, double price) {
            this.name = name;
            this.price = price;
        }
    }

    ArrayList<Product> products = new ArrayList<>();

    public void addProduct(String name, double price) {
        products.add(new Product(name, price));
    }

    private double getSum() {
        double sum = 0;
        for (Product product : products) {
            sum += product.price;
        }
        return sum;
    }

    public void getTotal(int persons) {
        String rub;
        double sum = getSum();
        rub = switch ((int) Math.floor(sum)) {
            case 1 -> "рубль";
            case 2, 3, 4 -> "рубля";
            default -> "рублей";
        };
        System.out.println("Вы должны внести: " + String.format("%.2f", sum / persons) + "  " + rub);

    }

    public void printProducts() {
        System.out.println("Добавленные товары:");
        for (Product product : products) {
            System.out.println(product.name);
        }
    }
}
