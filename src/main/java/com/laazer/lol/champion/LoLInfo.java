package com.laazer.lol.champion;

import com.google.gson.Gson;
import com.laazer.lol.LoLObject;

public class LoLInfo extends LoLObject{
    private int attack, defense, difficulty, magic;
    
    public static LoLInfo genLoLInfo(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, new LoLInfo().getClass());
    }

    public static LoLInfo generate(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json, new LoLInfo().getClass());
    }

    public int getAttack() {return attack;}
    public int getDefense() {return defense;}
    public int getDifficulty() {return difficulty;}
    public int getMagic() {return magic;}
    
}
