import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Getting_urls {

	public static HashMap<String,String> URLS=new HashMap<String,String>();
	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream("/home/kanv/workspace/tweets_req/Pathankot/Tweets/Pathankot_200_POS.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
        String line;
        while((line = br.readLine())!=null)
        {
        	line=line.trim();
        	line=Twokenize.tokenized(line);
        	String words[]=line.split(" ");
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
                		System.out.println(y);
                		Global.file_append("Pathankot/URLs/Pathankot_URLS.txt",y);
                	}
        		}
        	}
        }
        System.out.println("# URL's: "+URLS.size());
	}

}

