package glasswareserviceimpl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import glasswaredata.FaceBook;
import glasswaredata.User;
import glasswareservice.UserService;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class FaceBookServiceImpl implements UserService {

	private FaceBook user;
	
	public User getInfo(String name){
		//WHATEVER PRIVATE PROCESSING YOU NEED
		String html = getHtml(name);
		//do something to populate stuff from html to actual object
		this.user = htmlparser(html);
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
	
	public FaceBook htmlparser(String html){
		Document doc = Jsoup.parse(html);		
		//System.out.println(html);
		Elements the_elements = doc.getElementsByClass("pls");
		Element first_result = the_elements.first();
		FaceBook user = new FaceBook("not found");
		
		if (first_result != null){
			/*
			first_result.text().split();
			user.setName();
			user.setAbout(about);
			System.out.println(first_result.text());
			*/
		}
		
		return user;
	}
}
