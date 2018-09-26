package com.lh.pojo.vo;

import com.generator.tables.pojos.Author;

/**
 * 封装的响应体
 * 根据id查询author 
 * @author 刘昊
 *
 */
public class GetAuthorResp {
    
    private int status; // 响应业务状态
    private String msg; // 响应消
    private Author author; // 响应中的数据
    
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }    
}
