import java.io.*;
import java.util.*;
public class Feature_Vector {
	
	public static HashMap<String,String> bigram_dict=new HashMap<String,String>();
	public static HashMap<String,Double> posSenti=new HashMap<String,Double>();
	public static HashMap<String,Double> negSenti=new HashMap<String,Double>();
	
	
	public static HashMap<String,String> nrcHindiNegative=new HashMap<String,String>();
	public static HashMap<String,String> nrcHindiPositive=new HashMap<String,String>();
	public static HashMap<String,String> nrc_anger=new HashMap<String,String>();
	public static HashMap<String,String> nrc_anticipation=new HashMap<String,String>();
	public static HashMap<String,String> nrc_disgust=new HashMap<String,String>();
	public static HashMap<String,String> nrc_fear=new HashMap<String,String>();
	public static HashMap<String,String> nrc_joy=new HashMap<String,String>();
	public static HashMap<String,String> nrc_negative=new HashMap<String,String>();
	public static HashMap<String,String> nrc_positive=new HashMap<String,String>();
	public static HashMap<String,String> nrc_sadness=new HashMap<String,String>();
	public static HashMap<String,String> nrc_surprise=new HashMap<String,String>();
	public static HashMap<String,String> nrc_trust=new HashMap<String,String>();
	//public static HashMap<String,String> tweet_class=new HashMap<String,String>();
	public static String[] cls_tag=new String[4971];

