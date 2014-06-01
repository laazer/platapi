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
    
    public LoLStats genLoLStats(JSONObject jobj) {
        Gson gson = new Gson();
        return gson.fromJson(jobj.toString(), this.getClass());
    }
}
