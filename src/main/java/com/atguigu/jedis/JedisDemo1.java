package com.atguigu.jedis;

import org.testng.annotations.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

public class JedisDemo1 {
    public static void main(String[] args) {
        //创建jedis对象
        Jedis jedis = new Jedis("192.168.233.131",6379);
        //测试连接
        String value = jedis.ping();
        System.out.println("value = " + value);
    }
    //字符串操作
    @Test
    public void test(){
        //创建jedis对象
        Jedis jedis = new Jedis("192.168.233.131",6379);
        //添加数据
        jedis.set("name", "lucy");
        //同时添加多个数据
        jedis.mset("k1","v1","k2","v2");
        List<String> mget = jedis.mget("k1","k2");
        System.out.println("mget = " + mget);
        //得到k
        Set<String> keys = jedis.keys("*");
        for(String s : keys) {
            System.out.println(s);
        }
    }
    @Test
    public void test1(){
        //创建jedis对象(这里是测试list字符串)
        Jedis jedis = new Jedis("192.168.233.131",6379);
        jedis.lpush("key1", "lucy","mary","jack");
        List<String> key1 = jedis.lrange("key1",0,-1);
        System.out.println("key1 = " + key1);

    }
    //测试set数据类型
    @Test
    public void test2(){
        Jedis jedis = new Jedis("192.168.233.131",6379);
        jedis.sadd("name", "lucy", "mary");
        Set<String> names = jedis.smembers("name");
        System.out.println("names = " + names);

    }
    //测试hashmap
    @Test
    public void test3(){
        Jedis jedis = new Jedis("192.168.233.131",6379);
        jedis.hset("users","age","20");
        String hget = jedis.hget("users", "age");
        System.out.println("hget = " + hget);
    }
    //测试有序的set即测试zset
    @Test
    public void test4(){
        Jedis jedis = new Jedis("192.168.233.131",6379);

        jedis.zadd("china", 100, "shanghai");
        Set<String> china = jedis.zrange("china",0,-1);
        System.out.println("china = " + china);
    }
}
