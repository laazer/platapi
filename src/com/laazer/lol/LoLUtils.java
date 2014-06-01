package com.laazer.lol;

import org.json.JSONObject;

import com.laazer.common.UniFunction;
import com.laazer.common.JSONUtils;
import com.laazer.lol.champion.*;

public class LoLUtils extends LoLObject{
    
    public static UniFunction<Object, LoLRecommended> toRecommended = new ToRecommended();
    public static UniFunction<Object, LoLSkin> toSkin = new ToSkin();
    public static UniFunction<Object, LoLSpellVars> toSpellVar = new ToSpellVars();
    public static UniFunction<Object, LoLChampSpell> toChampSpell = new ToChampSpell();
    public static UniFunction<Object, LoLImage> toImage = new ToImage();
    public static UniFunction<Object, LoLBlockItem> toBlockItem = new ToBlockItem();
    
    private static class ToRecommended implements UniFunction<Object, LoLRecommended> {
        public LoLRecommended apply(Object value) {
            return new LoLRecommended().genLoLRecommened(JSONUtils.toJSONObject.apply(value));
        }
    }
    
    private static class ToSkin implements UniFunction<Object, LoLSkin> {
        public LoLSkin apply(Object value) {
            return new LoLSkin().genLoLSkin(JSONUtils.toJSONObject.apply(value));
        }
    }
    
    private static class ToSpellVars implements UniFunction<Object, LoLSpellVars> {
        public LoLSpellVars apply(Object value) {
            return new LoLSpellVars().genSpellVars(JSONUtils.toJSONObject.apply(value));
        }
    }
    
    private static class ToChampSpell implements UniFunction<Object, LoLChampSpell> {
        public LoLChampSpell apply(Object value) {
            return new LoLChampSpell().genChampSpell(JSONUtils.toJSONObject.apply(value));
        }
    }
    
    private static class ToImage implements UniFunction<Object, LoLImage> {
        public LoLImage apply(Object value) {
            return new LoLImage().genImage(JSONUtils.toJSONObject.apply(value));
        }
    }
    
    private static class ToBlockItem implements UniFunction<Object, LoLBlockItem> {
        public LoLBlockItem apply(Object value) {
            return new LoLBlockItem().genBlockItem(JSONUtils.toJSONObject.apply(value));
        }
        
    }
    
}
