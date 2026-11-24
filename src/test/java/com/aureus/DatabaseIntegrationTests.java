package com.aureus;

import com.aureus.support.TestcontainerConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Import(TestcontainerConfiguration.class)
public class DatabaseIntegrationTests {

    @Autowired
    private JdbcTemplate  jdbcTemplate;

    @Test
    void shouldConnectToPostgres() {
        Integer result = jdbcTemplate.queryForObject(
                "SELECT 1",
                    Integer.class
        );
        assertThat(result).isEqualTo(1);
    }

    @Test
    void shouldApplyInitialMigration() {
        Boolean applied = jdbcTemplate.queryForObject("""
                SELECT EXISTS (
                    SELECT 1
                    FROM flyway_schema_history
                    WHERE version = '1'
                        AND success = TRUE
                )
                """, Boolean.class
        );
        assertThat(applied).isTrue();
    }

    @Test
    void shouldCreateInitialMigration() {
        Boolean exists = jdbcTemplate.queryForObject("""
                    SELECT EXISTS (
                        SELECT 1
                        FROM information_schema.tables
                        WHERE table_schema = 'public'
                            AND table_name = 'schema_metadata'
                    )
                """, Boolean.class
        );
        assertThat(exists).isTrue();
    }
}
