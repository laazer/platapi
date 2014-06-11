package com.laazer.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.google.gson.Gson;
import com.json.*;
import com.json.parsers.JSONParser;

public class JSONUtils {
    
    public static UniFunction<Object, JSONObject> toJSONObject = new ToJSONObject();
    
    public static List<Object> jArrayToList(JSONArray jarray) throws JSONException {
        List<Object> jlist = new ArrayList<Object>();
        for(int i = 0; i < jarray.length(); i++){
           jlist.add(jarray.getJSONObject(i));
        }
        return jlist;        
    }
    
    public static <R> List<R> mappedList(JSONArray jarray, UniFunction<Object, R> f) throws JSONException {
        return ListUtils.map(JSONUtils.jArrayToList(jarray), f);
    }
    
    private static class ToJSONObject implements UniFunction<Object, JSONObject> {
        @Override
        public JSONObject apply(Object value) {
            return (JSONObject) value;
        }
    }

    public static <T> Box<T> safeUnpack(JSONObject jobj, String name, UniFunction<Object, T> f) {
        try {
            return new Full(f.apply((Object) jobj.get(name)));
        }catch(Exception e) {
            return Box.EMPTY;
        }
        
    }
    
    public static List<String> jArrayToList(String s) throws JSONException {
        List<String> jlist = new ArrayList<String>();
        Boolean dquote = false;
        char fChar = s.charAt(1);
        if (!(s.charAt(0) == '[' && s.charAt(s.length() - 1) == ']')) throw new JSONException("Poorly formatted array");
        for(int i = 1; i < s.length() - 1; i++) {  
            String tmp = "";
            if (s.charAt(i) == fChar ) dquote = !dquote;
            while(dquote) {
                if (s.charAt(i) == fChar) dquote = !dquote;
                tmp = tmp + s.charAt(i);
            }
            jlist.add(tmp);

        }
        return jlist;
    }
    
    public static Box<List<String>> safeJArrayToList(String s) {
        try {
            return Box.fill(jArrayToList(s));
        }catch (JSONException e) {
            System.out.println(e);
            return Box.EMPTY;
        }
        
    }
    
}
