import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Chapter3 {
    public static void main(String[] args)  {
        try {
            URL url = new URL("https://desicinemas.tv/");
            System.out.println(url);

            URL url1 = new URL("http", "www.desicinemas.tv", "/abc.html");
            System.out.println(url1);

            URL url2 = new URL("http", "www.desicinemas.tv",8080, "/abc.html");
            System.out.println(url2);

            URL url3 = new URL(url, "/abc.html");
            System.out.println(url3);


            InputStream inputStream = url.openStream();
//            int c;
//            while ((c = inputStream.read()) != -1) {
//                System.out.print(c+ " ");
//            }
            inputStream.close();


            URLConnection urlConnection = url.openConnection();

            InputStream inputStream2 = urlConnection.getInputStream();
//            int d;
//            while ((d = inputStream2.read()) != -1) {
//                System.out.print(d+ " ");
//            }
            inputStream.close();

            Object o = url.getContent();
            System.out.println("\n\n"+o.toString());

            Class<InputStream>[] classes = new Class[3];
            classes[0] =  InputStream.class;
            InputStream inputStream3 = (InputStream) url.getContent(classes);
            System.out.println(inputStream3);

//            int e;
//            while ((e = inputStream3.read()) != -1) {
//                System.out.print(e+ " ");
//            }

            URL url4 = new URL("http://www.ibiblio.org/javafaq/books/jnp/index.html?isbn=1565922069#toc");
            System.out.println("host: "+ url4.getHost());
            System.out.println("protocol: "+url4.getProtocol());
            System.out.println("port: "+url4.getPort());
            System.out.println("file: "+url4.getFile());
            System.out.println("ref or fragment: "+url4.getRef());
            System.out.println("query: "+url4.getQuery());
            System.out.println("path: "+url4.getPath());
            System.out.println("userInfo: "+url4.getUserInfo());
            System.out.println("authority: "+url4.getAuthority());

            System.out.println("\ntestequal: "+url4.equals(url1));
            System.out.println("to Hash: "+url4.hashCode());
            System.out.println("to String: "+url4.toString());


        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
