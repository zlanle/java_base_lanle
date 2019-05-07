package com.lanle.algorithm;

/**
 * 选择排序
 * 描述：每一趟从待排序序列，选择一个最小的元素，放到已排好序序列的末尾，剩下的为待排序序列，重复上述步骤直到完成排序
 */
public class SelectOrder {

    /**
     * 选择排序
     * @param array
     * @return
     */
    public static int[] sort(int[] array){
        for (int i = 0; i < array.length - 1; i++){
            int index = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[index] > array[j]){
                    index = j;
                }
            }
            //找到了比array[i]小的则与array[i]交换位置
            if(index != i){
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4,2,3,7,6};
        int[] ints = SelectOrder.sort(array);
        for (int anInt : ints) {
            System.out.print(anInt+"\t");
        }
    }
}
