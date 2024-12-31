import com.shahrukh.mansuri.hr.dl.exceptions.*;
import com.shahrukh.mansuri.hr.dl.interfaces.dto.*;
import com.shahrukh.mansuri.hr.dl.interfaces.dao.*;
import com.shahrukh.mansuri.hr.dl.dto.*;
import com.shahrukh.mansuri.hr.dl.dao.*;
import java.util.*;
import java.text.*;
import java.math.*;
public class EmployeeGetAllTestCase
{
public static void main(String gg[])
{
try
{
EmployeeDAOInterface employeeDAO;
employeeDAO=new EmployeeDAO();
Set<EmployeeDTOInterface> employees=new TreeSet<>();
employees=employeeDAO.getAll();
SimpleDateFormat simpleDateFormat;
simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
for(EmployeeDTOInterface employeeDTO:employees)
{
System.out.println("Employee id : "+employeeDTO.getEmployeeId());
System.out.println("Name : "+employeeDTO.getName());
System.out.println("Designation code : "+employeeDTO.getDesignationCode());
System.out.println("Date of birth : "+simpleDateFormat.format(employeeDTO.getDateOfBirth()));
System.out.println("Gender : "+employeeDTO.getGender());
System.out.println("Is indian : "+employeeDTO.getIsIndian());
System.out.println("Basic salary : "+employeeDTO.getBasicSalary());
System.out.println("PAN number  : "+employeeDTO.getPANNumber());
System.out.println("Aadhar card number : "+employeeDTO.getAadharCardNumber());
System.out.println("****************************************");
}
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}