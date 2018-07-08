package com.glmapper.bridge.transport.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @author liuyang@terminus.io
 * @date 2018-07-04 16:24
 * Created by liuyang .
 */

@ChannelHandler.Sharable
public class NettyServerHandler extends SimpleChannelInboundHandler<ByteBuf> {
    /**
     * 此方法会在连接到服务器后被调用
     */
    public void channelActive(ChannelHandlerContext ctx) {
        ctx.write(Unpooled.copiedBuffer("Netty rocks!", CharsetUtil.UTF_8));
    }

    /**
     * 此方法会在接收到服务器数据后调用
     */
    public void channelRead0(ChannelHandlerContext ctx, ByteBuf in) {
        System.out.println("Client received: " + ByteBufUtil.hexDump(in.readBytes(in.readableBytes())));
    }

    /**
     * 捕捉到异常
     */
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}
