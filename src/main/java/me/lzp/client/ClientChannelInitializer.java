package me.lzp.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import me.lzp.MarshallingCodeCFactory;

/**
 * Created by lizhanpeng on 2017/11/10.
 */
public class ClientChannelInitializer    extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

       /* pipeline.addLast("decoder", new StringDecoder());
        pipeline.addLast("encoder", new StringEncoder());

        // 我们自己的handler
        //pipeline.addLast("handler", new HelloWorldClientHandler());
       pipeline.addLast("handler", new TCP_TextClientHandler());*/

        pipeline.addLast(MarshallingCodeCFactory.buildMarshallingDecoder());
        pipeline.addLast(MarshallingCodeCFactory.buildMarshallingEncoder());

        // 客户端的逻辑
        pipeline.addLast("handler", new HelloWorldClientHandler());
    }
}
