import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//本算法的不足主要是每次循环和递归都要创建新的list有点浪费空间
//除0考虑的比较简单 就直接跳过了
//我个人觉得不需要考虑括号但是
class Solution {
    public boolean judgePoint24(int[] nums) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);//int 和Interger是可以互相兼容的
        }
        return solve(list);
    }


    boolean solve(List<Integer> s) {
        if ((s.size() == 1)) {
            if (s.get(0) == 24) {
                return true;
            } else {
                return false;
            }
        }

        int num1 = 0, num2 = 0;
        for (int i = 0; i < s.size() - 1; i++) {
            for (int j = i + 1; j < s.size(); j++) {
                num1 = s.get(i);
                num2 = s.get(j);
                List<Integer> newList = new ArrayList<>();
                newList.addAll(s);
                newList.remove(i);
                newList.remove(j - 1);

                //加法
                newList.add(num1 + num2);
                if (solve(newList)) return true;
                newList.remove(newList.size() - 1);


                //减法
                newList.add(num1 - num2);

                if (solve(newList)) return true;
                newList.remove(newList.size() - 1);


                newList.add(num2 - num1);
                if (solve(newList)) return true;
                newList.remove(newList.size() - 1);


                //乘法
                newList.add(num1 * num2);
                if (solve(newList)) return true;
                newList.remove(newList.size() - 1);


                //除法
                if(num2!=0){
                newList.add(num1 / num2);
                if (solve(newList)) return true;
                newList.remove(newList.size() - 1);

                }

                if(num1!=0) {
                    newList.add(num2 / num1);
                    if (solve(newList)) return true;
                    newList.remove(newList.size() - 1);
                }
            }

        }

        return false;
    }

}


public class Point24 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int a[] = new int[]{4, 1, 8, 7};

        if (s.judgePoint24(a))System.out.println("yes");
    }


}
