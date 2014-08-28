package com.laazer.lol;

import com.google.gson.Gson;


public abstract class LoLObject {
    protected final static String URL = "https://prod.api.pvp.net/api/lol/";
    protected final static String KEY = "api_key=f123e66a-3511-4219-bd29-71d8e315e603";
    
    public LoLObject genLoLObject(Object obj) {
        Gson gson = new Gson();
        return gson.fromJson(obj.toString(), this.getClass());
    }

    
}

@SuppressWarnings("serial")
class BadLoLConversionExecption extends Exception
{
      //Parameterless Constructor
      public BadLoLConversionExecption() {}

      //Constructor that accepts a message
      public BadLoLConversionExecption(String message)
      {
         super(message);
      }
 }
