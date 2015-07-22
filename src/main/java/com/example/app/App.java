package com.example.app;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

/**
 * Created by zonoise on 2015/07/17.
 */
public class App {
    public static void main(String[] args) throws IOException{
        System.out.println("hello");
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession sqlSession = factory.openSession();

        PostMapper postMapper = sqlSession.getMapper(PostMapper.class);
        Post p = new Post();
        p.setId((new Date()).getTime());
        p.setTitle("title");
        postMapper.insert(p);
        sqlSession.commit();
        sqlSession.close();
        System.out.println("hello");
    }
}
