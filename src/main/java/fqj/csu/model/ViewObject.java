package fqj.csu.model;

import java.util.HashMap;
import java.util.Map;


public class ViewObject {
    private Map<String,Object> objs = new HashMap<String,Object>();

    public void set(String key,Object view) {
        objs.put(key,view);
    }

    public Object get(String key) {
        return objs.get(key);
    }
}
