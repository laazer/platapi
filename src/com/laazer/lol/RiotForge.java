package com.laazer.lol;

import com.laazer.common.Box;
import com.laazer.lol.champion.LoLChampVal;
import com.laazer.lol.champion.LoLChampion;

public class RiotForge {
    String key;
    public RiotForge(String key){
        this.key = key;
    }
    
    public Box<LoLChampion> genSimpleChamp(int id) {
        return this.genComplexChamp(id);
    }
    
    //TODO
    public Box<LoLChampion> genComplexChamp(int id, LoLChampVal[]... args) {
        return Box.EMPTY;
    }
    
}
