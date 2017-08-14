package mybatis;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.GemFireCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;
import org.springframework.data.gemfire.support.GemfireCacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestTemplate;

import java.util.Properties;

@SpringBootApplication
@EnableCaching
@SuppressWarnings("unused")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {

        return (container -> {
            ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/401.html");
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html");

            container.addErrorPages(error401Page, error404Page, error500Page);
        });
    }
//    @Bean
//    DarkSkyCacheService darkSkyCacheService() {
//        return new DarkSkyCacheService();
//    }

    @Bean
    Properties gemfireProperties() {
        Properties gemfireProperties = new Properties();
        gemfireProperties.setProperty("name", "DataGemFireCachingApplication");
        gemfireProperties.setProperty("mcast-port", "0");
        gemfireProperties.setProperty("log-level", "config");
        return gemfireProperties;
    }

    @Bean
    CacheFactoryBean gemfireCache() {
        CacheFactoryBean gemfireCache = new CacheFactoryBean();
        gemfireCache.setClose(true);
        gemfireCache.setProperties(gemfireProperties());
        return gemfireCache;
    }

    @Bean
    LocalRegionFactoryBean<Integer, Integer> quotesRegion(GemFireCache cache) {
        LocalRegionFactoryBean<Integer, Integer> quotesRegion = new LocalRegionFactoryBean<>();
        quotesRegion.setCache(cache);
        quotesRegion.setClose(false);
        quotesRegion.setName("DarkSky");
        quotesRegion.setPersistent(false);
        return quotesRegion;
    }

    @Bean
    GemfireCacheManager cacheManager(Cache gemfireCache) {
        GemfireCacheManager cacheManager = new GemfireCacheManager();
        cacheManager.setCache(gemfireCache);
        return cacheManager;
    }

//    @Override
//    public void run(String... args) throws Exception {
//        DarkSky darkSky = darkSkyCacheService(12l);
//        requestDarkSky(darkSky.getId());
//        requestDarkSky(10l);
//    }

//    private DarkSky requestDarkSky(Long id) {
//        DarkSkyCacheService darkSkyCacheService = darkSkyCacheService();
//        long startTime = System.currentTimeMillis();
//        DarkSky darkSky = (id != null ? darkSkyCacheService.requestDarkSky(id) : darkSkyCacheService.requestRandomDarkSky());
//        long elapsedTime = System.currentTimeMillis();
//        System.out.printf("\"%1$s\"%nCache Miss [%2$s] - Elapsed Time [%3$s ms]%n", darkSky,
//                darkSkyCacheService.isCacheMiss(), (elapsedTime - startTime));
//        return darkSky;
//    }
}
