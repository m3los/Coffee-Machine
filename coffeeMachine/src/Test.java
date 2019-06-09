import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CoffeeMachine cf = new CoffeeMachine(400 ,540 ,120, 9, 550);
        cf.start(sc);
    }
}
