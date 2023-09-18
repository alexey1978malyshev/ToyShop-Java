import java.awt.datatransfer.Transferable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        List<Toy> toys = new ArrayList<>();
        toys.add(new Toy("Car", 4, 60));
        toys.add(new Toy("Constructor", 5, 20));
        toys.add(new Toy("Robot", 3, 20));
        toys.add(new Toy("Puzzle", 7, 85));
        System.out.println(toys);

        ShopWithRaffle shop = new ShopWithRaffle(toys);

        int totalCount = 0;
        for (Toy t :
                toys) {
            totalCount += t.getCount();
        }

        System.out.println("Press '1' for new raffle or press '0' for exit");
        Scanner sc = new Scanner(System.in);
        while (totalCount > 0) {
            if (sc.nextInt() == 1) {
                shop.toyRaffle(toys);
                totalCount = toys.stream().mapToInt(Toy::getCount).sum();
                System.out.println("*****************");
                System.out.println("Continue? Press 1.. or press '0' for exit");
                System.out.println("********In the store:*********");
                System.out.println(toys);
                System.out.println("******************************");

            }
            if (totalCount <= 0) {System.out.println("Our store is empty.., raffle is closed..");}


        }
        sc.close();


    }
}
