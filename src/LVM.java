import java.util.ArrayList;

public class LVM {
    private String name;
    private String UUID;
    private ArrayList<PhysicalDrive> drives;
    private ArrayList<PhysicalVolume> pvs;
    private ArrayList<VolumeGroup> vgs;


    public LVM(String n, String UUID){
        name = n;
        this.UUID = UUID;
        drives = new ArrayList<>();
        pvs = new ArrayList<>();
        vgs = new ArrayList<>();
    }

    public LVM(){
        name = null;
        this.UUID = null;
        drives = new ArrayList<>();
        pvs = new ArrayList<>();
        vgs = new ArrayList<>();
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
}
