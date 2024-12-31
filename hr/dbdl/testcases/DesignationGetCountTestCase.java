import com.shahrukh.mansuri.hr.dl.exceptions.*;
import com.shahrukh.mansuri.hr.dl.interfaces.dao.*;
import com.shahrukh.mansuri.hr.dl.dao.*;
public class DesignationGetCountTestCase
{
public static void main(String gg[])
{
try
{
DesignationDAOInterface designationDAO;
designationDAO=new DesignationDAO();
System.out.println("Designation count : "+designationDAO.getCount());
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}