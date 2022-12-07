package ucb.app.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ucb.app.dto.LogAnualCountDto;
import ucb.app.dto.LogDayCountDto;
import ucb.app.dto.LogGlobalCountDto;
import ucb.app.dto.LogMonthCountDto;
import ucb.app.dto.LogQuarterCountDto;
import ucb.app.dto.LogSemesterCountDto;

import javax.persistence.SqlResultSetMapping;
import javax.persistence.ConstructorResult;
import javax.persistence.ColumnResult;

/**
 *
 * @author ronaldorojasayala
 */
@Entity
@Table(name = "log")
@NamedQueries({
        @NamedQuery(name = "Log.findAll", query = "SELECT l FROM Log l"),
        @NamedQuery(name = "Log.findByIdLog", query = "SELECT l FROM Log l WHERE l.idLog = :idLog"),
        @NamedQuery(name = "Log.findByDate", query = "SELECT l FROM Log l WHERE l.date = :date"),
        @NamedQuery(name = "Log.findByIdBusiness", query = "SELECT l FROM Log l WHERE l.idBusiness = :idBusiness"),
        @NamedQuery(name = "Log.findByIdBranch", query = "SELECT l FROM Log l WHERE l.idBranch = :idBranch"),
        @NamedQuery(name = "Log.findByIdUser", query = "SELECT l FROM Log l WHERE l.idUser = :idUser") })

@SqlResultSetMapping(name = "LogGlobalCount", classes = @ConstructorResult(targetClass = LogGlobalCountDto.class, columns = {
        @ColumnResult(name = "idBusiness", type = Integer.class),
        @ColumnResult(name = "name", type = String.class),
        @ColumnResult(name = "idBranch", type = Integer.class),
        @ColumnResult(name = "address", type = String.class),
        @ColumnResult(name = "count", type = Integer.class) }))

@SqlResultSetMapping(name = "LogAnualCount", classes = @ConstructorResult(targetClass = LogAnualCountDto.class, columns = {
        @ColumnResult(name = "idBusiness", type = Integer.class),
        @ColumnResult(name = "name", type = String.class),
        @ColumnResult(name = "idBranch", type = Integer.class),
        @ColumnResult(name = "address", type = String.class),
        @ColumnResult(name = "year", type = Integer.class),
        @ColumnResult(name = "count", type = Integer.class) }))

@SqlResultSetMapping(name = "LogSemesterCount", classes = @ConstructorResult(targetClass = LogSemesterCountDto.class, columns = {
        @ColumnResult(name = "idBusiness", type = Integer.class),
        @ColumnResult(name = "name", type = String.class),
        @ColumnResult(name = "idBranch", type = Integer.class),
        @ColumnResult(name = "address", type = String.class),
        @ColumnResult(name = "year", type = Integer.class),
        @ColumnResult(name = "count", type = Integer.class),
        @ColumnResult(name = "semester", type = Integer.class),
        @ColumnResult(name = "yearSemeter", type = Integer.class) }))

@SqlResultSetMapping(name = "LogQuarterCount", classes = @ConstructorResult(targetClass = LogQuarterCountDto.class, columns = {
        @ColumnResult(name = "idBusiness", type = Integer.class),
        @ColumnResult(name = "name", type = String.class),
        @ColumnResult(name = "idBranch", type = Integer.class),
        @ColumnResult(name = "address", type = String.class),
        @ColumnResult(name = "year", type = Integer.class),
        @ColumnResult(name = "quarter", type = Integer.class),
        @ColumnResult(name = "count", type = Integer.class) }))

@SqlResultSetMapping(name = "LogMonthCount", classes = @ConstructorResult(targetClass = LogMonthCountDto.class, columns = {
        @ColumnResult(name = "idBusiness", type = Integer.class),
        @ColumnResult(name = "name", type = String.class),
        @ColumnResult(name = "idBranch", type = Integer.class),
        @ColumnResult(name = "address", type = String.class),
        @ColumnResult(name = "year", type = Integer.class),
        @ColumnResult(name = "month", type = Integer.class),
        @ColumnResult(name = "count", type = Integer.class) }))

@SqlResultSetMapping(name = "LogDayCount", classes = @ConstructorResult(targetClass = LogDayCountDto.class, columns = {
        @ColumnResult(name = "idBusiness", type = Integer.class),
        @ColumnResult(name = "name", type = String.class),
        @ColumnResult(name = "idBranch", type = Integer.class),
        @ColumnResult(name = "address", type = String.class),
        @ColumnResult(name = "date", type = Date.class),
        @ColumnResult(name = "count", type = Integer.class) }))

public class Log implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_log")
    private Integer idLog;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @Column(name = "id_business")
    private int idBusiness;
    @Basic(optional = false)
    @Column(name = "id_branch")
    private int idBranch;
    @Basic(optional = false)
    @Column(name = "id_user")
    private int idUser;

    public Log() {
    }

    public Log(Integer idLog) {
        this.idLog = idLog;
    }

    public Log(Integer idLog, Date date, int idBusiness, int idBranch, int idUser) {
        this.idLog = idLog;
        this.date = date;
        this.idBusiness = idBusiness;
        this.idBranch = idBranch;
        this.idUser = idUser;
    }

    public Integer getIdLog() {
        return idLog;
    }

    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getIdBusiness() {
        return idBusiness;
    }

    public void setIdBusiness(int idBusiness) {
        this.idBusiness = idBusiness;
    }

    public int getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(int idBranch) {
        this.idBranch = idBranch;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLog != null ? idLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Log)) {
            return false;
        }
        Log other = (Log) object;
        if ((this.idLog == null && other.idLog != null) || (this.idLog != null && !this.idLog.equals(other.idLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.appconcept.Log[ idLog=" + idLog + " ]";
    }

}
