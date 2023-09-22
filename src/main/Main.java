package main;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final List<Beverage> ingredients = new ArrayList<>();
    static{
        ingredients.add(new DarkRoast("Basic darkroast", 5));
        ingredients.add(new HouseBlend("Basic houseblend", 7));
        ingredients.add(new Espresso("Basic espresso", 3));
        ingredients.add(new Decaf("Basic shit", 4));

        ingredients.add(new Milk("Milkey", 2));
        ingredients.add(new Mocha("Mochita", 3.5));
        ingredients.add(new Soy("Soyita", 8));
        ingredients.add(new Whip("Whipie", 1));

    }

    private static final List<CondimentDecorator> selectedIngredients = new ArrayList<>();

    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("Bienvenido!!!");

        selectBaseBeverage();
    }

    public static void selectBaseBeverage() throws CloneNotSupportedException {
        System.out.println("\n--- Bebida base ---\n" +
                "Crea tu bebida. Selecciona la bebida base que quieres:" +
                "\n1) Dark roast" +
                "\n2) House blend" +
                "\n3) Espresso" +
                "\n4) Decaf");

        int selection = Integer.parseInt(scanner.nextLine());

        selectIngredients(selection);
    }

    public static void selectIngredients(int baseBeverage) throws CloneNotSupportedException {
        System.out.println("\n --- Ingredientes ---" +
                "\n1) Milk" +
                "\n2) Mocha" +
                "\n3) Soy" +
                "\n4) Whip" +
                "\n0) Terminar");

        int selection = Integer.parseInt(scanner.nextLine());

        if (selection == 0) {
            buildBeverage(baseBeverage);

            return;
        }

        selectedIngredients.add((CondimentDecorator) determineIngredient(selection).clone());

        selectIngredients(baseBeverage);
    }

    public static void buildBeverage(int baseBeverage) {
        System.out.println("\n--- Resumen bebida ---" +
                "\nIngredientes: ");

        Beverage base = Main.ingredients.get(baseBeverage-1);

        System.out.println("\n* Base: " + base.getDescription() + " - " + base.getCost());

        for (int i = 0; i < selectedIngredients.size(); i++) {
            CondimentDecorator aux = selectedIngredients.get(i);

            System.out.println("* " + aux.getDescription() + " - " + aux.getCost());

            aux.setBeverage((i != selectedIngredients.size()-1) ? selectedIngredients.get(i + 1) : base);
        }

        System.out.println("\nEl costo es: $" + selectedIngredients.get(0).cost());
    }

    private static Beverage determineIngredient(int ingredient) {
        return ingredients.get(ingredient + 3);
    }
}
