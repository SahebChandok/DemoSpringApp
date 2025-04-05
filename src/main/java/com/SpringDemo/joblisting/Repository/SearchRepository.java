package com.SpringDemo.joblisting.Repository;

import com.SpringDemo.joblisting.model.JobPost;
import org.springframework.stereotype.Repository;

import java.util.*;

public interface SearchRepository {
    List<JobPost> findByText(String text);
}
