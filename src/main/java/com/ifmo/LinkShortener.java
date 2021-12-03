package com.ifmo;

import java.util.HashMap;
import java.util.Random;

public class LinkShortener implements ShortenerActions {
    HashMap<String, String> ListOfLinks = new HashMap<>();

    @Override
    public void remove(String link) {

    }

    @Override
    public void convert(String link) {

    }

    @Override
    public void add(String link) {
        if (ListOfLinks.containsValue(link)){
            System.out.println("Value "+ link + " is already exist");
        } else {
            String shortLink;
            String schema = link.substring(0, link.indexOf("://"));
            String domain = ".lk.ru";

            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 5;
            Random random = new Random();
            StringBuilder buffer = new StringBuilder(targetStringLength);
            for (int i = 0; i < targetStringLength; i++) {
                int randomLimitedInt = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }
            shortLink = buffer.toString();

            shortLink = schema + shortLink + domain;
            ListOfLinks.put(shortLink, link);
        }
    }
}
