import java.util.ArrayList;

public class LVM {
    private String name;
    private String UUID;
    private ArrayList<String> drives;

    public LVM(String n, String UUID){
        name = n;
        this.UUID = UUID;
        drives = new ArrayList<>();
    }

    public LVM(){
        name = null;
        this.UUID = null;
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
    public String printDrives(){
        String result = "";
        for (String drive : drives) {
            result += drive + "\n";
        }
        return result;
    }
}
