package studyIO.zuoye.shopmall;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ShopMall implements Serializable {
    String name;
    List<Member> list = new ArrayList<>();

    public ShopMall(){

    }

    public ShopMall(String name) {
        this.name = name;
    }

    //    Member[] men = new Member[100];  //每个商场里都有会员数组
//    int count = 0;          //每次实例化商场的时候 都回加载



    //获取当前会员信息
    public void showAllMenberInformation() throws Exception{
        File file = new File("D:\\java代码\\培训\\12.07\\src\\studyIO\\zuoye\\shopmall\\Member.txt");
        if (file.length()==0){
            System.out.println("请先加入会员。");
            return;
        }
        ObjectInputStream oit = new ObjectInputStream(new FileInputStream(file));
        List<Member> list1 = (List<Member>) oit.readObject();
        for (Member ll:list1){
            ll.show();
            System.out.println("=====================");
        }
        oit.close();
//        for (Member member:men){
//            member.show();
//        }
    }
    //添加新会员开卡的方法
    public boolean add(String name,String tele){
        try {
            ObjectInputStream oit = new ObjectInputStream(new FileInputStream("D:\\java代码\\培训\\12.07\\src\\studyIO\\zuoye\\shopmall\\Member.txt"));
            list = (List<Member>) oit.readObject();
            oit.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //没有上一步的话  list每次添加都会覆盖前面对象
//        System.out.println(list.size());
        String number = 123+tele;
//        int integral = 100;  //初始话积分100
        list.add(new Member(number, name, tele, 100));
//        System.out.println(list.size());
//        list.add(new Member(number, name, tele, 1000));
        ObjectOutputStream oot = null;
        try {
            oot = new ObjectOutputStream(new FileOutputStream("D:\\java代码\\培训\\12.07\\src\\studyIO\\zuoye\\shopmall\\Member.txt"));
            oot.writeObject(list);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert oot != null;
                oot.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
