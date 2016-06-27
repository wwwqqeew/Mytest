package com.mina;

import java.util.Date;

import org.apache.mina.common.IdleStatus;
import org.apache.mina.common.IoHandlerAdapter;
import org.apache.mina.common.IoSession;

public class TimeServerHandler extends IoHandlerAdapter {
@Override
public void exceptionCaught(IoSession session, Throwable cause)
    throws Exception {
   cause.printStackTrace();
}

@Override
public void messageReceived(IoSession session, Object message)
    throws Exception {
   String str = message.toString();
   System.out.println("Message read:");
   System.out.println(str);

   Date date = new Date();
   session.write(date.toString());
   System.out.println("Message written...");
   session.close();
}

@Override
public void sessionIdle(IoSession session, IdleStatus status)
    throws Exception {
   System.out.println("IDLE " + session.getIdleCount(status));
}
}
