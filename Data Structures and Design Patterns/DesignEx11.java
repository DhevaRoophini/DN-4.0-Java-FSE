interface CustomerRepository {
    String findCustomerById(int id);
}

class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(int id) {
        return "Customer#" + id;
    }
}

class CustomerService {
    private CustomerRepository repo;

    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public void printCustomer(int id) {
        System.out.println(repo.findCustomerById(id));
    }
}

class DesignEx11 {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);
        service.printCustomer(101);
    }
}
