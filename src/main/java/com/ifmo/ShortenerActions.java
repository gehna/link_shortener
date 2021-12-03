package com.ifmo;

public interface ShortenerActions {
    public void add(String link);
    public void remove(String link);
    public String convertShortToLong(String link);
    public String getShortString(String link);
}
