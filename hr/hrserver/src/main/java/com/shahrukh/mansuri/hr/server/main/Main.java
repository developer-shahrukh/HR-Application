package com.shahrukh.mansuri.hr.server.main;
import com.shahrukh.mansuri.hr.server.*;
import com.shahrukh.mansuri.network.common.exceptions.*;
import com.shahrukh.mansuri.network.server.*;
public class Main
{
public static void main(String gg[])
{
try
{
RequestHandler requestHandler=new RequestHandler();
NetworkServer networkServer;
networkServer=new NetworkServer(requestHandler);
networkServer.start();
}catch(NetworkException networkException)
{
System.out.println(networkException);
}
}
}