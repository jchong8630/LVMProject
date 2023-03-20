import java.util.Scanner;
import java.util.UUID;

public class Runner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String choice = "";
        System.out.println("Welcome to the LVM System");
        while (!(choice.equals("exit"))){
            System.out.print("cmd#: ");
            choice = s.nextLine();
            if (choice.contains("install-drive")){
                choice = choice.substring(14);
                String name = choice.substring(0, choice.indexOf(" "));
                choice = choice.substring(choice.indexOf(" ") + 1, choice.indexOf("G"));
                int size = Integer.parseInt(choice);
                UUID u = UUID.randomUUID();
                PhysicalDrive p = new PhysicalDrive(name, u.toString(), size);
                System.out.println("Drive " + name + " installed");
            }
            if (choice.contains("list-drives")){
                System.out.print(LVM.printDrives());
            }
        }

    }
}
