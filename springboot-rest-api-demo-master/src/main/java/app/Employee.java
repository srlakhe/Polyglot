package app;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "company", type = "Employees", shards = 1, replicas = 0, refreshInterval = "-1")
public class Employee {

	@Id
	private String id;

	private String name;

	private String department;

	public Employee() {
	}

	public Employee(String id, String name, String department) {
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return String.format("Employee[id=%s, Name='%s', Department='%s']", this.id, this.name, this.department);
	}
}
