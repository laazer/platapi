package com.laazer.lol.champion;

import com.google.gson.Gson;
import com.laazer.lol.LoLObject;

public class LoLSkin extends LoLObject{
    int id;
    String name;
    int num;
    public LoLSkin() {}
    
    public static LoLSkin genLoLSkin(String obj) {
        Gson gson = new Gson();
        return gson.fromJson(obj, new LoLSkin().getClass());
    }
}
