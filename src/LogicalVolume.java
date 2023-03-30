import java.util.ArrayList;

public class LogicalVolume extends LVM{
    private int size;
    private String linkName;

    public LogicalVolume(String n, String UUID, String link, int size){
        super(n, UUID);
        this.size = size;
        linkName = link;
    }

    public boolean reduceSize(ArrayList<VolumeGroup> vgs){
        for (VolumeGroup vg : vgs){
            if (vg.getName().equals(linkName)){
                if (vg.getSize() >= size){
                    vg.reduceSize(size);
                    return true;
                }
            }
        }
        return false;
    }
}
