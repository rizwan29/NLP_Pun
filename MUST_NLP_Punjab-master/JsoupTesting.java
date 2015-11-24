import java.io.IOException;

import org.apache.commons.validator.routines.UrlValidator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Scanner;
import java.util.ArrayList;   
import java.util.Collections;   
import java.util.Comparator;   
import java.util.Iterator;   
import java.util.LinkedHashSet;   
import java.util.List;   
import java.util.Map;   
import java.util.Set;   

import net.sf.classifier4J.Utilities;
import net.sf.classifier4J.summariser.ISummariser;
import net.sf.classifier4J.summariser.SimpleSummariser;

import java.net.SocketTimeoutException;

import net.sf.classifier4J.Utilities; 
public class JsoupTesting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    	UrlValidator urlValidator = new UrlValidator();
    	 String query,texty="",result="";
      Scanner in = new Scanner(System.in);
 		String[] mylink=new String[20];
      System.out.println("Enter query");
      query= in.nextLine();
      boolean valid;
      
      try{
      // Document doc = Jsoup.connect("https://www.google.com/search?q="+query).userAgent("Mozilla").ignoreHttpErrors(true).timeout(5000).get();
    		query = "https://www.google.com/search?q=" + java.net.URLEncoder.encode(query, "UTF-8");
    		Document doc = Jsoup.connect(query).userAgent("Mozilla").ignoreHttpErrors(true).timeout(5000).get();

       Elements titles = doc.select("h3.r > a");
       int i=0;
for(Element e: titles){
	
	
	String et;
	et=e.attr("href");
	
	et=et.replace("/url?q=","");
	et = et.split("&sa=U&ved=")[0];
	
    System.out.println("link: " +et);
    mylink[i]=et;
    i++;
  } 
  
  for(int j=0;j<5;j++)
  {
	String url="";
	url=mylink[j];
	System.out.println(mylink[j]);
	valid = urlValidator.isValid(url);
	System.out.println(url + " is "+valid );
	Document docscrap=null;
	if(valid){
		docscrap = Jsoup.connect(url).ignoreHttpErrors(true).get();
		 result = docscrap.text();
         texty=texty+result;
        System.out.println(result);
	}
    }}
    catch(SocketTimeoutException e){
    	System.out.println("check your net connectivity");
    }


    in.close();
}
    
    }

