package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {
    Connection conn;
    public DepartmentDaoJDBC(Connection conn){
        this.conn = conn;
    }
    @Override
    public void insert(Department obj) {
    }

    @Override
    public void update(Department obj) {

    }

    @Override
    public void deleteById(Integer id) {

    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            st = conn.prepareStatement("SELECT * FROM department WHERE Id = ?");

            st.setInt(1,id);
            rs = st.executeQuery();
            if(rs.next()){
                Department department = instantiateDepartment(rs);
                return department;
            }

        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally{
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        return null;
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        List<Department> departmentList = new ArrayList<>();
        try{
            st = conn.prepareStatement("SELECT * FROM department");
            rs = st.executeQuery();

            while(rs.next()){
                departmentList.add(instantiateDepartment(rs));
            }
        }catch(SQLException e){
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
        return departmentList;
    }

    public Department instantiateDepartment(ResultSet rs) throws SQLException{
        Department department = new Department();
        department.setId(rs.getInt("Id"));
        department.setName(rs.getString("Name"));
        return department;
    }
}
