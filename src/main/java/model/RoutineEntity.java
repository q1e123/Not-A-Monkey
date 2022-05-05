package model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "routine", schema = "not-a-monkey", catalog = "")
public class RoutineEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "browser_id")
    private Integer browserId;
    @Basic
    @Column(name = "user_id")
    private Integer userId;

    public RoutineEntity(String name, Integer browserId, Integer userId) {
        this.name = name;
        this.browserId = browserId;
        this.userId = userId;
    }

    public RoutineEntity() {

    }

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

    public Integer getBrowserId() {
        return browserId;
    }

    public void setBrowserId(Integer browserId) {
        this.browserId = browserId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoutineEntity that = (RoutineEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(browserId, that.browserId) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, browserId, userId);
    }
}
