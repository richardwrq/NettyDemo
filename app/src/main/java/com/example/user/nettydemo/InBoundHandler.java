package com.example.user.nettydemo;

import android.util.Log;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by user on 2016/10/27.
 */

public class InBoundHandler extends ChannelInboundHandlerAdapter {
    private static final String TAG = "InBoundHandler";
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        Log.d(TAG, "channelRead: " + ctx.name());
        super.channelRead(ctx, msg);
    }
}
