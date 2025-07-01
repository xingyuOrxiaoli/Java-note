package reflect;


import java.lang.reflect.Field;

public class FieldsTest {

    private String id;
    String username;
    protected String password;
    public String sex;

    @Override
    public String toString() {
        return "FieldsTest{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<FieldsTest> clazz = FieldsTest.class;
        FieldsTest obj1 = clazz.newInstance();

        Field sex = clazz.getField("sex");
        sex.set(obj1,"男性");
        clazz.getDeclaredField("id").set(obj1,"1");

        System.out.println(obj1);
        System.out.println(sex.get(obj1));

    }
}
