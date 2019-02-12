package site.yueyiqiu.dao;

import java.io.Serializable;
import java.lang.reflect.*;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import site.yueyiqiu.model.PageModel;

@Transactional
public class DaoSupport<T> implements BaseDao<T>{
	
	protected Class<T> entityClass;
	
	
	@Autowired
	protected HibernateTemplate template;
	
	
	public DaoSupport(){
		
		Type genType=this.getClass().getGenericSuperclass();
		Type[] params=((ParameterizedType)genType).getActualTypeArguments();
		
		this.entityClass=(Class<T>) params[0];
		
	}
	
	public HibernateTemplate getTemplate(){
		return this.template;
	}
	
	
	@Override
	public void save(Object obj) {
		this.getTemplate().save(obj);
		
	}

	@Override
	public void saveOrUpdate(Object obj) {
		this.getTemplate().saveOrUpdate(obj);
		
	}

	@Override
	public void update(Object obj) {
		this.getTemplate().update(obj);
		
	}

	@Override
	public void delete(Serializable... ids) {
		
		for(Serializable id : ids){
			T t=this.getTemplate().load(entityClass, id);
			this.getTemplate().delete(t);
		}
		
		
	}

	@Override
	public T get(Serializable id) {
		
		return this.getTemplate().get(entityClass, id);
	}

	@Override
	public T load(Serializable id) {
		
		return this.getTemplate().load(entityClass, id);
	}

	
	@Override
	public Object uniqueResult(final String hql, final Object[] params) {
		
		return this.getTemplate().execute(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				
				Query query=session.createQuery(hql);
				setQueryParams(query,params);
				
				
				return query.uniqueResult();
			}});
	}
	
	protected void setQueryParams(Query query,Object[] params){
		
		if(params!=null&&params.length>0){
			
			for(int i=0;i<params.length;i++)
				query.setParameter(i, params[i]);
		}
		
	}

	@Override
	public long getCount() {
		
		String hql="select count(*) from "+this.entityClass.getSimpleName();
		
		return (long) this.uniqueResult(hql, null);
	}
	
	
	
	protected int getFirstResult(int pageNo,int maxResult){
		
		int result=(pageNo-1)*maxResult;
		
		return result<0?0:result;
		
	}
	
	
	protected String createOrderBy(Map<String,String> orderby){
		
		StringBuffer sb=new StringBuffer(" ");
		if(orderby!=null&&orderby.size()>0){
			
			sb.append(" order by ");
			
			for(String ptr:orderby.keySet())
				sb.append(ptr).append(" ").append(orderby.get(ptr)).append(" ");
				
			sb.deleteCharAt(sb.length()-1);
			
		}
		
		return sb.toString();
		
	}
	
	
	public PageModel<T> find(final String where,final Object[] params,final Map<String,String> orderby,final int pageNo,final int maxResult){
		
		
		final PageModel<T> model=new PageModel<T>();
		model.setPageNo(pageNo);
		model.setPageSize(maxResult);
		
		this.getTemplate().execute(new HibernateCallback(){

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				
				
				String hql=new StringBuilder().append("from ")
											  .append(entityClass.getSimpleName())
											  .append(" ")
											  .append(where==null?"":where)
											  .append(createOrderBy(orderby)).toString();
				System.out.println("hql="+hql);
				Query query=session.createQuery(hql);
				setQueryParams(query,params);
				List<T> list=null;
				
				if(pageNo<0&&maxResult<0){
					list=query.list();
				}
				else{
					
					list=query.setMaxResults(maxResult).setFirstResult(getFirstResult(pageNo,maxResult)).list();
					
					hql=new StringBuffer().append("select count(*) from ")
										  .append(entityClass.getSimpleName())
										  .append(" ")
										  .append(where==null?"":where)
										  .toString();
					query=session.createQuery(hql);
					setQueryParams(query,params);
					int total=Integer.parseInt(query.uniqueResult().toString()) ;
					model.setTotalRecords(total);
				}
				
				model.setList(list);
				
				return null;	
			}});
		
		
		return model;
		
	}

	@Override
	public PageModel<T> find(int pageNo, int maxResult) {
		
		return this.find(null, null, null, pageNo, maxResult);
	}

	@Override
	public PageModel<T> find(int pageNo, int maxResult, String where,
			Object[] params) {
		
		return this.find(where, params, null, pageNo, maxResult);
	}

	@Override
	public PageModel<T> find(int pageNo, int maxResult,
			Map<String, String> orderby) {
		
		return this.find(null, null, orderby, pageNo, maxResult);
	}

	@Override
	public void merge(Object obj) {
		
		this.getTemplate().merge(obj);
		
	}

	@Override
	public void close() {
		
		this.getTemplate().clear();
	}

	@Override
	public void evit() {
		
		//this.getTemplate().evict(entity);
		
	}

}
