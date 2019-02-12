package site.yueyiqiu.dao.user;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import site.yueyiqiu.dao.DaoSupport;
import site.yueyiqiu.model.user.User;

@Transactional
@Repository("userDao")
public class UserDaoImpl extends DaoSupport<User> implements UserDao{
	
	
	@Override
	public User login(String username, String password) {
		
		if(username!=null&&password!=null){
			String where="where username=? and password=?";
			Object[] params={username,password};
			List<User> list=this.find(where, params, null, -1, -1).getList();
			
			if(list!=null&&list.size()>0)
				return list.get(0);
			
		}
		
		return null;
	}

	@Override
	public boolean isUnique(String username) {
		
		List list=this.getTemplate().find("from User where username=?", username);
		if(list!=null&&list.size()>0)
			return false;
		
		return true;
	}
	
}
