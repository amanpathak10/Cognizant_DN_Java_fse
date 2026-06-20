public class DependencyInjectionExample {
    interface CustomerRepository { String findCustomerById(int id); }
    static class CustomerRepositoryImpl implements CustomerRepository { public String findCustomerById(int id){ return "Customer#"+id; } }
    static class CustomerService { private final CustomerRepository repo; CustomerService(CustomerRepository r){ this.repo=r; } public void printCustomer(int id){ System.out.println(repo.findCustomerById(id)); } }

    public static void main(String[] args){
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);
        service.printCustomer(42);
    }
}
