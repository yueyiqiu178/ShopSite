package site.yueyiqiu.action.user;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ModelDriven;

import site.yueyiqiu.action.BaseAction;
import site.yueyiqiu.model.user.User;

@Scope("prototype")
@Controller("userAction")
public class UserAction extends BaseAction implements ModelDriven<User>{
	
	
	public String login(){
		return this.USER_LOGIN;
	}
	
	
	public String logon(){
		
		User loginUser=userDao.login(user.getUsername().trim(), user.getPassword().trim());
		
		if(loginUser!=null){
			session.put("admin", loginUser);
		}
		else{
			
			this.addFieldError("", "±b¸¹©Î±K½X¿ù»~");
			return this.USER_LOGIN;
		}
		
		return this.MANAGER;
		
	}
	
	
	public String logout(){
		
		if(session!=null&&session.size()>0){
			session.clear();
		}
		
		return this.INDEX;
	}
	
	
	private User user=new User();
	
	
	
	
	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	@Override
	public User getModel() {
		
		return user;
	}
	
	
	
	
}
