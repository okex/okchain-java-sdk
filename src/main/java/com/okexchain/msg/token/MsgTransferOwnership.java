package com.okexchain.msg.token;

import com.okexchain.msg.MsgBase;
import com.okexchain.msg.common.Message;

public class MsgTransferOwnership extends MsgBase {

    public MsgTransferOwnership() { setMsgType("okexchain/token/MsgTransferOwnership");}

    public Message produceTransferOwnerShipMsg(String fromAddress, String toAddress, String symbol) {

        MsgTransferOwnershipValue value = new MsgTransferOwnershipValue();
        value.setFromAddress(fromAddress);
        value.setToAddress(toAddress);
        value.setSymbol(symbol);

        Message<MsgTransferOwnershipValue> msg = new Message<>();
        msg.setType(msgType);
        msg.setValue(value);

        return msg;
    }

}