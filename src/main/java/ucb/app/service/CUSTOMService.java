package ucb.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ucb.app.dto.BranchRatingCountDto;
import ucb.app.dto.BusinessCountDto;
import ucb.app.dto.BusinessZoneDto;

@Service
public class CUSTOMService {
    EntityManager entityManager;

    @Autowired
    public CUSTOMService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public List<BusinessCountDto> findBusinessCountDto() {
        @SuppressWarnings("unchecked")
        List<BusinessCountDto> businessCountDtos = (List<BusinessCountDto>) entityManager.createNativeQuery(
                "SELECT a.name AS name, COUNT(c.id_business) AS numberBusiness, a.id_zone AS idZone FROM zone a, branch b, business c WHERE a.id_zone = b.id_zone AND b.id_business = c.id_business GROUP BY a.name ORDER BY c.id_business DESC;",
                "BusinessCount").getResultList();
        return businessCountDtos;
    }

    @Transactional
    public List<BusinessZoneDto> findBusinessByZoneDto(Integer zoneId) {
        @SuppressWarnings("unchecked")
        List<BusinessZoneDto> businessZoneDtos = (List<BusinessZoneDto>) entityManager.createNativeQuery(
                "SELECT c.name, c.id_business FROM zone a, branch b, business c WHERE a.id_zone = b.id_zone AND b.id_business = c.id_business AND a.id_zone = ?1 ORDER BY c.id_business DESC;",
                "BusinessZone").setParameter(1, zoneId).getResultList();
        return businessZoneDtos;
    }

    @Transactional
    public List<BranchRatingCountDto> findBranchRatingCountDto() {
        @SuppressWarnings("unchecked")
        List<BranchRatingCountDto> branchRatingCountDtos = (List<BranchRatingCountDto>) entityManager.createNativeQuery(
                "SELECT b.id_branch AS idBranch, avg(a.score) AS averageScore, count(a.id_rating) AS countIdRating FROM rating a JOIN branch b ON a.id_branch = b.id_branch GROUP BY b.id_branch;",
                "BranchRatingCount").getResultList();
        return branchRatingCountDtos;
    }

    @Transactional
    public Integer updateBusinessStatusDto(Integer status, Integer idUser) {
        Integer countUpdate = entityManager
                .createNativeQuery("UPDATE business SET business.status = :status WHERE business.id_user = :idUser ;")
                .setParameter("status", status).setParameter("idUser", idUser).executeUpdate();
        return countUpdate;
    }

    @Transactional
    public Integer updateBranchStatusDto(Integer status, Integer idUser) {
        Integer countUpdate = entityManager
                .createNativeQuery(
                        "UPDATE business, branch SET branch.status = :status WHERE business.id_business = branch.id_business AND business.id_user = :idUser ;")
                .setParameter("status", status).setParameter("idUser", idUser).executeUpdate();
        return countUpdate;
    }
}
