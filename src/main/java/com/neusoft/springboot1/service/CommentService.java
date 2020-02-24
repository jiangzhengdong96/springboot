package com.neusoft.springboot1.service;

import com.neusoft.springboot1.entity.Comment;
import com.neusoft.springboot1.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    public List<Comment> getAllComment(){
        List<Comment> comments = commentMapper.getAllComment();
        return comments;
    }
    public int updateCommentStatus(Integer status,Integer cId){
        return commentMapper.updateCommentStatus(status,cId);
    }
}
