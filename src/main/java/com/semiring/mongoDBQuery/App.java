/*
 * mongoDBQuery
 * 
 * Copyright 2018 by Damir Cavar (http://damir.cavar.me/)
 * 
 * Example of a basic MongoDB query.
 * 
 */


package com.semiring.mongoDBQuery;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCursor;

import org.bson.Document;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * MongoDB Demo
 * 
 * Assuming on localhost there is a running MongoDB instance with a database
 * called exampledb and a collection called main.
 *
 */
public class App {

	public static void main(String[] args) {
		// stop MongoDB from generating tons of info messages
		Logger mongoLogger = Logger.getLogger("org.mongodb.driver");
		mongoLogger.setLevel(Level.SEVERE);

		MongoClient mongoClient = new MongoClient("localhost", 27017);
		MongoDatabase db = mongoClient.getDatabase("exampledb");
		MongoCollection<Document> coll = db.getCollection("main");

		BasicDBObject searchQuery = new BasicDBObject();

		for (String token : args) {
			searchQuery.put("type", token);
			System.out.println("Query token: " + token + System.lineSeparator());
			MongoCursor<Document> cursor = coll.find(searchQuery).iterator();
			int max = 0;
			try {
				if (!cursor.hasNext()) {
					System.out.println("Not found!");
				} else {
					while (cursor.hasNext() && max < 10) {
						max += 1;
						System.out.println(cursor.next().toJson());
					}
				}
			} finally {
				cursor.close();
			}
			System.out.println("--------------------------------------------");
		}
		mongoClient.close();
	}
}
