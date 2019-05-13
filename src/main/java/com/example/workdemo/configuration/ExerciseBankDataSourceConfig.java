package com.example.workdemo.configuration;

import com.zaxxer.hikari.HikariDataSource;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * HTexercise数据源配置
 * 因为与TCC并存多数据源，所以此处需要手动配置HTexercise数据源
 *
 * @author: tianlle
 * @date: 2019/01/29
 */
@Configuration
@MapperScan(basePackages = "com.huitongjy.exercisebank.dao")
public class ExerciseBankDataSourceConfig {

    /**
     * 读取application.properties中的配置参数映射成为一个对象
     * @return DataSource
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.exercisebank")
    public DataSource dateSourceExerciseBank() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
    @Bean
    public SqlSessionFactory exerciseBankSqlSessionFactory() throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dateSourceExerciseBank());
        //适用于用Java-jar启动 让程序加载mybatis的配置 vfs 加载虚拟文件系统
        bean.setVfs(SpringBootVFS.class);
        bean.setTypeAliasesPackage("com.huitongjy.exercisebank.dao");
        bean.setTypeHandlersPackage("com.huitongjy.exercisebank.dao.support");
        bean.setMapperLocations(
            // 设置mybatis的xml所在位置
            new PathMatchingResourcePatternResolver().getResources("classpath*:mybatis/**/*Mapper.xml"));
        return bean.getObject();
    }
    @Bean
    public SqlSessionTemplate exerciseBankSqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(exerciseBankSqlSessionFactory());
    }
}
