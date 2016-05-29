import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.nio.channels.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.text.AttributeSet;
import javax.swing.text.html.*;
import javax.swing.text.html.parser.*;

import org.w3c.dom.NodeList;

import twitter4j.*;


public class Download_URL {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		int count=1;
		try
        {	
            FileInputStream fis = new FileInputStream("JNU/URLs/JNU_URLS.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fis,"UTF-8"));
            String line;
            while((line = br.readLine())!=null)
            {
            	//URLEntity ccc=new URLURLEntity();
            	line=expandShortURL(line);
            	System.out.println(line);
            	//downloadFileFromURL(line, "Pathankot/"+count+".html");
            	download_images(line);
            	count++;
            }
            fis.close();
        }catch(IOException f){}   
	}
	public static void download_images(String fname) 
	{
        /*String str=Global.file_read(fname);
        
        int k=str.indexOf(".jpg",0);
        while(k>0)
        {
        	int l=str.lastIndexOf("\"", k)+1;
        	System.out.println(str.substring(l, k+4));
        	k=str.indexOf(".jpg",k+4);
        }*/
		
		try
		{
			String webUrl = fname;
	        URL url = new URL(webUrl);
	        URLConnection connection = url.openConnection();
	        InputStream is = connection.getInputStream();
	        InputStreamReader isr = new InputStreamReader(is);
	        BufferedReader br = new BufferedReader(isr);
	
	        HTMLEditorKit htmlKit = new HTMLEditorKit();
	        HTMLDocument htmlDoc = (HTMLDocument) htmlKit.createDefaultDocument();
	        HTMLEditorKit.Parser parser = new ParserDelegator();
	        HTMLEditorKit.ParserCallback callback = htmlDoc.getReader(0);
	        parser.parse(br, callback, true);
	
	        for (HTMLDocument.Iterator iterator = htmlDoc.getIterator(HTML.Tag.IMG); iterator.isValid(); iterator.next()) 
	        {
	            AttributeSet attributes = iterator.getAttributes();
	            String imgSrc = (String) attributes.getAttribute(HTML.Attribute.SRC);
	        	System.out.println("#####"+imgSrc);
	
	
	            if (imgSrc != null && (imgSrc.endsWith(".jpg") || (imgSrc.endsWith(".png")) || (imgSrc.endsWith(".jpeg")) || (imgSrc.endsWith(".bmp")) || (imgSrc.endsWith(".ico")))) 
	            {
	                try 
	                {
	                	//System.out.println("*****"+webUrl);
	                    downloadImage(webUrl, imgSrc);
	                } catch (IOException ex) 
	                {
	                    //System.out.println(ex.getMessage());
	                }
	            }
	        }
		}catch(Exception e)
		{
			System.out.println(e);
		}
    }
	public static void downloadImage(String url, String imgSrc) throws IOException 
	{
        BufferedImage image = null;
        try {
            if (!(imgSrc.startsWith("http"))) {
                url = url + imgSrc;
            } else {
                url = imgSrc;
            }
            imgSrc = imgSrc.substring(imgSrc.lastIndexOf("/") + 1);
            String imageFormat = null;
            imageFormat = imgSrc.substring(imgSrc.lastIndexOf(".") + 1);
            String imgPath = null;
            imgPath = "JNU/Images/" + imgSrc + "";
            URL imageUrl = new URL(url);
            image = ImageIO.read(imageUrl);
            if (image != null) {
                File file = new File(imgPath);
                ImageIO.write(image, imageFormat, file);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
	public static String expandShortURL(String address) throws IOException 
	{
        URL url = new URL(address);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection(Proxy.NO_PROXY); //using proxy may increase latency
        connection.setInstanceFollowRedirects(false);
        connection.connect();
        String expandedURL = connection.getHeaderField("Location");
        connection.getInputStream().close();
        return expandedURL;
    }

	public static void downloadFileFromURL(String urlString, String fname) 
	{
		try 
		{
            URL website = new URL(urlString);
            File destination=new File(fname);
            ReadableByteChannel rbc;
            rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(destination);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
            rbc.close();
        } 
		catch (IOException e) {
            e.printStackTrace();
        }
    }
}