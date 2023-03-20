import java.util.ArrayList;

public class LVM {
    private String name;
    private String UUID;
    private int size;
    private static ArrayList<String> drives;

    public LVM(String n, String UUID){
        name = n;
        this.UUID = UUID;
        drives = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getUUID() {
        return UUID;
    }

    public void addDrives(String drive){
        drives.add(drive);
    }

    public static String printDrives(){
        String result = "";
        for (int i = 0; i < drives.size(); i++) {
            result += drives.get(i) + "\n";
        }
        return result;
    }
}
