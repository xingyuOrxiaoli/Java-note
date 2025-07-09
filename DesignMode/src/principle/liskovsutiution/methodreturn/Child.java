package principle.liskovsutiution.methodreturn;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Child extends Base {
    @Override
    public HashMap method() {
        HashMap hashMap = new HashMap();
        System.out.println("执行 子类的method");
        hashMap.put("msg","子类的method");
        return hashMap;
    }
}
