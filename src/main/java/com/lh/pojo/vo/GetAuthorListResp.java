package com.lh.pojo.vo;

import java.util.List;

import com.generator.tables.pojos.Author;

public class GetAuthorListResp {
    private int status; // 响应业务状态
    private String msg; // 响应消
    private List<Author> authors; // 响应数据
    
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
    public List<Author> getAuthors() {
        return authors;
    }
    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }   
}
