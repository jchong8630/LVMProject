import java.util.ArrayList;

public class VolumeGroup extends LVM{
    private int size;
    private String linkName;
    private ArrayList<String> names;
    private int availableSize;

    public VolumeGroup(String n, String UUID, String linkName, ArrayList<PhysicalVolume> drives){
        super(n, UUID);
        this.linkName = linkName;
        for (PhysicalVolume drive : drives){
            if (drive.getName().contains(linkName)){
                size = drive.getSize();
            }
        }
        availableSize = size;
        names = new ArrayList<>();
        names.add(linkName);
    }

    public void addSize(PhysicalVolume physicalVolume, VolumeGroup vg){
        vg.size += physicalVolume.getSize();
        vg.availableSize += physicalVolume.getSize();
    }

    public int getSize(){
        return size;
    }

    public boolean vgAdd(ArrayList<PhysicalVolume> pvs, ArrayList<VolumeGroup> vgs){
        for (VolumeGroup vg : vgs){
            if (vg.getName().equals(getName())){
                for (PhysicalVolume pv : pvs){
                    if (pv.getName().equals(linkName)){
                        addSize(pv, vg);
                        vg.names.add(linkName);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checker(){
        return (size != 0);
    }

    public String getDrive(){
        return getName() + ": total:[" + size + "G] available:[" + availableSize + "G] " + names + " " + "[" + getUUID() +"]";
    }
}
