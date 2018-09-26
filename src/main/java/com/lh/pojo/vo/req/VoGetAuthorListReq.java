package com.lh.pojo.vo.req;

public class VoGetAuthorListReq {
    private Integer page ; // 当前页
    private Integer size = 10; // 每页数 默认10页
    private Integer StartRow = 0; // 开始行 默认从0开始
    
    public Integer getPage() {
        return page;
    }
    public void setPage(Integer page) {
        this.page = page;
    }
    public Integer getSize() {
        return size;
    }
    public void setSize(Integer size) {
        this.size = size;
    }
    public Integer getStartRow() {
        return StartRow;
    }
    public void setStartRow(Integer startRow) {
        StartRow = startRow;
    }
}
