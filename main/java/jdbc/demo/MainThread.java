package jdbc.demo;

import jdbc.entity.Categories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainThread {
    public static void main(String[] args) {
        Categories categories = new Categories();
        categories.setId(1);
        categories.setName("C1");
        categories.setDescription("Category1");
        categories.setThumbail("Anh1");
        categories.setCreatedAt(java.sql.Date.valueOf("2013-09-04"));
        insertCategories(categories);
    }
    public static void insertCategories(Categories categories){
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/t1908e_jdbc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Asia/Bangkok&characterEncoding=utf-8","root","");
            String queryString = "INSERT INTO categories" +
                    "(id, `name`, description, thumbail, createdAt, status)" +
                    "VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setInt(1,categories.getId());
            preparedStatement.setString(2,categories.getName());
            preparedStatement.setString(3,categories.getDescription());
            preparedStatement.setString(4,categories.getThumbail());
            preparedStatement.setDate(5,categories.getCreatedAt());
            preparedStatement.setInt(6,categories.getStatus());
            preparedStatement.execute();
            System.out.println("Thao tác thành công");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
