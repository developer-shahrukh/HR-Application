import com.shahrukh.mansuri.hr.dl.exceptions.*;
import com.shahrukh.mansuri.hr.dl.interfaces.dto.*;
import com.shahrukh.mansuri.hr.dl.interfaces.dao.*;
import com.shahrukh.mansuri.hr.dl.dto.*;
import com.shahrukh.mansuri.hr.dl.dao.*;
import java.util.*;
public class DesignationGetAllTestCase
{
public static void main(String gg[])
{
try
{
DesignationDAOInterface designationDAO;
designationDAO=new DesignationDAO();
Set<DesignationDTOInterface> designations;
designations=designationDAO.getAll();
designations.forEach((designationDTO)->{
System.out.printf("code %d, Title %s\n",designationDTO.getCode(),designationDTO.getTitle());
});

}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}