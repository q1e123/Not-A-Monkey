package model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "action_argument", schema = "not-a-monkey", catalog = "")
public class ActionArgumentEntity implements EntityFlag {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "value")
    private String value;
    @Basic
    @Column(name = "action_id")
    private Integer actionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getActionId() {
        return actionId;
    }

    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActionArgumentEntity that = (ActionArgumentEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(type, that.type) && Objects.equals(value, that.value) && Objects.equals(actionId, that.actionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, value, actionId);
    }
}
