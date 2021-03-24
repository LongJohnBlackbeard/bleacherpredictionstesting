package me.danieltujo.MongoInstance;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Mongo {
    public MongoClient mongoClient;
    public MongoDatabase database;
    public MongoCollection test;
    private static Mongo single_instance = null;


    private Mongo()  {
        mongoClient = MongoClients.create("mongodb+srv://testuser:test@cluster0.rxdor.mongodb.net/myFirstDatabase?retryWrites=true&w=majority/");
        database = mongoClient.getDatabase("BleacherPredictions");
        test = database.getCollection("White_Sox");
    }

    public static Mongo getInstance() {
        if (single_instance == null) {
            single_instance = new Mongo();
        }
        return single_instance;

    }

    public static void main(String[] args) {
        System.out.println(Mongo.getInstance().test.find());

    }
}
