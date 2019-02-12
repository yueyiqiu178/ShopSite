package site.yueyiqiu.dao;

import java.io.Serializable;
import java.util.Map;

import site.yueyiqiu.model.PageModel;

public interface BaseDao<T> {
	
	public void evit();
	public void close();
	public void merge(Object obj);
	public void save(Object obj);
	public void saveOrUpdate(Object obj);
	public void update(Object obj);
	public void delete(Serializable... ids);
	public T get(Serializable id);
	public T load(Serializable id);
	public Object uniqueResult(String hql,Object[] params);
	public long getCount();
	
	public PageModel<T> find(int pageNo,int maxResult);
	public PageModel<T> find(int pageNo,int maxResult,String where,Object[] params);
	public PageModel<T> find(int pageNo,int maxResult,Map<String,String> orderby);
	public PageModel<T> find(String where,Object[] params,Map<String,String> orderby,int pageNo,int maxResult);
	
}
