package com.laazer.lol.champion;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.laazer.lol.LoLObject;

public class LoLSkin extends LoLObject{
    int id;
    String name;
    int num;
    public LoLSkin() {}
    
    public static LoLSkin genLoLSkin(JSONObject jobj) {
        Gson gson = new Gson();
        return gson.fromJson(jobj.toString(), new LoLSkin().getClass());
    }
}
