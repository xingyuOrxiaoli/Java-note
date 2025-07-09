package principle.liskovsutiution.methodparam;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        Base base = new Base();
        Base child = new Child();
        HashMap hashMap = new HashMap();
        child.method(hashMap);
    }
}
