package com.lanle.algorithm;

/**
 * 冒泡排序
 * 描述：外层循环排序论询次数，内层比大小
 * 特点：效率低，实现简单
 */
public class BubbleSort {

    /**
     * 冒泡排序
     * @param arrays 排序数组
     * @param order 升序降序 0升序;1降序
     * @return
     */
    public static int[] sort(int[] arrays,int order){
        for (int i = 1; i < arrays.length; i++) {
            for (int j = 0; j < arrays.length-i; j++) {
                if(0 == order){
                    if (arrays[j] > arrays[j+1]){
                        int temp = arrays[j];
                        arrays[j] = arrays[j+1];
                        arrays[j+1] = temp;
                    }
                }else{
                    if (arrays[j] < arrays[j+1]){
                        int temp = arrays[j];
                        arrays[j] = arrays[j+1];
                        arrays[j+1] = temp;
                    }
                }
            }
        }
        return arrays;
    }

    public static void main(String[] args) {
        int[] testArrays = new int[]{21,12,45,32,7,3};
        int[] result = BubbleSort.sort(testArrays,1);
        for (int i : result) {
            System.out.print(i+"\t");
        }
    }
}
