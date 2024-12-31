import com.shahrukh.mansuri.hr.dl.exceptions.*;
import com.shahrukh.mansuri.hr.dl.interfaces.dto.*;
import com.shahrukh.mansuri.hr.dl.interfaces.dao.*;
import com.shahrukh.mansuri.hr.dl.dto.*;
import com.shahrukh.mansuri.hr.dl.dao.*;
public class DesignationGetByTitleTestCase
{
public static void main(String gg[])
{
String title=gg[0];
try
{
DesignationDTOInterface designationDTO;
DesignationDAOInterface designationDAO;
designationDAO=new DesignationDAO();
designationDTO=designationDAO.getByTitle(title);
System.out.printf("code ,%d Title %s\n",designationDTO.getCode(),designationDTO.getTitle());
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}