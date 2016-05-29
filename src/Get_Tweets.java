import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import twitter4j.Paging;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

public class Get_Tweets 
{
	public static String consumerKey = "aNPM4QefkxvWzVal9qoTHdGcy";
	public static String consumerSecret = "o8aF3515lddr5IgnSp7hW4hELPB91GiHRyb019QigJH7YEuhPK";
	public static String token = "3067445095-RZFtI3ae0F9iztp6fOplgsU4ePjnAMeNug65YNp";
	public static String tokenSecret = "qjMcRfzDY0PAF7HchNyk6crXfIYhuzqR3pPXbxtcTtEXy";

	public static HashMap<String,String> twt_texts=new HashMap<String,String>();
	public static HashMap<String,String> URLS=new HashMap<String,String>();


	public static void main(String[] args) throws TwitterException 
	{
		RunTagger.tagger = new cmu.arktweetnlp.Tagger();		
		try
		{
			RunTagger.tagger.loadModel("POS_model/model.20120919");
		}catch(Exception e){System.err.println("POS Loading Error:"+e);e.printStackTrace();}
		
		//System.out.println(Flatten(RunTagger.run_POS("input.txt")));
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true)
		.setOAuthConsumerKey(consumerKey)
		.setOAuthConsumerSecret(consumerSecret)
		.setOAuthAccessToken(token)
		.setOAuthAccessTokenSecret(tokenSecret);
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();
		
		String word="JNU";
        //Query query = new Query("(I diagnosed depression) OR (I diagnosis depression) OR (I diagnosed depressed)");
        //Query query = new Query("(antidepressant) OR (dysthymia) OR (anxiety) OR (suicide) OR (psychotherapy therapy counseling)");
		//Query query = new Query("(france) OR (paris) AND (terrorist) OR (terrorism)");
		Query query = new Query("(JNU) AND (Kanhaiya)");
		//query.setUntil("2016-02-01");
		//Query query = new Query(word);

        boolean finished = false;
        while (!finished) 
        {
            QueryResult result = twitter.search(query);  

            List<Status> statuses = result.getTweets();
            for (Status status : statuses) 
            {
            	//if(status.getLang().equals("en"))
            	//{
                	System.out.println("Tweet:\t"+status.getId()+"\t"+status.getText().replaceAll("\n", " ").replaceAll("\r", "").trim());
                	//Global.file_append("Daniela_Words/"+word+".txt", status.getUser().getScreenName()+"\t"+status.getCreatedAt()+"\t"+status.getId()+"\t"+status.getText().replaceAll("\n", " ").replaceAll("\r", "").trim());
                	String x=status.getText().replaceAll("\n", " ").replaceAll("\r", "").trim();
                	x=Twokenize.tokenized(x);
                	Global.file_update("JNU/Tweets/input.txt", x);
                	x=Flatten(RunTagger.run_POS("JNU/Tweets/input.txt"));
                	System.out.println(x);
                	String words[]=x.split(" ");
                	
                	if(twt_texts.containsKey(x))
                	{
                		continue;
                	}
                	else
                	{
                		//twt_texts.put(status.getText().replaceAll("\n", " ").replaceAll("\r", "").trim(), "");
                		twt_texts.put(x, "");
                		Global.file_append("JNU/Tweets/JNU.txt",status.getId()+"\t"+x);
                	}
                	
                	for(int i=0;i<words.length;i++)
                	{
                		if(words[i].endsWith("/U"))
                		{
                			String y=words[i].substring(0, words[i].length()-2);
                			if(URLS.containsKey(y))
                        	{
                        		continue;
                        	}
                        	else//unique url
                        	{
                        		//twt_texts.put(status.getText().replaceAll("\n", " ").replaceAll("\r", "").trim(), "");
                        		URLS.put(y, "");
                        		Global.file_append("JNU/URLs/JNU_URLS.txt",y);
                        	}
                		}
                	}
                	
            	//}
            }
        }
	}
	public static String Flatten(String text)
	{
		//System.out.println("*****"+text);
		String out="";
		
		text=text.replaceAll("\t", "/");
		text=text.replaceAll("\n", " ");

		out=text.trim();
		
		//System.out.println("*****"+out);
		
		return out;
	}
}