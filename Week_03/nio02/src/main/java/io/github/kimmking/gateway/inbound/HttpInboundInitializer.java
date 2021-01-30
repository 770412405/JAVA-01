package io.github.kimmking.gateway.inbound;


import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;

import java.util.List;

public class HttpInboundInitializer extends ChannelInitializer<SocketChannel> {
	
	private List<String> proxyServer;
	
	public HttpInboundInitializer(List<String> proxyServer) {
		this.proxyServer = proxyServer;
	}
	

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		String str = "连接成功";
		byte[] data = str.getBytes();
		ByteBuf message = Unpooled.buffer(data.length);
		message.writeBytes(data);
		ctx.writeAndFlush(message);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		ByteBuf in = (ByteBuf)msg;
		String echoStr = "ECHO>>" +in.toString(CharsetUtil.UTF_8);
		ByteBuf echoBuf = Unpooled.buffer(echoStr.length());
		echoBuf.writeBytes(echoStr.getBytes());
		ctx.writeAndFlush(echoBuf);
	}

	@Override
	public void initChannel(SocketChannel ch) {
		ChannelPipeline p = ch.pipeline();
//		if (sslCtx != null) {
//			p.addLast(sslCtx.newHandler(ch.alloc()));
//		}
		p.addLast("idleStateHandler", new IdleStateHandler(60, 30, 0));
		p.addLast(new HttpServerCodec());
		//p.addLast(new HttpServerExpectContinueHandler());
		p.addLast(new HttpObjectAggregator(1024 * 1024));
		p.addLast(new HttpInboundHandler(this.proxyServer));
	}
}
