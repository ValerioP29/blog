package com.example.demo.controllers;

import com.example.demo.models.BlogPost;
import com.example.demo.repositories.BlogPostRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogPostController {

    private final BlogPostRepositories repositories;

    public BlogPostController(BlogPostRepositories repositories) {
        this.repositories = repositories;
    }

    @GetMapping
    public ResponseEntity<List<BlogPost>> getAllBlogPosts() {
        return ResponseEntity.ok(repositories.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogPost> getPostById(@PathVariable Long id) {
        return repositories.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BlogPost> createPost(@RequestBody BlogPost blogPost) {
        return ResponseEntity.ok(repositories.save(blogPost));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogPost> updatePost(@PathVariable Long id, @RequestBody BlogPost updatePost) {
        return repositories.findById(id)
                .map(post -> {
                    post.setCategoria(updatePost.getCategoria());
                    post.setTitolo(updatePost.getTitolo());
                    post.setTempoDiLettura(updatePost.getTempoDiLettura());
                    return ResponseEntity.ok(repositories.save(post));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBlogPost(@PathVariable Long id) {
        if (repositories.existsById(id)) {
            repositories.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
