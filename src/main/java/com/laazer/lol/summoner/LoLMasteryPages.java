package com.laazer.lol.summoner;

import java.util.Set;
import java.util.List;
import com.laazer.lol.LoLObject;

public class LoLMasteryPages extends LoLObject{
    Set<LoLMasteryPage> pages;
    Long summonerId;
}

class LoLMasteryPage extends LoLObject {
    boolean current;
    Long id;
    List<LoLMastery> masteries;
    String name;
}

class LoLMastery extends LoLObject {
    int id, rank;
}