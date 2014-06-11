package com.laazer.lol.champion;

import org.json.JSONObject;
import com.google.gson.*;
import com.laazer.lol.LoLObject;

public class LoLStats extends LoLObject{
    Double armor, armorPerLevel;
    Double attackDamage, attackDamagePerLevel;
    Double attackRange;
    Double attackSpeed, attackSpeedPerLevel;
    Double crit, critPerLevel;
    Double hp, hpPerLevel, hpRegen, hpRegenPerLevel;
    Double moveSpeed;
    Double mp, mpPerLevel, mpRegen, mpRegenPerLevel;
    Double spellBlock, spellBlockPerLevel;
    public LoLStats() {}
    
    public static LoLStats genLoLStats(JSONObject jobj) {
        return genLoLStats(jobj.toString());
    }
    
    public static LoLStats genLoLStats(String jobj) {
        Gson gson = new Gson();
        return gson.fromJson(jobj, new LoLStats().getClass());
    }
}
