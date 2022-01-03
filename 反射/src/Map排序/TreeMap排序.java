package Map排序;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMap排序{

    public static void main(String[] args) {
        System.out.println("---------------- 默认 排序结果-----------------");
        createDefaultSortTreeMap();
        System.out.println("---------------- 自定义 排序结果-----------------");
        createDefinitionSortTreeMap();
    }

    public static void createDefaultSortTreeMap() {
        TreeMap<String, String> map = new TreeMap<String, String>();

        init(map);
        print(map);
    }

    public static void createDefinitionSortTreeMap() {

        TreeMap<String, String> map = new TreeMap<>(new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }

        });

        init(map);
        print(map);
    }

    public static void init(Map<String, String> map) {
        map.put("c", "1");
        map.put("a", "1");
        map.put("bb", "1");
        map.put("b", "1");
        map.put("aaaa", "1");
    }

    public static void print(Map<String, String> map) {
        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}