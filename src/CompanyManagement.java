import java.util.List;
import java.util.Scanner;

public class CompanyManagement {

    public static void main(String[] args) {
        //create interface constant
        employeeDAO dao = EmployeeDAOImpl.getInstance();

        //Get all Employee
            diaplayAllEmployee(dao);
        //add new Employee
            //addNewEmployee(dao);
        //find Employee by ID
            //findEmployeeByID(dao);
        //update Employee by ID
            //updateEmployeeByID(dao);
        //deleteEmployee By ID
            deleteEmployeeByID(dao);


    }//main

    private static void deleteEmployeeByID(employeeDAO dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Delete emloyee with ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        dao.deleteEmp(id);

    }


    private static void updateEmployeeByID(employeeDAO dao) {
        Employee emp = findEmployeeByID2(dao);
        Scanner sc = new Scanner(System.in);
        System.out.print("Update new salaray for employee ID" + emp.getEmpID()+":");
        double ns = Double.parseDouble(sc.nextLine().trim());
        //update salary
        emp.setSalary(ns);
        dao.updateEmp(emp);
        System.out.println("Updated employee with ID: "+emp.getEmpID());


    }
    private static Employee findEmployeeByID2(employeeDAO dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an employee ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        Employee emp = dao.findEmp(id);
        System.out.println(emp.toString());

        return emp;

    }

    private static void findEmployeeByID(employeeDAO dao) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an employee ID: ");
        int id = Integer.parseInt(sc.nextLine().trim());
        Employee emp = dao.findEmp(id);
        System.out.println(emp.toString());

    }

    private static void addNewEmployee(employeeDAO dao) {
        Scanner sc = new Scanner(System.in);
        //input data
        System.out.print("Enter emloyee id :");
        int id = Integer.parseInt(sc.nextLine().trim());
        System.out.print("Enter emloyee name:");
        String name = sc.nextLine().trim();
        System.out.print("Enter emloyee position");
        String position = sc.nextLine().trim();
        System.out.print("Enter emloyee salary");
        double salary = Double.parseDouble(sc.nextLine().trim());
        //insert data to darabase
        Employee newEmp=new Employee(id,name,position,salary);
        dao.addEmp(newEmp);
    }

    private static void diaplayAllEmployee(employeeDAO dao) {
        List<Employee> myEmp = dao.getAllEmp();
        for (Employee emp:myEmp){
            System.out.println(emp.toString());
        }
    }
}//class
