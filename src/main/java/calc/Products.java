package calc;

import java.util.ArrayList;

public class Products {

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
        double payment = getSum()/persons;
        System.out.println("Вы должны внести: " + String.format("%.2f", payment) + "  " + Rub.returnRubLine(payment));

    }

    public void printProducts() {
        System.out.println("\nДобавленные товары:"); //Перенос строки для красоты
        for (Product product : products) {
            System.out.println(product.name);
        }
    }
}