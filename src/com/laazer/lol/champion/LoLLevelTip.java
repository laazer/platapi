package com.laazer.lol.champion;

import java.util.List;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.laazer.lol.LoLObject;

public class LoLLevelTip extends LoLObject{
    public List<String> effect;
    public List<String> lable;
    
    public static LoLLevelTip genLevelTip(String jobj) {
        Gson gson = new Gson();
        return gson.fromJson(jobj, new LoLLevelTip().getClass());
    }
}
