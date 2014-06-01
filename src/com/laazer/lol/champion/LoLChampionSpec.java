package com.laazer.lol.champion;

import com.laazer.common.Box;
import junit.framework.TestCase;

public class LoLChampionSpec extends TestCase {

    Box<LoLChampion> garen;
    Box<LoLChampion> soraka;
    Box<LoLChampion> nidalee;
    
    public void init() {
        garen = LoLChampion.genChampion(86);
        soraka = LoLChampion.genChampion(16);
        nidalee = LoLChampion.genChampion(76);
    }
    
    public void testExistence() {
        assertTrue(garen.isFull());
        assertTrue(soraka.isFull());
        assertTrue(nidalee.isFull());
    }
    
}
