package Tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试工具 ：代码执行时间
 */
public class Times {
    private  static  final SimpleDateFormat fmt = new SimpleDateFormat("HH:mm:ss.SS");

    public interface Task{
        void  execute();
    }
    public  static  void test(String title,Task task){
        if (task==null)return;
        title =(title==null)? "":("【"+title+"】") ;
        System.out.println(title);
        System.out.println("开始："+fmt.format(new Date()));
        long begin  = System.currentTimeMillis();
        task.execute();
        long end = System.currentTimeMillis();
        System.out.println("结束："+fmt.format(new Date()));
        double time = (end - begin)/1000.0;
        System.out.println("耗时"+time+"秒");
        System.out.println("_______________________-");
    }
}
