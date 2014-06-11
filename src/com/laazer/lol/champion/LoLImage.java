package com.laazer.lol.champion;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.laazer.lol.LoLObject;

public class LoLImage extends LoLObject {
    String full;
    String group;
    String sprite;
    int h;
    int w;
    int x;
    int y;
    
    public static LoLImage genImage(JSONObject jobj) {
        return genImage(jobj.toString());
    }
    
    public static LoLImage genImage(String jobj) {
        Gson gson = new Gson();
        return gson.fromJson(jobj, new LoLImage().getClass());
    }
}
