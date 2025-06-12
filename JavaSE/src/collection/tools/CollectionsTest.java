package collection.tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsTest {
    public static void main(String[] args) {
        // 添加元素
        List<Integer> list = new ArrayList<>(16);
        Collections.addAll(list, 1, 2, 3, 4, 5,-1,100,3);
        System.out.println(list);
        // 排序
        Collections.sort(list);
        System.out.println(list);
        // 查找
        System.out.println(Collections.binarySearch(list, 100));
        // 最值
        System.out.println(Collections.max(list));
        // 填充
        Collections.fill(list,100);
        System.out.println(list);
        // 复制
        List<Integer> list2 = new ArrayList<>(16);
        Collections.addAll(list2, 1, 2, 3, 4, 5,-1,10,2);
        Collections.copy(list2,list); // list2 必须长度大于等于list
        System.out.println(list2);
        // 同步
        // 第一代集合类 Vector、Hashtable、线程安全、效率低、多线程
        // 第二代集合类 ArrayList、HashMap 线程不安全 、效率高、单线程
        // 如果既希望速度快、又希望线程安全，但是不适用第一代集合
        // 方法1 ：对第二代集合类进行加锁，如果是多线程
        list = Collections.synchronizedList(list);
        // 方法2 ：使用第三代集合类
        // 第三代集合类 CopyonWriterArrayList、ConcurrentHashMap JDK1.5


    }
}
