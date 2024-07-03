package q6;
/*
.利用面向对象思想设计开发一个手机系统，设计相关的类和接口，实现对手
机的阅读和输入功能，显示输出基本信息。依据以上要求，开发类和接口：
1）开发一个Phone类（手机），
要求如下：该类为抽象类。定义私有属性：手机的价格，公有属性：手机的品牌。
定义一个有无参构造方法。定义一个有参构造方法，对手机的价格进行赋值。定义手机价格的setter 和getter方法。
该类具有print()抽象方法。
2）开发一个IUsb接口，
要求如下：该接口有一个读功能的抽象方法 read()。该接口有一个写功能的抽象方法write()。
3）开发一个HuaWeiPhone类（华为手机），
要求如下：该类是Phone的子类，并实现了IUsb接口。重写父类Phone的print()方法，
输出手机的品牌。实现接口IUsb的read()方法和write()方法。
4）开发一个Test类，该类为测试类，要求如下：创建HuaWeiPhone对象，通过构造方法初始化对象，
调用print() 方法、read()方法和write()方法，输出对象相关的信息。
 */

public class q6 {
    public static void main(String[] args) {
        HuaWeiPhone huaweiPhone = new HuaWeiPhone(999.99);
        huaweiPhone.print();
        huaweiPhone.read();
        huaweiPhone.write();
    }
}
