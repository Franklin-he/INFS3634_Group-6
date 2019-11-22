package com.example.math_learning_app;

import com.example.math_learning_app.model.Topic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BookmarkDatabase {

    public static HashMap<String, Topic> favouriteTopicsMap;

    static{
        favouriteTopicsMap = new HashMap<>();
    }
    
    public static ArrayList<Topic> getBookmarkedTopics(){
        ArrayList<Topic> favouriteTopicsArray = new ArrayList<>();
        for (Map.Entry<String, Topic> favouriteTopic :
                favouriteTopicsMap.entrySet()) {
            favouriteTopicsArray.add(favouriteTopic.getValue());
        }
        return favouriteTopicsArray;
    }

    public static void addToBookmarks(Topic newTopic){
        String topicId = newTopic.getId();
        //Check If topic Exists
        if (!favouriteTopicsMap.containsKey(topicId)){
            favouriteTopicsMap.put(topicId, newTopic);
            System.out.println(newTopic.getTitle() + " bookmarked.");
        } else {
            System.out.println("This topic is already a favourite.");
        }
    }

    public static void removeFromBookmarked(Topic newTopic){
        String topicId = newTopic.getId();
        if (favouriteTopicsMap.containsKey(topicId)){
            favouriteTopicsMap.remove(topicId);
            System.out.println(newTopic.getTitle() + " removed from bookmarked.");
        } else {
            System.out.println("Topic removed from bookmarked.");
        }

    }

}
