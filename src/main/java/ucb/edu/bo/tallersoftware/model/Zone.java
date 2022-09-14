package ucb.edu.bo.tallersoftware.model;

import javax.persistence.*;
@Entity
@Table(name = "zone",schema = "project", catalog = "")
public class Zone {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_zone")
    private int id_zone;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "id_municipalities")
    private Integer id_municipalities;

    public Zone(int id_zone, String name, Integer id_municipalities) {
        this.id_zone = id_zone;
        this.name = name;
        this.id_municipalities = id_municipalities;
    }

    public Zone() {

    }

    public int getId_zone() {
        return id_zone;
    }

    public void setId_zone(int id_zone) {
        this.id_zone = id_zone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId_municipalities() {
        return id_municipalities;
    }

    public void setId_municipalities(Integer id_municipalities) {
        this.id_municipalities = id_municipalities;
    }

}
