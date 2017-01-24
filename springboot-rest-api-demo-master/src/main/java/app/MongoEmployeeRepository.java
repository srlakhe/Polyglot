package app;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoEmployeeRepository extends MongoRepository<Employee, String>{

}
