import java.util.ArrayList;

public class LVM {
    private String name;
    private String UUID;
    private ArrayList<PhysicalDrive> drives;
    private ArrayList<PhysicalVolume> pvs;


    public LVM(String n, String UUID){
        name = n;
        this.UUID = UUID;
        drives = new ArrayList<>();
        pvs = new ArrayList<>();
    }

    public LVM(){
        name = null;
        this.UUID = null;
        drives = new ArrayList<>();
        pvs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getUUID() {
        return UUID;
    }

    public ArrayList<PhysicalDrive> getDrives() {
        return drives;
    }

    public void addDrives(PhysicalDrive drive){
        drives.add(drive);
    }
    public void addPV(PhysicalVolume pv){
        pvs.add(pv);
    }

    public String printPV(){
        String result = "";
        for (PhysicalVolume pv : pvs) {
            result += pv.getDrive() + "\n";
        }
        return result;
    }
    public String printDrives(){
        String result = "";
        for (PhysicalDrive drive : drives) {
            result += drive.getDrive() + "\n";
        }
        return result;
    }
}
