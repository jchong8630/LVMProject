public class PhysicalDrive extends LVM{
    private int size;

    public PhysicalDrive(String n, String UUID, int size){
        super(n, UUID);
        this.size = size;
        super.addDrives(super.getName() + " [" + size + "G]" + "[" + super.getUUID() +"]");
    }

    public int getSize() {
        return size;
    }

}
