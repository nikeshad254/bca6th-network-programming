import java.net.*;

public class Chapter4 {
    public static void main(String[] args) {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cookieManager);

        CookieStore cookieStore = cookieManager.getCookieStore();
        try {
            cookieStore.add(new URI("www.google.com"), new HttpCookie("fristName", "Nikesh"));
            cookieStore.add(new URI("www.google1.com"), new HttpCookie("lastName", "Adhikari"));

            System.out.print("All Cookies: ");
            for (int i = 0; i < cookieStore.getCookies().toArray().length; i++) {
                System.out.print(cookieStore.getCookies().get(i) + " , ");
            }

            System.out.println("\nCookie from google.com: "+ cookieStore.get(new URI("www.google.com")));

            System.out.println("All URIS: " + cookieStore.getURIs());


            cookieStore.remove(new URI("www.google.com"), cookieStore.getCookies().getFirst());

            System.out.println("URI after remove1: "+cookieStore.getCookies());

            cookieStore.removeAll();
            System.out.println("After remove all: "+ cookieStore.getCookies());



        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
