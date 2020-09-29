package com.csi.DBUtil;

import java.util.List;

//进行数据分页
public class Page<T> {
    private int currentPage;//当前页
        private int pageSize;//一页显示多少条数据
        private int totalData;//一共是多少条数据
        private List<T> data;//查询结果
    //构造方法

    public Page() {
    }

    public Page(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }
    //get/set

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalData() {
        return totalData;
    }

    public void setTotalData(int totalData) {
        this.totalData = totalData;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
    //创建自定义方法
    //1.获取总页数的方法
    public int getTotalPageCount(){
        //使用总数据数对每一页显示的数据数量进行整除
        //如果整除除尽了 总页数就是 总数据数/每一页显示的数据数量
        /*如果没有除尽 证明肯定有多余的数据 但是数据的数量是小于每一页显示的数量
        *但是也必须占一个正页 所以总页数的结果就是 总数据数/每一页显示的数据数量+1*/
        return this.totalData % this.pageSize == 0?this.totalData/this.pageSize:this.totalData/this.pageSize+1;
    }
    //2.求上一页
    public int prev(){
        //求上一页 当前页-1是否大于0 如果大于 证明没有到达第一页 那么就返回-1的值就可以
        //如果当前页-1 不大于 证明当前页 就是第一页 没有办法再往上一页跳转 返回第一页就可以了
        return this.currentPage-1>0?this.currentPage-1:1;
    }
    //3.求下一页
    public int next(){
        //判断当前页+1 小于等于总页数 如果满足条件说明可以进行下一页跳转+1 操作
        //如果不满足 证明当前页就是最后一页 就没有下一页 就返回最后一夜就可以
        return this.currentPage+1<=getTotalPageCount()?this.currentPage+1:getTotalPageCount();
    }
    //4.创建一个方法求sql起始位置
    public int start(){
        return (this.currentPage-1)*this.pageSize;
    }
}
