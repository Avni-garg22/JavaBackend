package mockitoo;


//our target is to isolate service becz just need unit testing(test only userService)
public class UserService {
//for creaking fake mock dao
	
	private UserDao dao;
	
	public UserService(UserDao dao) {
		this.dao=dao;
	}
	public String typeOfUser(int id) { //1
		
		//we want finById from mockito which is fake---mockito will create fake UserDao 
		
		User user=dao.findById(id);
		
		if(user.getBalance()>0 && user.getBalance()<=1000) {
			return "new user";
		}else if(user.getBalance()>=1001 && user.getBalance()<=2000) {
		return "regular user";
			}else {
				return "premium user";
	}
}
	
}
