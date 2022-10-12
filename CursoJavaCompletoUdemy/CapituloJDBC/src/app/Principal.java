package app;

import java.util.Date;
import java.util.List;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

/**
 *
 * @author Alisson Chiquitto <chiquitto@gmail.com>
 */
public class Principal {

    public static void main(String[] args) {

        {
            DepartmentDao departmentDao = DaoFactory.factoryDepartmentDao();

            System.out.println("\n=== department.findById ===");
            Department department = departmentDao.findById(1);
            System.out.println(department);

            System.out.println("\n=== department.findAll ===");
            List<Department> list = departmentDao.findAll();
            for (Department obj : list) {
                System.out.println(obj);
            }

            System.out.println("\n=== department.insert ===");
            Department newDepartment = new Department(null, "Sport");
            departmentDao.insert(newDepartment);
            System.out.println(newDepartment);

            System.out.println("\n=== department.update ===");
            newDepartment.setName(newDepartment.getName().toUpperCase());
            departmentDao.update(newDepartment);
            System.out.println(departmentDao.findById(newDepartment.getId()));

            System.out.println("\n=== department.delete ===");
            departmentDao.deleteById(newDepartment.getId());
            System.out.println(departmentDao.findById(newDepartment.getId()));
        }

        {
            SellerDao sellerDao = DaoFactory.factorySellerDao();

            System.out.println("\n=== seller.findById ===");
            Seller seller = sellerDao.findById(1);
            System.out.println(seller);

            System.out.println("\n=== seller.findByDepartment ===");
            List<Seller> list = sellerDao.findByDepartment(seller.getDepartment());
            for (Seller obj : list) {
                System.out.println(obj);
            }

            System.out.println("\n=== seller.findAll ===");
            list = sellerDao.findAll();
            for (Seller obj : list) {
                System.out.println(obj);
            }

            System.out.println("\n=== seller.insert ===");
            Seller newSeller = new Seller(null, "Grag", "grag@gmail.com", new Date(), 3500.0,
                    seller.getDepartment());
            sellerDao.insert(newSeller);
            System.out.println(newSeller);

            System.out.println("\n=== seller.update ===");
            newSeller.setName(newSeller.getName().toUpperCase());
            sellerDao.update(newSeller);
            System.out.println(sellerDao.findById(newSeller.getId()));

            System.out.println("\n=== seller.delete ===");
            sellerDao.deleteById(1000);
            System.out.println(sellerDao.findById(newSeller.getId()));
        }

    }

}
