package mockitopractice;


///Bussiness logic
public class UserService {
UserDao dao; //null

 public UserService(UserDao dao){ 
	//dao ref to perform logics
	this.dao=dao;
}
public String typeOfUser(int id) {
	
	User user=dao.findById(id);
	
	if(user.getBalance()>0 && user.getBalance()<=1000) {
		return "new User";
	}else if(user.getBalance()>1000 && user.getBalance()<=2000) {
		return "regular user";
	}else {
		return "premium user";
	}
}

}
