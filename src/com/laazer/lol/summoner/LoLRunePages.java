package com.laazer.lol.summoner;

import com.laazer.lol.LoLObject;
import java.util.Set;

public class LoLRunePages implements LoLObject {
    Set<LoLRunePage> pages;
    Long summonerId;
}

class LoLRunePage implements LoLObject {
    boolean cuurent;
    Long id;
    String name;
    Set<LoLRuneSlot> slots;
}

class LoLRuneSlot implements LoLObject {
    int runeId;
    int runeSlotId;
}

