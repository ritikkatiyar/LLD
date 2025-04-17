public class ProxyDesignPattern {
    public static void main(String args[]){
        try{
            EmployeeDao employeeDao=new EmployeeDaoProxy();
            employeeDao.create("USER",new EmployeeDo());
            System.out.println("Opertion successfull");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
