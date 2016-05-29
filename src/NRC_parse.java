import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class NRC_parse {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("/home/kanv/Sem6/Additional_Project/NRC-Emotion-Lexicon-v0.92/NRC-Emotion-Lexicon-v0.92/NRC-emotion-lexicon");
        BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
        String line;
        while((line=br.readLine())!=null)
        {
        	String[] words=line.split("\t");
        	int val=Integer.parseInt(words[2]);
        	if(words[1].equals("anger") && val==1)
        	{
        		System.out.println("anger: "+words[0]);
        		Global.file_append("/home/kanv/Sem6/Additional_Project/NRC-Emotion-Lexicon-v0.92/NRC-Emotion-Lexicon-v0.92/NRC_anger", words[0]);
        	}
        	
            if(words[1].equals("anticipation") && val==1)
            {
            	System.out.println("anticipation: "+ words[0]);
            	Global.file_append("/home/kanv/Sem6/Additional_Project/NRC-Emotion-Lexicon-v0.92/NRC-Emotion-Lexicon-v0.92/NRC_anticipation", words[0]);
            }
            
            if(words[1].equals("disgust") && val==1)
            {
            	System.out.println("disgust: "+words[0]);
            	Global.file_append("/home/kanv/Sem6/Additional_Project/NRC-Emotion-Lexicon-v0.92/NRC-Emotion-Lexicon-v0.92/NRC_disgust", words[0]);
            }
            
            if(words[1].equals("fear") && val==1)
            {
            	System.out.println("fear: "+words[0]);
            	Global.file_append("/home/kanv/Sem6/Additional_Project/NRC-Emotion-Lexicon-v0.92/NRC-Emotion-Lexicon-v0.92/NRC_fear", words[0]);
            }
            
            if(words[1].equals("joy") && val==1)
            {
            	System.out.println("joy: "+words[0]);
            	Global.file_append("/home/kanv/Sem6/Additional_Project/NRC-Emotion-Lexicon-v0.92/NRC-Emotion-Lexicon-v0.92/NRC_joy", words[0]);
            }
            
            if(words[1].equals("negative") && val==1)
            {
            	System.out.println("negative: "+words[0]);
            	Global.file_append("/home/kanv/Sem6/Additional_Project/NRC-Emotion-Lexicon-v0.92/NRC-Emotion-Lexicon-v0.92/NRC_negative", words[0]);
            }
            
            if(words[1].equals("positive") && val==1)
            {
            	System.out.println("positive: "+words[0]);
            	Global.file_append("/home/kanv/Sem6/Additional_Project/NRC-Emotion-Lexicon-v0.92/NRC-Emotion-Lexicon-v0.92/NRC_positive", words[0]);
            }
            
            if(words[1].equals("sadness") && val==1)
            {
            	System.out.println("sadness: "+words[0]);
            	Global.file_append("/home/kanv/Sem6/Additional_Project/NRC-Emotion-Lexicon-v0.92/NRC-Emotion-Lexicon-v0.92/NRC_sadness", words[0]);
            }
            
            if(words[1].equals("surprise") && val==1)
            {
            	System.out.println("surprise: "+words[0]);
            	Global.file_append("/home/kanv/Sem6/Additional_Project/NRC-Emotion-Lexicon-v0.92/NRC-Emotion-Lexicon-v0.92/NRC_surprise", words[0]);
            }
            
            if(words[1].equals("trust") && val==1)
            {
            	System.out.println("trust: "+words[0]);
            	Global.file_append("/home/kanv/Sem6/Additional_Project/NRC-Emotion-Lexicon-v0.92/NRC-Emotion-Lexicon-v0.92/NRC_trust", words[0]);
            }
        }
	}
}
