package site.yueyiqiu.model;

import java.util.List;

public class PageModel<T> {
	
	private int totalRecords;
	private List<T> list;
	private int pageNo;
	private int pageSize;
	
	
	public int getFirstPageNo(){
		return 1;
	}
	
	
	public int getPreviousPageNo(){
		
		if(this.pageNo<=1)
			return 1;
		return this.pageSize-1;
	}
	
	
	public int getNextPageNo(){
		
		if(this.pageNo==this.getTotalPages())
			return this.getTotalPages()==0?1:this.getTotalPages();
		
		return this.pageNo+1;
	}
	
	public int getLastPageNo(){
		return this.getTotalPages()==0?1:this.getTotalPages();
	}
	

	
	public int getTotalPages(){
		
		if(this.totalRecords==0)
			return 0;
		if (this.totalRecords%this.pageSize==0)
			return this.totalRecords/this.pageSize;
		else
			return this.totalRecords/this.pageSize+1;
					
	}


	public int getTotalRecords() {
		return totalRecords;
	}


	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}


	public List<T> getList() {
		return list;
	}


	public void setList(List<T> list) {
		this.list = list;
	}


	public int getPageNo() {
		return pageNo;
	}


	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
	
	
	
}
