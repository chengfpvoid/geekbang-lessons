package org.geektimes.projects.user.web.listener;

import org.geektimes.projects.user.sql.DBConnectionManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ConcurrentHashMap;

import static org.geektimes.projects.user.sql.DBConnectionManager.*;

@WebListener
public class DBConnectionInitializerListener implements ServletContextListener {
    public static ConcurrentHashMap<String,Object> BEAN_MAP = new ConcurrentHashMap<>();

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        String databaseURL = "jdbc:derby:~/user-platform;create=true";
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection connection = DriverManager.getConnection(databaseURL);
            Statement statement = connection.createStatement();
            // 删除 users 表
            boolean isExist = statement.execute("SELECT COUNT(*) FROM users");
            if (isExist) {
                statement.execute(DROP_USERS_TABLE_DDL_SQL); // false
            }
            //statement.execute(DROP_USERS_TABLE_DDL_SQL); // false
            // 创建 users 表
            statement.execute(CREATE_USERS_TABLE_DDL_SQL); // false
            statement.executeUpdate(INSERT_USER_DML_SQL);  // 5
            DBConnectionManager dbConnectionManager = new DBConnectionManager();
            dbConnectionManager.setConnection(connection);
            BEAN_MAP.put("dBConnectionManager",dbConnectionManager);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DBConnectionManager dbConnectionManager = (DBConnectionManager) BEAN_MAP.get("dBConnectionManager");
        dbConnectionManager.releaseConnection();

    }
}
