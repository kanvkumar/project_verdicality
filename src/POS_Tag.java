public class POS_Tag
{
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		RunTagger.tagger = new cmu.arktweetnlp.Tagger();		
		try
		{
			RunTagger.tagger.loadModel("POS_model/model.20120919");
			//RunTagger.tagger.loadModel("POS_model/model.irc.20121211");
		}
		catch(Exception e){System.err.println("POS Loading Error:"+e);e.printStackTrace();}
		
		String x=Flatten(RunTagger.run_POS("JNU/Tweets/JNU_4970.txt"));
		System.out.println(x);
		Global.file_append("JNU/Tweets/JNU_4970_POS.txt", x);
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