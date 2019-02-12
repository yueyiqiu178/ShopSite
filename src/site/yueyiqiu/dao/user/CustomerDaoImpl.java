package site.yueyiqiu.dao.user;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import site.yueyiqiu.dao.DaoSupport;
import site.yueyiqiu.model.user.Customer;

@Transactional
@Repository("customerDao")
public class CustomerDaoImpl extends DaoSupport<Customer> implements CustomerDao{

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Customer login(String username, String password) {
		
		if(username!=null&&password!=null){
			
			String where="where username=? and password=?";
			Object[] params={username,password};
			List<Customer> list=this.find(where, params, null, -1, -1).getList();
			if(list!=null&&list.size()>0){
				System.out.println("hello");
				return list.get(0);
			}
			
		}
		
		return null;
	}

	@Override
	public boolean isUnique(String username) {
		
		List list=this.getTemplate().find("from Customer where username=?", username);
		
		if(list!=null&&list.size()>0)
		return false;
		
		return true;
	}
	
	
	
}
