package ucb.edu.bo.demo.dao;

import ucb.edu.bo.demo.dto.Business;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class BusinessDao {
    private DataSource dataSource;

    @Autowired
    public BusinessDao(DataSource dataSource){
        this.dataSource=dataSource;
    }

    public List<Business> getAll(){
        List<Business> result=new ArrayList<>();
        String query = "SELECT * FROM business";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
                ) {
                System.out.println(query);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Business business = new Business();
                    business.setId_business(rs.getInt("id_business"));
                    business.setName(rs.getString("name"));
                    business.setDescription((rs.getString("description")));
                    business.setId_type_business(rs.getInt("id_type_business"));
                    business.setCreate_date(rs.getDate("create_date"));
                    business.setUpdate_date(rs.getDate("update_date"));
                    business.setStatus(rs.getInt("status"));
                    business.setUser_id_user(rs.getInt("user_id_user"));

                    result.add(business);
                }
                rs.close();
                System.out.println("Si se logro :')");
                System.out.println(result);

            } catch (SQLException ex){
                ex.printStackTrace();
                System.out.println("No se logro :(");
            }
        return result;
    }

    public List<Business> getById(int id_b){
        List<Business> result=new ArrayList<>();
        String query = "SELECT * FROM business b where b.id_business = (?) ";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
                ) {
                System.out.println(query);
                pstmt.setInt(1, id_b);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Business business = new Business();
                    business.setId_business(rs.getInt("id_business"));
                    business.setName(rs.getString("name"));
                    business.setDescription((rs.getString("description")));
                    business.setId_type_business(rs.getInt("id_type_business"));
                    business.setCreate_date(rs.getDate("create_date"));
                    business.setUpdate_date(rs.getDate("update_date"));
                    business.setStatus(rs.getInt("status"));
                    business.setUser_id_user(rs.getInt("user_id_user"));

                    result.add(business);
                }
                rs.close();
                System.out.println("Si se logro :')");
                System.out.println(result);

            } catch (SQLException ex){
                ex.printStackTrace();
                System.out.println("No se logro :(");
            }
        return result;
    }

    public List<Business> findByName(String name) {
        List<Business> result = new ArrayList<>();
        String query = "SELECT * FROM  business b WHERE UPPER(b.name) LIKE (?)";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
            ) {
                System.out.println(query);
                pstmt.setString(1, "%"+name.toUpperCase()+ "%");
                ResultSet rs = pstmt.executeQuery();
            
                while(rs.next()) {
                    Business business = new Business();
                    business.setId_business(rs.getInt("id_business"));
                    business.setName(rs.getString("name"));
                    business.setDescription((rs.getString("description")));
                    business.setId_type_business(rs.getInt("id_type_business"));
                    business.setCreate_date(rs.getDate("create_date"));
                    business.setUpdate_date(rs.getDate("update_date"));
                    business.setStatus(rs.getInt("status"));
                    business.setUser_id_user(rs.getInt("user_id_user"));

                    result.add(business);
                }
                rs.close();
                System.out.println("Si se logro :')");
                System.out.println(result);

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("No se logro :(");
            }
        return result;
    } 

    public List<Business> findByType(String name) {
        List<Business> result = new ArrayList<>();
        String query = "SELECT * FROM  business b, type_business t WHERE b.id_type_business = t.id_type_business AND UPPER(t.name) LIKE (?)";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
            ) {
                System.out.println(query);
                pstmt.setString(1, "%"+name.toUpperCase()+ "%");
                ResultSet rs = pstmt.executeQuery();
            
                while(rs.next()) {
                    Business business = new Business();
                    business.setId_business(rs.getInt("id_business"));
                    business.setName(rs.getString("name"));
                    business.setDescription((rs.getString("description")));
                    business.setId_type_business(rs.getInt("id_type_business"));
                    business.setCreate_date(rs.getDate("create_date"));
                    business.setUpdate_date(rs.getDate("update_date"));
                    business.setStatus(rs.getInt("status"));
                    business.setUser_id_user(rs.getInt("user_id_user"));

                    result.add(business);
                }
                rs.close();
                System.out.println("Si se logro :')");
                System.out.println(result);

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("No se logro :(");
            }
        return result;
    } 

    public List<Business> findByNameAndType(String type_name, String business_name) {
        List<Business> result = new ArrayList<>();
        String query = "SELECT * FROM  business b, type_business t WHERE b.id_type_business = t.id_type_business AND UPPER(t.name) LIKE (?) AND UPPER(b.name) LIKE (?)";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
            ) {
                System.out.println(query);
                pstmt.setString(1, "%"+type_name.toUpperCase()+ "%");
                pstmt.setString(2, "%"+business_name.toUpperCase()+ "%");
                ResultSet rs = pstmt.executeQuery();
            
                while(rs.next()) {
                    Business business = new Business();
                    business.setId_business(rs.getInt("id_business"));
                    business.setName(rs.getString("name"));
                    business.setDescription((rs.getString("description")));
                    business.setId_type_business(rs.getInt("id_type_business"));
                    business.setCreate_date(rs.getDate("create_date"));
                    business.setUpdate_date(rs.getDate("update_date"));
                    business.setStatus(rs.getInt("status"));
                    business.setUser_id_user(rs.getInt("user_id_user"));

                    result.add(business);
                }
                rs.close();
                System.out.println("Si se logro :')");
                System.out.println(result);

            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("No se logro :(");
            }
        return result;
    }
}
