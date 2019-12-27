package com.one.constants;

import java.util.ArrayList;
import java.util.List;

import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;



public class Constants {
	private static final String MONGODB_HOST = "localhost";
	private static final int MONGODB_PORT = 27017;
	private static final String MONGODB_DATABASE = "account1";
	
	public static String getDataBaseName() {
		return MONGODB_DATABASE;
		
	}
	 
	public static List<ServerAddress> getMongoServerAddresses() {
		List<ServerAddress> serverAddressList = new ArrayList<>();
		serverAddressList.add(new ServerAddress(MONGODB_HOST, MONGODB_PORT));
		return serverAddressList;
	}
	
	public static List<MongoCredential> getMongoCredentials() {
		List<MongoCredential> credentials = new ArrayList<>();
		return credentials;
	}
}
