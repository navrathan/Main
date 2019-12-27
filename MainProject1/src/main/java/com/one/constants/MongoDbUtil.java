package com.one.constants;

import java.io.IOException;
import java.util.List;
import org.apache.log4j.Logger;
import org.bson.Document;

import com.one.constants.Constants;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.MongoException;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDbUtil {

	private static final Logger logger = Logger.getLogger(MongoDbUtil.class);

	private static MongoClient mongoClient = null;
	private static MongoDatabase db = null;
	private static DB jongoDB = null;

	private MongoDbUtil() {
	}

	static {
		initializeDB();
	}

	@SuppressWarnings("deprecation")
	private static void initializeDB() {
		if (mongoClient == null) {
			List<ServerAddress> serverAddresses = Constants.getMongoServerAddresses();
			List<MongoCredential> credentials = Constants.getMongoCredentials();
			if (serverAddresses != null && serverAddresses.size() > 1) {
				MongoClientOptions.Builder builder = new MongoClientOptions.Builder();
				// build the connection options
				builder.maxConnectionIdleTime(60000);
				builder.sslEnabled(true);
				MongoClientOptions options = builder.build();
				
				mongoClient = new MongoClient(serverAddresses, credentials, options);
				mongoClient.slaveOk();
			}else{
				mongoClient = new MongoClient(serverAddresses, credentials);	
			}
		}
		if (db == null) {
			db = mongoClient.getDatabase(Constants.getDataBaseName());
		}
		if (jongoDB == null) {
			jongoDB = new DB(mongoClient, Constants.getDataBaseName());
		}
	}

	public static DB getDB() {
		if (jongoDB == null) {
			initializeDB();
		}
		return jongoDB;
	}

	public static MongoCollection<Document> getCollection(String collectionName) {
		return getMongoDataBase().getCollection(collectionName);
	}

	public static MongoDatabase getMongoDataBase() {
		if (db == null) {
			initializeDB();
		}
		return db;
	}

	public static void closeCursor(MongoCursor<Document> cursor) {
		try {
			if (cursor != null) {
				cursor.close();
			}
		} catch (MongoException e) {
			logger.error("Exception occurred while closing Mongo Cursor connection", e);
		}
	}

	@SuppressWarnings("rawtypes")
	public static void closeJongoCursor(org.jongo.MongoCursor cursor) {
		try {
			if (cursor != null) {
				cursor.close();
			}
		} catch (MongoException | IOException e) {
			logger.error("Exception occurred while closing jongo connection", e);
		}
	}

}
