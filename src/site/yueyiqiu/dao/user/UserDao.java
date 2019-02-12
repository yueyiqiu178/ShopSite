package site.yueyiqiu.dao.user;

import site.yueyiqiu.dao.BaseDao;
import site.yueyiqiu.model.user.User;

public interface UserDao extends BaseDao<User>{
	
	
	public User login(String username,String password);
	public boolean isUnique(String username);
	
}
