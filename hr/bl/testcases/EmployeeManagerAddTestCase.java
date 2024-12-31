import com.shahrukh.mansuri.hr.bl.interfaces.managers.*;
import com.shahrukh.mansuri.hr.bl.interfaces.pojo.*;
import com.shahrukh.mansuri.hr.bl.managers.*;
import com.shahrukh.mansuri.hr.bl.exceptions.*;
import com.shahrukh.mansuri.hr.bl.pojo.*;
import com.shahrukh.mansuri.enums.*;
import java.util.*;
import java.text.*;
import java.math.*;
class EmployeeManagerAddTestCase
{
public static void main(String gg[])
{
try
{
String name="Dinesh Patidar";
DesignationInterface designation=new Designation();
designation.setCode(2);
Date dateOfBirth=new Date();
boolean isIndian=true;
BigDecimal basicSalary=new BigDecimal("200000");
String panNumber="P123456";
String aadharCardNumber="A123456";

EmployeeInterface employee;
employee=new Employee();
employee.setName(name);
employee.setDesignation(designation);
employee.setDateOfBirth(dateOfBirth);
employee.setGender(GENDER.MALE);
employee.setIsIndian(isIndian);
employee.setBasicSalary(basicSalary);
employee.setPANNumber(panNumber);
employee.setAadharCardNumber(aadharCardNumber);

EmployeeManagerInterface employeeManager;
employeeManager=EmployeeManager.getEmployeeManager();
employeeManager.addEmployee(employee);
System.out.printf("Employee added with employee id. %s\n",employee.getEmployeeId());
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