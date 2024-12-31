package com.shahrukh.mansuri.hr.bl.managers;
import com.shahrukh.mansuri.hr.bl.interfaces.pojo.*;
import com.shahrukh.mansuri.hr.bl.interfaces.managers.*;
import com.shahrukh.mansuri.hr.bl.exceptions.*;
import com.shahrukh.mansuri.hr.bl.pojo.*;
import java.util.*;
import com.shahrukh.mansuri.network.common.*;
import com.shahrukh.mansuri.network.client.*;
import com.shahrukh.mansuri.network.common.exceptions.*;
public class DesignationManager implements DesignationManagerInterface
{
private static DesignationManager designationManager=null;
private DesignationManager() throws BLException
{
}
public static DesignationManagerInterface getDesignationManager() throws BLException
{
if(designationManager==null) designationManager=new DesignationManager();
return designationManager;
}
public void addDesignation(DesignationInterface designation) throws BLException
{
BLException blException;
blException=new BLException();
if(designation==null)
{
blException.setGenericException("Designation required ");
throw blException;
}
int code=designation.getCode();
String title=designation.getTitle();
if(code!=0)
{
blException.addException("code "," code should be zero");
}
if(title==null)
{
blException.addException("title ","Title required");
title="";
}
else
{
title=title.trim();
if(title.length()==0) 
{
blException.addException("title "," Title required");
}
}
if(blException.hasExceptions())
{
throw blException;
}
Request request=new Request();
request.setManager(Managers.getManagerType(Managers.DESIGNATION));
request.setAction(Managers.getAction(Managers.Designation.ADD_DESIGNATION));
request.setArguments(designation);
NetworkClient client=new NetworkClient();
try
{
Response response=client.send(request);
if(response.hasException())
{
blException=(BLException)response.getException();
throw blException;
}
DesignationInterface d=(DesignationInterface)response.getResult();
designation.setCode(d.getCode());
}catch(NetworkException networkException)
{
blException.setGenericException(networkException.getMessage());
throw blException;
}
}
public void updateDesignation(DesignationInterface designation) throws BLException
{
BLException blException;
blException=new BLException();
if(designation==null) 
{
blException.setGenericException("Designation required");
throw blException;
}
int code=designation.getCode();
String title=designation.getTitle();
if(code<=0)
{
blException.addException("code","Invalid code : "+code);
}
if(title==null) 
{
blException.addException("title","Title required");
title="";
}
else
{
title=title.trim();
if(title.length()==0)
{
blException.addException("title","Title required");
}
}
if(blException.hasExceptions())
{
throw blException;
}
Request request=new Request();
request.setManager(Managers.getManagerType(Managers.DESIGNATION));
request.setAction(Managers.getAction(Managers.Designation.UPDATE_DESIGNATION));
request.setArguments(designation);
NetworkClient client=new NetworkClient();
try
{
Response response=client.send(request);
if(response.hasException())
{
blException=(BLException)response.getException();
throw blException;
}
}catch(NetworkException networkException)
{
blException.setGenericException(networkException.getMessage());
throw blException;
}
}
public void removeDesignation(int code) throws BLException
{
if(code<=0)
{
BLException blException;
blException=new BLException();
blException.addException("code","Invalid code : "+code);
throw blException;
}
Request request=new Request();
request.setManager(Managers.getManagerType(Managers.DESIGNATION));
request.setAction(Managers.getAction(Managers.Designation.REMOVE_DESIGNATION));
request.setArguments(code);
NetworkClient client=new NetworkClient();
try
{
Response response=client.send(request);
if(response.hasException())
{
BLException blException;
blException=new BLException();
blException=(BLException)response.getException();
throw blException;
}
}catch(NetworkException networkException)
{
BLException blException;
blException=new BLException();
blException.setGenericException(networkException.getMessage());
throw blException;
}
}
public DesignationInterface getDesignationByCode(int code) throws BLException
{
if(code<=0)
{
BLException blException;
blException=new BLException();
blException.addException("code","Invalid code : "+code);
throw blException;
}
Request request=new Request();
request.setManager(Managers.getManagerType(Managers.DESIGNATION));
request.setAction(Managers.getAction(Managers.Designation.GET_DESIGNATION_BY_CODE));
request.setArguments(new Integer(code));
NetworkClient client=new NetworkClient();
try
{
Response response=client.send(request);
if(response.hasException())
{
BLException blException;
blException=new BLException();
blException=(BLException)response.getException();
throw blException;
}
DesignationInterface designation;
designation=(DesignationInterface)response.getResult();
return designation;
}catch(NetworkException networkException)
{
BLException blException;
blException=new BLException();
blException.setGenericException(networkException.getMessage());
throw blException;
}
}
public DesignationInterface getDesignationByTitle(String title) throws BLException
{
if(title==null)
{
BLException blException;
blException=new BLException();
blException.addException("title","Title required");
throw blException;
}
title=title.trim();
if(title.length()==0)
{
BLException blException;
blException=new BLException();
blException.addException("title","Title required");
throw blException;
}
Request request=new Request();
request.setManager(Managers.getManagerType(Managers.DESIGNATION));
request.setAction(Managers.getAction(Managers.Designation.GET_DESIGNATION_BY_TITLE));
request.setArguments(title);
NetworkClient client=new NetworkClient();
try
{
Response response=client.send(request);
if(response.hasException())
{
BLException blException;
blException=new BLException();
blException=(BLException)response.getException();
throw blException;
}
DesignationInterface designation;
designation=(DesignationInterface)response.getResult();
return designation;
}catch(NetworkException networkException)
{
BLException blException;
blException=new BLException();
blException.setGenericException(networkException.getMessage());
throw blException;
}
}
public int getDesignationCount()
{
Request request=new Request();
request.setManager(Managers.getManagerType(Managers.DESIGNATION));
request.setAction(Managers.getAction(Managers.Designation.GET_DESIGNATION_COUNT));
NetworkClient client=new NetworkClient();
try
{
Response response=client.send(request);
Integer count;
count=(Integer)response.getResult();
return count.intValue(); // no need to intValue, unboxing will be done
}catch(NetworkException networkException)
{
throw new RuntimeException(networkException.getMessage());
}
}
public boolean designationCodeExists(int code) 
{
if(code<=0)
{
return false;
}
Request request=new Request();
request.setManager(Managers.getManagerType(Managers.DESIGNATION));
request.setAction(Managers.getAction(Managers.Designation.DESIGNATION_CODE_EXISTS));
request.setArguments(new Integer(code));
NetworkClient client=new NetworkClient();
try
{
Response response=client.send(request);
Boolean exists=(Boolean)response.getResult();
return exists;
}catch(NetworkException networkException)
{
throw new RuntimeException(networkException.getMessage());
}
}
public boolean designationTitleExists(String title)
{
if(title==null)
{
return false;
}
title=title.trim();
if(title.length()==0)
{
return false;
}
Request request=new Request();
request.setManager(Managers.getManagerType(Managers.DESIGNATION));
request.setAction(Managers.getAction(Managers.Designation.DESIGNATION_TITLE_EXISTS));
request.setArguments(title);
NetworkClient client=new NetworkClient();
try
{
Response response=client.send(request);
Boolean exists=(Boolean)response.getResult();
return exists;
}catch(NetworkException networkException)
{
throw new RuntimeException(networkException.getMessage());
}
}
public Set<DesignationInterface> getDesignations()
{
Request request=new Request();
request.setManager(Managers.getManagerType(Managers.DESIGNATION));
request.setAction(Managers.getAction(Managers.Designation.GET_DESIGNATIONS));
NetworkClient client=new NetworkClient();
try
{
Response response=client.send(request);
Set<DesignationInterface> designations;
designations=(Set<DesignationInterface>)response.getResult();
return designations;
}catch(NetworkException networkException)
{
throw new RuntimeException(networkException.getMessage());
}
}
}
