import com.shahrukh.mansuri.hr.dl.exceptions.*;
import com.shahrukh.mansuri.hr.dl.interfaces.dto.*;
import com.shahrukh.mansuri.hr.dl.interfaces.dao.*;
import com.shahrukh.mansuri.hr.dl.dto.*;
import com.shahrukh.mansuri.hr.dl.dao.*;
public class DesignationTitleExistsTestCase
{
public static void main(String gg[])
{
String title=gg[0];
try
{
DesignationDAOInterface designationDAO;
designationDAO=new DesignationDAO();
System.out.println("Title + exists :" +designationDAO.titleExists(title));
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}