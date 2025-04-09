package config;

import chapter07.MemberDao;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "chapter07")
public class AppConfig {
    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://daelim-spring.ctss2wq4sozt.ap-northeast-2.rds.amazonaws.com:3306/daelim");
        dataSource.setUsername("admin");
        dataSource.setPassword("admin1234");

        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);

        return dataSource;
    }

    @Bean
    public MemberDao memberDao() {
        return new MemberDao(dataSource());
    }
}