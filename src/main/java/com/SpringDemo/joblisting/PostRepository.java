package com.SpringDemo.joblisting;

import com.SpringDemo.joblisting.model.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface PostRepository extends MongoRepository<JobPost,String> {
}
