package edu.ksu.swe6633.finalproj.config.database;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import javax.sql.DataSource;
import java.util.Properties;

public class DataSourceModule extends AbstractModule {

    @Override
    protected void configure() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Names.bindProperties(binder(), loadProperties());
        bind(DataSource.class).toProvider(MySqlDataSourceProvider.class).in(Scopes.SINGLETON);

    }
    @Provides
    @DbSchema
    @Singleton
    String provideDbSchema() {
        return "swe6633_stp";
    }

    static class MySqlDataSourceProvider implements Provider<DataSource> {
        private final String url;
        private final String username;
        private final String password;

        @Inject
        public MySqlDataSourceProvider(@Named("url") final String url,
                                       @Named("username") final String username,
                                       @Named("password") final String password) {
            this.url = url;
            this.username = username;
            this.password = password;
        }

        public DataSource get() {
            final MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);
            return dataSource;
        }
    }
    private Properties loadProperties() {
        Properties properties = new Properties();
        properties.setProperty("url", "jdbc:mysql://localhost:3306/swe6633_stp");
        properties.setProperty("username", "java");
        //TODO Not this.
        properties.setProperty("password", "Hackers2010");
        return properties;
    }
}
