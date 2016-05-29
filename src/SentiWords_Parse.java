import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class SentiWords_Parse {
	
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("/home/kanv/Sem6/Additional_Project/Features/SentiWordNet");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
        String line;
        while((line=br.readLine())!=null)
        {
        	String[] s=line.split("\t");
        	if (s[2].length()==0 || s[3].length()==0 )continue;
        	double pos=Double.parseDouble(s[2]);
        	double neg=Double.parseDouble(s[3]);
        	//System.out.println("positive: "+ s[2] + ", " + "negative: " + s[3]);
        	if(pos>neg)//pos
        	{
        		//System.out.println(s[4]);
        		String[] words= s[4].split(" ");
        		for(int i=0;i<words.length;i++)
        		{
        			int x=words[i].indexOf("#");
        			String word=words[i].substring(0,x);
        			System.out.println(word);
        			Global.file_append("/home/kanv/Sem6/Additional_Project/Features/pos_senti.txt",word + " "+ pos);
        		}
        		//Global.file_append("", );
        	}
        	if(pos<neg)
        	{
        		
            		//System.out.println(s[4]);
            		String[] words= s[4].split(" ");
            		for(int i=0;i<words.length;i++)
            		{
            			int x=words[i].indexOf("#");
            			String word=words[i].substring(0,x);
            			System.out.println(word);
            			Global.file_append("/home/kanv/Sem6/Additional_Project/Features/neg_senti.txt",word + " "+neg );
            		}
            		//Global.file_append("", );
        	}
        }
	}
}