package Algorithm;

/**
 * 算法面试题--1
 */
public class test1 {
    public static void main(String[] args) {
        //System.out.println(containExectly2("abccv","ccvss"));
        System.out.println(containExectly1("abccv","cv"));
    }

    /**
     * 给定长度为m的字符串aim,以及一个长度为n的字符串str,问能否在str中找到一个长度为m的连续字串，使得这个字串刚好由aim的m个字符组成，顺序无所谓
     * 返回一个人任意满足条件的一个字串的起始位置吗，未找到返回-1
     * @param str
     * @param aim
     * @return
     */
    public static int containExectly1(String str,String aim){
        if(str==null||aim==null&&str.length()<aim.length()){
            return  -1;
        }
        char [] s = str.toCharArray();
        char [] a = aim.toCharArray();
        for (int l = 0; l <=s.length-a.length ; l++) {
            if (isTY(s,a,l)){
                return l;
            }
        }

        return -1;
    }
    public static boolean isTY(char[] s,char[] aim,int l){
            //利用char强制int 后为对应的ascii码值  给定一个长度为256的int类型数组 将aim字符对应的位置加一 在s中进行查找 进行减操作，如果数目不对应就会出现数组位置小于
            int count[] = new int[256];
            for (int i = 0; i <aim.length ; i++) {
                count[  aim[i]  ]++;
            }
            for (int i = 0; i <aim.length ; i++) {
              if(  count[  s[l+i]  ]--==0){
                  return false;
              }
            }

        return true;
    }
    public static int containExectly2(String str,String aim){
        char [] s = str.toCharArray();
        char [] a = aim.toCharArray();
        int M= a.length;
        int count[] = new int [256];
        for (int i = 0; i <M; i++) {
            count[ a[i] ]++;
        }
        int inValidTimes = 0;
        int R = 0;

        for (; R < M; R++) {
            if(count[s[R]] --<=0){
                inValidTimes++;
            }
        }
        for (; R <s.length ; R++) {
            if(inValidTimes==0){
                return R-M;
            }
            if(count[s[R]]--<=0){
                inValidTimes++;
            }
            if (count[s[R-M]]++<0){
                inValidTimes--;
            }
        }
        return inValidTimes==0 ? R-M : -1;
    }
}
