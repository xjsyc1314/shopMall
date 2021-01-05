package studyIO.zuoye.shopmall;

import java.io.Serializable;

public class Member implements Serializable {
    //一商场的会员系统中，有多个会员，用对象数组表示，假设为100个，
    //会员属性有会员号，姓名，手机号，积分，
    private String number;
    private String name;
    private String tele;
    private int integral;

    public Member(String number, String name, String tele, int integral){
        this.integral = integral;
        this.name = name;
        this.tele = tele;
        this.number = number;
    }


    public String getNumber() {
        return number;
    }

    public void setIntegral(int integral) {
        if (integral<0)
            integral = 0;
        this.integral += integral;
    }

    public int getIntegral() {
        return integral;
    }

    public void show() {
        System.out.printf("会员姓名：%s,\n会员号：%s\n电话号码：%s\n积分：%s\n",name, number, tele, integral);
    }

}
