package hello.entity;

public class User {

	public User(Integer id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public User() {
	}

	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

	private Integer id;

    private String name;

    private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}

