package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class Test3 {
    public static void main(String[] args) {

        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            //Employee - название класса, а не таблицы
//            List<Employee> emps = session.createQuery("from Employee")
//                            .getResultList();
            List<Employee> emps = session.createQuery("from Employee " +
                            "where name = 'Alexandr' AND salary>=600")
                    .getResultList();

            for (Employee e: emps) {
                System.out.println(e);
            }
            session.getTransaction().commit();
            System.out.println("Done!");


        }
    }
}
