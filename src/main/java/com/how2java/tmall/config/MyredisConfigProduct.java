package com.how2java.tmall.config;

import com.how2java.tmall.pojo.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * ClassName:MyredisConfigProduct
 * Package:com.how2java.tmall.config
 * Description:
 *
 * @date:2019/6/4 15:57
 * @author:廖凡
 */
@Configuration
public class MyredisConfigProduct {
    /**
     * Product的redisConfig
     * @param redisConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<Object,Product> productRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object, Product> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<Product> serializer = new Jackson2JsonRedisSerializer<Product>(Product.class);
        template.setDefaultSerializer(serializer);
        return template;
    }
    @Bean
    public RedisCacheManager blogCacheManager(RedisTemplate<Object, Product> productRedisTemplate){
        //注入自己定义的RedisTemplate
        RedisCacheManager cacheManager = new RedisCacheManager(productRedisTemplate);
        //使用前缀
        cacheManager.setUsePrefix(true);
        return cacheManager;
    }
}
