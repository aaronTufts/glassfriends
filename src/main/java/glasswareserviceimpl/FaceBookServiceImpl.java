package glasswareserviceimpl;

import glasswaredata.FaceBook;
import glasswaredata.User;
import glasswareservice.UserService;

public class FaceBookServiceImpl implements UserService {

	private FaceBook user;
	
	public User getInfo(String name){
		this.user = new FaceBook(name);
		//WHATEVER PRIVATE PROCESSING YOU NEED
		return this.user;
	}
}
