package Algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author 吴昊
 * 在一随机长度的字符串当中找到最长的字符串并返回
 * 思路: 将字符串转为一个字符数组，遍历数组的同时将重复数组放到一个新数组中，当遇到不同字符的时候，将扫描的字符长度与数组存储的字符长度进行比较，保留较长的字符串
 */
public class test2 {

    public String findStrs(String str){
        char[] s = str.toCharArray();
        char[] a = new char[0];
        int j = 0;//用于辅助记录字符长度
        int length = 0;//记录字符长度
        if(s.length==0){
            return null;
        }
        for(int i = 1; i<s.length;i++){//遍历所有字符

            length = i==s.length-1 ?i-j+1 : i-j;//当运行到末尾位置时,向后多取一位

              if(s[i]!=s[i-1]||i==s.length-1){//在结尾处的字符串没有下一个作为对比,这时进行一次判断
                  if(a.length<(length)||a.length==0){//如果已经记录的字符长度小于当前扫描到的字符长度或者在初始化的时候 进行数组填充
                      a= new char[length];//长度赋值
                      System.arraycopy(s,j,a,0,length);/*数组赋值 s:原数组 j:起始位置 a:目标数组 0:开始复制的起始位置 length :复制长度*/
                  }
                  j=i;
              }
        }

            return String.valueOf(a);
    }

    public static void main(String[] args) {
        test2 test = new test2();
        String str =  test.findStrs("aaaszbbabbbbcddefffffff");
        System.out.println(str);
    }
}
