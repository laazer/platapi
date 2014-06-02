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
    final static String LocURL = LoLObject.URL + "static-data/"+ Region.NA +"/v1.2/champion/";
    int id;
    boolean freeToPlay;
    String key, name, title, blurb, lore, partype;;
    List<String> allyTips, enemyTips, tags;
    LoLImage image;
    LoLInfo info;
    LoLPassive passive;
    List<LoLRecommended> recommended;
    List<LoLSkin> skins;
    List<Box<LoLChampSpell>> spells;
    LoLStats stats;
    
    LoLChampion() {

    }

    private static JSONObject generateJson(int id) {
        //TODO make url an input
        JSONParser parser = new JSONParser();
        String url = LocURL + id + "?champData=all&" + LoLObject.KEY;
        System.out.println(url);
        JSONObject jobj = (JSONObject) parser.parseJson(UrlManager.executeGet(url).get());
        return jobj;
    }
    
    public static Box<LoLChampion> genChampion(JSONObject obj) {
        try {
            LoLChampion champ = new LoLChampion();
            champ.id = obj.getInt("id");
            champ.freeToPlay = obj.getBoolean("freetoplay");
            champ.key = obj.getString("key"); champ.name = obj.getString("name");
            champ.title = obj.getString("title"); champ.blurb = obj.getString("blurb"); 
            champ.allyTips = JSONUtils.mappedList(obj.getJSONArray("allytips"), Functions.toString);
            champ.enemyTips = JSONUtils.mappedList(obj.getJSONArray("enemytips"), Functions.toString);
            champ.image = LoLImage.genImage(obj.getJSONObject("image")); 
            champ.lore = obj.getString("lore");
            champ.recommended = JSONUtils.mappedList(obj.getJSONArray("recommended"), LoLUtils.toRecommended);
            champ.passive = new LoLPassive(obj.getJSONObject("passive"));
            champ.partype = obj.getString("partype");
            champ.skins = JSONUtils.mappedList(obj.getJSONArray("skins"), LoLUtils.toSkin);
            champ.spells = JSONUtils.mappedList(obj.getJSONArray("spells"), LoLUtils.toChampSpell);
            champ.stats = new LoLStats().genLoLStats(obj.getJSONObject("stats"));
            champ.tags = JSONUtils.mappedList(obj.getJSONArray("tags"), Functions.toString);
            return Box.fill(champ);
        } catch(JSONException e) {
            e.printStackTrace();
            return Box.EMPTY;
        }
        
    }
    
    public static Box<LoLChampion> genChampion(int id) {
        return genChampion(LoLChampion.generateJson(id));
    }
    
}
