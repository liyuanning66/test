package test;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class test2 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Class parentClass = Parent.class;
        Parent parent = (Parent) parentClass.newInstance();
        System.out.println(parent);
        //线程池的方式
        ExecutorService executor = Executors.newFixedThreadPool(3);
        //还有一种需要设置核心参数的方式ThreadPoolExecutor
    }
}
class Parent{

}