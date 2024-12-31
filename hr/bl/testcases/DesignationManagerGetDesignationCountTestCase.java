import com.shahrukh.mansuri.hr.bl.interfaces.managers.*;
import com.shahrukh.mansuri.hr.bl.managers.*;
import com.shahrukh.mansuri.hr.bl.exceptions.*;
import java.util.*;
class DesignationManagerGetDesignationCountTestCase
{
public static void main(String gg[])
{
try
{
DesignationManagerInterface designationManager;
designationManager=DesignationManager.getDesignationManager();
System.out.println("Number of designation : "+designationManager.getDesignationCount());
}catch(BLException blException)
{
List<String> properties=blException.getProperties();
properties.forEach((property)->{
System.out.println(blException.getException(property));
});
}
}
}