package dome1;


import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author: 肖震
 * @date: 2021/1/22
 * @since:
 */
public class OkHttpDemo {

    public static void main(String[] args) throws IOException {
        String url = "http://localhost:8801";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                   .url(url)
                   .get()
                   .build();
           final Call call = client.newCall(request);
            Response response = call.execute();
            System.out.println(response.body().string());
    }

}
