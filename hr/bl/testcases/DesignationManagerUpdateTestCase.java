import com.shahrukh.mansuri.hr.bl.managers.*;
import com.shahrukh.mansuri.hr.bl.interfaces.managers.*;
import com.shahrukh.mansuri.hr.bl.interfaces.pojo.*;
import com.shahrukh.mansuri.hr.bl.pojo.*;
import com.shahrukh.mansuri.hr.bl.exceptions.*;
import java.util.*;
class DesignationManagerUpdateTestCase
{
public static void main(String gg[])
{
DesignationInterface designation=new Designation();
designation.setCode(2);
designation.setTitle("MANAGER");
try
{
DesignationManagerInterface designationManager;
designationManager=DesignationManager.getDesignationManager();
designationManager.updateDesignation(designation);
System.out.println("Designation updated\n");
}catch(BLException blException)
{
if(blException.hasGenericException())
{
System.out.println(blException.getGenericException());
}
List<String> properties=blException.getProperties();
for(String property : properties)
{
System.out.println(blException.getException(property));
}
}
}
}


