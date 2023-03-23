package hibermate_ony_to_many_bi;

import hibermate_ony_to_many_bi.entity.Department;
import hibermate_ony_to_many_bi.entity.Employee;
import hibernate_one_to_one.entity.Detail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {

        Session session = null;
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory()) {
//            session = factory.getCurrentSession();
//
//            Department dep = new Department("IT", 300, 1200);
//            Employee emp1 = new Employee("Michael", "Goncharov", 800);
//            Employee emp2 = new Employee("Elena", "Smirnova", 1000);
//
//            dep.addEmployeeToDepartment(emp1);
//            dep.addEmployeeToDepartment(emp2);
//
//            session.beginTransaction();
//            session.save(dep);
//
//            session.getTransaction().commit();
//
//            System.out.println("Done!");


//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Department department = session.get(Department.class, 1);
//            System.out.println(department);
//            System.out.println(department.getEmps());
//
//            session.getTransaction().commit();
//
//            System.out.println("Done!");

//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Employee employee = session.get(Employee.class, 1);
//            System.out.println(employee);
//            System.out.println(employee.getDepartment());
//
//            session.getTransaction().commit();
//
//            System.out.println("Done!");

//***********************************************************************
            session = factory.getCurrentSession();

            session.beginTransaction();
            Employee employee = session.get(Employee.class, 2);
            session.delete(employee);

            session.getTransaction().commit();

            System.out.println("Done!");




        }
    }
}