	public static void features()
	{
		int x=1;
		Global.file_append("/home/kanv/workspace/tweets_req/JNU/Tweets/vector_jnu4970Bigram_lessNRCSenti.arff", "@relation Features");
		try
        {
            FileInputStream fis = new FileInputStream("/home/kanv/workspace/tweets_req/JNU/Tweets/biagram_less_200.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
            String line;
            //bigrams
            bigram_dict.clear();
            while((line = br.readLine())!=null)
            {
            	line=line.substring(0,line.indexOf(":")).trim();
            	//System.out.println(line);
            	bigram_dict.put(line, " ");
            }
			int s1=bigram_dict.size();
            while(x<=s1)
            {
            	Global.file_append("/home/kanv/workspace/tweets_req/JNU/Tweets/vector_jnu4970Bigram_lessNRCSenti.arff", "@ATTRIBUTE word"+(x)+"  NUMERIC");
            	x++;
            }
            x--;
            //for pos/neg
            //Global.file_append("/home/kanv/workspace/tweets_req/JNU/Tweets/vector_jnu4970BigramSentiNRC", "@ATTRIBUTE word"+(x)+"  NUMERIC");
            fis.close();
            System.out.println(bigram_dict.size()+" "+x);
            
            //sentiwords
            /*line="";
            FileInputStream fis2 = new FileInputStream("/home/kanv/workspace/tweets_req/JNU/Tweets/pos_senti.txt");
            BufferedReader br2 = new BufferedReader(new InputStreamReader(fis2,"UTF-8"));
            while((line = br2.readLine())!=null)
            {
            	line=line.trim();
            	String[] val=line.split(" ");
            	//System.out.println(line);
            	posSenti.put(val[0].trim(), Double.parseDouble(val[1]));
            }
            fis2.close();*/
            //int s2=sentiwords_dict.size();
            /*while(x<=(s1+s2))
            {
            	Global.file_append("/home/kanv/workspace/tweets_req/JNU/Tweets/vector_jnu4970BigramSenti", "@ATTRIBUTE word"+(x)+"  NUMERIC");
			    x++;
            }
            fis2.close();
            System.out.println(sentiwords_dict.size()+" "+x);*/
            
            /*line="";
            FileInputStream fis3 = new FileInputStream("/home/kanv/workspace/tweets_req/JNU/Tweets/neg_senti.txt");
            BufferedReader br3 = new BufferedReader(new InputStreamReader(fis3,"UTF-8"));
            while((line = br3.readLine())!=null)
            {
            	line=line.trim();
            	String[] val=line.split(" ");
            	//System.out.println(line);
            	negSenti.put(val[0].trim(), Double.parseDouble(val[1]));
            }
            fis3.close();*/
            
            //NRC emotion features....
            //nrc_anger
            line="";
            FileInputStream fis4 = new FileInputStream("/home/kanv/Sem6/Additional_Project/NRC-Emotion-Lexicon-v0.92/NRC-Emotion-Lexicon-v0.92/NRC_anger");
            BufferedReader br4 = new BufferedReader(new InputStreamReader(fis4,"UTF-8"));
            while((line = br4.readLine())!=null)
            {
            	line=line.trim();
            	//System.out.println(line);
            	nrc_anger.put(line, "");
            }
            Global.file_append("/home/kanv/workspace/tweets_req/JNU/Tweets/vector_jnu4970Bigram_lessNRCSenti.arff", "@ATTRIBUTE word"+(x+1)+"  NUMERIC");
            fis4.close();
            
            //nrc_anticipation
            FileInputStream fis5 = new FileInputStream("/home/kanv/Sem6/Additional_Project/NRC-Emotion-Lexicon-v0.92/NRC-Emotion-Lexicon-v0.92/NRC_anticipation");
            BufferedReader br5 = new BufferedReader(new InputStreamReader(fis5,"UTF-8"));
            while((line = br5.readLine())!=null)
            {
            	line=line.trim();
            	//System.out.println(line);
            	nrc_anticipation.put(line, "");
            }
            Global.file_append("/home/kanv/workspace/tweets_req/JNU/Tweets/vector_jnu4970Bigram_lessNRCSenti.arff", "@ATTRIBUTE word"+(x+2)+"  NUMERIC");
            fis5.close();
            
            //nrc_disgust
            FileInputStream fis6 = new FileInputStream("/home/kanv/Sem6/Additional_Project/NRC-Emotion-Lexicon-v0.92/NRC-Emotion-Lexicon-v0.92/NRC_disgust");
            BufferedReader br6 = new BufferedReader(new InputStreamReader(fis6,"UTF-8"));
            while((line = br6.readLine())!=null)
            {
            	line=line.trim();
            	//System.out.println(line);
            	nrc_disgust.put(line, "");
            }
            Global.file_append("/home/kanv/workspace/tweets_req/JNU/Tweets/vector_jnu4970Bigram_lessNRCSenti.arff", "@ATTRIBUTE word"+(x+3)+"  NUMERIC");
            fis6.close();
            
            //nrc_fear
            FileInputStream fis7 = new FileInputStream("/home/kanv/Sem6/Additional_Project/NRC-Emotion-Lexicon-v0.92/NRC-Emotion-Lexicon-v0.92/NRC_fear");
            BufferedReader br7 = new BufferedReader(new InputStreamReader(fis7,"UTF-8"));
            while((line = br7.readLine())!=null)
            {
            	line=line.trim();
            	//System.out.println(line);
            	nrc_fear.put(line, "");
            }
            Global.file_append("/home/kanv/workspace/tweets_req/JNU/Tweets/vector_jnu4970Bigram_lessNRCSenti.arff", "@ATTRIBUTE word"+(x+4)+"  NUMERIC");
            fis7.close();
            
            //nrc_joy
            FileInputStream fis8 = new FileInputStream("/home/kanv/Sem6/Additional_Project/NRC-Emotion-Lexicon-v0.92/NRC-Emotion-Lexicon-v0.92/NRC_joy");
            BufferedReader br8 = new BufferedReader(new InputStreamReader(fis8,"UTF-8"));
            while((line = br8.readLine())!=null)
            {
            	line=line.trim();
            	//System.out.println(line);
            	nrc_joy.put(line, "");
            }
            Global.file_append("/home/kanv/workspace/tweets_req/JNU/Tweets/vector_jnu4970Bigram_lessNRCSenti.arff", "@ATTRIBUTE word"+(x+5)+"  NUMERIC");
            fis8.close();
            
            //nrc_negative
            FileInputStream fis9 = new FileInputStream("/home/kanv/Sem6/Additional_Project/NRC-Emotion-Lexicon-v0.92/NRC-Emotion-Lexicon-v0.92/NRC_negative");
            BufferedReader br9 = new BufferedReader(new InputStreamReader(fis9,"UTF-8"));
            while((line = br9.readLine())!=null)
            {
            	line=line.trim();
            	//System.out.println(line);
            	nrc_negative.put(line, "");
            }
            Global.file_append("/home/kanv/workspace/tweets_req/JNU/Tweets/vector_jnu4970Bigram_lessNRCSenti.arff", "@ATTRIBUTE word"+(x+6)+"  NUMERIC");
            fis9.close();
            
            //nrc_positive
            FileInputStream fis10 = new FileInputStream("/home/kanv/Sem6/Additional_Project/NRC-Emotion-Lexicon-v0.92/NRC-Emotion-Lexicon-v0.92/NRC_positive");
            BufferedReader br10 = new BufferedReader(new InputStreamReader(fis10,"UTF-8"));
            while((line = br10.readLine())!=null)
            {
            	line=line.trim();
            	//System.out.println(line);
            	nrc_positive.put(line, "");
            }
            Global.file_append("/home/kanv/workspace/tweets_req/JNU/Tweets/vector_jnu4970Bigram_lessNRCSenti.arff", "@ATTRIBUTE word"+(x+7)+"  NUMERIC");
            fis10.close();
            
            //nrc_sadness
            FileInputStream fis11 = new FileInputStream("/home/kanv/Sem6/Additional_Project/NRC-Emotion-Lexicon-v0.92/NRC-Emotion-Lexicon-v0.92/NRC_sadness");
            BufferedReader br11 = new BufferedReader(new InputStreamReader(fis11,"UTF-8"));
            while((line = br11.readLine())!=null)
            {
            	line=line.trim();
            	//System.out.println(line);
            	nrc_sadness.put(line, "");
            }
            Global.file_append("/home/kanv/workspace/tweets_req/JNU/Tweets/vector_jnu4970Bigram_lessNRCSenti.arff", "@ATTRIBUTE word"+(x+8)+"  NUMERIC");
            fis11.close();
            
            //nrc_surprise
            FileInputStream fis12 = new FileInputStream("/home/kanv/Sem6/Additional_Project/NRC-Emotion-Lexicon-v0.92/NRC-Emotion-Lexicon-v0.92/NRC_surprise");
            BufferedReader br12 = new BufferedReader(new InputStreamReader(fis12,"UTF-8"));
            while((line = br12.readLine())!=null)
            {
            	line=line.trim();
            	//System.out.println(line);
            	nrc_sadness.put(line, "");
            }
            Global.file_append("/home/kanv/workspace/tweets_req/JNU/Tweets/vector_jnu4970Bigram_lessNRCSenti.arff", "@ATTRIBUTE word"+(x+9)+"  NUMERIC");
            fis12.close();
            
            //nrc_trust
            FileInputStream fis13 = new FileInputStream("/home/kanv/Sem6/Additional_Project/NRC-Emotion-Lexicon-v0.92/NRC-Emotion-Lexicon-v0.92/NRC_trust");
            BufferedReader br13 = new BufferedReader(new InputStreamReader(fis13,"UTF-8"));
            while((line = br13.readLine())!=null)
            {
            	line=line.trim();
            	//System.out.println(line);
            	nrc_trust.put(line, "");
            }
            Global.file_append("/home/kanv/workspace/tweets_req/JNU/Tweets/vector_jnu4970Bigram_lessNRCSenti.arff", "@ATTRIBUTE word"+(x+10)+"  NUMERIC");
            fis13.close();
            
            //nrcHindiNegative
            FileInputStream fis14 = new FileInputStream("/home/kanv/workspace/tweets_req/JNU/Tweets/nrcHindiPositive.txt");
            BufferedReader br14 = new BufferedReader(new InputStreamReader(fis14,"UTF-8"));
            while((line = br14.readLine())!=null)
            {
            	line=line.trim();
            	//System.out.println(line);
            	nrcHindiPositive.put(line, "");
            }
            Global.file_append("/home/kanv/workspace/tweets_req/JNU/Tweets/vector_jnu4970Bigram_lessNRCSenti.arff", "@ATTRIBUTE word"+(x+11)+"  NUMERIC");
            fis14.close();
            
            //nrcHindiNegative
            FileInputStream fis15 = new FileInputStream("/home/kanv/workspace/tweets_req/JNU/Tweets/nrcHindiNegative.txt");
            BufferedReader br15 = new BufferedReader(new InputStreamReader(fis15,"UTF-8"));
            while((line = br15.readLine())!=null)
            {
            	line=line.trim();
            	//System.out.println(line);
            	nrcHindiNegative.put(line, "");
            }
            Global.file_append("/home/kanv/workspace/tweets_req/JNU/Tweets/vector_jnu4970Bigram_lessNRCSenti.arff", "@ATTRIBUTE word"+(x+12)+"  NUMERIC");
            fis15.close();
        
        }catch(IOException f){}    
	}
	
	public static void main(String[] args)
	{
		
		features();
		Global.file_append("/home/kanv/workspace/tweets_req/JNU/Tweets/vector_jnu4970Bigram_lessNRCSenti.arff", "@ATTRIBUTE class {ct+,ct-,pr+,pr-,uu}");
		Global.file_append("/home/kanv/workspace/tweets_req/JNU/Tweets/vector_jnu4970Bigram_lessNRCSenti.arff", "@Data");
		
		//Map<String, String> treeMap = new TreeMap<String, String>(dict);
		
		//File folder = new File("/home/kanv/Sem5/IR/IR_project/Hindi_Tweets");
		//File[] listOfFiles = folder.listFiles();
		
		//for (File file : listOfFiles) 
		//{
		  //  if (file.isFile()) 
		   // {
		        //System.out.println(file.getName());
		    	String row="";
		        try
		        {
		        	//reading annotated class tags from file....
		        	String line;
		            FileInputStream fis2 = new FileInputStream("/home/kanv/Sem6/Additional_Project/JNU/Tweets/JNU_4970_Annotations.txt");
		            BufferedReader br2 = new BufferedReader(new InputStreamReader(fis2,"UTF-8"));
		            int k=1;
		            while((line = br2.readLine())!=null)
		            {
		            	String tag=line.trim().toLowerCase();
		            	//int tg=-1;
		            	if(tag.equals("ct+"))
		            		cls_tag[k]="ct+";
		            		//tg=0;
		            	else if(tag.equals("ct-"))
		            		cls_tag[k]="ct-";
		            		//tg=1;
		            	else if(tag.equals("pr+"))
		            		cls_tag[k]="pr+";
		            		//tg=2;
		            	else if(tag.equals("pr-"))
		            		cls_tag[k]="pr-";
		            		//tg=3;
		            	else if(tag.equals("uu"))
		            		cls_tag[k]="uu";
		            	k++;
		            		//tg=4;
		            }
		        
		            
		            //br.close();
		            //fis.close();
		            //creating vector
		            //System.out.println(cls_tag.length);
		            //for(int dd = 0 ; dd < cls_tag.length ; dd ++)
		            //	System.out.println(cls_tag[dd]);
		            FileInputStream fis3 = new FileInputStream("/home/kanv/workspace/tweets_req/JNU/Tweets/JNU_4970.txt");
		            BufferedReader br3 = new BufferedReader(new InputStreamReader(fis3,"UTF-8"));
		            int cnt=1;
		            while((line = br3.readLine())!=null)
		            {
		            	row="";//for each tweet
		            	//String splitter[];
		            	//splitter=line.split("\t");
		           
		            	//System.out.println(splitter[1]);
		            	String tweet=Twokenize.tokenized(line).trim();
		            	String words[]=line.split(" ");
		            	//int c=0;
		            	//System.out.println(dict.size());
		            	for (Map.Entry<String, String> entry : bigram_dict.entrySet())
						{
						    //System.out.println(entry.getKey()+" : "+entry.getValue());
		            		
						    String x=entry.getKey();
						    //System.out.println(x);
						    if(tweet.contains(x))//if bigram present in tweet
						    {
						    	row+="1,";
						    }
						    else
						    {
						    	row+="0,";
						    }
						    //c++;
						    
						}
		            	/*double pos=0,neg=0;
		            	for (Map.Entry<String, Double> entry : posSenti.entrySet())
						{
						    //System.out.println(entry.getKey()+" : "+entry.getValue());
		            		
						    String x=entry.getKey();
						    //System.out.println(x);
						    if(tweet.contains(x))//if positive sentiword present in tweet
						    {
						    	pos+=entry.getValue();
						    	//row+="1,";
						    }  
						}
		            	
		            	for (Map.Entry<String, Double> entry : negSenti.entrySet())
						{
						    //System.out.println(entry.getKey()+" : "+entry.getValue());
		            		
						    String x=entry.getKey();
						    //System.out.println(x);
						    if(tweet.contains(x))//if positive sentiword present in tweet
						    {
						    	neg+=entry.getValue();
						    	//row+="1,";
						    }  
						}
		            	
		            	if(pos>neg)row+="1,";//pos tweet
		            	else if(pos<neg)row+="0,";//neg tweet
		            	else continue;//neutral tweet */
		            	
		            	//nrc emotions...
		            	int anger=0,anticip=0,disgust=0,fear=0,joy=0,negative=0,positive=0,sadness=0;
		            	int surprise=0,trust=0;
		            	for (Map.Entry<String, String> entry : nrc_anger.entrySet())
						{
						    //System.out.println(entry.getKey()+" : "+entry.getValue());
		            		
						    String x=entry.getKey();
						    //System.out.println(x);
						    if(tweet.contains(x))//if nrc_anger found present in tweet
						    {   	
						    	row+="1,";
						    	anger=1;
						    	break;
						    }
						}
		            	if(anger==0)row+="0,";
		            	
		            	for (Map.Entry<String, String> entry : nrc_anticipation.entrySet())
						{
						    //System.out.println(entry.getKey()+" : "+entry.getValue());
		            		
						    String x=entry.getKey();
						    //System.out.println(x);
						    if(tweet.contains(x))//if nrc_anticipation found present in tweet
						    {   	
						    	row+="1,";
						    	anticip=1;
						    	break;
						    }
						}
		            	if(anticip==0)row+="0,";
		            	
		            	for (Map.Entry<String, String> entry : nrc_disgust.entrySet())
						{
						    //System.out.println(entry.getKey()+" : "+entry.getValue());
		            		
						    String x=entry.getKey();
						    //System.out.println(x);
						    if(tweet.contains(x))//if nrc_disgust found present in tweet
						    {   	
						    	row+="1,";
						    	disgust=1;
						    	break;
						    }
						}
		            	if(disgust==0)row+="0,";
		            	
		            	for (Map.Entry<String, String> entry : nrc_fear.entrySet())
						{
						    //System.out.println(entry.getKey()+" : "+entry.getValue());
		            		
						    String x=entry.getKey();
						    //System.out.println(x);
						    if(tweet.contains(x))//if nrc_fear found present in tweet
						    {   	
						    	row+="1,";
						    	fear=1;
						    	break;
						    }
						}
		            	if(fear==0)row+="0,";
		            	
		            	for (Map.Entry<String, String> entry : nrc_joy.entrySet())
						{
						    //System.out.println(entry.getKey()+" : "+entry.getValue());
		            		
						    String x=entry.getKey();
						    //System.out.println(x);
						    if(tweet.contains(x))//if nrc_joy found present in tweet
						    {   	
						    	row+="1,";
						    	joy=1;
						    	break;
						    }
						}
		            	if(joy==0)row+="0,";
		            	
		            	for (Map.Entry<String, String> entry : nrc_negative.entrySet())
						{
						    //System.out.println(entry.getKey()+" : "+entry.getValue());
		            		
						    String x=entry.getKey();
						    //System.out.println(x);
						    if(tweet.contains(x))//if nrc_negative found present in tweet
						    {   	
						    	row+="1,";
						    	negative=1;
						    	break;
						    }
						}
		            	if(negative==0)row+="0,";
		            	
		            	for (Map.Entry<String, String> entry : nrc_positive.entrySet())
						{
						    //System.out.println(entry.getKey()+" : "+entry.getValue());
		            		
						    String x=entry.getKey();
						    //System.out.println(x);
						    if(tweet.contains(x))//if nrc_positive found present in tweet
						    {   	
						    	row+="1,";
						    	positive=1;
						    	break;
						    }
						}
		            	if(positive==0)row+="0,";
		            	
		            	for (Map.Entry<String, String> entry : nrc_sadness.entrySet())
						{
						    //System.out.println(entry.getKey()+" : "+entry.getValue());
		            		
						    String x=entry.getKey();
						    //System.out.println(x);
						    if(tweet.contains(x))//if nrc_sadness found present in tweet
						    {   	
						    	row+="1,";
						    	sadness=1;
						    	break;
						    }
						}
		            	if(sadness==0)row+="0,";
		            	
		            	for (Map.Entry<String, String> entry : nrc_surprise.entrySet())
						{
						    //System.out.println(entry.getKey()+" : "+entry.getValue());
		            		
						    String x=entry.getKey();
						    //System.out.println(x);
						    if(tweet.contains(x))//if nrc_surprise found present in tweet
						    {   	
						    	row+="1,";
						    	surprise=1;
						    	break;
						    }
						}
		            	if(surprise==0)row+="0,";
		            	
		            	for (Map.Entry<String, String> entry : nrc_trust.entrySet())
						{
						    //System.out.println(entry.getKey()+" : "+entry.getValue());
		            		
						    String x=entry.getKey();
						    //System.out.println(x);
						    if(tweet.contains(x))//if nrc_trust found present in tweet
						    {   	
						    	row+="1,";
						    	trust=1;
						    	break;
						    }
						}
		            	if(trust==0)row+="0,";
		            	
		            	int sc_neg=0,sc_pos=0;
		            	for (Map.Entry<String, String> entry : nrcHindiNegative.entrySet())
						{
						    //System.out.println(entry.getKey()+" : "+entry.getValue());
		            		
						    String x=entry.getKey();
						    //System.out.println(x);
						    if(tweet.contains(x))//if nrc_trust found present in tweet
						    {   	
						    	 sc_neg++;
						    	//row+="1,";
						    	//trust=1;
						    	//break;
						    }
						}
		            	for (Map.Entry<String, String> entry : nrcHindiPositive.entrySet())
						{
						    //System.out.println(entry.getKey()+" : "+entry.getValue());
		            		
						    String x=entry.getKey();
						    //System.out.println(x);
						    if(tweet.contains(x))//if nrc_trust found present in tweet
						    {   	
						    	 sc_pos++;
						    	//row+="1,";
						    	//trust=1;
						    	//break;
						    }
						}
		            	
		            	//row+=Integer.toString(sc_pos-sc_neg)+',';
		            	if(sc_pos > sc_neg) row+="1,";
		            	else row+="0,";
		            	String cls=cls_tag[cnt];
		            	System.out.println(cls_tag[cnt] + " SentiScore: " + (sc_pos-sc_neg));
		            	Global.file_append("/home/kanv/workspace/tweets_req/JNU/Tweets/vector_jnu4970Bigram_lessNRCSenti.arff", row+cls);
		            	//if(cnt==4970)break;
		            	cnt++;
		            	//System.out.println(row);
		            }
		            fis3.close();
		            br3.close();
		            
		        }
		        catch(IOException f){} 
		  	
		   // }
		//}//end of for
	}//end of main()
	
	/*public static TreeMap<String, Integer> SortByValue (HashMap<String, Integer> map) 
	{
		ValueComparator vc =  new ValueComparator(map);
		TreeMap<String,Integer> sortedMap = new TreeMap<String,Integer>(vc);
		sortedMap.putAll(map);
		return sortedMap;
	}*/
	
	
}

/*class ValueComparator implements Comparator<String> 
{
	 
    Map<String, Double> map;
 
    public ValueComparator(Map<String, Double> base) {
        this.map = base;
    }
 
    public int compare(String a, String b) {
        if (map.get(a) >= map.get(b)) {
            return -1;
        } else {
            return 1;
        } // returning 0 would merge keys 
    }
}*/