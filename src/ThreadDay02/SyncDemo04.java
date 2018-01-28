package ThreadDay02;

import java.util.*;

/**
 * 将集合或 Map 转换为线程安全
 */
public class SyncDemo04 {
    public static void main(String[] args) {
        /**
         * ArrayList 与 LinkList 都不是线程安全的
         */
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("tow");
        list.add("three");
        list.add("four");

        System.out.println(list);
        // 将给定集合转换为线程安全集合
        list = Collections.synchronizedList(list);

        System.out.println(list);


        Set<String> set = new HashSet<>(list);
        System.out.println(set);
        set = Collections.synchronizedSet(set);
        System.out.println(set);


        Map<String, Integer> map = new HashMap<>();
        map.put("语文", 99);
        map.put("数学", 100);
        System.out.println(map);

        map = Collections.synchronizedMap(map);
        System.out.println(map);
    }
}
