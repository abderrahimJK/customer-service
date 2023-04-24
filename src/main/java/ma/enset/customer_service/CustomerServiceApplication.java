package ma.enset.customer_service;

import ma.enset.customer_service.entities.Customer;
import ma.enset.customer_service.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(new Customer(null, "Ahmed", "Ahmed@gmail.com"));
            customerRepository.save(new Customer(null, "med", "med@gmail.com"));
            customerRepository.save(new Customer(null, "Ali", "ali@gmail.com"));
            customerRepository.save(new Customer(null, "hind", "hind@gmail.com"));
            customerRepository.findAll().forEach( customer -> {
                System.out.println(customer.toString());
            });
        };

    }

}
