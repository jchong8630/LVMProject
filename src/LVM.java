import java.lang.reflect.Array;
import java.util.ArrayList;

public class LVM {
    private String name;
    private String UUID;
    private ArrayList<PhysicalDrive> drives;
    private ArrayList<PhysicalVolume> pvs;
    private ArrayList<VolumeGroup> vgs;
    private ArrayList<LogicalVolume> lvs;


    public LVM(String n, String UUID){
        name = n;
        this.UUID = UUID;
        drives = new ArrayList<>();
        pvs = new ArrayList<>();
        vgs = new ArrayList<>();
        lvs = new ArrayList<>();
    }

    public LVM(){
        name = null;
        this.UUID = null;
        drives = new ArrayList<>();
        pvs = new ArrayList<>();
        vgs = new ArrayList<>();
        lvs = new ArrayList<>();
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

    public ArrayList<PhysicalVolume> getPvs() {
        return pvs;
    }

    public ArrayList<VolumeGroup> getVgs() {
        return vgs;
    }

    public ArrayList<LogicalVolume> getLvs() {
        return lvs;
    }

    public void addLV(LogicalVolume lv){lvs.add(lv);}
    public void addDrives(PhysicalDrive drive){
        drives.add(drive);
    }
    public void addVG(VolumeGroup vg){vgs.add(vg);}
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

    public String printVG(){
        String result = "";
        for (VolumeGroup vg : vgs) {
            result += vg.getDrive() + "\n";
        }
        return result;
    }
    public String printLV(){
        String result = "";
        for (LogicalVolume lv : lvs) {
            result += lv.getDrive() + "\n";
        }
        return result;
    }
}
