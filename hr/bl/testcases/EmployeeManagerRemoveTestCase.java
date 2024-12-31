import com.shahrukh.mansuri.hr.bl.interfaces.managers.*;
import com.shahrukh.mansuri.hr.bl.interfaces.pojo.*;
import com.shahrukh.mansuri.hr.bl.managers.*;
import com.shahrukh.mansuri.hr.bl.exceptions.*;
import com.shahrukh.mansuri.hr.bl.pojo.*;
import com.shahrukh.mansuri.enums.*;
import java.util.*;
import java.text.*;
import java.math.*;
class EmployeeManagerRemoveTestCase
{
public static void main(String gg[])
{
try
{
String employeeId=gg[0];
EmployeeManagerInterface employeeManager;
employeeManager=EmployeeManager.getEmployeeManager();
employeeManager.removeEmployee(employeeId);
System.out.printf("Employee removed");
}catch(BLException blException)
{
if(blException.hasGenericException())
{
System.out.println(blException.getGenericException());
}
List<String>properties=blException.getProperties();
for(String property:properties)
{
System.out.println(blException.getException(property));
}
}
}
}