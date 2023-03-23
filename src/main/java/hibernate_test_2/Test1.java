package hibernate_test_2;


import hibernate_test_2.entity.Detail;
import hibernate_test_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {

//        try (SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Employee.class)
//                .addAnnotatedClass(Detail.class)
//                .buildSessionFactory()) {
//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Michael", "Goncharov", "IT", 500);
//            Detail detail = new Detail("Baku", "12334", "michaeilgoncharov@gmail.com");
//            employee.setEmpDetail(detail);
//            session.beginTransaction();
//            session.save(employee);
//
//            session.getTransaction().commit();
//
//            System.out.println("Done!");

//        try (SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Employee.class)
//                .addAnnotatedClass(Detail.class)
//                .buildSessionFactory()) {
//            Session session = factory.getCurrentSession();
//            Employee employee = new Employee("Oleg", "Smirnov", "Sales", 700);
//            Detail detail = new Detail("Moscow", "9876", "olegka@gmail.com");
//            employee.setEmpDetail(detail);
//            session.beginTransaction();
//            session.save(employee);
//
//            session.getTransaction().commit();
//
//            System.out.println("Done!");


//        Session session = null;
//        try (SessionFactory factory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Employee.class)
//                .addAnnotatedClass(Detail.class)
//                .buildSessionFactory()) {
//            session = factory.getCurrentSession();
//
//            session.beginTransaction();
//            Employee emp = session.get(Employee.class, 10);
//            System.out.println(emp.getEmpDetail());
//
//            session.getTransaction().commit();
//
//            System.out.println("Done!");
//        }
        Session session = null;
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory()) {
            session = factory.getCurrentSession();

            session.beginTransaction();
            Employee emp = session.get(Employee.class, 2);
            session.delete(emp);


            session.getTransaction().commit();

            System.out.println("Done!");
        }

    }
}
