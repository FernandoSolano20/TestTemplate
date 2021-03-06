package cr.ac.ucenfotec.test.config;

import java.time.Duration;

import org.ehcache.config.builders.*;
import org.ehcache.jsr107.Eh107Configuration;

import org.hibernate.cache.jcache.ConfigSettings;
import io.github.jhipster.config.JHipsterProperties;

import org.springframework.boot.autoconfigure.cache.JCacheManagerCustomizer;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.boot.info.BuildProperties;
import org.springframework.boot.info.GitProperties;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import io.github.jhipster.config.cache.PrefixedKeyGenerator;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.*;

@Configuration
@EnableCaching
public class CacheConfiguration {
    private GitProperties gitProperties;
    private BuildProperties buildProperties;
    private final javax.cache.configuration.Configuration<Object, Object> jcacheConfiguration;

    public CacheConfiguration(JHipsterProperties jHipsterProperties) {
        JHipsterProperties.Cache.Ehcache ehcache = jHipsterProperties.getCache().getEhcache();

        jcacheConfiguration = Eh107Configuration.fromEhcacheCacheConfiguration(
            CacheConfigurationBuilder.newCacheConfigurationBuilder(Object.class, Object.class,
                ResourcePoolsBuilder.heap(ehcache.getMaxEntries()))
                .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(ehcache.getTimeToLiveSeconds())))
                .build());
    }

    @Bean
    public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(javax.cache.CacheManager cacheManager) {
        return hibernateProperties -> hibernateProperties.put(ConfigSettings.CACHE_MANAGER, cacheManager);
    }

    @Bean
    public JCacheManagerCustomizer cacheManagerCustomizer() {
        return cm -> {
            createCache(cm, cr.ac.ucenfotec.test.repository.UserRepository.USERS_BY_LOGIN_CACHE);
            createCache(cm, cr.ac.ucenfotec.test.repository.UserRepository.USERS_BY_EMAIL_CACHE);
            createCache(cm, cr.ac.ucenfotec.test.domain.User.class.getName());
            createCache(cm, cr.ac.ucenfotec.test.domain.Authority.class.getName());
            createCache(cm, cr.ac.ucenfotec.test.domain.User.class.getName() + ".authorities");
            createCache(cm, cr.ac.ucenfotec.test.domain.Image.class.getName());
            createCache(cm, cr.ac.ucenfotec.test.domain.ApplicationUser.class.getName());
            createCache(cm, cr.ac.ucenfotec.test.domain.ApplicationUser.class.getName() + ".paymentMethods");
            createCache(cm, cr.ac.ucenfotec.test.domain.ApplicationUser.class.getName() + ".proyects");
            createCache(cm, cr.ac.ucenfotec.test.domain.ApplicationUser.class.getName() + ".donations");
            createCache(cm, cr.ac.ucenfotec.test.domain.ApplicationUser.class.getName() + ".notifications");
            createCache(cm, cr.ac.ucenfotec.test.domain.ApplicationUser.class.getName() + ".payments");
            createCache(cm, cr.ac.ucenfotec.test.domain.ApplicationUser.class.getName() + ".favorites");
            createCache(cm, cr.ac.ucenfotec.test.domain.PaymentMethod.class.getName());
            createCache(cm, cr.ac.ucenfotec.test.domain.Proyect.class.getName());
            createCache(cm, cr.ac.ucenfotec.test.domain.Proyect.class.getName() + ".images");
            createCache(cm, cr.ac.ucenfotec.test.domain.Proyect.class.getName() + ".donations");
            createCache(cm, cr.ac.ucenfotec.test.domain.Proyect.class.getName() + ".checkpoints");
            createCache(cm, cr.ac.ucenfotec.test.domain.Proyect.class.getName() + ".reviews");
            createCache(cm, cr.ac.ucenfotec.test.domain.Proyect.class.getName() + ".partners");
            createCache(cm, cr.ac.ucenfotec.test.domain.Proyect.class.getName() + ".raffles");
            createCache(cm, cr.ac.ucenfotec.test.domain.Proyect.class.getName() + ".auctions");
            createCache(cm, cr.ac.ucenfotec.test.domain.Proyect.class.getName() + ".exclusiveContents");
            createCache(cm, cr.ac.ucenfotec.test.domain.Proyect.class.getName() + ".payments");
            createCache(cm, cr.ac.ucenfotec.test.domain.ProyectAccount.class.getName());
            createCache(cm, cr.ac.ucenfotec.test.domain.Category.class.getName());
            createCache(cm, cr.ac.ucenfotec.test.domain.Category.class.getName() + ".proyects");
            createCache(cm, cr.ac.ucenfotec.test.domain.Checkpoint.class.getName());
            createCache(cm, cr.ac.ucenfotec.test.domain.Review.class.getName());
            createCache(cm, cr.ac.ucenfotec.test.domain.DonationHistory.class.getName());
            createCache(cm, cr.ac.ucenfotec.test.domain.Auction.class.getName());
            createCache(cm, cr.ac.ucenfotec.test.domain.Raffle.class.getName());
            createCache(cm, cr.ac.ucenfotec.test.domain.ExclusiveContent.class.getName());
            createCache(cm, cr.ac.ucenfotec.test.domain.Prize.class.getName());
            createCache(cm, cr.ac.ucenfotec.test.domain.Prize.class.getName() + ".images");
            createCache(cm, cr.ac.ucenfotec.test.domain.PartnerRequest.class.getName());
            createCache(cm, cr.ac.ucenfotec.test.domain.Notification.class.getName());
            createCache(cm, cr.ac.ucenfotec.test.domain.Payment.class.getName());
            createCache(cm, cr.ac.ucenfotec.test.domain.UserPreferences.class.getName());
            createCache(cm, cr.ac.ucenfotec.test.domain.AdminPreferences.class.getName());
            createCache(cm, cr.ac.ucenfotec.test.domain.Fee.class.getName());
            createCache(cm, cr.ac.ucenfotec.test.domain.AppLog.class.getName());
            createCache(cm, cr.ac.ucenfotec.test.domain.Recommendation.class.getName());
            createCache(cm, cr.ac.ucenfotec.test.domain.PasswordHistory.class.getName());
            // jhipster-needle-ehcache-add-entry
        };
    }

    private void createCache(javax.cache.CacheManager cm, String cacheName) {
        javax.cache.Cache<Object, Object> cache = cm.getCache(cacheName);
        if (cache == null) {
            cm.createCache(cacheName, jcacheConfiguration);
        }
    }

    @Autowired(required = false)
    public void setGitProperties(GitProperties gitProperties) {
        this.gitProperties = gitProperties;
    }

    @Autowired(required = false)
    public void setBuildProperties(BuildProperties buildProperties) {
        this.buildProperties = buildProperties;
    }

    @Bean
    public KeyGenerator keyGenerator() {
        return new PrefixedKeyGenerator(this.gitProperties, this.buildProperties);
    }
}
