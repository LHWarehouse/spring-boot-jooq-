package com.lh.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generator.tables.pojos.Author;
import com.lh.dao.AuthorMapper;
import com.lh.pojo.vo.req.VoAddAuthorReq;
import com.lh.pojo.vo.req.VoUpdateAuthorReq;

@Service
public class AuthorService {

    @Autowired
    private DSLContext dsl;

    @Autowired
    private AuthorMapper authorMapper;

   
    /**
     * 
     * 通过id查询指定记录
     * @param id
     * @return
     */ 
    public Author getAuthor(@Valid @NotNull Integer id){
        return authorMapper.getAuthor(id);
    }
    
    /**
     * 查询Author表所有记录
     * @return
     */
    public List<Author> getAuthors(){
        return authorMapper.getAuthors();
    }
    
    /**
     * 通过id更新相应字段
     * @param voUpdateAuthorReq
     * @return
     */
    public Author updateAuthor(@Valid @NotNull VoUpdateAuthorReq voUpdateAuthorReq){
        //封装author类
        com.generator.tables.pojos.Author author = new com.generator.tables.pojos.Author();
        author.setId(voUpdateAuthorReq.getId());
        author.setFirstName(voUpdateAuthorReq.getFirstName());
        author.setLastName(voUpdateAuthorReq.getLastName());
        return authorMapper.updateAuthor(author);
    }
    
    /**
     * 插入一条新的一行
     * @param voAddAuthorReq
     * @return
     */
    public Author addAuthor(@Valid @NotNull VoAddAuthorReq voAddAuthorReq){
        Author author = new Author();
        author.setId(voAddAuthorReq.getId());
        author.setFirstName(voAddAuthorReq.getFirstName());
        author.setLastName(voAddAuthorReq.getLastName());
        return authorMapper.addAuthor(author);
    }
    
    /**
     * 删除指定id的一行
     * @param id
     * @return
     */
    public Boolean deleteAuthor(@Valid @NotNull Integer id) {
        return authorMapper.deleteAuthor(id);
    }
}
