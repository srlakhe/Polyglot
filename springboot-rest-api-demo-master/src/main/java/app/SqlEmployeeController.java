package app;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sql")
public class SqlEmployeeController {

	@Autowired
	SqlEmployeeService empService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<SqlEmployee> addEmployee(@RequestBody SqlEmployee employee) {
		empService.save(employee);
		return new ResponseEntity<SqlEmployee>(employee, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> updateEmployee(@RequestBody SqlEmployee employee) {
		SqlEmployee existingEmp = empService.getById(employee.getId());
		if (existingEmp == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			empService.save(employee);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<SqlEmployee> getEmployee(@PathVariable("id") String id) {
		SqlEmployee employee = empService.getById(id);
		if (employee == null) {
			return new ResponseEntity<SqlEmployee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<SqlEmployee>(employee, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<SqlEmployee>> getAllEmployees() {
		List<SqlEmployee> employees = empService.getAll();
		if (employees.isEmpty()) {
			return new ResponseEntity<List<SqlEmployee>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<SqlEmployee>>(employees, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") String id) {
		SqlEmployee employee = empService.getById(id);
		if (employee == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			empService.delete(id);
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}

}
