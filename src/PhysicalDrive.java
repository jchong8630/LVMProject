public class PhysicalDrive extends LVM{
    private int size;
    private static int totalSize;

    public PhysicalDrive(String n, String UUID, int size){
        super(n, UUID);
        this.size = size;
        totalSize += size;
    }

    public String getDrive(){
        return super.getName() + " [" + size + "G]" + "[" + super.getUUID() +"]";
    }

    public int getSize() {
        return size;
    }

    public int getTotalSize(){
        return totalSize;
    }

}
