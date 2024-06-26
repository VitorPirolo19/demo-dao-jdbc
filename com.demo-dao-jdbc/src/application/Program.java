package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.time.LocalDate;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println();
        System.out.println("=== TEST 2: seller findByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for(Seller obj:list){
            System.out.println(obj);
        }

        System.out.println();
        System.out.println("=== TEST 3: seller findAll ====");
        list = sellerDao.findAll();
        for(Seller obj:list){
            System.out.println(obj);
        }

        System.out.println();
        System.out.println("=== TEST 4: seller Insert ====");
        Seller seller1 = new Seller(null, "Greg", "greg@gmail.com",LocalDate.now(), 4000.00, department);
        sellerDao.insert(seller1);
        System.out.println("Inserted! new id = "+seller1.getId());

        System.out.println();
        System.out.println("=== TEST 5: seller Update ====");
        seller = sellerDao.findById(1);
        seller.setName("Martha Wayne");
        sellerDao.update(seller);
        System.out.println("Update Completed!");
    }
}
