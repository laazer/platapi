package com.laazer.lol.champion;

public enum LoLChampVal {
    BLURB, LORE, PARTYPE, ALLY_TIPS, ENEMY_TIPS, TAGS, IMAGE, INFO, PASSIVE,
    RECOMMENDED, SKINS, SPELLS, STATS, ALL;
    
    @Override
    public String toString() {
        switch(this) {
            case BLURB: return "blurb"; 
            case LORE: return "lore"; 
            case PARTYPE: return "partype";
            case ALLY_TIPS: return "allytips"; 
            case ENEMY_TIPS: return "enemytips";
            case TAGS: return "tags"; 
            case IMAGE: return "image"; 
            case INFO: return "info";
            case PASSIVE: return "passive"; 
            case RECOMMENDED: return "recommended"; 
            case SKINS: return "skins"; 
            case SPELLS: return "spells"; 
            case STATS: return "stats";
            case ALL: return "all";
            default: return "";
        }
    }
}
