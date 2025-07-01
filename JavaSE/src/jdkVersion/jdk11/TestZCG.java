package jdkVersion.jdk11;

import java.util.ArrayList;
import java.util.List;

public class TestZCG {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("垃圾回收器工作了....");
    }

    public static void main(String[] args) {

        List<TestZCG> list = new ArrayList<TestZCG>();

        int count = 0 ;
        count ++;
        while(true){


            list.add(new TestZCG());
            if(count == 500){
                // clear 的list中的对象就会变成垃圾
                list.clear();
            }
        }

    }
}
