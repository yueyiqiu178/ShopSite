package site.yueyiqiu.util;

public class AppException extends RuntimeException{
	
	
	private String message;
	private String[] args;
	private String defaultMessage;
	
	public AppException(String message){
		this.message=message;
	}
	
	public AppException(String message,String...  args){
		this.message=message;
		if(args!=null&&args.length>0){
			
		}
	}
	
	
	
	
	
}
