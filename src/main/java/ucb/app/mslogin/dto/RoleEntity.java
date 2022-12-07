package ucb.app.mslogin.dto;

import ucb.app.mslogin.dao.RoleName;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class RoleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private RoleName name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoleName getName() {
        return name;
    }

    public void setName(RoleName name) {
        this.name = name;
    }
}
