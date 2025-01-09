package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.BlogPost;
public interface BlogPostRepositories extends JpaRepository<BlogPost, Long> {
}
