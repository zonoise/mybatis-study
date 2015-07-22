package com.example.app;

/**
 * Created by zonoise on 2015/07/17.
 */
import com.example.app.Post;
public interface PostMapper {
    Post getPost(long id);
    long insert(Post post);
}
