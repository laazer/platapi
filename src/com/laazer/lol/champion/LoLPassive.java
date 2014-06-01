package com.laazer.lol.champion;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.laazer.lol.LoLObject;

public class LoLPassive extends LoLObject{
    String description;
    LoLImage image;
    String name;
    String sanitizedDescription;
    public LoLPassive(JSONObject jsonObject) {
        // TODO Auto-generated constructor stub
    }
    
    public LoLPassive genPassive(JSONObject jobj) {
        Gson gson = new Gson();
        return gson.fromJson(jobj.toString(), this.getClass());
    }
}
