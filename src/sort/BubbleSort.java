package sort;

import Tools.Times;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {96,93,25,66,16,1,2,59841,1561,1156,151,15,54,64,6,46,4,61,111,444,66,55,44,88,99,85,58,71,78,3};

        Times.test("冒泡排序",()->{
                    bubbleSort1(a);
                }
                );

    }
    static   void bubbleSort1(int[] a){
        int l = a.length;
        boolean flag = true;
        for (int i = l-1; i>=0;i--){
            for (int j = 0;j<i;j++){
                if (a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    flag = false;
                }
                if (flag){
                    break;
                }
            }
        }
        for (int p = 0 ; p<l; p++ ){
            System.out.print(a[p]+"___");
        }
    }
}
