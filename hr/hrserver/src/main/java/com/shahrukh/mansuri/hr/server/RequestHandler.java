package com.shahrukh.mansuri.hr.server;
import com.shahrukh.mansuri.network.server.*;
import com.shahrukh.mansuri.network.common.*;
import com.shahrukh.mansuri.hr.bl.interfaces.managers.*;
import com.shahrukh.mansuri.hr.bl.exceptions.*;
import com.shahrukh.mansuri.hr.bl.managers.*;
public class RequestHandler implements RequestHandlerInterface
{
private DesignationManagerInterface designationManager;
public RequestHandler()
{
try
{
designationManager=DesignationManager.getDesignationManager();
}catch(BLException blException)
{
// do nothing
}
}
public Response process(Request request)
{
Response response=new Response();
String manager=request.getManager();
String action=request.getAction();
Object [] arguments=request.getArguments();
if(manager.equals("DesignationManager"))
{
if(designationManager==null)
{
// will implement later on
}
if(action.equals("getDesignations"))
{
Object result=designationManager.getDesignations();
response.setSuccess(true);
response.setResult(result);
response.setException(null);
}
} // DesigantionManager part ends here
return response;
}
}