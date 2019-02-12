package site.yueyiqiu.model;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;

public class UU<T extends Enum<T>> implements UserType{
	
	private static final int[] SQL_TYPES={Types.VARCHAR}; 
	private Class<T> clazz=null;
	
	public UU(Class<T> c){
		this.clazz=c;
	}
	
	@Override
	public Object assemble(Serializable arg0, Object arg1)
			throws HibernateException {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public Object deepCopy(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public Serializable disassemble(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return (Serializable)arg0;
	}

	@Override
	public boolean equals(Object arg0, Object arg1) throws HibernateException {
		
		if(arg0==arg1)
			return true;
		if(arg0==null&&arg1==null)
			return true;
		
		return arg0.equals(arg1);
	}

	@Override
	public int hashCode(Object arg0) throws HibernateException {
		// TODO Auto-generated method stub
		return arg0.hashCode();
	}

	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object nullSafeGet(ResultSet arg0, String[] arg1, Object arg2)
			throws HibernateException, SQLException {
		
		try {
//			if (!rs.wasNull()) {
				// 获取字段值
				String name = arg0.getString(arg1[0]).toUpperCase();
				// 将字段值转换成为枚举
				return Enum.valueOf(clazz, name);
//			}else{
//				System.out.println("----------------rs.wasNull()-------------------");
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public void nullSafeSet(PreparedStatement arg0, Object arg1, int arg2)
			throws HibernateException, SQLException {
		
		if (null == arg1) {
			arg0.setNull(arg2, Types.VARCHAR);
		} else {
			// 将枚举转换成为字符串
			arg0.setString(arg2, ((Enum) arg1).name());
		}
	}

	@Override
	public Object replace(Object arg0, Object arg1, Object arg2)
			throws HibernateException {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public Class returnedClass() {
		// TODO Auto-generated method stub
		return this.clazz;
	}

	@Override
	public int[] sqlTypes() {
		// TODO Auto-generated method stub
		return this.SQL_TYPES;
	}
	
	public static void main(String[] args){
		
		UU<PaymentWay> uu=new UU<PaymentWay>(PaymentWay.class);
		
		System.out.println(uu.SQL_TYPES[0]);
		
		System.out.println(Enum.valueOf(PaymentWay.class, PaymentWay.ALIPAY.toString()));
		
		System.out.println(((Enum<PaymentWay>)PaymentWay.FINISH_PAY).name());
		
	}
	

}