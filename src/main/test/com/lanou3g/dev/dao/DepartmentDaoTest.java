package com.lanou3g.dev.dao;

import com.lanou3g.dev.domain.Department;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by doubleyLin on 17/11/24.
 * 作者:徐颢
 */

public class DepartmentDaoTest {



    private SqlSession session;

    @Before
    public void setUp() throws Exception {
        //初始化Mybatis
        //加载mybatis的配置文件到输入流中
        InputStream is = Resources.getResourceAsStream("mybatis-cfg.xml");
        //获取SessionFactory
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
        //通过SessionFactory获取session
        session = sf.openSession();
    }

    @After
    public void tearDown() throws Exception {
        //执行完毕之后关闭session
        session.close();
    }

    @Test
    public void findAll() throws Exception {
        //第一种方式

        List<Object> list = session.selectList("com.lanou3g.dev.dao.DepartmentDao.findAll");
        //遍历输出集合中的所有元素
        list.forEach(System.out::println);

        System.out.println("-----------------");
        //第二种方式

        DepartmentDao departmentDao = session.getMapper(DepartmentDao.class);
        departmentDao.findAll().forEach(System.out::println);
    }

    @Test
    public void findDeptById() throws Exception {
        //第一种方式
        //当查询结果只有一条数据的时候
        //既可以使用selectOne
        //也可以使用selectList
        //但查询结果有多个的时候
        //使用selectOne会报错
        Object one = session.selectOne("com.lanou3g.dev.dao.DepartmentDao.findDeptById",1);
        System.out.println(one);


        //第二种方式
        DepartmentDao departmentDao = session.getMapper(DepartmentDao.class);
        System.out.println(departmentDao.findDeptById(2));

    }
    @Test
    public void save() throws Exception {
        //第一种方式
//        Department department = new Department();
//        department.setDepName("人事部");
//        int reResult = session.insert("save", department);
//        System.out.println(reResult);
        //第二种方式
        Department department = new Department();
        department.setDepName("市场部");
        DepartmentDao departmentDao = session.getMapper(DepartmentDao.class);
        departmentDao.save(department);
        session.commit();
        //增删改必须提交
        //必须调用session.commit方法
    }

    @Test
    public void update() throws Exception {
        Department department = new Department();
        department.setDepId(3);
        department.setDepName("小卖部");
        DepartmentDao departmentDao = session.getMapper(DepartmentDao.class);
        departmentDao.update(department);
        session.commit();
    }

    @Test
    public void delete() throws Exception {
        DepartmentDao departmentDao = session.getMapper(DepartmentDao.class);
        departmentDao.delete(5);
        session.commit();
    }

    @Test
    public void find() throws Exception {
        Department department = new Department();
        department.setDepName("部");
        DepartmentDao departmentDao = session.getMapper(DepartmentDao.class);
        departmentDao.find(department).forEach(System.out::println);

    }

    @Test
    public void findDeptByIdBug() throws Exception {
        DepartmentDao departmentDao = session.getMapper(DepartmentDao.class);
        List<Department> deptByIdBug = departmentDao.findDeptByIdBug("1 or 1=1");
        deptByIdBug.forEach(System.out::println);
    }
}
