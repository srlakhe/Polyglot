package app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/polyglot/employee/elastic")
public class ElasticEmployeeController {

	@Autowired
	private ElasticEmployeeRespositoryInf repository;

	@RequestMapping(method = RequestMethod.GET)
	private ResponseEntity<Employee> fetchEmployee(@RequestParam(value = "name") String name) {
		Employee emp = this.repository.findByName(name);
		if(emp == null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

//	@RequestMapping("department")
//	private ResponseEntity<List<Employee>>  fetchEmployeesByDepartment(@RequestParam(value = "department") String department) {
//		List<Employee> emp = this.repository.findByDepartment(department);
//		if(emp == null) {
//			return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<List<Employee>>(HttpStatus.OK);
//	}

	@RequestMapping(method = RequestMethod.POST)
	private ResponseEntity<Employee> storeEmployee(@RequestBody Employee emp) {
		this.repository.save(emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	private ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp) {
		this.repository.save(emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE)
	private ResponseEntity<Employee> deleteEmployee(@RequestBody Employee emp) {
		Employee e = this.repository.findOne(emp.getId());
		if(e == null) {
			return new ResponseEntity<Employee>(emp, HttpStatus.NOT_FOUND);
		}
		this.repository.delete(emp);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
}