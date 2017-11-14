package me.lzp.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import me.lzp.Msg;

/**
 * Created by lizhanpeng on 2017/11/10.
 */
public class HelloWordServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //ctx.channel().pipeline()。
      /*  System.out.println(ctx.channel().remoteAddress()+"===>server: "+msg.toString());
        ctx.write("received your msg");
        ctx.flush();*/

        if(msg instanceof String){
            System.out.println(msg.toString());
        }else{
            ctx.writeAndFlush("received your msg");
            Msg m = (Msg)msg;
            System.out.println("client: "+m.getBody());
            m.setBody("人生苦短，快用python");
            ctx.writeAndFlush(m);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        ctx.close();
    }
}
