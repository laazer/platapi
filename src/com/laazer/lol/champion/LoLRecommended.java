package com.laazer.lol.champion;
import java.util.List;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.laazer.lol.LoLObject;

public class LoLRecommended extends LoLObject{
    List<LoLBlock> blocks;
    String champion;
    String map;
    String mode;
    boolean priority;
    String tutke;
    String type;
    public LoLRecommended() {
        // TODO Auto-generated constructor stub
    }
    
    public LoLRecommended genLoLRecommened(JSONObject jobj) {
        Gson gson = new Gson();
        return gson.fromJson(jobj.toString(), this.getClass());
    }
}
