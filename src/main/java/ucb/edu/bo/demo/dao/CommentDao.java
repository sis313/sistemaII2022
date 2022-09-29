package ucb.edu.bo.demo.dao;

import ucb.edu.bo.demo.dto.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CommentDao {
    private DataSource dataSource;

    @Autowired
    public CommentDao(DataSource dataSource){
        this.dataSource=dataSource;
    }

    public List<Comment> getAll(){
        List<Comment> result=new ArrayList<>();
        String query = "SELECT * FROM comment";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
                ) {
                System.out.println(query);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Comment comment = new Comment();
                    comment.setId_comment(rs.getInt("id_business"));
                    comment.setMessage(rs.getString("message"));
                    comment.setId_user(rs.getInt("id_user"));
                    comment.setId_business(rs.getInt("id_business"));
                    comment.setStatus(rs.getInt("status"));

                    result.add(comment);
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

    public List<Comment> getAllByUser(int id_user){
        List<Comment> result=new ArrayList<>();
        String query = "SELECT * FROM comment c where c.id_user = (?)";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
                ) {
                System.out.println(query);
                pstmt.setInt(1, id_user);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Comment comment = new Comment();
                    comment.setId_comment(rs.getInt("id_business"));
                    comment.setMessage(rs.getString("message"));
                    comment.setId_user(rs.getInt("id_user"));
                    comment.setId_business(rs.getInt("id_business"));
                    comment.setStatus(rs.getInt("status"));

                    result.add(comment);
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

    public List<Comment> getByIdAndUser(int id_user, int id_comment){
        List<Comment> result=new ArrayList<>();
        String query = "SELECT * FROM comment c where c.id_user = (?) AND c.id_comment = (?)";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
                ) {
                System.out.println(query);
                pstmt.setInt(1, id_user);
                pstmt.setInt(2, id_comment);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Comment comment = new Comment();
                    comment.setId_comment(rs.getInt("id_business"));
                    comment.setMessage(rs.getString("message"));
                    comment.setId_user(rs.getInt("id_user"));
                    comment.setId_business(rs.getInt("id_business"));
                    comment.setStatus(rs.getInt("status"));

                    result.add(comment);
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

    public List<Comment> getById(int id_comment){
        List<Comment> result=new ArrayList<>();
        String query = "SELECT * FROM comment c where c.id_comment = (?)";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
                ) {
                System.out.println(query);
                pstmt.setInt(2, id_comment);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Comment comment = new Comment();
                    comment.setId_comment(rs.getInt("id_business"));
                    comment.setMessage(rs.getString("message"));
                    comment.setId_user(rs.getInt("id_user"));
                    comment.setId_business(rs.getInt("id_business"));
                    comment.setStatus(rs.getInt("status"));

                    result.add(comment);
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

}
