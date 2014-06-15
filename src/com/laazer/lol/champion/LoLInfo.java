package com.laazer.lol.champion;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.laazer.lol.LoLObject;

public class LoLInfo extends LoLObject{
    public int attack, defense, difficulty, magic;
    
    public static LoLInfo genLoLSkin(String jobj) {
        Gson gson = new Gson();
        return gson.fromJson(jobj, new LoLInfo().getClass());
    }
}
