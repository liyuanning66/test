package com.atguigu.jedis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

public class JedisDemo2 {
    public static void main(String[] args) {
        //创建集群对象
        HostAndPort hostAndPort = new HostAndPort("192.168.233.133", 6379);
        JedisCluster jedisCluster = new JedisCluster(hostAndPort);

        //进行操作
        jedisCluster.set("b1", "value");
        String value = jedisCluster.get("b1");
        System.out.println("value = " + value);
    }
}
