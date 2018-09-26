package com.lh.dao.impl;

import static com.generator.tables.Author.AUTHOR;

import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.generator.tables.pojos.Author;
import com.generator.tables.records.AuthorRecord;
import com.lh.dao.AuthorMapper;

@Repository
public class AuthorMapperImpl implements AuthorMapper {

    @Autowired
    private DSLContext dsl;

    //com.generator.tables.Author a = com.generator.tables.Author.AUTHOR.as("a");

    /**
     * 
     * 根据id查询
     */
    @Override
    public Author getAuthor(Integer id) {

        Assert.notNull(id, "输入id为空");
        AuthorRecord record = dsl.selectFrom(AUTHOR)
                .where(AUTHOR.ID.eq(id))
                .fetchOne();
        
        Assert.notNull(record, "请输入有效id");
        Author author = record.into(Author.class);
        return author;
    }

    /**
     * 查询Author所有记录
     * 
     */
    @Override
    public List<Author> getAuthors() {
        Result<AuthorRecord> records = dsl.selectFrom(AUTHOR)
                .fetch();
        Assert.notNull(records, "查询不到记录，为空");
        List<Author> authors = records.into(Author.class);
        return authors;
    }

    /**
     * 更新相应id的相关字段
     * 
     */
    @Override
    public Author updateAuthor(Author author) {
        // dsl.update(a).set
        AuthorRecord Record = dsl.newRecord(AUTHOR);
        Record.from(author);
        int updateRow = Record.store();
        if (updateRow == 1) {
            return Record.into(Author.class);
        } else {
            return null;
        }
    }

    /**
     * 
     * 插入一行数据
     */
    @Override
    public Author addAuthor(Author author) {
        AuthorRecord record =  new AuthorRecord();
        record  =  dsl.insertInto(AUTHOR)
                .set(dsl.newRecord(AUTHOR, author))
                .returning()
                .fetchOne();
        Assert.notNull(record, "请输入有效id");
        return record.into(Author.class);
    }
    
    /**
     * 删除指定id的一行
     * @param id
     * @return
     */
    @Override
    public Boolean deleteAuthor(Integer id) {
        Assert.notNull(id, "输入id为空");
        int deleteRows = dsl.deleteFrom(AUTHOR)
                .where(AUTHOR.ID.eq(id)).execute();
        
        if(deleteRows > 0) {
            return true;
        }else {
            Assert.notNull(deleteRows == 0, "删除失败");
            return false;
        }
    }
}
