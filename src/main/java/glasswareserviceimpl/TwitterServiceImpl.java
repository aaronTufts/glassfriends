package glasswareserviceimpl;

import glasswaredata.Twitter;
import glasswaredata.User;
import glasswareservice.UserService;

public class TwitterServiceImpl implements UserService {

	private Twitter user;
	
	public User getInfo(String name){
		this.user = new Twitter(name);
		//WHATEVER PRIVATE PROCESSING YOU NEED
		return this.user;
	}
}
