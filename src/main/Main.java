package main;

import model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    private static List<Beverage> ingredients = new ArrayList<>();
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

    public static void main(String[] args) {
        System.out.println("Bienvenido!!!");

        selectBaseBeverage();
    }

    public static void selectBaseBeverage() {
        System.out.println("\n\n--- Bebida base ---\n" +
                "Crea tu bebida. Selecciona la bebida base que quieres:" +
                "\n1) Dark roast" +
                "\n2) House blend" +
                "\n3) Espresso" +
                "\n4) Decaf");

        int selection = Integer.parseInt(scanner.nextLine());

        selectIngredients(selection, new ArrayList<Integer>());
    }

    public static void selectIngredients(int baseBeverage, ArrayList<Integer> ingredients) {
        System.out.println("\n\n --- Ingredientes ---" +
                "\n1) Milk" +
                "\n2) Mocha" +
                "\n3) Soy" +
                "\n4) Whip" +
                "\n0) Terminar");

        int selection = Integer.parseInt(scanner.nextLine());

        if (selection == 0) {
            buildBeverage(baseBeverage, ingredients);

            return;
        }

        ingredients.add(selection);
        selectIngredients(baseBeverage, ingredients);
    }

    public static void buildBeverage(int baseBeverage, ArrayList<Integer> ingredients) {
        System.out.println("\n\n--- Resumen bebida ---" +
                "\nIngredientes: ");

        for (Integer ingredientInt : ingredients) {
            Beverage ingredient = determineIngredient(ingredientInt);
            System.out.println("* " + (ingredient.getDescription()));
        }
    }

    private static Beverage determineIngredient(int ingredient) {
        return ingredients.get(ingredient + 3);
    }
}
