package lhh.dataStructureAndAlgorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @program: IdeaJava
 * @Date: 2019/11/29 11:42
 * @Author: lhh
 * @Description:
 */
public class TestMapGetKeyAndValue {
    public static void main(String[] arga){
        Map<String,String> map = new HashMap<String,String>();
        map.put("1","value1");
        map.put("2","value2");
        map.put("3","value3");

        for(String key : map.keySet()){
            System.out.println("key= "+ key + " and value= " + map.get(key));
        }

        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<String,String> entry = it.next();
            System.out.println("key= " + entry.getKey() + " and value= "
                    + entry.getValue());
        }
    }
}
