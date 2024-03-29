package com.turvo.graphqltutorial.configuration;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

//@Configuration
public class MongoConfiguration extends AbstractMongoClientConfiguration {

  @Override
  public MongoClient mongoClient() {
    ConnectionString connectionString = new ConnectionString("mongodb://dev-cr-4361-05.turvo.net:27017/test");
    MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
        .applyConnectionString(connectionString)
        .build();

    return MongoClients.create(mongoClientSettings);
  }

  @Override
  protected String getDatabaseName() {
    return "turvo";
  }
}
