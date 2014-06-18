package com.laazer.lol.champion;

public enum LoLChampVal {
    BLURB, LORE, PARTYPE, ALLY_TIPS, ENEMY_TIPS, TAGS, IMAGE, INFO, PASSIVE,
    RECOMMENDED, SKINS, SPELLS, STATS;
    
    @Override
    public String toString() {
        switch(this) {
            case BLURB: return "blurb"; 
            case LORE: return "lore"; 
            case PARTYPE: return "partupe"; 
            case ALLY_TIPS: return "allytips"; 
            case ENEMY_TIPS: return "ENEMY_TIPS"; 
            case TAGS: return "tags"; 
            case IMAGE: return "image"; 
            case INFO: return "info";
            case PASSIVE: return "passive"; 
            case RECOMMENDED: return "recommended"; 
            case SKINS: return "skins"; 
            case SPELLS: return "spells"; 
            case STATS: return "stats"; 
            default: return "";
        }
    }
}
