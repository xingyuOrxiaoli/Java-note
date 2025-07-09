package principle.liskovsutiution.change;

public class Rectangle implements QuadRangele{
    private long width;
    private long height;



    public void setWidth(long width) {
        this.width = width;
    }


    public void setHeight(long height) {
        this.height = height;
    }

    @Override
    public long getHeight() {
        return height;
    }
    @Override
    public long getWidth() {
        return width;
    }
}
