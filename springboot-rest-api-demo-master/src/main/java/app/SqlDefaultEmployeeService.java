package app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SqlDefaultEmployeeService implements SqlEmployeeService {

	@Autowired
	private SqlEmployeeRepository employeeRepository;

	public SqlEmployee save(SqlEmployee entity) {
		return employeeRepository.save(entity);
	}

	public SqlEmployee getById(String id) {
		return employeeRepository.findOne(id);
	}

	public List<SqlEmployee> getAll() {
		return employeeRepository.findAll();
	}

	public void delete(String id) {
		employeeRepository.delete(id);
	}

}