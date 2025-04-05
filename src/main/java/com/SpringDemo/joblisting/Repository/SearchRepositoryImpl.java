package com.SpringDemo.joblisting.Repository;

import com.SpringDemo.joblisting.model.JobPost;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepositoryImpl implements SearchRepository {
    @Autowired
    MongoClient client;
    @Autowired
    MongoConverter converter;

    @Override
    public List<JobPost> findByText(String text) {
        List<JobPost> searchResult = new ArrayList<>();

        MongoDatabase database = client.getDatabase("SpringDemo");
        MongoCollection<Document> collection = database.getCollection("JobList");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search", new Document("text", new Document("query", text).append("path", Arrays.asList("techs","desc","profile")))), new Document("$sort", new Document("exp", 1L)), new Document("$limit", 5L)));

        result.forEach(doc -> searchResult.add(converter.read(JobPost.class,doc)));

        return searchResult;
    }
}
