package com.ifmo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class LinkShortener implements ShortenerActions {
    HashMap<String, String> ListOfLinks;

    public LinkShortener(HashMap<String, String> listOfLinks) {
        ListOfLinks = listOfLinks;
    }

    @Override
    public void remove(String link) {
        if (ListOfLinks.containsValue(link)) {
            ListOfLinks.remove(link);
        } else {
            System.out.println("Value " + link + " is not exist");
        }
    }

    @Override
    public String convertShortToLong(String link) {
        return ListOfLinks.get(link);

    }

    @Override
    public String getShortString(String link) {
        for (Map.Entry<String, String> entry : ListOfLinks.entrySet()) {
            if (entry.getValue().equals(link)) {
                return entry.getKey();
            }
        }
        return ""+link+" not found";
    }

    @Override
    public void add(String link) {
        if (ListOfLinks.containsValue(link)){
            System.out.println("Value "+ link + " is already exist");
        } else {
            String shortLink;
            String schema = link.substring(0, link.indexOf("://")) + "://";
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

    public static void main(String[] args) {
        LinkShortener lSh = new LinkShortener(new HashMap<>());
        lSh.add("http://lalalala.ru");
        lSh.add("http://dadada.ru");
        System.out.println(lSh.getShortString("http://lalalala.ru"));
//        System.out.println(lSh);

    }
}
