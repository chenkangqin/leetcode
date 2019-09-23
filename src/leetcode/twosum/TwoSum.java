package leetcode.twosum;

/**
 * @ClassName leetcode.twosum.TwoSum
 * @Description 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author chenkq
 * @Date 2019/9/23 20:08
 * @Version V1.0
 **/
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
       int[] result = returnIndex(nums,3);
        System.out.println(result[0]+""+result[1]);
    }
    public static int[] returnIndex(int[] nums,int target){
        if(nums==null){
            return null;
        }
        int[] result = new int[2];
        for (int i=0;i<nums.length;i++){
            for (int j=i;j<nums.length;j++){
                if (nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                    return result;
                }
            }
        }
        return null;
    }
}
