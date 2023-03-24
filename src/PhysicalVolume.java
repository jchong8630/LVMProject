import java.util.ArrayList;

public class PhysicalVolume extends LVM{
    private int size;
    private String linkName;

    public PhysicalVolume(String n, String UUID, String linkName, ArrayList<PhysicalDrive> drives){
        super(n, UUID);
        this.linkName = linkName;
        for (PhysicalDrive drive : drives){
            if (drive.getName().contains(linkName)){
                size = drive.getSize();
            }
        }
    }

    public boolean checker(){
        return (size != 0);
    }

    public int getSize() {
        return size;
    }

    public String getDrive(){
        return getName() + " [" + size + "G]" + "[" + getUUID() +"]";
    }
}
