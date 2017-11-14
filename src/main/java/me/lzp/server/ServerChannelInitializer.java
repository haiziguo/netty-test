package me.lzp.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import me.lzp.MarshallingCodeCFactory;


/**
 * Created by lizhanpeng on 2017/11/10.
 */
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

       /* pipeline.addLast(new LineBasedFrameDecoder(2048));
        // 字符串解码 和 编码
        pipeline.addLast("decoder", new StringDecoder());
        pipeline.addLast("encoder", new StringEncoder());

        // 自己的逻辑Handler
        //pipeline.addLast("handler", new HelloWordServerHandler());
         pipeline.addLast("handler", new TCP_TextServerHandler());*/


        pipeline.addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
        pipeline.addLast(MarshallingCodeCFactory.buildMarshallingEncoder());

        // 自己的逻辑Handler
        pipeline.addLast("handler", new HelloWordServerHandler());

    }
}
