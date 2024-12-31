package com.shahrukh.mansuri.network.server;
import com.shahrukh.mansuri.network.common.*;
import com.shahrukh.mansuri.network.common.exceptions.*;
import java.net.*;
public class NetworkServer
{
private RequestHandlerInterface requestHandler;
public NetworkServer(RequestHandlerInterface requestHandler) throws NetworkException
{
if(requestHandler==null)
{
throw new NetworkException("Request handler missing");
}
this.requestHandler=requestHandler;
}
public void start() throws NetworkException // will run on main thread
{
ServerSocket serverSocket=null;
int port=Configuration.getPort();
try
{
serverSocket=new ServerSocket(port);
}catch(Exception exception)
{
throw new NetworkException("Unable to start server on port : "+port);
}
try
{
Socket socket;
RequestProcessor requestProcessor;
while(true)
{
System.out.println("Server is ready to accept request on port : "+port);
socket=serverSocket.accept();
System.out.println(socket);
requestProcessor=new RequestProcessor(socket,requestHandler);
System.out.println("Request processor send : "+requestProcessor);
System.out.println("***************");
}
}catch(Exception e)
{
System.out.println("Exception");
System.out.println(e);
}
System.out.println("After catch Request Handler");
}
}