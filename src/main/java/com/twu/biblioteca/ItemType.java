package com.twu.biblioteca;

public enum ItemType {
    BOOK, MOVIE, INVALID;

    public static ItemType lookup(String type){
        try{
            return ItemType.valueOf(type.toUpperCase());
        }
        catch (IllegalArgumentException e){
            return INVALID;
        }
    }
}
