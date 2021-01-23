package dome1;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;

/**
 * @author: 肖震
 * @date: 2021/1/22
 * @since:
 */
public class HttpClientDome {
    public static void main(String[] args) throws IOException, ParseException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        String url = "http://localhost:8801";
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(httpGet);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

}
