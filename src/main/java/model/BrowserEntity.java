package model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "browser", schema = "not-a-monkey", catalog = "")
public class BrowserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "driver_path")
    private String driverPath;

    public BrowserEntity() {
    }

    public Integer getId() {
        return id;
    }

    @Basic
    @Column(name = "browser_type")
    private String browserType;

    public BrowserEntity(String name, String driverPath, String browserType) {
        this.name = name;
        this.driverPath = driverPath;
        this.browserType = browserType;
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

    public String getDriverPath() {
        return driverPath;
    }

    public void setDriverPath(String driverPath) {
        this.driverPath = driverPath;
    }

    public String getBrowserType() {
        return browserType;
    }

    public void setBrowserType(String browserType) {
        this.browserType = browserType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BrowserEntity that = (BrowserEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(driverPath, that.driverPath);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, driverPath);
    }


}
