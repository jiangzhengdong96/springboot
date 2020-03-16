package com.neusoft.springboot1.service.serviceImpl;

import com.neusoft.springboot1.entity.Comment;
import com.neusoft.springboot1.mapper.CommentMapper;
import com.neusoft.springboot1.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getAllComment() {
        List<Comment> comments = commentMapper.getAllComment();
        return comments;
    }

    @Override
    public int updateCommentStatus(Integer status, Integer cId) {
        return commentMapper.updateCommentStatus(status,cId);
    }

    @Override
    public List<Comment> getAllCommentsById(Integer gId) {
        return commentMapper.getAllCommentsById(gId);
    }

    @Override
    public int insertComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }


}
