package app;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mongo")
public class MongoEmployeeController {

	@Autowired
	private MongoEmployeeRepository empRepository;

	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> createEmp(@RequestBody Map<String, Object> empMap) {
		Employee emp = new Employee(empMap.get("id").toString(), empMap.get("name").toString(),
				empMap.get("department").toString());

		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("message", "Employee created successfully");
		empRepository.save(emp);
		return response;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{empId}")
	public Employee getEmpDetails(@PathVariable("empId") String empId) {
		return empRepository.findOne(empId);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/{empId}")
	public Map<String, Object> editEmp(@PathVariable("empId") String empId, @RequestBody Map<String, Object> empMap) {
		Employee emp = new Employee(empMap.get("id").toString(), empMap.get("name").toString(),
				empMap.get("department").toString());
		// book.setId(bookId);

		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("message", "Employee Updated successfully");
		// response.put("book", bookRepository.save(book));
		empRepository.save(emp);
		return response;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{empId}")
	public Map<String, String> deleteEmp(@PathVariable("empId") String empId) {
		empRepository.delete(empId);
		Map<String, String> response = new HashMap<String, String>();
		response.put("message", "Employee deleted successfully");

		return response;
	}

	@RequestMapping(method = RequestMethod.GET)
	public Map<String, Object> getAllEmps() {
		List<Employee> emps = empRepository.findAll();
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		response.put("totalEmployees", emps.size());
		response.put("Employees", emps);
		return response;
	}
}
