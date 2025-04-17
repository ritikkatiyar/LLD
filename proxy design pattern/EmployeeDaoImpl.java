public class EmployeeDaoImpl implements EmployeeDao{

    @Override
    public void create(String client, EmployeeDo employeeDo) throws Exception {
        System.out.println("created new row in employee tbl");
    }

    @Override
    public void delete(String client, int employeeId) throws Exception {
        System.out.println("deleted row with employeeId "+employeeId);
    }

    @Override
    public EmployeeDo get(String client, int employeeId) throws Exception {
        System.out.println("fetching data from the db");
        return new EmployeeDo();
    }
}
