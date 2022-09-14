package ucb.edu.bo.tallersoftware.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "branch",schema = "project", catalog = "")
public class Branch {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_branch")
    private int id;
    @Basic
    @Column(name = "address")
    private String adrress;
    @Basic
    @Column(name = "open_hour")
    private String open_hour;
    @Basic
    @Column(name = "close_hour")
    private String close_hour;
    @Basic
    @Column(name = "attention_days")
    private String attention_days;
    @Basic
    @Column(name = "image")
    private String image;
    @Basic
    @Column(name = "id_zone")
    private Integer id_zone;
    @Basic
    @Column(name = "id_location")
    private Integer id_location;
    @Basic
    @Column(name = "id_business")
    private Integer id_business;
    @Basic
    @Column(name = "create_date")
    private Date create_date;
    @Basic
    @Column(name = "update_date")
    private Date update_date;
    @Basic
    @Column(name = "status")
    private Integer status;

    public Branch(int id, String adrress, String open_hour, String close_hour, String attention_days, String image, Integer id_zone, Integer id_location, Integer id_business, Date create_date, Date update_date, Integer status) {
        this.id = id;
        this.adrress = adrress;
        this.open_hour = open_hour;
        this.close_hour = close_hour;
        this.attention_days = attention_days;
        this.image = image;
        this.id_zone = id_zone;
        this.id_location = id_location;
        this.id_business = id_business;
        this.create_date = create_date;
        this.update_date = update_date;
        this.status = status;
    }

    public Branch() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdrress() {
        return adrress;
    }

    public void setAdrress(String adrress) {
        this.adrress = adrress;
    }

    public String getOpen_hour() {
        return open_hour;
    }

    public void setOpen_hour(String open_hour) {
        this.open_hour = open_hour;
    }

    public String getClose_hour() {
        return close_hour;
    }

    public void setClose_hour(String close_hour) {
        this.close_hour = close_hour;
    }

    public String getAttention_days() {
        return attention_days;
    }

    public void setAttention_days(String attention_days) {
        this.attention_days = attention_days;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getId_zone() {
        return id_zone;
    }

    public void setId_zone(Integer id_zone) {
        this.id_zone = id_zone;
    }

    public Integer getId_location() {
        return id_location;
    }

    public void setId_location(Integer id_location) {
        this.id_location = id_location;
    }

    public Integer getId_business() {
        return id_business;
    }

    public void setId_business(Integer id_business) {
        this.id_business = id_business;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
