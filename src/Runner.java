import java.util.Scanner;
import java.util.UUID;

public class Runner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String choice = "";
        System.out.println("Welcome to the LVM System");
        LVM l = new LVM();
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
                l.addDrives(p);
                System.out.println("Drive " + name + " installed");
            }
            if (choice.contains("list-drives")){
                System.out.print(l.printDrives());
            }
            if (choice.contains("pvcreate")){
                choice = choice.substring(9);
                String name = choice.substring(0, choice.indexOf(" "));
                choice = choice.substring(choice.indexOf(" ") + 1);
                String link = choice;
                UUID u = UUID.randomUUID();
                PhysicalVolume p = new PhysicalVolume(name, u.toString(), link, l.getDrives());
                if (p.checker()){
                    System.out.println(p.getName() + " created");
                    l.addPV(p);
                }
            }
            if (choice.contains("pvlist")){
                System.out.print(l.printPV());
            }
            if (choice.contains("vgcreate")){
                choice = choice.substring(9);
                String name = choice.substring(0, choice.indexOf(" "));
                choice = choice.substring(choice.indexOf(" ") + 1);
                String link = choice;
                UUID u = UUID.randomUUID();
                VolumeGroup v = new VolumeGroup(name, u.toString(), link, l.getPvs());
                if (v.checker()){
                    System.out.println(v.getName() + " created");
                    l.addVG(v);
                }
                else{
                    System.out.println(name + " creation failed");
                }
            }
            if (choice.contains("vglist")){
                System.out.print(l.printVG());
            }
            if (choice.contains("vgextend")){
                choice = choice.substring(9);
                String name = choice.substring(0, choice.indexOf(" "));
                choice = choice.substring(choice.indexOf(" ") + 1);
                String link = choice;
                UUID u = UUID.randomUUID();
                VolumeGroup v = new VolumeGroup(name, u.toString(), link, l.getPvs());
                if(v.vgAdd(l.getPvs(), l.getVgs())){
                    System.out.println(link + " added to " + name);
                }
                else{
                    System.out.println(name + " extension failed");
                }
            }
            if (choice.contains("lvcreate")) {
                choice = choice.substring(9);
                String name = choice.substring(0, choice.indexOf(" "));
                choice = choice.substring(choice.indexOf(" ") + 1);
                int size = Integer.parseInt(choice.substring(0, choice.indexOf("G")));
                choice = choice.substring(choice.indexOf("G") + 2);
                String link = choice;
                UUID u = UUID.randomUUID();
                LogicalVolume lv = new LogicalVolume(name, u.toString(), link, size);
                if(lv.reduceSize(l.getVgs())){
                    l.addLV(lv);
                    System.out.println(name + " created");
                }
                else{
                    System.out.println(name + " creation failed");
                }
            }
            if(choice.contains("lvlist")){
                System.out.print(l.printLV());
            }

        }

    }
}
