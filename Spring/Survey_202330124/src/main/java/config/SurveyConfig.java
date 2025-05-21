package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import survey.SurveyDao;

@Configuration
@ComponentScan
@EnableTransactionManagement
public class SurveyConfig {
    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource());

        return dataSourceTransactionManager;
    }

    @Bean(destroyMethod = "close")
    public DataSource dataSource() {
        DataSource dataSource = new DataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://daelim-spring.c1ckki2c2889.ap-northeast-2.rds.amazonaws.com/Survey_202330124?characterEncoding=utf8");
        dataSource.setUsername("admin");
        dataSource.setPassword("daelimspring");

        dataSource.setInitialSize(5);
        dataSource.setMaxActive(10);

        return dataSource;
    }

    @Bean
    public SurveyDao surveyDao() {
        return new SurveyDao(dataSource());
    }
}