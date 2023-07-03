package com.atguigu.jedis;

import redis.clients.jedis.Jedis;

import java.util.Random;

public class PhoneCode {
    public static void main(String[] args) {
        //模拟验证码的发送
        verifyCode("113213413");
        //验证
//        getRedisCode("113213413","822263");
    }
    //生成验证码
    public static String getCode(){
        Random random = new Random();
        String code = "";
        for(int i = 0; i < 6; i++){
            int rand = random.nextInt(10);
            code += rand;
        }
        return code;
    }
    //让每一个手机每天只能发送三次，验证码放到redis中去，两分钟内有效
    public static void verifyCode(String phone){
        //连接
        Jedis jedis = new Jedis("192.168.233.131",6379);

        //验证码
        String countKey = "VerifyCode"+phone+":count";
        //验证码key
        String codeKey = "VerifyCode"+phone+":code";
        //每个手机每天只能发送三次
        String count = jedis.get(countKey);
        if(count == null){
            jedis.setex(countKey,24* 60 *60,"1");
        }else if(Integer.parseInt(count) <= 2){
            jedis.incr(countKey);
        }else{
            System.out.println("你今天以及发送三次了");
            jedis.close();
            return;
        }
        //第二步我们给key发在redis中去
        String code = getCode();
        jedis.setex(codeKey,120,code);
        jedis.close();
    }
    public static void getRedisCode(String phone, String code){
        //连接
        Jedis jedis = new Jedis("192.168.233.131",6379);
        String codeKey = "VerifyCode"+phone+":code";
        //判断
        String codeValue = jedis.get(codeKey);
        if(code.equals(codeValue)){
            System.out.println("成功");
        }else{
            System.out.println("失败");
        }
    }
}
