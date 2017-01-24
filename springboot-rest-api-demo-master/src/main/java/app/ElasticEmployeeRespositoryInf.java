package app;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ElasticEmployeeRespositoryInf extends ElasticsearchRepository<Employee, String> {
	public Employee findByName(String name);

	public List<Employee> findByDepartment(String department);
}
