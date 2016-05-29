import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClassDistribution {
	
	public static void main(String[] Args) throws IOException{
		FileInputStream fis = new FileInputStream("/home/kanv/Sem6/Additional_Project/JNU/Tweets/JNU_4970_Annotations.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
        String line;
        double c1=0,c2=0,c3=0,c4=0,c5=0;
        while((line = br.readLine())!=null)
        {
        	String cls=line.trim();
        	if(cls.equals("ct+"))
        		c1++;
        	if(cls.equals("ct-"))
        		c2++;
        	if(cls.equals("pr+"))
        		c3++;
        	if(cls.equals("pr-"))
        		c4++;
        	if(cls.equals("uu"))
        		c5++;	
        }
        System.out.println("ct+ : "+ (c1/4970)*100);
        System.out.println("ct- : "+ (c2/4970)*100);
        System.out.println("pr+ : "+ (c3/4970)*100);
        System.out.println("pr- : "+ (c4/4970)*100);
        System.out.println("uu : "+ (c5/4970)*100);
	}
}
