package glasswareserviceimpl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import glasswaredata.FaceBook;
import glasswaredata.User;
import glasswareservice.UserService;

public class FaceBookServiceImpl implements UserService {

	private FaceBook user;
	
	public User getInfo(String name){
		//WHATEVER PRIVATE PROCESSING YOU NEED
		String html = getHtml(name);
		//do something to populate stuff from html to actual object
		return this.user;
	}
	
	public String getHtml(String name) {
        try {
        	String encodedname = URLEncoder.encode(name,"UTF-8");
        	String url = "http://www.facebook.com/search.php?q=" + encodedname + "&amp;_fb_noscript=1";
			return Scraper.executeGet(url);
		} catch (UnsupportedEncodingException e) {
			System.out.println("could not encode parameters");
			e.printStackTrace();
	        return null;
		}
    }
	
}
