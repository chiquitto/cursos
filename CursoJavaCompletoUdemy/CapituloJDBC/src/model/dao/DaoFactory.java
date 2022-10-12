package model.dao;

import db.DB;
import model.dao.impl.DepartmentDaoJDBC;
import model.dao.impl.SellerDaoJDBC;

/**
 *
 * @author Alisson Chiquitto <chiquitto@gmail.com>
 */
public class DaoFactory {

    public static DepartmentDao factoryDepartmentDao() {
        return new DepartmentDaoJDBC(DB.getConnection());
    }

    public static SellerDao factorySellerDao() {
        return new SellerDaoJDBC(DB.getConnection());
    }

}
