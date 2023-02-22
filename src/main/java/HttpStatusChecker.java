import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class HttpStatusChecker {
    private final CloseableHttpClient httpClient = HttpClients.createDefault();

    public String getStatusImage(int code) throws IOException {
        String Url = "https://http.cat/" + code;

        HttpGet request = new HttpGet(Url);

        try (CloseableHttpResponse response = httpClient.execute(request)) {
            String[] firstline = response.getStatusLine().toString().split(" ");
            int status = Integer.parseInt(firstline[1]);
            if (status == 404) {
                throw new IllegalArgumentException("page not found");
            }
            return Url;

        }
    }

    public void close() throws IOException {
        httpClient.close();
    }

}
