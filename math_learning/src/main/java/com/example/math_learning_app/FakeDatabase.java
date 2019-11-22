package com.example.math_learning_app; // <============= CHANGE ME

import com.example.math_learning_app.model.Topic;

import java.util.HashMap;
import java.util.List;

/***
 * A class to simulate some data source existing. Use to practice intents and lists/RecyclerView
 * before going into APIs.
 *
 * Week 6:
 *  Now this acts as a place to store our objects, and make them accessible by an ID.
 *  It no longer contains fake data in there by default. You must populate it by parsing the JSON.
 *
 *
 *      e.g. if I got [ArrayList<Book> booksFromJson] from my Gson parsing:
 *              FakeDatabase.saveBooksToFakeDatabase(booksFromJson);
 *
 *           now my FakeDatabase contains my books from JSON.
 *           And I can now do FakeDatabase.getBookByIsbn(1);
 *
 *
 *
 * Example usage:
 *      Article articleObject1 = FakeDatabase.getArticleById(1);
 *      System.out.println(articleObject1.getTitle());
 *
 * Output:
 *      Diamonds, Warlords and Mercenaries: Russia’s New Playbook in Africa
 */
public class FakeDatabase {
    public static HashMap<Long, Topic> topics = new HashMap<>();



    public static Topic getArticleById(long topicID) {
        return topics.get(topicID);
    }

    public static List<Topic> getAllTopics() {
        return (List) topics.values();
    }

    // This methods simulates saving the data you get from the API to your local database.
    // This way, we retrieve the whole object for an Article by using its ID.
    // Keep in mind it's not a real database yet.
    /*
    public static void saveArticlesToFakeDatabase(List<Article> articlesToSave) {
        for(int i = 0; i < articlesToSave.size(); i++) {
            Topic topic = articlesToSave.get(i);
            topic.put(topic.getId(), topic);
        }
    }*/





}
