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
        names.add(n);
    }

    public void addSize(PhysicalVolume physicalVolume, VolumeGroup vg){
        vg.size += physicalVolume.getSize();
        vg.availableSize += physicalVolume.getSize();
    }

    public void vgAdd(String choice, ArrayList<VolumeGroup> vgs){
        choice = choice.substring(9);
        String name = choice.substring(0, choice.indexOf(" "));
        choice = choice.substring(choice.indexOf(" ") + 1);
        String link = choice;
        for (VolumeGroup vg : vgs){
            if (vg.getName().equals(name)){
                addSize();
            }
        }
    }

    public boolean checker(){
        return (size != 0);
    }
    public String getDrive(){
        return getName() + ": total:[" + size + "G] available:[" + availableSize + "G] " + names + " " + "[" + getUUID() +"]";
    }
}
