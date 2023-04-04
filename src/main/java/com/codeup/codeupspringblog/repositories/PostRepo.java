package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PostRepo extends JpaRepository<Post, Long> {
    Post findByTitle(String title);

}
