package com.laazer.lol.champion;

import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import com.google.gson.Gson;
import com.json.parsers.*;
import com.laazer.common.Box;
import com.laazer.common.UniFunction;
import com.laazer.common.Functions;
import com.laazer.common.JSONUtils;
import com.laazer.common.ListUtils;
import com.laazer.common.UrlManager;
import com.laazer.lol.LoLObject;
import com.laazer.lol.LoLUtils;
import com.laazer.lol.Region;
import java.lang.Class;

public class LoLChampion extends LoLObject{
    private final static String LocURL = LoLObject.URL + "static-data/"+ Region.NA +"/v1.2/champion/";
    private int id;
    private String key, name;
    private Box<String> title, blurb, lore, partype;;
    private Box<List<String>> allyTips, enemyTips, tags;
    private Box<LoLImage> image;
    private Box<LoLInfo> info;
    private Box<LoLPassive> passive;
    private Box<List<LoLRecommended>> recommended;
    private Box<List<LoLSkin>> skins;
    private Box<List<Box<LoLChampSpell>>> spells;
    private Box<LoLStats> stats;

    LoLChampion() {}
    
    private static String simpleTypes = "blurb,lore,partype";
    private static String simpleLists = "allytips,enemytips,tags";
    private static String IMAGE = "image";
    private static String INFO = "info";
    private static String PASSIVE = "passive";
    private static String RECOMMEDED = "recommended";
    private static String SKINS = "skins";
    private static String SPELLS = "spells";
    private static String STATS = "stats";
    
    public static Box<LoLChampion> genComplexChamp(int id, String key, LoLChampVal[]... args) {
        String params = getParams(args);
        
    }
    
    private static String getParams(LoLChampVal[]... args) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < args.length; i++) {
            sb = sb.append(args[i].toString()).append('&');
        }
        return sb.toString();
    }
    
    
    private static Map<String, Object> generateJson(int id, Box<String> args) {
        //TODO remove print lines
        JSONParser parser = new JSONParser();
        String myArgs = "";
        if (args.isFull()) myArgs = args.get();
        String url = LocURL + id + "?champData="+ myArgs + "&" + LoLObject.KEY;
        Map<String, Object> map = (Map<String,Object>) parser.parseJson(UrlManager.executeGet(url).get());
        return map;
    }
    
    private static String generateJsonAsString(int id, String key) {
        String url = LocURL + id + "?champData=all&" + key;
        return UrlManager.executeGet(url).get();
    }
        
    public static Box<LoLChampion> genChampion(Map<String, Object> cobj) {
        try {
            LoLChampion champ = new LoLChampion();
            champ.id = Integer.parseInt(cobj.get("id").toString());
            champ.key = cobj.get("key").toString(); 
            champ.name = cobj.get("name").toString();
            champ.title = Box.fill(cobj.get("title")).map(Functions.toString);
            champ.blurb = Box.fill(cobj.get("blurb")).map(Functions.toString);
            champ.lore = Box.fill(cobj.get("lore")).map(Functions.toString);
            champ.allyTips = ListUtils.map(ListUtils.toList.apply(lobj.get("allytips")), Functions.toString);
            champ.enemyTips = ListUtils.map(ListUtils.toList.apply(lobj.get("enemytips")), Functions.toString);
            champ.image = LoLImage.genImage(generateJson(id, Box.fill(IMAGE)).get("image").toString()); 
//            champ.recommended = ListUtils.map(generateJson(id, Box.fill(RECOMMEDED)).getJSONArray("recommended"), LoLUtils.toRecommended);
//            champ.passive = LoLPassive.genPassive(generateJson(id, Box.fill(PASSIVE)).getJSONObject("passive"));
            champ.partype = Box.fill(cobj.get("partype").toString());
//            champ.skins = JSONUtils.mappedList(generateJson(id, Box.fill(SKINS)).getJSONArray("skins"), LoLUtils.toSkin);
//            champ.spells = JSONUtils.mappedList(generateJson(id, Box.fill(SPELLS)).getJSONArray("spells"), LoLUtils.toChampSpell);
            champ.stats = LoLStats.genLoLStats(generateJson(id, Box.fill(STATS)).get("stats").toString());
            champ.tags = ListUtils.map(ListUtils.toList.apply(lobj.get("tags")), Functions.toString);
            return Box.fill(champ);
        } catch(Exception e) {
            e.printStackTrace();
            return Box.EMPTY;
        }
    }
    
    private static void setFeilds(LoLChampion champ, Map<String, Object> obj, LoLChampVal arg) {
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
    public Box<String> getTitle() {return title;}
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

