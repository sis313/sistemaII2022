package ucb.edu.bo.tallersoftware.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "business", schema = "project", catalog = "")
public class BusinessList {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_business")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "id_type_business")
    private int id_type_business;
    @Basic
    @Column(name = "create_date")
    private Date create_date;
    @Basic
    @Column(name = "update_date")
    private Date update_date;
    @Basic
    @Column(name = "status")
    private int status;
    @Basic
    @Column(name = "user_id_user")
    private int user_id_user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_type_business() {
        return id_type_business;
    }

    public void setId_type_business(int id_type_business) {
        this.id_type_business = id_type_business;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUser_id_user() {
        return user_id_user;
    }

    public void setUser_id_user(int user_id_user) {
        this.user_id_user = user_id_user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusinessList that = (BusinessList) o;
        return id == that.id && id_type_business == that.id_type_business && status == that.status && user_id_user == that.user_id_user && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(create_date, that.create_date) && Objects.equals(update_date, that.update_date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, id_type_business, create_date, update_date, status, user_id_user);
    }
}
