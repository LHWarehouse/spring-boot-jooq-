package com.lh.dao;

import java.util.List;

import com.generator.tables.pojos.Author;

public interface AuthorMapper {
    /*查询一条记录*/
    public Author getAuthor(Integer id);
    /*查询多条记录*/
    public List<Author> getAuthors();
    /*更新表*/
    public Author updateAuthor(Author author);
    /*插入表*/
    public Author addAuthor(Author author);
    /*删除一条记录*/
    public Boolean deleteAuthor(Integer id);
}
