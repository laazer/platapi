package com.laazer.lol.champion;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.laazer.lol.LoLObject;

public class LoLImage extends LoLObject {
    private String full, group, sprite;
    private int h, w, x, y;
    
    public static LoLImage genImage(JSONObject jobj) {
        return genImage(jobj.toString());
    }
    
    public static LoLImage genImage(String jobj) {
        Gson gson = new Gson();
        return gson.fromJson(jobj, new LoLImage().getClass());
    }
    
    @Override
    public String toString() {
        return sprite + "( " + x + "x" + y + " )";
    }

    public String getFull() {return full;}
    public String getGroup() {return group;}
    public String getSprite() {return sprite;}
    public int getH() {return h;}
    public int getW() {return w;}
    public int getX() {return x;}
    public int getY() {return y;}
    
    
}
