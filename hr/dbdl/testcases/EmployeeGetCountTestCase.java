import com.shahrukh.mansuri.hr.dl.exceptions.*;
import com.shahrukh.mansuri.hr.dl.interfaces.dto.*;
import com.shahrukh.mansuri.hr.dl.interfaces.dao.*;
import com.shahrukh.mansuri.hr.dl.dto.*;
import com.shahrukh.mansuri.hr.dl.dao.*;
public class EmployeeGetCountTestCase
{
public static void main(String gg[])
{
try
{
EmployeeDAOInterface employeeDAO;
employeeDAO=new EmployeeDAO();
System.out.println("Employee record count. "+employeeDAO.getCount());
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}