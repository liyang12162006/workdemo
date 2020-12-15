package com.example.example.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

/**
 * 这是单数据源配置
 * @author tianll
 * @date 2020/12/14
 */
@Aspect
@Configuration
public class DaoConfig {

    private static final String TRANSACTION_AOP_POINTCUT = "execution(* com.huitongjy.*.service.impl..*.*(..))";

//    /**
//     * 数据库配置，读取application.properties中的配置参数映射成为一个对象
//     * @return DataSource
//     */
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DataSource dataSourceStatCenter() {
//        return DataSourceBuilder.create().type(DruidDataSource.class).build();
//    }

//    @Autowired
//    private PlatformTransactionManager platformTransactionManager;

    @Bean
    public TransactionInterceptor txAdvice() {

        RuleBasedTransactionAttribute readOnlyTx = new RuleBasedTransactionAttribute();
        readOnlyTx.setReadOnly(true);
        readOnlyTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_SUPPORTS );

        /*当前存在事务就使用当前事务，当前不存在事务就创建一个新的事务*/
        RuleBasedTransactionAttribute requiredTx = new RuleBasedTransactionAttribute();
        requiredTx.setRollbackRules(
            Collections.singletonList(new RollbackRuleAttribute(Throwable.class)));
        requiredTx.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        Map<String, TransactionAttribute> txMap = new HashMap<>();
        txMap.put("create*", requiredTx);
        txMap.put("modify*", requiredTx);
        txMap.put("remove*", requiredTx);
        txMap.put("find*", readOnlyTx);
        txMap.put("*", readOnlyTx);
        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        source.setNameMap(txMap);

        TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
//        transactionInterceptor.setTransactionManager(platformTransactionManager);
        transactionInterceptor.setTransactionAttributeSource(source);
        return transactionInterceptor;
    }

    @Bean
    public Advisor txAdviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(TRANSACTION_AOP_POINTCUT);
        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }

//    @Bean
//    public PageMybatis34Interceptor pageMybatis34Interceptor() {
//        return new PageMybatis34Interceptor();
//    }
}
