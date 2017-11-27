package com.lanou3g.dev.dao;

import com.lanou3g.dev.domain.Department;

import java.util.List;

/**
 * Created by doubleyLin on 17/11/24.
 * 作者:徐颢
 */

public interface DepartmentDao {
//    查询所有
    List<Department> findAll();
//    根据id查某一条数据
    Department findDeptById(int depId);


    //修改
    void update(Department department);

    //添加
    void save(Department department);

    //删除
    void delete(int depId);

    //模糊查询
    List<Department> find(Department department);

    List<Department> findDeptByIdBug(String id);
}
