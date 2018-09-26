package com.lh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.generator.tables.pojos.Author;
import com.lh.pojo.vo.GetAuthorListResp;
import com.lh.pojo.vo.GetAuthorResp;
import com.lh.pojo.vo.req.VoAddAuthorReq;
import com.lh.pojo.vo.req.VoGetAuthorListReq;
import com.lh.pojo.vo.req.VoUpdateAuthorReq;
import com.lh.service.AuthorService;



@RestController
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class AuthorController {
    @Autowired
    private AuthorService authorService;
   
    
    /**
     * 根据id查询指定id的记录
     * @param id
     * @return
     */
    @GetMapping("/authors/{author-id}")
    @ResponseStatus(HttpStatus.OK)
    public GetAuthorResp getAuthor(@PathVariable("author-id")Integer id) {
        GetAuthorResp result = new GetAuthorResp();
        Author author = authorService.getAuthor(id);
        
        /*封装响应体*/
        result.setStatus(200);
        result.setMsg("获取成功");
        result.setAuthor(author);
        
        return result;
    }
    
    /**
     * 查询一个记录列表
     * @param vo
     * @return
     */
    @GetMapping("/authors")
    @ResponseStatus(HttpStatus.OK)
    public GetAuthorListResp getAuthors(VoGetAuthorListReq vo) {
        GetAuthorListResp result = new GetAuthorListResp();
        List<Author> authors = authorService.getAuthors();
        
        /*封装响应体*/
        result.setStatus(200);
        result.setMsg("获取成功");
        result.setAuthors(authors);
        
        return result; 
    }
    
    /**
     * 根据id来更新相应字段
     * @param id
     * @param voUpdateAuthorReq
     * @return
     */
    @PutMapping("/authors/{author-id}")
    @ResponseStatus(HttpStatus.CREATED)
    public GetAuthorResp updateAuthor(@PathVariable("author-id")Integer id,
            @RequestBody VoUpdateAuthorReq voUpdateAuthorReq) {
        GetAuthorResp result = new GetAuthorResp();  
        voUpdateAuthorReq.setId(id);
        
        Author update_author = authorService.updateAuthor(voUpdateAuthorReq);
        
        /*封装响应体*/
        result.setStatus(200);
        result.setMsg("更新成功");
        result.setAuthor(update_author);
        
        return result;
        
    }
    
    /**
     * 在数据表中插入一行
     * @param voAddAuthorReq
     * @return
     */
    @PostMapping("/authors")
    @ResponseStatus(HttpStatus.CREATED)
    public GetAuthorResp addAuthor(@RequestBody VoAddAuthorReq voAddAuthorReq) {
        GetAuthorResp result = new GetAuthorResp(); 
        Author add_Author = authorService.addAuthor(voAddAuthorReq);
        
        /*封装响应体*/
        result.setStatus(200);
        result.setMsg("插入成功");
        result.setAuthor(add_Author);
        
        return result;
    }
    
    /**
     * 删除指定id的行
     * @param id
     */
    @DeleteMapping("/authors/{authors-id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable("authors-id")Integer id) {
        authorService.deleteAuthor(id);
    }
   
    
}
