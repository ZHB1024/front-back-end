package com.forever.zhb.common.io.netty.server;

import com.forever.zhb.common.io.netty.server.handler.EchoServerHandler;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoServer {
    
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        new EchoServer().start();
    }

    public void start() throws Exception {
        EchoServerHandler handler = new EchoServerHandler();
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            ServerBootstrap server = new ServerBootstrap();
            server.group(group)
            .channel(NioServerSocketChannel.class).localAddress(PORT).childHandler(
                    new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(handler);
                        }
                    });
            ChannelFuture future = server.bind().sync();
            future.channel().closeFuture().sync();
            future.channel().eventLoop().shutdownGracefully();
        } finally {
            group.shutdownGracefully().sync();
        }
    }
}
