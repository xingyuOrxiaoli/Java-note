package collection.first;

import java.util.Enumeration;
import java.util.Vector;

public class TestVector {
    public static void main(String[] args) {
        Vector v = new Vector();
        v.addElement(123);
        v.addElement(234);
        System.out.println(v);

        for (int i = 0 ; i < v.size() ; i++){
            System.out.print(v.elementAt(1) +" , ");
        }

        System.out.println();
        Enumeration elements = v.elements();
        while (elements.hasMoreElements()){
            System.out.println(elements.nextElement());
        }
    }
}
