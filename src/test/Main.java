package test;

import com.securedsigning.rest.client.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        String serviceUrl="https://api.securedsigning.com/web";
        String version="v1.3";
        String apiKey = "YOUR API KEY";
        String secret = "YOUR API Secret";
        String host = "YOUR Access URL";

        ServiceClient restClient = new ServiceClient(serviceUrl,version,apiKey, secret, host);

        try {
            ArrayList<dto.Document> docs =restClient.getActiveDocuments("InBox");
            System.out.print(docs.size());
        } catch (Exception e) {
            System.out.println(e.getMessage() + "\n");
        } finally {
            System.exit(0);
        }
        return;
    }
}