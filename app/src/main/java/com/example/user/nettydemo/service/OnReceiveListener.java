package com.example.user.nettydemo.service;

import com.google.protobuf.GeneratedMessage;

/**
 * Created by user on 2016/10/26.
 */

public interface OnReceiveListener {
    void handleReceive(GeneratedMessage msg);
}
