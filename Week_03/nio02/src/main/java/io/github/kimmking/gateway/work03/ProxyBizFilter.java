package io.github.kimmking.gateway.work03;

import io.github.kimmking.gateway.filter.HttpRequestFilter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaders;

/**
 * @author: 肖震
 * @date: 2021/1/30
 * @since:
 */
public class ProxyBizFilter implements HttpRequestFilter {
    public static ProxyBizFilter newInstance() {
        return new ProxyBizFilter();
    }

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        String uri = fullRequest.uri();
        System.out.println(" filter地址接收到的请求,url: " + uri);
        /*if (uri.startsWith("/hello")) {
            // 放过
        } else {
            throw new RuntimeException("不支持的uri:" + uri);
        }*/
        HttpHeaders headers = fullRequest.headers();
        if (headers == null) {
            headers = new DefaultHttpHeaders();
        }
        headers.add("mao", this.getClass().getSimpleName());
    }
}
