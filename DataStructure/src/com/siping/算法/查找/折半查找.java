package com.siping.算法.查找;

/**
 * 又称为二分查找：mid = (low + high)/2 = low + 1/2*(high - low)它的前提是线性表中的记录必须是关键码有序（通常从小到大有序），线性表必须顺序存储。
 * 在有序表中，取中间记录作为比较对象，若给定值与中间记录的关键值相等则查找成功；若给定值小于中间记录的 关键值，则在中间记录的左半侧查找，反之在右侧查找；
 * 
 * 插值查找： mid = low + ((key-a[low])/(a[high] - a[low])) * (high - low)对二分查找的优化，差别主要在于每次折半的那个1/2有优化空间，
 * 比如我们在查字典时，查a则不会首选去翻中间，查Z可能就会首先翻尾部。因此对于1/2这个因子可以做优化。但是这个算法也有个局限性，就是对于表长较长而且关键字
 * 分布比较均匀时比较适合。反之，如果类似于{0,1,2,1000,2000,...}这种分布不均匀的数据并不合适。
 */
public class 折半查找 {

    public static int binarySearch(int[] a, int key) {
        int low = 0;
        int mid;
        int high = a.length - 1;
        while (low < high) {
            // 二分查找
              mid = (low + high) / 2; 
            // 插值查找
            //mid = low + (high - low) * (key - a[low]) / (a[high] - a[low]); 
            if (a[mid] < key) { // 在右半侧查找
                low = mid + 1;
            } else if (a[mid] > key) { // 在左半侧查找
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1; // 没有找到
    }

    public static void main(String[] args) {
        int[] a = { 1, 3, 5, 6, 7, 8, 9, 12, 14, 15, 18, 19 };
        System.out.println(binarySearch(a, 15));
    }
}
