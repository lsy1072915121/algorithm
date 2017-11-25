package com.liushiyao.algorithm.array;



import java.util.Arrays;
import org.junit.Test;



/*
 *			名称：数组的操作
 *			目的：对数组元素的相关操作
 *			思路：编写相应的算法，对数组的元素的相关操作
 *			作者：刘石尧
 *			时间：start：时间
 *					end：
 *			注意事项：
 *			BUG：
 */

/*

    排序方式：
      1.选择排序：固定一个指针，遍历其他元素，将最大的或者最小的排在第一位，重复操作
        “重新排队”
      2.冒泡排序：将相邻的两个元素比较，把最大（最小）的往右移动，一趟之后，
        最大（最小）的元素将排到最后。重复该操作
        "往一边挤"


 */

public class ArrayOperate {

  /**
   * @param arr 需要求其最大值角标的数组
   * @return index 最大值元素的角标
   * @author 电子小孩
   */
  public int maxIndex(int[] arr) {
    int index = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[index] < arr[i]) {
        index = i;
      }
    }
    return index;
  }


  /**
   * @param arr 需要获取其元素最大值得数组
   * @return arr[index]
   * @name 获取数组中元素的最大值
   * @author 电子小孩
   */
  public int maxEle(int[] arr) {
    int index = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[index] < arr[i]) {
        index = i;
      }
    }
    return arr[index];
  }

  /**
   * @param arr 需要排序的数组
   * @return void
   * @name 选择排序（从小到大）
   * @author 电子小孩
   */
  public void selectSort(int arr[]) {
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] > arr[j]) {
          arr[i] = arr[i] + arr[j];
          arr[j] = arr[i] - arr[j];
          arr[i] = arr[i] - arr[j];
        }
      }
    }
  }

  @Test
  public void selectSortTest() {

    int[] arr = {2, 12, -1, 23, 45, 0, 4, 0};
    System.out.println("排序前：");
    System.out.println(Arrays.toString(arr));
    selectSort(arr);
    System.out.println("排序后：");
    System.out.println(Arrays.toString(arr));

  }

  /**
   * @param arr 需要排序的数组
   * @return void
   * @name 冒泡排序
   * @author 电子小孩
   * @time 2015-12-3下午12:13:21
   */
  public void bubbleSort(int arr[]) {
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - 1 - i; j++) {
        if (arr[j] > arr[j + 1]) {
          arr[j] = arr[j] + arr[j + 1];
          arr[j + 1] = arr[j] - arr[j + 1];
          arr[j] = arr[j] - arr[j + 1];
        }
      }
    }
  }

  @Test
  public void bubbleSortTest(){

    int [] arr = {2,1,45,-3,8};
    System.out.println("排序前："+Arrays.toString(arr));
    bubbleSort(arr);
    System.out.println("排序后："+Arrays.toString(arr));


  }

  /**
   * @name 快速排序
   * @author 电子小孩
   * @time 2015-12-3下午12:32:51
   */

  public static int oneSort ( int array[], int lo, int hi ) {

    //选择一个基准元素
    //基准值的选择影响着算法的时间复杂度
    //通常情况选择第一个元素作为基准值，但也有“随机选择”的算法
    int temp = array[ lo ];

    while ( lo < hi ) {

      //先从右边往左边指向
      while ( array[ hi ] >= temp && lo < hi ) {
        hi--;
      }
      array[ lo ] = array[ hi ];              //
      //然后再从左边往右边指向
      while ( array[ lo ] <= temp && lo < hi ) {
        lo++;
      }
      array[ hi ] = array[ lo ];
    }
    array[ hi ] = temp;       //中心（相交点）赋予基准点的值
    return hi;      //返回基准点
  }

  public static void quickSort ( int array[], int lo, int hi ) {
    if ( lo >= hi ) {
      return;       //递归出口（必须存在）
    }
    int index = oneSort ( array, lo, hi );  //每次获取一个基准点
    quickSort ( array, lo, index - 1 );          //lo~基准点的前一个
    quickSort ( array, index + 1, hi );         //基准点后一个~hi
  }

  @Test
  public void quickSortTest(){

    int arr[] = {2,12,4,123,1,-6,8};
    System.out.println("排序前："+Arrays.toString(arr));
    quickSort(arr,0,arr.length-1);
    System.out.println("排序后："+Arrays.toString(arr));

  }


}

