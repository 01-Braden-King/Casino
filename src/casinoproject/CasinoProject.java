package casinoproject;

import java.util.*;

public class CasinoProject {

    private static Scanner input = new Scanner(System.in);
    public static double balance = 200;
    public static double bet = 0;
    public static Random random = new Random();
    public static int randnum = random.nextInt(36 - 1) + 1;

    public static void main(String[] args) {
        mainMenu();
    }

    public static void mainMenu() {
        System.out.println("Welcome to my casino.\nThere are 3 games that you can gamble on and play.");
        System.out.println("What game would you like to play?");
        System.out.println("1 - Roulette");
        System.out.println("2 - Higher or Lower");
        System.out.println("3 - Blackjack");
        System.out.println("0 - Exit");
        int userChoice = input.nextInt();
        switch (userChoice) {
            case 1:
                Roulette();
                break;
            case 2:
                HigherorLower();
                break;
            case 3:
                Blackjack();
                break;
            case 0:
                System.exit(0);
        }
    }

    public static void Roulette() {
        while (true) {
            int randnum = random.nextInt(36 - 1) + 1;
            System.out.println("Welcome to Roulette.\nDo you wish to bet on a \"number\", \"group\" (of numbers) or a \"colour\"?\nYour balance is " + balance + "\nType \"menu\" to go back to the menu screen");
            String numcol = input.next();
            if (numcol.equals("number")) {
                number();
            }
            if (numcol.equals("group")) {
                group();
            }
            if (numcol.equals("colour")) {
                colour();
            }
            if (numcol.equals("menu")) {
                System.out.println("");
                mainMenu();
            }
        }
    }

    public static void number() {
        boolean t = true;
        int numb = 1;

        while (t == true) {
            System.out.println("Enter the number you wish to place a bet on");
            numb = input.nextInt();
            if ((numb > 36) || (numb < 0)) {
                System.out.println("Please enter a number beteween 1-36");
                t = true;
            } else {

                t = false;
            }
        }
        boolean b = true;
        while (b == true) {
            System.out.println("Enter the amount you want to bet");
            double bet = input.nextInt();
            if (bet > balance) {
                System.out.println("You dont have enough money to place that bet");
                b = true;
            }
            if (bet < 0) {
                System.out.println("That is not  a valid bet");
                b = true;
            } else {
                b = false;
            }
        }
        if (numb == randnum) {
            balance = (balance - bet) + bet * 36;
        } else {
            balance = balance - bet;
        }

    }

    public static void colour() {
        int cntrl = 0;
        boolean t = true;
        while (t == true) {
            System.out.println("Enter the colour you wish to place a bet on (red or black)");
            String colo = input.next();
            if (colo.equalsIgnoreCase("red")) {
                cntrl = 1;
                t = false;
            }
            if (colo.equalsIgnoreCase("black")) {
                cntrl = 2;
                t = false;
            } else {
                System.out.println("Please enter a valid colour");
            }
        }

        boolean b = true;
        while (b == true) {
            System.out.println("Enter the amount you want to bet");
            double bet = input.nextInt();
            if (bet > balance) {
                System.out.println("You dont have enough money to place that bet");
                b = true;
            }
            if (bet < 0) {
                System.out.println("That is not  a valid bet");
                b = true;
            } else {
                b = false;
            }
        }
        if (randnum % 2 == cntrl % 2) {
            bet = bet * 2;
            balance = (balance - bet) + bet * 2;
            System.out.println("You won " + bet + " coins so you balance is now " + balance);
        } else {
            balance = balance - bet;
        }

    }

    public static void group() {
        int grnum = 0;
        boolean t = true;
        while (t == true) {
            System.out.println("Enter the group of numbers (\"1\" for 1-12)(\"2\" for 13-24)(\"3\" for 25-36) you wish to place a bet on");
            grnum = input.nextInt();
            if ((grnum > 3) || (grnum < 0)) {
                System.out.println("Please enter a valid number (either 1 2 or 3) corresponding to each group");
                t = true;
            } else {
                t = false;
            }
        }
        boolean b = true;
        while (b == true) {
            System.out.println("Enter the amount you want to bet");
            double bet = input.nextInt();
            if (bet > balance) {
                System.out.println("You dont have enough money to place that bet");
                b = true;
            }
            if (bet < 0) {
                System.out.println("That is not  a valid bet");
                b = true;
            } else {
                b = false;
            }
            if ((grnum == 1) && (randnum > 1 && randnum < 12)) {
                System.out.println("You won");
                balance = (balance - bet) + bet * 3;
            }
            if ((grnum == 2) && (randnum >= 13 && randnum <= 24)) {
                System.out.println("You won");
                balance = (balance - bet) + bet * 3;
            }
            if ((grnum == 3) && (randnum > 25 && randnum < 36)) {
                System.out.println("You won");
                balance = (balance - bet) + bet * 3;

            } else {
                balance = balance - bet;
            }
            System.out.println("You lost the money you bet");
        }

    }

    public static void HigherorLower() {
        while (true) {
            String[] cards = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
            System.out.println("Welcome to Higher or Lower.\nYour balance is " + balance + "\nAce is counted as 1.");
            int randhigh = random.nextInt(12);
            int rando = random.nextInt(12);
            String chosenCard = cards[randhigh];
            String wasCard = cards[rando];
            String guess = "a";
            boolean t = true;
            while (t == true) {
                System.out.println("Your card is " + chosenCard + " do you think the next card will be higher or lower? Or type \"menu\" to go back to the menu.");
                guess = input.next();
                if (guess.equalsIgnoreCase("higher")) {
                    t = false;
                } else if (guess.equalsIgnoreCase("lower")) {
                    t = false;
                }else if(guess.equalsIgnoreCase("menu")){
                    mainMenu();
                }
                else {
                    System.out.println("Please enter a valid input");
                    t = true;
                }
            }
            boolean b = true;
            while (b == true) {
                System.out.println("Enter the amount you want to bet");
                double bet = input.nextInt();
                if (bet > balance) {
                    System.out.println("You dont have enough money to place that bet");
                    b = true;
                }
                if (bet < 0) {
                    System.out.println("That is not  a valid bet");
                    b = true;
                } else {
                    b = false;
                }
            }
            System.out.println(guess);
            if (guess.equalsIgnoreCase("higher") && randhigh > rando) {
                System.out.println("You won the card was "+ wasCard);
                balance = (balance - bet) + (2 * bet);
            } else if ((guess.equalsIgnoreCase("lower")) && (randhigh < rando)) {
                System.out.println("You won the card was " + wasCard);
                balance = (balance - bet) + (2 * bet);
            } else {
                System.out.println("You lost the card was " + wasCard);
                balance = balance - bet;
            }

        }
    }

    public static void Blackjack() {

    }
}
