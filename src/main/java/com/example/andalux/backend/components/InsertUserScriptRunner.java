package com.example.andalux.backend.components;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ScriptUtils;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;

@Component
public class InsertUserScriptRunner implements CommandLineRunner {

    private final DataSource dataSource;

    public InsertUserScriptRunner(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) throws Exception {
        try (Connection conn = dataSource.getConnection()) {
            ScriptUtils.executeSqlScript(conn, new ClassPathResource("db/insert_user.sql"));
            System.out.println("✅ insert_user.sql executed successfully.");
        } catch (Exception e) {
            System.err.println("❌ Failed to execute insert_user.sql: " + e.getMessage());
        }
    }
}
