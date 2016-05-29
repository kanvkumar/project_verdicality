import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * http://blog.tomtasche.at/2011/07/how-to-expand-shortened-url-in-java.html
 * 
 * @author Thomas Taschauer
 *
 */
public class URLExpander 
{

     public static String expand(String url) 
     {
          try 
          {
               HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
               connection.setInstanceFollowRedirects(true);
               connection.getInputStream().read();
          } catch (MalformedURLException e) {
               e.printStackTrace();
          } catch (IOException e) {
               e.printStackTrace();
          }

          return null;
     }
}