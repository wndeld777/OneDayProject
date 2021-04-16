package com.callor.blackjack.service;
import java.util.*;

public class blackjack {

    /*
     * Array list to store users and dealers cards
     */
    public ArrayList<String> usersCards = new ArrayList<String>();
    public ArrayList<String> dealersCards = new ArrayList<String>();

    /*
     * Array for storing potential cards
     */
    String[] card = { "2", "3", "4", "5", "6", "7", "8", "9", "10",
            "Jack", "Queen", "King", "Ace"};
    /*
     * Dealer && User Variables
     */
    int usersValue = 0;
    int dealersValue = 0;
    int usersDecision = 0;

    boolean userTwisting = false;
    boolean dealerTwisting = false;
    boolean dealerNotBust = true;


    /*
     * Scanner
     */
    Scanner kb = new Scanner(System.in);

    blackjack() {

        /*
         * Start Game
         */

        /*
         * Generate Dealer && Users Cards
         * First Portion Of Game
         */
        generateDealersCard();
        generateUsersCard();
        generateUsersCard();
        displayUsersCards();
        displayDealersCards();
        checkBlackJack();

        /*
         * Second Portion Of Game
         */
        userOptions();

        usersDecision = kb.nextInt();
        do {
            if(usersDecision == 1) {
                generateUsersCard();
                displayUsersCards();
                checkBlackJack();
                checkBust();

                userOptions();
                usersDecision = kb.nextInt();
            } else {
                userTwisting = false;
            }
        }while(userTwisting == true);

        do {
            getDealersValue(dealersValue);
            checkDealersActions();
        } while (dealerNotBust = true);

    }
    /*
     * Dealers Cards Value
     */
    public int getDealersValue(int dValue) {
        dValue = 0;

        for(int i = 0; i < dealersCards.size(); i++) {
            if(dealersCards.get(i).equals("2")) {
                dValue += 2;
            } else if(dealersCards.get(i).equals("3")) {
                dValue += 3;
            } else if(dealersCards.get(i).equals("4")) {
                dValue += 4;
            } else if(dealersCards.get(i).equals("5")) {
                dValue += 5;
            } else if(dealersCards.get(i).equals("6")) {
                dValue += 6;
            } else if(dealersCards.get(i).equals("7")) {
                dValue += 7;
            } else if(dealersCards.get(i).equals("8")) {
                dValue += 8;
            } else if(dealersCards.get(i).equals("9")) {
                dValue += 9;
            } else if(dealersCards.get(i).equals("10")) {
                dValue += 10;
            } else if(dealersCards.get(i).equals("Jack")) {
                dValue += 10;
            } else if(dealersCards.get(i).equals("Queen")) {
                dValue += 10;
            } else if(dealersCards.get(i).equals("King")) {
                dValue += 10;
            } else if(dealersCards.get(i).equals("Ace")) {
                dValue += 11;
            }
        }
        dealersValue = dValue;
        return dValue;
    }
    /*
     * Generate Dealers Cards
     */
    void generateDealersCard() {
        int randomGenNumber = (int) (Math.random()*13);

        dealersCards.add(card[randomGenNumber]);
    }

    /*
     * Users Cards Value
     */
    public int getUsersValue(int uValue) {
        uValue = 0;

        for(int i = 0; i < usersCards.size(); i++) {
            if(usersCards.get(i).equals("2")) {
                uValue += 2;
            } else if(usersCards.get(i).equals("3")) {
                uValue += 3;
            } else if(usersCards.get(i).equals("4")) {
                uValue += 4;
            } else if(usersCards.get(i).equals("5")) {
                uValue += 5;
            } else if(usersCards.get(i).equals("6")) {
                uValue += 6;
            } else if(usersCards.get(i).equals("7")) {
                uValue += 7;
            } else if(usersCards.get(i).equals("8")) {
                uValue += 8;
            } else if(usersCards.get(i).equals("9")) {
                uValue += 9;
            } else if(usersCards.get(i).equals("10")) {
                uValue += 10;
            } else if(usersCards.get(i).equals("Jack")) {
                uValue += 10;
            } else if(usersCards.get(i).equals("Queen")) {
                uValue += 10;
            } else if(usersCards.get(i).equals("King")) {
                uValue += 10;
            } else if(usersCards.get(i).equals("Ace")) {
                uValue += 1;
            }
        }
        usersValue = uValue;
        return uValue;

    }
    /*
     * Generate Users Cards
     */
    void generateUsersCard() {
        int randomGenNumber = (int) (Math.random()*13);

        usersCards.add(card[randomGenNumber]);

        userTwisting = true;
    }
    /*
     * Display Users && Dealers Cards
     */
    public void displayUsersCards() {
        System.out.println("You Have: " + usersCards);
    }
    public void displayDealersCards() {
        System.out.println("The Dealer Has: " + dealersCards);
    }
    /*
     * Check For BlackJack
     */
    public void checkBlackJack() {

        getDealersValue(dealersValue);
        getUsersValue(usersValue);
        /*
         * Check Dealers BlackJack
         */
        if(dealersValue == 21) {
            System.out.println("Dealer Has BlackJack! You Lose");
            System.exit(0);
        }
        if(usersValue == 21) {
            System.out.println("You Have BlackJack! You Win!");
            System.exit(0);
        }

    }
    /*
     * Compare Values
     */
    public void compareValues() {
        getDealersValue(dealersValue);
        getUsersValue(usersValue);

        if(dealersValue == usersValue) {
            System.out.println("\nDealers Value: " + dealersValue
                    + " Users Value: " + usersValue);
            System.out.println("You've Drawn!");
            System.exit(0);
        }
        if(dealersValue > usersValue) {
            System.out.println("\nDealers Value: " + dealersValue
                    + " Users Value: " + usersValue);
            System.out.println("You've Lost!");
            System.exit(0);
        } else {
            System.out.println("\nDealers Value: " + dealersValue
                    + " Users Value: " + usersValue);
            System.out.println("You Win!");
            System.exit(0);
        }


    }
    /*
     * Check For Bust
     */
    public void checkBust() {

        getDealersValue(dealersValue);
        getUsersValue(usersValue);

        if(dealersValue > 21) {
            System.out.println("Dealer Has Bust - You Win!");
            System.exit(0);
        }

        if(usersValue > 21) { 
            System.out.println("You've Bust - You Lose!");
            System.exit(0);
        }
    }

    /*
     * Check Dealers Actions
     */
    public void checkDealersActions() {

        getDealersValue(dealersValue);

        if(dealersValue <=16) {
            System.out.println("Dealer Has 16 or Less - Twisting");
            generateDealersCard();
            displayDealersCards();
            checkBust();
            checkBlackJack();
        }

        if(dealersValue == 17) {
            System.out.println("Dealer Has 17 - Sticking");
            compareValues();
        }

        if(dealersValue > 17) {
            System.out.println("Dealer Has: " + getDealersValue(dealersValue) + " - Sticking");
            compareValues();
            System.exit(0);
        }

    }

    public void userOptions() {
        System.out.println("Do You Want To:\n [1] Twist\n [2] Stick");
    }

    public static void main(String[] args) {

        new blackjack();


    }
}