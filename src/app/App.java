package app;

import app.Models.MerchantA;
import app.Products.ProductA;
import app.Utils.Rounder;
import java.util.Scanner;

// Класс-входная точка в приложение.
// App launcher.
public class App {

    static String merchantName;
    static String email;
    static String phone;
    static String productName;
    static int quantity;
    static double price;
    static String roundBonus;
    static ProductA product;
    static MerchantA merchantA;
    static String infoMerchant;
    static String infoProduct;

    // Делаем метод main() наименее загруженным логикой
    public static void main(String[] args) {
        //initVars();
        Scanner scanner = new Scanner(System.in);
        getUserInput(scanner);
        getProductInfo(scanner);
        scanner.close();
        showData(processData());
    }

    // Инициализация переменных.
    // Имитация ввода данных пользователем.
//    private static void initVars() {
//        merchantName = "Роберт";
//        email = "bob@mail.com";
//        phone = "055 123-4567";
//        productName = "апельсины";
//        quantity = 1000;
//        price = 19.99;
//    }

    // Передача данных на обработку.
    // Вызовы методов через экземпляры классов
    // для получения результатов расчетов.
    // Здесь же получение расчета и округления бонуса.
    // Получение шаблона для вывода.
    private static String processData() {
        merchantA = new MerchantA(merchantName, phone, email);
        infoMerchant = merchantA.infoMerchant();
        product = new ProductA(productName, quantity, price);
        infoProduct = product.infoProduct();
        double sales = product.calcSales(quantity, price);
        roundBonus = Rounder.roundValue(merchantA.calcBonus(sales));
        return infoMerchant + infoProduct + "\nБонус (грн.): " + roundBonus;
    }

    // Вывод данных
    private static void showData(String output) {
        System.out.println(output);
    }

    public static String getUserInput(Scanner scanner) {
        System.out.println("Введите имя: ");
        merchantName = scanner.next();
        System.out.println("Введите ваш Email: ");
        email = scanner.next();
        System.out.println("Введите ваш номер телефона: ");
        phone = scanner.next();

        return merchantName + email + phone;
    }

    public static String getProductInfo(Scanner scanner) {
        System.out.println("Введите наименование товара: ");
        productName = scanner.next();
        System.out.println("Введите колличестово (шт): ");
        quantity = scanner.nextInt();
        System.out.println("Введите цену товара: ");
        price = scanner.nextDouble();

        return productName + quantity + price;
    }
}

