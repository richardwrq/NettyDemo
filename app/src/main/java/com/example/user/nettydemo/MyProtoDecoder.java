package com.example.user.nettydemo;

import com.google.protobuf.ExtensionRegistry;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.MessageLite;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.protobuf.ProtobufDecoder;

/**
 * Created by user on 2016/10/26.
 */

public class MyProtoDecoder extends ProtobufDecoder {
    public MyProtoDecoder(MessageLite prototype) {
        super(prototype);
    }

    public MyProtoDecoder(MessageLite prototype, ExtensionRegistry extensionRegistry) {
        super(prototype, extensionRegistry);
    }

    public MyProtoDecoder(MessageLite prototype, ExtensionRegistryLite extensionRegistry) {
        super(prototype, extensionRegistry);
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        super.decode(ctx, msg, out);

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        super.channelInactive(ctx);
    }
}
