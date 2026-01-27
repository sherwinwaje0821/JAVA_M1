package ph.com.bpi.M6;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(
        name = "name",
        columnDefinition = "VARCHAR(100)",
        nullable = false
    )
    private String name;

    @Column(
        name = "age",
        nullable = false
    )
    private int age;

    @Column(
        name = "email",
        columnDefinition = "VARCHAR(150)",
        unique = true,
        nullable = false
    )
    private String email;

    // Getters and Setters
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }


public void setEmail(String email) {
    this.email = email;
}

}
       

