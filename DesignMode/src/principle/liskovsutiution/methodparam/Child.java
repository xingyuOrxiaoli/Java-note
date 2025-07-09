package principle.liskovsutiution.methodparam;

import java.util.HashMap;
import java.util.Map;

public class Child extends Base {

//    @Override
//    public void method(HashMap hashMap) {
//        System.out.println("执行子类HashMap入参");
//    }

    // 比父类宽松
    public void method(Map map) {
        System.out.println("执行子类Map入参");
    }
}
