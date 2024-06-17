import java.net.*;

/**
 * Lab 11: Cookie Manager with Adding, Getting, and Removing Cookies
 * Show an example of cookie Manager, Cookie store and its method to add, get, remove the cookies.
 */

public class CookieManagerExample {
    public static void main(String[] args) {
        System.out.println("Nikesh - Lab 11: Cookie Manager with Adding, Getting, and Removing Cookies\n");

        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cookieManager);
        String siteURl = "www.google.com";

        CookieStore cookieStore = cookieManager.getCookieStore();
        try {
            cookieStore.add(new URI(siteURl), new HttpCookie("fristName", "Nikesh"));
            cookieStore.add(new URI(siteURl), new HttpCookie("lastName", "Adhikari"));

            System.out.print("All Cookies: ");
            System.out.print(cookieStore.getCookies());

            cookieStore.remove(new URI(siteURl), cookieStore.getCookies().getFirst());

            System.out.println("\nURI after remove first: "+cookieStore.getCookies());

            cookieStore.removeAll();
            System.out.println("After remove all: "+ cookieStore.getCookies());



        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
