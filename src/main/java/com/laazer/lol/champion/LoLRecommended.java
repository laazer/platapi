package com.laazer.lol.champion;
import java.util.List;

import com.google.gson.Gson;
import com.laazer.lol.LoLObject;

public class LoLRecommended extends LoLObject{
    private List<LoLBlock> blocks;
    private String champion, map, mode;
    private boolean priority;
    private String tutke, type;
    private LoLRecommended() {}
    
    public static LoLRecommended genLoLRecommened(String jobj) {
        Gson gson = new Gson();
        return gson.fromJson(jobj, new LoLRecommended().getClass());
    }

    public List<LoLBlock> getBlocks() {return blocks;}
    public String getChampion() {return champion;}
    public String getMap() {return map;}
    public String getMode() {return mode;}
    public boolean isPriority() {return priority;}
    public String getTutke() {return tutke;}
    public String getType() {return type;}
       
}
