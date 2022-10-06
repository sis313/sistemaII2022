package ucb.app.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ronaldorojasayala
 */
@Entity
@Table(name = "rating")
@NamedQueries({
        @NamedQuery(name = "Rating.findAll", query = "SELECT r FROM Rating r"),
        @NamedQuery(name = "Rating.findByIdRating", query = "SELECT r FROM Rating r WHERE r.idRating = :idRating"),
        @NamedQuery(name = "Rating.findByScore", query = "SELECT r FROM Rating r WHERE r.score = :score"),
        @NamedQuery(name = "Rating.findByFavoriteStatus", query = "SELECT r FROM Rating r WHERE r.favoriteStatus = :favoriteStatus"),
        @NamedQuery(name = "Rating.findByIdBranch", query = "SELECT r FROM Rating r WHERE r.idBranch = :idBranch"),
        @NamedQuery(name = "Rating.findByIdUser", query = "SELECT r FROM Rating r WHERE r.idUser = :idUser"),
        @NamedQuery(name = "Rating.findAverageByIdBranch", query = "SELECT AVG(r.score) FROM Rating r WHERE r.idBranch = :idBranch") })
public class Rating implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_rating")
    private Integer idRating;
    @Basic(optional = false)
    @Column(name = "score")
    private int score;
    @Basic(optional = false)
    @Column(name = "favorite_status")
    private boolean favoriteStatus;
    @Basic(optional = false)
    @Column(name = "id_branch")
    private int idBranch;
    @Basic(optional = false)
    @Column(name = "id_user")
    private int idUser;

    public Rating() {
    }

    public Rating(Integer idRating) {
        this.idRating = idRating;
    }

    public Rating(Integer idRating, int score, boolean favoriteStatus, int idBranch, int idUser) {
        this.idRating = idRating;
        this.score = score;
        this.favoriteStatus = favoriteStatus;
        this.idBranch = idBranch;
        this.idUser = idUser;
    }

    public Integer getIdRating() {
        return idRating;
    }

    public void setIdRating(Integer idRating) {
        this.idRating = idRating;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean getFavoriteStatus() {
        return favoriteStatus;
    }

    public void setFavoriteStatus(boolean favoriteStatus) {
        this.favoriteStatus = favoriteStatus;
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
        hash += (idRating != null ? idRating.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rating)) {
            return false;
        }
        Rating other = (Rating) object;
        if ((this.idRating == null && other.idRating != null)
                || (this.idRating != null && !this.idRating.equals(other.idRating))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.serviceproject.Rating[ idRating=" + idRating + " ]";
    }

}
