public class DITest {
    public static void main(String[] args) {
        // Inject repository implementation
        CustomerRepository repository = new CustomerRepositoryImpl();

        // Inject into service via constructor
        CustomerService service = new CustomerService(repository);

        // Use the service
        Customer customer = service.getCustomerById(1);
        if (customer != null) {
            System.out.println("Customer found: ID = " + customer.getId() + ", Name = " + customer.getName());
        } else {
            System.out.println("Customer not found.");
        }
    }
}
