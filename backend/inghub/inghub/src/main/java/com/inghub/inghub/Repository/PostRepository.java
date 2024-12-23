package com.inghub.inghub.Repository;

import com.inghub.inghub.Model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
