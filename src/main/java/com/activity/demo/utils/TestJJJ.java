package com.activity.demo.utils;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import org.springframework.util.StringUtils;
public class TestJJJ {
    /**
     * in 有序（升序）数组 out 字符串（例如：1-5,7,9-10,）
     *
     * @param arr
     * @return
     */
    public static String getPstnidScope(int[] arr) {
        Arrays.sort(arr);
        String str = "";
        if (arr.length == 0) {
            return "";
        } else if (arr.length == 1) {
            return String.valueOf(arr[0]) + ",";
        } else {
            List<Integer> arrList = new ArrayList<>();
            for (int i = 0; i < arr.length - 1; i++) {
                int j = i + 1;
                if (arr[j] - arr[i] == 1 && j == arr.length - 1) {
                    str += arr[0] + "-" + arr[j] + ",";
                } else if (arr[j] - arr[i] == 1) {
                    continue;
                } else if (arr[j] - arr[i] != 1) {
                    if (j == 1) {
                        str += arr[i] + ",";
                    } else {
                        str += arr[0] + "-" + arr[i] + ",";
                    }
                    for (int m = j; m <= arr.length - 1; m++) {
                        arrList.add(arr[m]);
                    }
                    break;
                }
            }
            int[] arr1 = new int[arrList.size()];
            for (int i = 0; i < arrList.size(); i++) {
                arr1[i] = arrList.get(i);
            }
            str += getPstnidScope(arr1);
        }
        return str;
    }

    /**
     * in 床位范围（例如："1-3,6,8-10"） out 床位的数组(例如：[1,2,3,6,8,9,10])
     *
     * @param bedScope
     * @return
     */
    public static Integer[] getBedArr(String bedScope) {
        bedScope = bedScope.replaceAll("，", ",");
        bedScope = bedScope.replaceAll("；", ",");
        bedScope = bedScope.replaceAll(";", ",");
        // bedScope = bedScope.replaceAll(".", ",");
        bedScope = bedScope.replaceAll("。", ",");
        bedScope = bedScope.replaceAll("'", ",");
        bedScope = bedScope.replaceAll("_", "-");
        bedScope = bedScope.replaceAll("——", "-");
        List<Integer> bedArr = new ArrayList<>();
        // bedScope = "1-10,2,30-40"
        if (StringUtils.isEmpty(bedScope)) {// 为空
            return null;
        } else {// 不为空
            if (bedScope.contains(",")) {// 包含，
                String[] split1 = bedScope.split(",");
                for (String str1 : split1) {
                    if (str1.contains("-")) {
                        String[] split2 = str1.split("-");
                        for (int i = Integer.parseInt(split2[0]); i <= Integer.parseInt(split2[1]); i++) {
                            if (!bedArr.contains(i)) {
                                bedArr.add(i);
                            }
                        }
                    } else {
                        if (!bedArr.contains(Integer.parseInt(str1))) {
                            bedArr.add(Integer.parseInt(str1));
                        }
                    }
                }
            } else {// 不含，
                if (bedScope.contains("-")) {// 包含-
                    String[] split = bedScope.split("-");
                    for (int i = Integer.parseInt(split[0]); i <= Integer.parseInt(split[1]); i++) {
                        if (!bedArr.contains(i)) {
                            bedArr.add(i);
                        }
                    }
                } else {// 不含-
                    if (!bedArr.contains(Integer.parseInt(bedScope))) {
                        bedArr.add(Integer.parseInt(bedScope));
                    }
                }
            }
        }
        Integer[] array = bedArr.toArray(new Integer[bedArr.size()]);
        Arrays.sort(array);
        return array;
    }

    public static void main(String[] args) {
        // int arr[] = {1,2,4,5,6,8,9,10,12,13,14,17,19};
        /*
         * int arr[] = new int[100]; List<Integer> list = new ArrayList<>();
         * Random random = new Random();
         *
         * while(list.size() < 100){ int number = random.nextInt(200)+1;
         * if(!list.contains(number)){ list.add(number); } } for (int i = 0; i <
         * list.size(); i++) { arr[i] = list.get(i); }
         */
        /*
         * int arr[] = new int[1]; arr[0] = 10; Arrays.sort(arr); String str =
         * getPstnidScope(arr); String substring =
         * str.substring(0,str.length()-1); System.out.println(substring);
         */
        int arr[] = { 1, 2, 3, 4 ,8,10};
        String pstnidScope = getPstnidScope(arr);
        if (!pstnidScope.equals("")) {
            System.out.println(pstnidScope.substring(0, pstnidScope.length() - 1));
        }
    }
}
