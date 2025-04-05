package com.SpringDemo.joblisting.Repository;

import com.SpringDemo.joblisting.model.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface PostRepository extends MongoRepository<JobPost,String> {
}
