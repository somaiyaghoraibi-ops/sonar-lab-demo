package edu.psau.se4221;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HexFormat;

/**
 * Intentionally vulnerable class for the Security part of the lab.
 * Students will fix the SQL injection, hardcoded credential, and
 * weak hashing findings, then re-run the analysis.
 */
public class UserDao {

    // Vulnerability: hardcoded credential
    private static final String DB_PASS = "P@ssw0rd123!";

    // Vulnerability: SQL injection via string concatenation
    public String findByName(Connection conn, String name) throws Exception {
        String sql = "SELECT * FROM users WHERE name = '" + name + "'";
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getString("name");
            }
            return null;
        }
    }

    // Security hotspot: weak hashing algorithm
    public String hash(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(password.getBytes());
        return HexFormat.of().formatHex(digest);
    }

    public String dbPassword() {
        return DB_PASS;
    }
}
