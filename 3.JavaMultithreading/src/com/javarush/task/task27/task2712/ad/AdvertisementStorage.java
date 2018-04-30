package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sashka on 21.12.2016.
 */
class AdvertisementStorage
{
    private final static AdvertisementStorage instance = new AdvertisementStorage();

    private final List<Advertisement> videos = new ArrayList<>();

    private AdvertisementStorage()
    {
        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60));
        add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60));
        add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60));
    }

    static AdvertisementStorage getInstance()
    {
        return instance;
    }

    List<Advertisement> list()
    {
        return videos;
    }

    void add(Advertisement advertisement)
    {
        videos.add(advertisement);
    }
}