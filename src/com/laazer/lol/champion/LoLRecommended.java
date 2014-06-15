package com.laazer.lol.champion;
import java.util.List;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.laazer.lol.LoLObject;

public class LoLRecommended extends LoLObject{
    public List<LoLBlock> blocks;
    public String champion, map, mode;
    public boolean priority;
    public String tutke, type;
    public LoLRecommended() {
        // TODO Auto-generated constructor stub
    }
    
    public static LoLRecommended genLoLRecommened(String jobj) {
        Gson gson = new Gson();
        return gson.fromJson(jobj, new LoLRecommended().getClass());
    }
}
