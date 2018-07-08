package com.glmapper.bridge.transport.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;

/**
 * @author liuyang@terminus.io
 * @date 2018-07-04 16:23
 * Created by liuyang .
 */
public class NettyServer {
    private int port;

    public NettyServer(int port) {
        this.port = port;
    }

    public void start(){
        /**
         * 如果一个ServerBootstrap有两个EventLoopGroup，
         * 那么就可以把第一个EventLoopGroup用来专门负责绑定到端口监听连接事件，
         * 而把第二个EventLoopGroup用来处理每个接收到的连接，
         */
        //而服务器端的ServerBootstrap会用到两个（这两个也可以是同一个实例）
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            //ServerBootstrap用于Server端，通过调用bind()方法来绑定到一个端口监听连接
            ServerBootstrap sbs = new ServerBootstrap().group(bossGroup,workerGroup).channel(NioServerSocketChannel.class).localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {

                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
                            ch.pipeline().addLast("decoder", new StringDecoder());
                            ch.pipeline().addLast("encoder", new StringEncoder());
                            ch.pipeline().addLast(new NettyServerHandler());
                        };

                    }).option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);
            // 绑定端口，开始接收进来的连接
            ChannelFuture future = sbs.bind(port).sync();

            System.out.println("Server start listen at " + port );
            future.channel().closeFuture().sync();
        } catch (Exception e) {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        int port;
        if (args.length > 0) {
            port = Integer.parseInt(args[0]);
        } else {
            port = 8080;
        }
        new NettyServer(port).start();
    }

}
