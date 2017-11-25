package com.liushiyao.algorithm.array;


/*
  二分法查找指定元素
  1.顺序表必须是有序的
  2.只能一个顺序结构存储
 */
public class BinarySearch {


  public static int query(int[] arry, int value) {

    int front = 0;
    int high = arry.length;
    if (arry.length == 0) {
      return -1;
    }
    while (front < high) {
      int middle = (front + high) / 2;
      if (value == arry[middle]) {
        return middle;
      }
      if (value < arry[middle]) {
        high--;
      }
      if (value > arry[middle]) {
        front++;
      }

    }
    return -1;
  }

  public static void main(String[] a) {

    int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    System.out.println(query(array,12));

  }

}
