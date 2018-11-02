package ru.ezikvice.springotus.homework13.config;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.acls.dao.AclRepository;
import org.springframework.security.acls.domain.*;
import org.springframework.security.acls.jdbc.LookupStrategy;
import org.springframework.security.acls.model.AclCache;
import org.springframework.security.acls.model.PermissionGrantingStrategy;
import org.springframework.security.acls.mongodb.BasicLookupStrategy;
import org.springframework.security.acls.mongodb.MongoDBMutableAclService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.net.UnknownHostException;

@Configuration
@EnableAutoConfiguration
@EnableMongoRepositories(basePackageClasses = {AclRepository.class})
public class ContextConfig {

    @Autowired
    AclRepository aclRepository;

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        return new MongoTemplate(mongoClient, "user_db");
    }

    @Bean
    public AclAuthorizationStrategy aclAuthorizationStrategy() {
        return new AclAuthorizationStrategyImpl(new SimpleGrantedAuthority("ROLE_ADMINISTRATOR"));
    }

    @Bean
    public PermissionGrantingStrategy permissionGrantingStrategy() {
        ConsoleAuditLogger consoleAuditLogger = new ConsoleAuditLogger();
        return new DefaultPermissionGrantingStrategy(consoleAuditLogger);
    }

    @Bean
    public LookupStrategy lookupStrategy() throws UnknownHostException {
        return new BasicLookupStrategy(mongoTemplate(), aclCache(), aclAuthorizationStrategy(), permissionGrantingStrategy());
    }

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("test");
    }

    @Bean
    public AclCache aclCache() {
        Cache springCache = cacheManager().getCache("test");
        return new SpringCacheBasedAclCache(springCache, permissionGrantingStrategy(), aclAuthorizationStrategy());
    }

    @Bean
    public MongoDBMutableAclService aclService() throws UnknownHostException {
        return new MongoDBMutableAclService(aclRepository, lookupStrategy(), aclCache());
    }
}
