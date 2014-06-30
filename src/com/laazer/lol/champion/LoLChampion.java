package com.laazer.lol.champion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.google.gson.reflect.TypeToken;
import com.laazer.common.Box;
import com.laazer.common.Functions;
import com.laazer.common.ListUtils;
import com.laazer.common.UrlManager;
import com.laazer.lol.LoLObject;
import com.laazer.lol.LoLUtils;
import com.laazer.lol.Region;
import com.google.gson.*;


public class LoLChampion extends LoLObject{
    private final static String LocURL = LoLObject.URL + "static-data/"+ Region.NA +"/v1.2/champion/";
    private int id;
    private String key, name, title;
    private Box<String> blurb, lore, partype;;
    private Box<List<String>> allyTips, enemyTips, tags;
    private Box<LoLImage> image;
    private Box<LoLInfo> info;
    private Box<LoLPassive> passive;
    private Box<List<LoLRecommended>> recommended;
    private Box<List<LoLSkin>> skins;
    private Box<List<Box<LoLChampSpell>>> spells;
    private Box<LoLStats> stats;
    LoLChampion() {}
    
    public static Box<LoLChampion> genComplexChamp(int id, String key, LoLChampVal... args) {
        Map<String, Object> mobj = genJsonMap(id, key, args);
        LoLChampion champ = genSimpleChamp(mobj);
        try {
            for(int i = 0; i < args.length; i++) {
                setFields(champ, mobj, args[i]);
            }
            return Box.fill(champ);
        } catch (Exception e) {
            return Box.EMPTY;
        }
    }

    private static String getParams(LoLChampVal... args) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < args.length; i++) {
            sb = sb.append(args[i].toString()).append(',');
        }
        if (sb.length() > 0) return sb.substring(0, sb.length() - 1).concat("&").toString();
        else return "";
    }
    
    private static Map<String, Object> genJsonMap(int id, String key, LoLChampVal... args) {
        String eq = "";
        if(args.length > 0) eq = "="; else eq = "";
        String url = LocURL + id + "?champData" + eq + getParams(args) + "api_key=" + key;
        String map = UrlManager.executeGet(url).get();
        return new Gson().fromJson(map, new TypeToken<HashMap<String, Object>>() {}.getType());
    }
        
    private static LoLChampion genSimpleChamp(Map<String, Object> cobj) {
            LoLChampion champ = new LoLChampion();
            champ.id = Integer.parseInt(cobj.get("id").toString());
            champ.key = cobj.get("key").toString(); 
            champ.name = cobj.get("name").toString();
            champ.title = cobj.get("title").toString();
            return champ;
    }
    
    private static void setFields(LoLChampion champ, Map<String, Object> obj, LoLChampVal arg) {
        try {
            switch(arg) {
            case BLURB: {
                champ.blurb = Box.fill(obj.get(arg.toString())).map(Functions.toString);
            }
            case LORE:  {
                champ.lore = Box.fill(obj.get(arg.toString())).map(Functions.toString);
            }
            case PARTYPE: {
                champ.partype = Box.fill(obj.get(arg.toString()).toString());
            }
            case ALLY_TIPS: {
                champ.allyTips = Box.fill(ListUtils.map(ListUtils.toList.apply(obj.get(arg.toString())), Functions.toString));
            }
            case ENEMY_TIPS: {
                champ.enemyTips = Box.fill(ListUtils.map(ListUtils.toList.apply(obj.get(arg.toString())), Functions.toString));
            }
            case TAGS: {
                champ.tags = Box.fill(ListUtils.map(ListUtils.toList.apply(obj.get(arg.toString())), Functions.toString));
            }
            case IMAGE: {
                champ.image = Box.fill(LoLImage.genImage(obj.get(arg.toString()).toString())); 
            }
            case INFO: {
                champ.info = Box.fill(LoLInfo.genLoLInfo(obj.get(arg.toString()).toString()));
            }
            case PASSIVE: {
                champ.passive = LoLPassive.genPassive(obj.get(arg.toString()).toString());
            }
            case RECOMMENDED: {
                champ.recommended = Box.fill(ListUtils.map(ListUtils.toList.apply(obj.get(arg.toString())), LoLUtils.toRecommended));
            }
            case SKINS: {
                champ.skins = Box.fill(ListUtils.map(ListUtils.toList.apply(obj.get(arg.toString())), LoLUtils.toSkin));
            }
            case SPELLS: {
                champ.spells = Box.fill(ListUtils.map(ListUtils.toList.apply(obj.get(arg.toString())), LoLUtils.toChampSpell));
            }
            case STATS: {
                champ.stats = Box.fill(LoLStats.genLoLStats(obj.get(arg.toString()).toString()));
            }
        }
            
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    //all of the getters for this class
    public int getId() {return id;}
    public String getKey() {return key;}
    public String getName() {return name;}
    public String getTitle() {return title;}
    public Box<String> getBlurb() {return blurb;}
    public Box<String> getLore() {return lore;}
    public Box<String> getPartype() {return partype;}
    public Box<List<String>> getAllyTips() {return allyTips;}
    public Box<List<String>> getEnemyTips() {return enemyTips;}
    public Box<List<String>> getTags() {return tags;}
    public Box<LoLImage> getImage() {return image;}
    public Box<LoLInfo> getInfo() {return info;}
    public Box<LoLPassive> getPassive() {return passive;}
    public Box<List<LoLRecommended>> getRecommended() {return recommended;}
    public Box<List<LoLSkin>> getSkins() {return skins;}
    public Box<List<Box<LoLChampSpell>>> getSpells() {return spells;}
    public Box<LoLStats> getStats() {return stats;}
    
    //TODO make a quick and dirty method for freeToPlay (joking about the dirty part)
    public Boolean freeToPlay() {return false;}
    
}

