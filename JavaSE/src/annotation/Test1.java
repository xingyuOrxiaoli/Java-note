package annotation;

@MyAnnotation1
public class Test1 {

    @MyAnnotation1
    private String username;


    @MyAnnotation1
    public void fun1(){}

    public void fun2(@MyAnnotation1 String password){

    }

}
