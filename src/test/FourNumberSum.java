package test;

import java.util.*;

/**
 * @author huangtao54
 * @description 找出四个数相加等于指定值
 * @date 2018/7/31
 */
public class FourNumberSum {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> L = new ArrayList<List<Integer>>();
        List<Integer> l;
        Arrays.sort(nums);
        int k, w;
        ArrayList<Integer> temp;
        HashSet<List<Integer>> result = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                k = j + 1;
                w = nums.length - 1;

                while (k < w) {
                    if (nums[i] + nums[j] + nums[k] + nums[w] == target) {

                        temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[w]);
                        if (!result.contains(temp)) {
                            result.add(temp);
                            L.add(temp);
                        }
                        k++;
                        w--;
                    } else if (nums[i] + nums[j] + nums[k] + nums[w] < target) {
                        k++;
                    } else {
                        w--;
                    }

                }
            }
        }


        return L;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> result = fourSum(nums, 0);
        System.out.println(result.size());
    }
}
