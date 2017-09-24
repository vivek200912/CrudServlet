import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UserDao {
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:mytestdb3","MYTESTDBUSER2","MYTESTDBUSER2");
		}catch(Exception e){System.out.println(e);}
		return con;
	}
	
	public static List<UserBean> getAllUsersAndPasswords(){
		List<UserBean> list=new ArrayList<UserBean>();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from dvusers");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				UserBean bean = new UserBean();
				bean.setName(rs.getString(1));
				bean.setPassword(rs.getString(2));
				list.add(bean);
			}
			rs.close();
			ps.close();
			con.close();
		}catch(Exception e){e.printStackTrace();}
		
		return list;
	}

	public static Boolean validateUser(String userName, String password) {
		List<UserBean> list = getAllUsersAndPasswords();
		for(UserBean bean:list){
			if(bean.getName().equals(userName)){
				if(bean.getPassword().equals(password)){
					return true;
				}
				else
					return false;
			}
		}
		return false;
	}
}
