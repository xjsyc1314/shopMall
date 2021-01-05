package studyIO.zuoye.shopmall;

import java.io.*;
import java.util.Scanner;

public class ShopMallTest {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        File file = new File("D:\\java代码\\培训\\12.07\\src\\studyIO\\zuoye\\shopmall\\ShopMall.txt");
        while (true)
        if (file.length()==0) {
            System.out.println("没有超市，需要创建超市\n请输入超市名字");
            ShopMall shopMall = new ShopMall(in.nextLine());
            ObjectOutputStream oot = new ObjectOutputStream(new FileOutputStream(file));
            oot.writeObject(shopMall);
            oot.close();
        } else {
            ObjectInputStream oit = new ObjectInputStream(new FileInputStream(file));
            ShopMall ss = (ShopMall) oit.readObject();
            System.out.println(ss.name+"超市");
            System.out.println("1.查询 2.开卡 3.退出");
            switch (in.nextInt()) {
                case 1:
                    ss.showAllMenberInformation();
                    break;
                case 2:
                    System.out.println("输入名字：");
                    String name = in.next();
                    System.out.println("输入电话：");
                    String tele = in.next();
                    ss.add(name, tele);
                    break;
                case 3:
                    oit.close();
                    System.exit(0);
                default:
                    System.out.println("输入有误");
            }
        }
    }
}
