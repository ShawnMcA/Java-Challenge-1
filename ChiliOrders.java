// =============================================
//
//  Shopping cart program to calculate the
//  total price of the order and total profit
//  for the company. 
//
// =============================================

import java.util.Scanner;
import java.text.NumberFormat;

public class ChiliOrders {

    // Meal Prices for sale
    final static float adultMealPrice = 7.00f;
    final static float seniorMealPrice = 5.50f;
    final static float childMealPrice = 4.25f;

    // Cost of the Meals
    final static float adultMealCost = 4.50f;
    final static float seniorMealCost = 3.50f;
    final static float childMealCost = 2.20f;

    // How many meals ordered
    static int adultMealQuantity = 0;
    static int seniorMealQuantity = 0;
    static int childMealQuantity = 0;

    // Total Values
    static float orderTotal = 0.00f;
    static float profitTotal = 0.00f;

    // Checks if the user is still ordering
    static boolean ordering = true;

    // User input
    static Scanner userInput = new Scanner(System.in);

    // Introduction
    public static void displayIntro(){
        System.out.println("\nWelcome to the Huntington Boys and Girls Club Chili Fundraiser!");
        System.out.println("We have a few choices of food for you to choose from:");
        System.out.println();
    }

    // Displays the ordering menu
    public static void displayMenu() {
        System.out.println("\n1. Adult Meal - " + currencyConvert(adultMealPrice));
        System.out.println("2. Senior Meal - " + currencyConvert(seniorMealPrice));
        System.out.println("3. Child Meal - " + currencyConvert(childMealPrice));
        System.out.println("4. Checkout");
        System.out.println();
    }

    // Checks item selection from user and returns the amount
    public static void placeOrder() {
        int menuOrder = userInput.nextInt();

        if (menuOrder == 1) {
            adultMealQuantity += getOrderQuantity();
        } else if (menuOrder == 2) {
            seniorMealQuantity += getOrderQuantity();
        } else if (menuOrder == 3) {
            childMealQuantity += getOrderQuantity();
        } else if (menuOrder == 4) {
            ordering = false;
        } else {
            System.out.println("\nThat isn't a valid option. Please try again...");
        }
    }

    // Gets and returns the quantity from the user
    public static int getOrderQuantity(){
        System.out.println();
        System.out.println("\nHow many would you like to order?");
        int qty = userInput.nextInt();

        return qty;
    }

    // Converts the float to a currency format
    public static String currencyConvert(float amount) {
        return NumberFormat.getCurrencyInstance().format(amount);
    }

    // Calculates the totals
    public static void totals() {
        orderTotal = (adultMealQuantity * adultMealPrice) + (seniorMealQuantity * seniorMealPrice) + (childMealQuantity * childMealPrice);
        profitTotal = (adultMealQuantity * (adultMealPrice - adultMealCost)) + (seniorMealQuantity * (seniorMealPrice - seniorMealCost)) + (childMealQuantity * (childMealPrice - childMealCost));
    }

    // Show checkout totals
    public static void checkout() {
        System.out.println("\n\n\n===== CHECKOUT =====\n");
        System.out.println("Adult Meals: " + adultMealQuantity + "  Total Price: " + currencyConvert(adultMealQuantity * adultMealPrice));
        System.out.println();
        System.out.println("Senior Meals: " + seniorMealQuantity + "  Total Price: " + currencyConvert(seniorMealQuantity * seniorMealPrice));
        System.out.println();
        System.out.println("Child Meals: " + childMealQuantity + "  Total Price: " + currencyConvert(childMealQuantity * childMealPrice));
        System.out.println();
        System.out.println("Order Total: " + currencyConvert(orderTotal));
        System.out.println();
    }

    // Show profit totals
    public static void profit() {
        System.out.println("\n\n\n===== PROFITS =====\n");
        System.out.println("Adult Meals: " + adultMealQuantity + "  Total Profit: " + currencyConvert(adultMealQuantity * (adultMealPrice - adultMealCost)));
        System.out.println();
        System.out.println("Senior Meals: " + seniorMealQuantity + "  Total Profit: " + currencyConvert(seniorMealQuantity * (seniorMealPrice - seniorMealCost)));
        System.out.println();
        System.out.println("Child Meals: " + childMealQuantity + "  Total Profit: " + currencyConvert(childMealQuantity * (childMealPrice - childMealCost)));
        System.out.println();
        System.out.println("Total Profit: " + currencyConvert(profitTotal));
        System.out.println();
    }

    // Main Program
    public static void main(String[] arg) {
        displayIntro();
        // Main loop 
        do {
            displayMenu();
            placeOrder();

        } while (ordering); 
        totals();
        checkout();
        profit();
    }
}