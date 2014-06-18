package com.laazer.lol.champion;

import com.google.gson.*;
import com.laazer.lol.LoLObject;

public class LoLStats extends LoLObject{
    private Double armor, armorPerLevel;
    private Double attackDamage, attackDamagePerLevel;
    private Double attackRange;
    private Double attackSpeed, attackSpeedPerLevel;
    private Double crit, critPerLevel;
    private Double hp, hpPerLevel, hpRegen, hpRegenPerLevel;
    private Double moveSpeed;
    private Double mp, mpPerLevel, mpRegen, mpRegenPerLevel;
    private Double spellBlock, spellBlockPerLevel;
    public LoLStats() {}
        
    public static LoLStats genLoLStats(String jobj) {
        Gson gson = new Gson();
        return gson.fromJson(jobj, new LoLStats().getClass());
    }

    public Double getArmor() {return armor;}
    public Double getArmorPerLevel() {return armorPerLevel;}
    public Double getAttackDamage() {return attackDamage;}
    public Double getAttackDamagePerLevel() {return attackDamagePerLevel;}
    public Double getAttackRange() {return attackRange;}
    public Double getAttackSpeed() {return attackSpeed;}
    public Double getAttackSpeedPerLevel() {return attackSpeedPerLevel;}
    public Double getCrit() {return crit;}
    public Double getCritPerLevel() {return critPerLevel;}
    public Double getHp() {return hp;}
    public Double getHpPerLevel() {return hpPerLevel;}
    public Double getHpRegen() {return hpRegen;}
    public Double getHpRegenPerLevel() {return hpRegenPerLevel;}
    public Double getMoveSpeed() {return moveSpeed;}
    public Double getMp() {return mp;}
    public Double getMpPerLevel() {return mpPerLevel;}
    public Double getMpRegen() {return mpRegen;}
    public Double getMpRegenPerLevel() {return mpRegenPerLevel;}
    public Double getSpellBlock() {return spellBlock;}
    public Double getSpellBlockPerLevel() {return spellBlockPerLevel;}
    
    
}
