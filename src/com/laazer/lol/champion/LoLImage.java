package com.laazer.lol.champion;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.laazer.lol.LoLObject;

public class LoLImage extends LoLObject {
    public String full, group, sprite;
    public int h, w, x, y;
    
    public static LoLImage genImage(JSONObject jobj) {
        return genImage(jobj.toString());
    }
    
    public static LoLImage genImage(String jobj) {
        Gson gson = new Gson();
        return gson.fromJson(jobj, new LoLImage().getClass());
    }
    
    public String toString() {
        return sprite + "( " + x + "x" + y + " )";
    }
}
