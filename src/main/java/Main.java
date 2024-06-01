import java.util.Scanner;

import calc.Products;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Ввод количества людей
        int persons;
        while (true) {
            try {
                System.out.println("На сколько человек разделить счет?");
                persons = sc.nextInt();
                if (persons > 1) {
                    sc.nextLine(); // Под вопросом почему без него пропускает следующий ввод
                    break;
                } else {
                    System.out.println("Неправильное количество людей!");
                }
            } catch (Exception e) {
                System.out.println("Введите целое число!\n"); //Перенос строки для красоты
                sc.nextLine(); // Под вопросом почему без него пропускает следующий ввод
            }
        }

        // Ввод товаров

        Products products = new Products();

        while (true) {

            System.out.println("\nВведите название продукта:"); //Перенос строки для красоты
            String name = sc.nextLine();

            while (true) {
                System.out.println("Введите цену продукта в формате [рубли.копейки]:");
                try {
                    // По причине того что цену в задаче просят вводить через "." а консолька этого
                    // не понимает и хочет ввода через ","
                    String priceString  = sc.nextLine();
                    double price = Double.parseDouble(priceString);
                    if (price  <=  0)  {
                        throw new NumberFormatException();
                    }
                    
                    // Добавляем продукт
                    products.addProduct(name, price);
                    System.out.println("Продукт добавлен!\n"); //Перенос строки для красоты
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

        sc.close(); // Для приличия закроем

        // Выводим список товаров и сумму взноса
        products.printProducts();
        products.getTotal(persons);

    }
}





