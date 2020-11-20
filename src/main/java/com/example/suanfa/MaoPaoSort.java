package com.example.suanfa;

/**
 * @author liyangyang
 * @date 2020/11/10 18:28
 * @since 2.4.0.0
 */
public class MaoPaoSort {

    public static void main(String[] args) {
//        int[] arr = {2, 5, 1, 3, 8, 5, 7, 4, 3};
        long now =System.currentTimeMillis();

        for (int i = 0; i <100000 ; i++) {
            int arr[] = { 10237547,10237548,10238320,10237550,10238300,10237551,10237551,10237552,10237553,10237554,10237555,10237556,10237557,10237576,10237577,10237578,10237583,10237584,10238294 };
            //冒泡
            bubbleSort(arr);

            //快速排序
            //quickSort(arr, 0 ,arr.length-1);
        }
        long time = System.currentTimeMillis() - now;

        System.out.println("------：" + time);

    }

    /**
     * 冒泡排序
     *
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int length = arr.length;
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 快速排序
     *
     * @author liyangyang
     * @date 2020-11-11 10:59
     * @since 2.9.0.0
     */
        public static void quickSort(int[] array, int left, int right) {
            if(left > right) {
                return;
            }
            // base中存放基准数
            int base = array[left];
            int i = left, j = right;
            while(i != j) {
                // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
                while(array[j] >= base && i < j) {
                    j--;
                }

                // 再从左往右边找，直到找到比base值大的数
                while(array[i] <= base && i < j) {
                    i++;
                }

                // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
                if(i < j) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }

            // 将基准数放到中间的位置（基准数归位）
            array[left] = array[i];
            array[i] = base;

            // 递归，继续向基准的左右两边执行和上面同样的操作
            // i的索引处为上面已确定好的基准值的位置，无需再处理
            quickSort(array, left, i - 1);
            quickSort(array, i + 1, right);
        }


    public static void swap(int[] data, int a, int b) {
        int t = data[a];
        data[a] = data[b];
        data[b] = t;

    }




}
