package ucb.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import ucb.app.dto.BranchRatingCountDto;
import ucb.app.dto.BusinessBranchActiveCountDto;
import ucb.app.dto.BusinessCountDto;
import ucb.app.dto.BusinessZoneDto;
import ucb.app.dto.LogAnualCountDto;
import ucb.app.dto.LogDayCountDto;
import ucb.app.dto.LogGlobalCountDto;
import ucb.app.dto.LogMonthCountDto;
import ucb.app.dto.LogQuarterCountDto;
import ucb.app.dto.LogSemesterCountDto;

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
                "SELECT c.id_business AS idBusiness, c.name AS name, b.id_branch AS idBranch, b.address AS address, AVG(a.score) AS averageScore, COUNT(a.id_rating) AS countIdRating FROM rating a JOIN branch b ON a.id_branch = b.id_branch JOIN business c ON b.id_business = c.id_business GROUP BY b.id_branch;",
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

    @Transactional
    public List<LogGlobalCountDto> findLogGlobalCountDto() {
        @SuppressWarnings("unchecked")
        List<LogGlobalCountDto> logGlobalDtos = (List<LogGlobalCountDto>) entityManager.createNativeQuery(
                "SELECT c.id_business AS idBusiness, c.name AS name, b.id_branch AS idBranch, b.address AS address, COUNT(a.id_log) AS count FROM log a JOIN branch b ON a.id_branch = b.id_branch JOIN business c ON b.id_business = c.id_business GROUP BY b.id_branch ORDER BY COUNT(a.id_log) DESC;",
                "LogGlobalCount").getResultList();
        return logGlobalDtos;
    }

    @Transactional
    public List<LogAnualCountDto> findLogAnualCountDto() {
        @SuppressWarnings("unchecked")
        List<LogAnualCountDto> logAnualCountDtos = (List<LogAnualCountDto>) entityManager.createNativeQuery(
                "SELECT c.id_business AS idBusiness, c.name AS name, b.id_branch AS idBranch, b.address AS address, YEAR(a.date) AS year, COUNT(a.id_log) AS count FROM log a JOIN branch b ON a.id_branch = b.id_branch JOIN business c ON b.id_business = c.id_business GROUP BY b.id_branch, YEAR(a.date) ORDER BY YEAR(a.date), b.id_branch;",
                "LogAnualCount").getResultList();
        return logAnualCountDtos;
    }

    @Transactional
    public List<LogSemesterCountDto> findLogSemesterCountDto() {
        @SuppressWarnings("unchecked")
        List<LogSemesterCountDto> logSemesterCountDtos = (List<LogSemesterCountDto>) entityManager.createNativeQuery(
                "SELECT c.id_business AS idBusiness, c.name AS name, b.id_branch AS idBranch, b.address AS address, YEAR(a.date) AS year, COUNT(a.id_log) AS count, IF(MONTH(a.date) < 7,1,2) AS semester, YEAR(a.date) AS yearSemeter FROM log a JOIN branch b ON a.id_branch = b.id_branch JOIN business c ON b.id_business = c.id_business GROUP BY b.id_branch, YEAR(a.date), semester ORDER BY YEAR(a.date), semester, b.id_branch;",
                "LogSemesterCount").getResultList();
        return logSemesterCountDtos;
    }

    @Transactional
    public List<LogQuarterCountDto> findLogQuarterCountDto() {
        @SuppressWarnings("unchecked")
        List<LogQuarterCountDto> logQuarterCountDtos = (List<LogQuarterCountDto>) entityManager.createNativeQuery(
                "SELECT c.id_business AS idBusiness, c.name AS name, b.id_branch AS idBranch, b.address AS address, YEAR(a.date) AS year, quarter(a.date) AS quarter, COUNT(a.id_log) AS count FROM log a JOIN branch b ON a.id_branch = b.id_branch JOIN business c ON b.id_business = c.id_business GROUP BY b.id_branch, YEAR(a.date), quarter(a.date) ORDER BY YEAR(a.date), quarter(a.date), b.id_branch;",
                "LogQuarterCount").getResultList();
        return logQuarterCountDtos;
    }

    @Transactional
    public List<LogMonthCountDto> findLogMonthCountDto() {
        @SuppressWarnings("unchecked")
        List<LogMonthCountDto> logMonthCountDtos = (List<LogMonthCountDto>) entityManager.createNativeQuery(
                "SELECT c.id_business AS idBusiness, c.name AS name, b.id_branch AS idBranch, b.address AS address, YEAR(a.date) AS year, MONTH(a.date) AS month, COUNT(a.id_log) AS count FROM log a JOIN branch b ON a.id_branch = b.id_branch JOIN business c ON b.id_business = c.id_business GROUP BY b.id_branch, YEAR(a.date), MONTH(a.date) ORDER BY YEAR(a.date), MONTH(a.date), b.id_branch;",
                "LogMonthCount").getResultList();
        return logMonthCountDtos;
    }

    @Transactional
    public List<LogDayCountDto> findLogDayCountDto() {
        @SuppressWarnings("unchecked")
        List<LogDayCountDto> logDayCountDtos = (List<LogDayCountDto>) entityManager.createNativeQuery(
                "SELECT c.id_business AS idBusiness, c.name AS name, b.id_branch AS idBranch, b.address AS address, DATE(a.date) AS date, COUNT(a.id_log) AS count FROM log a JOIN branch b ON a.id_branch = b.id_branch JOIN business c ON b.id_business = c.id_business GROUP BY b.id_branch, DATE(a.date) ORDER BY DATE(a.date), b.id_branch;",
                "LogDayCount").getResultList();
        return logDayCountDtos;
    }

    @Transactional
    public List<LogAnualCountDto> findLogAnualCountByUserIdDto(Integer idUser) {
        @SuppressWarnings("unchecked")
        List<LogAnualCountDto> logAnualCountDtos = (List<LogAnualCountDto>) entityManager.createNativeQuery(
                "SELECT c.id_business AS idBusiness, c.name AS name, b.id_branch AS idBranch, b.address AS address, YEAR(a.date) AS year, COUNT(a.id_log) AS count FROM log a JOIN branch b ON a.id_branch = b.id_branch JOIN business c ON b.id_business = c.id_business WHERE a.id_user = :idUser GROUP BY b.id_branch, YEAR(a.date) ORDER BY YEAR(a.date), b.id_branch;",
                "LogAnualCount").setParameter("idUser", idUser).getResultList();
        return logAnualCountDtos;
    }

    @Transactional
    public List<BusinessBranchActiveCountDto> findBusinessBranchActiveCountDto() {
        @SuppressWarnings("unchecked")
        List<BusinessBranchActiveCountDto> businessBranchActiveCountDtos = (List<BusinessBranchActiveCountDto>) entityManager
                .createNativeQuery(
                        "SELECT bu.id_business AS idBusiness, bu.name AS name, bu.description AS description, bu.id_type_business AS idTypeBusiness, bu.id_user AS idUser, bu.create_date AS createDate, bu.update_date AS updateDate, bu.status AS status, COUNT(bu.id_business) AS activeBranchCount FROM business AS bu, branch AS br WHERE bu.id_business = br.id_business AND br.status = 1 GROUP BY bu.id_business;",
                        "BusinessBranchActiveCount")
                .getResultList();
        return businessBranchActiveCountDtos;
    }
}
