import java.io.*;
//import java.io.FileNotFoundException;
//import java.io.FileReader;

import com.sun.media.protocol.DataSource;
 
import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
 
public class KMeans {
	
	public static void main(String[] args) throws Exception {
		SimpleKMeans kMeans = new SimpleKMeans();
 
		kMeans.setSeed(10);
 
		BufferedReader reader = new BufferedReader(
        new FileReader("//home/kanv/Downloads/6.arff"));
		Instances dataa = new Instances(reader);


	   // create the model 
	   kMeans = new SimpleKMeans();
	   kMeans.setNumClusters(10);
	   kMeans.buildClusterer(dataa); 

	   // print out the cluster centroids
	   Instances centroids = kMeans.getClusterCentroids(); 
	   for (int i = 0; i < centroids.numInstances(); i++) 
	   { 
	   int len = centroids.numInstances();
	     System.out.println( "Centroid  is" + ": " + centroids.instance(i)); 
	   } 

	   // get cluster membership for each instance 
	 //  for (int i = 0; i < dataa.numInstances(); i++) { 
	   // System.out.println( dataa.instance(i) + " is in cluster " + kMeans.clusterInstance(dataa.instance(i))); 
	   //}
	   }
}