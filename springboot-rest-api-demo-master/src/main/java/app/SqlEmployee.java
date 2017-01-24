package app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class SqlEmployee implements java.io.Serializable {

	private static final long serialVersionUID = 4910225916550731446L;

	@Id
	@Column(name = "id", unique = true, nullable = false)
	private String id;

	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "department", length = 20)
	private String department;

	public SqlEmployee(String id, String name, String department) {
		this.id = id;
		this.name = name;
		this.department = department;
	}

	public SqlEmployee() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getname() {
		return this.name;
	}

	public void setname(String firstname) {
		this.name = firstname;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("Id: ").append(this.id).append(", Name: ").append(this.name).append(", Department: ")
				.append(this.department);
		return sb.toString();
	}

}