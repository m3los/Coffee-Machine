import java.util.Scanner;

public class CoffeeMachine {

    private Action action = Action.menu;

    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;
    private String input = "";

    public CoffeeMachine(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this. cups = cups;
        this. money = money;
    }

    public enum  Action{
        menu, buy, fill, take, remaining, exit
    }

    private void processInput(Scanner sc) {
        input = sc.next();
    }

    public void start(Scanner sc) {
        while(action != Action.exit) {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            processInput(sc);
            action = Enum.valueOf(Action.class, input);
            switch(action) {

                case buy:
                    action = Action.buy;
                    System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                    processInput(sc);

                    if(input.equals("1")) {
                        if(water >= 250 && beans >= 16 && cups >= 1) {
                            System.out.println("I have enough resources, making you a coffee!");
                            water -= 250;
                            beans -= 16;
                            cups--;
                            money += 4;
                        } else {
                            if(water < 250) {
                                System.out.println("Sorry, not enough water!");
                            } else if(beans < 16) {
                                System.out.println("Sorry, not enough beans!");
                            } else if(cups < 1) {
                                System.out.println("Sorry, not enough cups!");
                            }
                        }

                    } else if(input.equals("2")) {
                        if(water >= 350 && milk >= 75 && beans >= 20 && cups >= 1) {
                            System.out.println("I have enough resources, making you a coffee!");
                            water -= 350;
                            milk -= 75;
                            beans -= 20;
                            cups--;
                            money += 7;
                        } else {
                            if(water < 350) {
                                System.out.println("Sorry, not enough water!");
                            } else if(milk < 75) {
                                System.out.println("Sorry, not enough milk!");
                            }else if(beans < 20) {
                                System.out.println("Sorry, not enough beans!");
                            } else if(cups < 1) {
                                System.out.println("Sorry, not enough cups!");
                            }
                        }
                        System.out.println();

                    } else if(input.equals("3")) {
                        if(water >= 200 && milk >= 100 && beans >= 12 && cups >= 1) {
                            System.out.println("I have enough resources, making you a coffee!");
                            water -= 200;
                            milk -= 100;
                            beans -= 12;
                            cups--;
                            money += 6;
                        } else {
                            if(water < 200) {
                                System.out.println("Sorry, not enough water!");
                            } else if(milk < 100) {
                                System.out.println("Sorry, not enough milk!");
                            }else if(beans < 12) {
                                System.out.println("Sorry, not enough beans!");
                            } else if(cups < 1) {
                                System.out.println("Sorry, not enough cups!");
                            }
                        }
                    }
                    break;

                case fill:
                    action = Action.fill;
                    System.out.print("Write how many ml of water do you want to add: ");
                    processInput(sc);
                    int addW = Integer.valueOf(input);
                    water += addW;

                    System.out.print("Write how many ml of milk do you want to add: ");
                    processInput(sc);
                    int addM = Integer.valueOf(input);
                    milk += addM;

                    System.out.print("Write how many grams of coffee beans do you want to add: ");
                    processInput(sc);
                    int addB = Integer.valueOf(input);
                    beans += addB;

                    System.out.print("Write how many disposable cups do you want to add: ");
                    processInput(sc);
                    int addC = Integer.valueOf(input);
                    cups += addC;

                    System.out.println();
                    display(water, milk, beans, cups, money);
                    break;

                case take:
                    System.out.println("*I gave you " + money + " €*");
                    money -= money;

                    System.out.println();
                    display(water, milk, beans, cups, money);
                    break;

                case remaining:
                    System.out.println();
                    display(water, milk, beans, cups, money);
                    break;

                case exit:
                    break;
            }
        }
    }

    private void display(int water, int milk, int beans, int cups, int money) {
        System.out.println("The coffee machine has:\n"
                + "-----------------------\n"
                + water + " of water\n"
                + milk + " of milk\n"
                + beans + " of coffee beans\n"
                + cups + " of disposable cups\n"
                + money + " of money");
    }
}
