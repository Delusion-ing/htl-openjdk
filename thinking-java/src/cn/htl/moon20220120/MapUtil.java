package cn.htl.moon20220120;

import jdk.nashorn.internal.runtime.JSONFunctions;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * CreateTime 2022/1/20 hushujing
 */
public class MapUtil {

    @Test
    public void MapToJson () {
        Map<String, String> toMap = new HashMap<>();
        toMap.put("data","ABS");
        toMap.put("type","FPS");
        String toString = toMap.toString();
        System.out.println(JSONFunctions.quote(toString));

    }
}
