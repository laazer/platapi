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
    private Box<List<LoLChampSpell>> spells;
    private Box<LoLStats> stats;
    LoLChampion() {}

    /**
     * Allows for the creation of custom champions using Json Strings
     * @param jsonString a given Json String
     * @return a {@code Box} filled with a {@code LoLChampion} if creation was successful and an empty Box otherwise.
     */
    public static Box<LoLChampion> genCustomChamp(String jsonString) {
        Map<String, Object> map = new Gson().fromJson(jsonString, new TypeToken<HashMap<String, Object>>() {}.getType());
        LoLChampion champ = genSimpleChamp(map);
        setFields(champ, map, LoLChampVal.ALL);
        return Box.fill(champ);
    }

    public static Box<LoLChampion> genCompleteChamp(int id, String key) {
        Map<String, Object> mobj = genJsonMap(id, key, LoLChampVal.ALL);
        LoLChampion champ = genSimpleChamp(mobj);
        setFields(champ, mobj, LoLChampVal.ALL);
        return Box.fill(champ);
    }

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
            champ.id = Math.round(Float.parseFloat(cobj.get("id").toString()));
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
                break;
            }
            case LORE:  {
                champ.lore = Box.fill(obj.get(arg.toString())).map(Functions.toString);
                break;
            }
            case PARTYPE: {
                champ.partype = Box.fill(obj.get(arg.toString()).toString());
                break;
            }
            case ALLY_TIPS: {
                champ.allyTips = Box.fill(ListUtils.map(ListUtils.toList.apply(obj.get(arg.toString())), Functions.toString));
                break;
            }
            case ENEMY_TIPS: {
                champ.enemyTips = Box.fill(ListUtils.map(ListUtils.toList.apply(obj.get(arg.toString())), Functions.toString));
                break;
            }
            case TAGS: {
                champ.tags = Box.fill(ListUtils.map(ListUtils.toList.apply(obj.get(arg.toString())), Functions.toString));
                break;
            }
            case IMAGE: {
                champ.image = Box.fill(LoLImage.genImage(obj.get(arg.toString()).toString()));
                break;
            }
            case INFO: {
                champ.info = Box.fill(LoLInfo.genLoLInfo(obj.get(arg.toString()).toString()));
                break;
            }
            case PASSIVE: {
                champ.passive = LoLPassive.genPassive((Map<String, Object>)obj.get(arg.toString()));
                break;
            }
            case RECOMMENDED: {
                champ.recommended = Box.fill(ListUtils.map(ListUtils.toList.apply(obj.get(arg.toString())), LoLUtils.toRecommended));
                break;
            }
            case SKINS: {
                champ.skins = Box.fill(ListUtils.map(ListUtils.toList.apply(obj.get(arg.toString())), LoLUtils.toSkin));
                break;
            }
            case SPELLS: {
                champ.spells = Box.fill(ListUtils.map(ListUtils.toList.apply(obj.get(arg.toString())), LoLUtils.toChampSpell));
                break;
            }
            case STATS: {
                champ.stats = Box.fill(LoLStats.genLoLStats(obj.get(arg.toString()).toString()));
                break;
            }
            case ALL: {
                Gson gson = new Gson();
                champ.blurb = Box.fill(obj.get(LoLChampVal.BLURB.toString())).map(Functions.toString);
                champ.lore = Box.fill(obj.get(LoLChampVal.LORE.toString())).map(Functions.toString);
                champ.partype = Box.fill(obj.get(LoLChampVal.PARTYPE.toString()).toString());
                champ.allyTips = Box.fill(ListUtils.map(ListUtils.toList.apply(obj.get(LoLChampVal.ALLY_TIPS.toString())), Functions.toString));
                champ.enemyTips = Box.fill(ListUtils.map(ListUtils.toList.apply(obj.get(LoLChampVal.ENEMY_TIPS.toString())), Functions.toString));
                champ.tags = Box.fill(ListUtils.map(ListUtils.toList.apply(obj.get(LoLChampVal.TAGS.toString())), Functions.toString));
                champ.image = Box.fill(LoLImage.genImage(obj.get(LoLChampVal.IMAGE.toString()).toString()));
                champ.info = Box.fill(LoLInfo.generate(gson.toJson(obj.get(LoLChampVal.INFO.toString()))));
                champ.passive = Box.fill(LoLPassive.generate(gson.toJson(obj.get(LoLChampVal.PASSIVE.toString()))));
                champ.recommended = Box.fill(ListUtils.map(ListUtils.toList.apply(obj.get(LoLChampVal.RECOMMENDED.toString())), LoLUtils.toRecommended));
                champ.skins = Box.fill(ListUtils.map(ListUtils.toList.apply(obj.get(LoLChampVal.SKINS.toString())), LoLUtils.toSkin));
                champ.spells = Box.fill(ListUtils.map(ListUtils.toList.apply(obj.get(LoLChampVal.SPELLS.toString())), LoLUtils.toChampSpell));
                champ.stats = Box.fill(LoLStats.genLoLStats(obj.get(LoLChampVal.STATS.toString()).toString()));
                break;
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
    public Box<List<LoLChampSpell>> getSpells() {return spells;}
    public Box<LoLStats> getStats() {return stats;}
    
    //TODO make a quick and dirty method for freeToPlay (joking about the dirty part)
    public Boolean freeToPlay() {return false;}
    
}

