package com.javayh.probe.link.util;

import com.javayh.probe.link.configuration.ProbeLinkProperties;
import com.javayh.probe.link.registration.metadata.ProbeLink;

import java.sql.*;

/**
 * <p>
 *
 * </p>
 *
 * @author hai ji
 * @version 1.0.0
 * @since 2023-05-31
 */
public class JdbcUtils {

    /**
     * 获取数据库连接
     *
     * @param url      数据库链接
     * @param username 用户名
     * @param password 密码
     * @param driver   驱动类型
     * @return 数据库链接 {@link Connection}
     */
    public static Connection getConnection(ProbeLinkProperties probeLinkProperties) {
        try {
            Class.forName(probeLinkProperties.getDriver());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(probeLinkProperties.getUrl(), probeLinkProperties.getUsername(), probeLinkProperties.getPassword());
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭结果集、语句和连接
     *
     * @param rs   {@link ResultSet}
     * @param psmt {@link PreparedStatement}
     * @param conn {@link Connection}
     */
    public static void close(Connection conn, PreparedStatement psmt, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (psmt != null) {
                psmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void serverBatch(ProbeLinkProperties probeLinkProperties, ProbeLink baseInfo) {
        Connection conn = getConnection(probeLinkProperties);

        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(null);
            for (int i = 1; i <= 1000000; i++) {
                ps.setObject(1, i);
                ps.addBatch();
                if (i % 500 == 0) {
                    ps.executeBatch();
                    ps.clearBatch();
                }
            }
            ps.executeBatch();
            ps.clearBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(conn, ps, null);
        }

    }




}

