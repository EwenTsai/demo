package com.example.demo.redis.service;

public interface RedisService {

    /**
     * redis存储
     * @param key 键值
     * @param val 值
     * @param expires 过期时间
     */
    void store(String key, Object val, long expires);

    /**
     * 根据key值获取val
     * @param key 键值
     * @return { val }
     */
    Object get(String key);

    /**
     * 删除key缓存
     * @param key 键值
     */
    void delete(String key);

    /**
     * 是否存在key值
     * @param key 键值
     * @return { true or false }
     */
    boolean hasKey(String key);

}
