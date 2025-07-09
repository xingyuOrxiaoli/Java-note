package principle.liskovsutiution.methodparam;

import java.util.HashMap;

public class Base {

    public void method(HashMap hashMap) {
        System.out.println("执行父类HashMap入参");
    }
}
