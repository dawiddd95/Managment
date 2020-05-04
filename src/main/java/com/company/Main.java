package com.company;

import com.company.api.ProductService;
import com.company.api.UserRegisterLoginFacade;
import com.company.entity.Boots;
import com.company.entity.Cloth;
import com.company.entity.Product;
import com.company.entity.User;
import com.company.entity.enums.Color;
import com.company.entity.enums.Material;
import com.company.entity.enums.SkinType;
import com.company.entity.parser.ColorParser;
import com.company.entity.parser.MaterialParser;
import com.company.entity.parser.SkinParser;
import com.company.facade.UserRegisterLoginFacadeImpl;
import com.company.service.ProductServiceImpl;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void startMenu() {
        System.out.println("MANAGEMENT MENU");
        System.out.println("1 - Zaloguj się");
        System.out.println("2 - Zarejestruj się");
        System.out.println("0 - Wyjdź");
    }

    public static void loggedMenu() {
        System.out.println("MANAGEMENT MENU");
        System.out.println("1 - Dodaj nowy product");
        System.out.println("0 - Wyloguj się");
    }

    public static void productTypeMenu() {
        System.out.println("1 - Dodaj buty");
        System.out.println("2 - Dodaj ubrania");
        System.out.println("3 - Inne");
    }

    public static Product createOtherProduct() {
        String productName;
        Color color;
        Float price, weight;
        Integer count;
        System.out.println("ProductName: ");
        productName = scanner.next();

        System.out.println("Price: ");
        price = scanner.nextFloat();

        System.out.println("Weight: ");
        weight = scanner.nextFloat();

        System.out.println("Choose color: RED, BLUE, GREEN, BLACK, WHITE, YELLOW ");
        color = ColorParser.parseStrToColor(scanner.next());

        System.out.println("Count: ");
        count = scanner.nextInt();


        return new Product(1L, productName, price, weight, color, count);
    }

    public static Product createBootsProduct() {
        String productName;
        Color color;
        Float price, weight;
        Integer count, size;
        SkinType skinType;

        System.out.println("ProductName: ");
        productName = scanner.next();

        System.out.println("Price: ");
        price = scanner.nextFloat();

        System.out.println("Weight: ");
        weight = scanner.nextFloat();

        System.out.println("Choose color: RED, BLUE, GREEN, BLACK, WHITE, YELLOW ");
        color = ColorParser.parseStrToColor(scanner.next());

        System.out.println("Count: ");
        count = scanner.nextInt();

        System.out.println("Size: ");
        size = scanner.nextInt();

        System.out.println("Choose skin type: NATURAL, ARTIFICIAL ");
        skinType = SkinParser.parseStrToSkinType(scanner.next());


        return new Boots(1L, productName, price, weight, color, count, size, skinType);
    }

    public static Product createClothProduct() {
        String productName, size;
        Color color;
        Float price, weight;
        Integer count;
        Material material;

        System.out.println("ProductName: ");
        productName = scanner.next();

        System.out.println("Price: ");
        price = scanner.nextFloat();

        System.out.println("Weight: ");
        weight = scanner.nextFloat();

        System.out.println("Choose color: RED, BLUE, GREEN, BLACK, WHITE, YELLOW ");
        color = ColorParser.parseStrToColor(scanner.next());

        System.out.println("Count: ");
        count = scanner.nextInt();

        System.out.println("Size: ");
        size = scanner.next();

        System.out.println("Choose material: LEATHER, FUR, COTTON, WOOL, POLYESTERS.");
        material = MaterialParser.parseStrToMaterial(scanner.next());


        return new Cloth(1L, productName, price, weight, color, count, size, material);
    }

    public static void main(String[] args) {
        UserRegisterLoginFacade userFacade = UserRegisterLoginFacadeImpl.getInstance();
        ProductService productService = ProductServiceImpl.getInstance();
        boolean appOn = true;
        boolean loggedOn = false;
        int read;

        while (appOn) {
            startMenu();
            read = scanner.nextInt();

            switch (read) {
                case 1:
                    System.out.println("Podaj login:");
                    String loginLog = scanner.next();
                    System.out.println("Podaj hasło:");
                    String passwordLog = scanner.next();
                    if (userFacade.loginUser(loginLog, passwordLog)) {
                        loggedOn = true;
                        System.out.println("Zalogowałeś się!");
                    } else {
                        System.out.println("Niepoprawne dane!");
                    }
                    break;
                case 2:
                    System.out.println("Podaj login:");
                    String loginReg = scanner.next();
                    System.out.println("Podaj hasło:");
                    String passwordReg = scanner.next();
                    User user = new User(1L, loginReg, passwordReg);
                    if (userFacade.registerUser(user)) {
                        System.out.println("Zarejestrowałeś się!");
                    } else {
                        System.out.println("Cos poszło nie tak!");
                    }
                    break;
                case 0:
                    appOn = false;
                    break;
            }

            while (loggedOn) {

                loggedMenu();
                read = scanner.nextInt();

                switch (read) {
                    case 1:
                        productTypeMenu();
                        read = scanner.nextInt();
                        Product product = null;
                        switch (read) {
                            case 1:
                                product = createBootsProduct();
                                break;
                            case 2:
                                product = createClothProduct();
                                break;
                            case 3:
                                product = createOtherProduct();
                                break;
                        }
                        if (productService.saveProduct(product)) {
                            System.out.println("Produkt został utworzony");
                        } else {
                            System.out.println("Produkt nie został utworzony.");
                        }
                        break;


                    case 0:
                        loggedOn = false;
                        break;
                }


            }


        }


    }
}
