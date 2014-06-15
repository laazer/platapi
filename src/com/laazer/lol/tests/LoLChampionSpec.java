package com.laazer.lol.tests;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import org.junit.Test;

import com.laazer.common.Box;
import com.laazer.lol.champion.LoLChampion;

public class LoLChampionSpec {

    Box<LoLChampion> garen;
    Box<LoLChampion> soraka;
    Box<LoLChampion> nidalee;
    
    public void initGaren() {
        garen = LoLChampion.genChampion(86);
    }
    public void initSoraka() {
        soraka = LoLChampion.genChampion(16);}
    public void initNid() {
        nidalee = LoLChampion.genChampion(76);
    }
    
    @Test
    public void testGaren() {
        initGaren();
        assertTrue(garen.isFull());
    }
    
    @Test
    public void testSoraka() {
        initSoraka();
        assertTrue(soraka.isFull());
    }
    
    
}
