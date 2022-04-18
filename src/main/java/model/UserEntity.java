package model;

import com.google.common.hash.Hashing;
import controller.InsecurePasswordException;
import controller.SecurityPoliciesManager;
import jakarta.persistence.*;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "not-a-monkey", catalog = "")
public class UserEntity implements EntityFlag {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        SecurityPoliciesManager securityPoliciesManager = SecurityPoliciesManager.getInstance();
        try {
            securityPoliciesManager.checkPassword(password);
        } catch (InsecurePasswordException e) {
            e.printStackTrace();
            return;
        }
        String passwordHash = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        this.password = passwordHash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }
}
