package test;

public class test1 {
    public static void main(String[] args) {
        Bank bank1 = Bank.getInstance();
        Bank bank2 = Bank.getInstance();
        System.out.println(bank1 == bank2);
        GirlFriend girlFriend = GirlFriend.getInstance();
        GirlFriend girlFriend1 = GirlFriend.getInstance();
        System.out.println(girlFriend1 == girlFriend);
    }
}
//饿汉式（线程安全的）
class Bank{
    //1.私有构造器
    private Bank(){
    }
    //2.在类的内部创建当前类的实例
    private static Bank instance = new Bank();
    //3.创建一个方法获取当前类的实例，必须声明为static的
    public static Bank getInstance(){
        return instance;
    }
}
//懒汉式（线程不安全）
class GirlFriend{
    //1.私有化构造器
    private  GirlFriend(){}

    //2.声明当前类的实例
    private static GirlFriend instance = null;
    //3.声明方法得到实例
    public static GirlFriend getInstance(){
        //判断当前类的实例是否是为null
        if(instance == null) {
            instance = new GirlFriend();
        }
        return instance;
    }
}
