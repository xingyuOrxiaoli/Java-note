package collection.sources;

public class IndexOutOfBoundsException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public IndexOutOfBoundsException(){

    }
    public IndexOutOfBoundsException(String message){
        super(message);
    }
}
