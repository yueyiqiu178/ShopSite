package site.yueyiqiu.dao.user;

import site.yueyiqiu.dao.BaseDao;
import site.yueyiqiu.model.user.Customer;

public interface CustomerDao extends BaseDao<Customer>{

	public Customer login(String username,String password);
	public boolean isUnique(String username);	
		
	
	
	
}
