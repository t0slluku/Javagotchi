import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {

    private static Pet pet;

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a name for your pet: ");
            String name = scanner.nextLine();

            pet = new Pet(name);

            startHeartbeat();

            while (true) {

                System.out.println("\n--- MENU ---");
                System.out.println("1. Feed pet");
                System.out.println("2. Play with pet");
                System.out.println("3. Check status");
                System.out.println("4. Exit");

                int choice = scanner.nextInt();

                switch (choice) {

                    case 1 -> pet.feed();

                    case 2 -> pet.play();

                    case 3 -> pet.checkstatus();

                    case 4 -> {
                        System.out.println("Goodbye!");
                        System.exit(0);
                    }

                    default -> System.out.println("Invalid choice");
                }
            }
        }
    }


    private static void startHeartbeat() {

        ScheduledExecutorService scheduler =
                Executors.newSingleThreadScheduledExecutor();

        scheduler.scheduleAtFixedRate(() -> {
            pet.setHunger(pet.getHunger() + 1);
            pet.setHappiness(pet.getHappiness() - 1);
            
            System.out.println("\nTime passes...");
            
            if (pet.getHunger() >= 10) {
                System.out.println(pet.getName() + " starved to death...");
                System.exit(0);
            }

            if (pet.getHappiness() <= 0) {
                System.out.println(pet.getName() + " became too sad...");
                System.exit(0);
            }
        }, 10, 10, TimeUnit.SECONDS);
    }
}