package ucb.app.mslogin.dto;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "refresh_token", schema = "service_maps", catalog = "")
public class RefreshTokenEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_refresh_token", nullable = false)
    private int idRefreshToken;

    @Basic
    @Column(nullable = false, unique = true, name = "token", length = 300)
    private String token;
    @Basic
    @Column(nullable = false, name = "expiry_date")
    private Instant expiryDate;
    @OneToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private UserEntity userEntity;

    public RefreshTokenEntity() {
    }

    public Integer getIdRefreshToken() {
        return idRefreshToken;
    }

    public void setIdRefreshToken(Integer idRefreshToken) {
        this.idRefreshToken = idRefreshToken;
    }

    public void setIdRefreshToken(int idRefreshToken) {
        this.idRefreshToken = idRefreshToken;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Instant getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Instant expiryDate) {
        this.expiryDate = expiryDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        RefreshTokenEntity that = (RefreshTokenEntity) o;

        if (idRefreshToken != that.idRefreshToken)
            return false;
        if (userEntity != that.userEntity)
            return false;
        if (!Objects.equals(token, that.token))
            return false;
        if (!Objects.equals(expiryDate, that.expiryDate))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idRefreshToken ^ (idRefreshToken >>> 32));
        result = 31 * result + (token != null ? token.hashCode() : 0);
        result = 31 * result + (expiryDate != null ? expiryDate.hashCode() : 0);
        result = Integer.parseInt(31 * result + userEntity.toString());
        return result;
    }
}
