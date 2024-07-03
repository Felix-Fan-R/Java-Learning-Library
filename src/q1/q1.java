package q1;
/*
某零售店推出了会员积分制度的促销活动。根据会员的积分数不同，享有不同的消费折扣。
具体规则如下：
如果会员积分小于 2000 分，则消费总金额打 9 折。
如果会员积分大于等于 2000 分且小于 4000 分，则消费总金额打 8 折。
如果会员积分大于等于 4000 分，则消费总金额打 7 折。
定义一个会员商品消费的函数，该函数包含一个参数-积分，根据积分的规则确定折扣率，计算商品的金额。
编写代码，调用以上函数，输出最终商品价格。
 */
public class q1 {
    public static double Price(double allPrice, int points) {
        double tmp;
        if (points < 2000) {
            tmp = 0.9;
        } else if (points >= 2000 && points < 4000) {
            tmp = 0.8;
        } else {
            tmp = 0.7;
        }
        return allPrice * tmp;
    }

    public static void main(String[] args) {
        double allPrice = 100.0;
        int points = 2500;
        double finalPrice = Price(allPrice, points);
        System.out.println("商品价格为: " + finalPrice);
    }
}
