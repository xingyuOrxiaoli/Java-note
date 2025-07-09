package principle.liskovsutiution.change;

public class Square implements QuadRangele{

    private long length;

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }


    @Override
    public long getWidth() {
        return getLength();
    }

    @Override
    public long getHeight() {
        return getLength();
    }
}
