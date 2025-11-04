package app.config;

import org.hibernate.dialect.MariaDBDialect;

public class CustomMariaDBDialect extends MariaDBDialect {
    @Override
    public String getAlterTableString(String tableName) {
        return "alter table " + tableName;
    }
}
