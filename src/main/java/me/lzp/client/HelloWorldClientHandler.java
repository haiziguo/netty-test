package me.lzp.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import me.lzp.Msg;

/**
 * Created by lizhanpeng on 2017/11/10.
 */
public class HelloWorldClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof String){
            System.out.println(msg);
        }else{
            Msg m = (Msg)msg;
            System.out.println("client: "+m.getBody());
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Msg msg = new Msg();
        msg.setHeader((byte)0xa);
        msg.setLength(34);
        msg.setBody("放纵自己，你好兄弟");

        ctx.writeAndFlush(msg);
    }

}