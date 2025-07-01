package reflect.getAnnotation;

@MyTable(name="tableName")
public class Student {

    @MyColumn(name="id" , type="int" , length=10)
    private Integer id;
    @MyColumn(name="username" , type="varchar" , length=20)
    private String username;
    @MyColumn(name="password" , type="varchar" , length=20)
    private String password;

    @Deprecated
    @MyColumn(name="score" , type="double" , length=7,precision=2)
    private double score;

}
