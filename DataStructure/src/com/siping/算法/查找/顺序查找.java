package com.siping.算法.查找;

public class 顺序查找 {

    // 顺序查找
    public int sequentialSearch(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if(a[i] == key) {
                return i;
            }
        }
        return -1; // 没有找到
    }
    
    /**
     * 顺序查找优化
     * 顺序查找，由于每次循环都需要判断i是否越界，是否小于等于n做判断。所以可以优化，设置一个哨兵，可以减少判断
     */
    public int sequentialSearch2(int[] a, int key) {
        int i = a.length;
        if(key == a[0]) { // 判断key是否在a[0]的位置上
            return 0; // a[0]就找到key
        }
        a[0] = key; // 设置哨兵
        while (key != a[i]) {
            i--; 
        }
        if(i == 0) {
            return -1; // 没有找到
        }
        return i;
    }
}
