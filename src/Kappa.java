import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class Kappa {
	
	static String[] rajji = new String[500];
	static String[] kush=new String[500];
	static int[][] kappa_matrix = new int[6][6]; //CT+,CT-,PR+,PR-,PS+,PS-,Uu
	public static HashMap<String,Integer> mp=new HashMap<String,Integer>();//CT+:1,CT-:2.....
	
	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = new FileInputStream("/home/kanv/Sem6/Additional_Project/GetOldTweets-python-master/Rajji_JNU.txt");
        BufferedReader br1 = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
        String line;
        int k=1;
        while((line = br1.readLine())!=null)
        {
        	line=line.trim().toLowerCase();
        	rajji[k++]=line;
        }
        
        FileInputStream fis2 = new FileInputStream("/home/kanv/Sem6/Additional_Project/GetOldTweets-python-master/Kushal_JNU.txt");
        BufferedReader br2 = new BufferedReader(new InputStreamReader(fis2,"UTF-8"));
        k=1;
        while((line = br2.readLine())!=null)
        {
        	line=line.trim().toLowerCase();
        	kush[k++]=line;
        	//System.out.println(kush[k-1]);
        }
        
        mp.put("ct+", 1);mp.put("ct-", 2);mp.put("pr+", 3);mp.put("pr-", 4);
        //mp.put("ps+", 5);mp.put("ps-", 6);
        mp.put("uu", 5);
        //System.out.println("Size of Kush: " + kush.length);
        int k1,k2;
        for(int i=0;i<rajji.length;i++)
        {
        	String x=rajji[i];
        	String y=kush[i];
        	if(mp.get(x)!=null && mp.get(y)!=null)
        	{
        		k1=mp.get(x);k2=mp.get(y);
        		kappa_matrix[k1][k2]++;
        	}
        }
        int tsum=0,diag_sum=0,sum_i=0,sum_j=0;
        
        //tsum
        for(int i=1;i<=5;i++)
        {
        	for(int j=1;j<=5;j++)
        	{
        		if(i==j)
        			diag_sum+=kappa_matrix[i][j];
        		tsum+=kappa_matrix[i][j];
        	}
        }
        
        double[] probi=new double[6];//for col
        double[] probj=new double[6];//for row
        //sum_j
        double prob_j=0;//for row
        for(int i=1;i<=5;i++)
        {
        	sum_j=0;
        	for(int j=1;j<=5;j++)
        	{
        		sum_j+=kappa_matrix[i][j];
        	}
        	prob_j=((1.0)*sum_j)/((1.0)*tsum);
        	probj[i]=prob_j;
        }
        
        
        
        //sum_i
        double prob_i=0;//for col
        for(int j=1;j<=5;j++)
        {
        	sum_i=0;
        	for(int i=1;i<=5;i++)
        	{
        		sum_i+=kappa_matrix[i][j];
        	}
        	prob_i=((1.0)*sum_i)/((1.0)*tsum);
        	probi[j]=prob_i;
        }
        
        double pe=0;
        for(k=1;k<=5;k++)
        {
        	pe+=(probj[k])*(probi[k]);
        }
        double p0=((1.0)*diag_sum)/((1.0)*tsum);
        double kappa=(p0-pe)/(1-pe);
        for(int i=1;i<=5;i++)
        {
        	for(int j=1;j<=5;j++)
        		System.out.print(kappa_matrix[i][j]+" ");
        	System.out.println();
        }
        System.out.println("kappa: "+ kappa);
        
	}

}
