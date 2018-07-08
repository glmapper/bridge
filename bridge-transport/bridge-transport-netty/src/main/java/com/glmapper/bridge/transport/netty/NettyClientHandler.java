package com.glmapper.bridge.transport.netty;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author liuyang@terminus.io
 * @date 2018-07-04 16:36
 * Created by liuyang .
 */
@ChannelHandler.Sharable//注解@Sharable可以让它在channels间共享
public class NettyClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        System.out.println("NettyClient Active");
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        System.out.println("NettyClient read Message:" + msg);
        ctx.write(msg);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER) //flush掉所有写回的数据
                .addListener(ChannelFutureListener.CLOSE); //当flush完成后关闭channel
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();//捕捉异常信息
        ctx.close();//出现异常时关闭channel
    }

}