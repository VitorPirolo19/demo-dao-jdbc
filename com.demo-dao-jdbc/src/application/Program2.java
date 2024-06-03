package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;

public class Program2 {
    public static void main(String[] args){

        System.out.println("==== TEST: 1 department findById ====");
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println();
        System.out.println("==== TEST: 2 department findAll ====");
        List<Department> list1 = departmentDao.findAll();
        System.out.println(list1);


    }
}
