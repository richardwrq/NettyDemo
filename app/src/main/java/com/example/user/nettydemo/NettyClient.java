package com.example.user.nettydemo;

import com.example.user.nettydemo.service.OnServerConnectListener;
import com.google.protobuf.MessageLite;

import java.net.Inet4Address;
import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

/**
 * Created by user on 2016/10/26.
 */

public class NettyClient {
    private InetSocketAddress mServerAddress;
    private Bootstrap mBootstrap;
    private Channel mChannel;
    private EventLoopGroup mWorkerGroup;
    private OnServerConnectListener onServerConnectListener;

    public void connect(final InetSocketAddress socketAddress, OnServerConnectListener onServerConnectListener) {
        mServerAddress = socketAddress;
        this.onServerConnectListener = onServerConnectListener;

        if (mBootstrap == null) {
            mWorkerGroup = new NioEventLoopGroup();
            mBootstrap = new Bootstrap();
            mBootstrap.group(mWorkerGroup)
                    .channel(NioSocketChannel.class)
                    .option(ChannelOption.SO_KEEPALIVE, true)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            pipeline.addLast("decoder", new ProtobufDecoder(Test.ProtoTest.getDefaultInstance()));
                            pipeline.addLast(new ChannelHandler() {
                            })
                            pipeline.addLast("encoder", new ProtobufEncoder());

                        }
                    })
                    .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000);
        }
    }

}
