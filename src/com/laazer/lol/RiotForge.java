package com.laazer.lol;

import com.laazer.common.Box;
import com.laazer.lol.champion.LoLChampVal;
import com.laazer.lol.champion.LoLChampion;

public class RiotForge {

    public static Box<LoLChampion> genSimpleChamp(int id) {
        return genComplexChamp(id);
    }
    
    //TODO
    public static Box<LoLChampion> genComplexChamp(int id, LoLChampVal[]... args) {
        return Box.EMPTY;
    }
    
}
