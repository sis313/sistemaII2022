package ucb.edu.bo.demo.dao;

import ucb.edu.bo.demo.dto.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class TypeDao {
    private DataSource dataSource;

    @Autowired
    public TypeDao(DataSource dataSource){
        this.dataSource=dataSource;
    }

    public List<Type> getAllTypes(){
        List<Type> result=new ArrayList<>();
        String query = "SELECT * FROM type_business";

        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement pstmt =  conn.prepareStatement(query);
                ) {
                System.out.println(query);
                ResultSet rs = pstmt.executeQuery();
                while (rs.next()) {
                    Type type = new Type();
                    type.setId_type_business(rs.getInt("id_type_business"));
                    type.setName(rs.getString("name"));
                    result.add(type);
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
