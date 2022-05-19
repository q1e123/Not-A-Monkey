package model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "action", schema = "not-a-monkey", catalog = "")
public class ActionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "routine_id")
    private Integer routineId;


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

    public Integer getRoutineId() {
        return routineId;
    }

    public void setRoutineId(Integer routineId) {
        this.routineId = routineId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionEntity that = (ActionEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(routineId, that.routineId);
    }

    public ActionEntity(String name, Integer routineId) {
        this.name = name;
        this.routineId = routineId;
    }

    public ActionEntity() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, routineId);
    }
}
