package vn.tvn;

import org.junit.Assert;// nó tự tạo
import org.junit.Test;// nó tự tạo

import java.lang.reflect.Array;// nó tự tạo
import java.util.Arrays;// nó tự tạo

public class TwoSumTest {
    @Test
    public void test01(){
        TwoSum twoSumArray = new TwoSum();
        int[] nums = {2,7,11,15};
        int target =9;
        int[] result =twoSumArray.process(nums, target);
        //expected result= vị trí array 0 và 1
        System.out.println(Arrays.toString(result));
        Assert.assertArrayEquals(new int[]{0,1}, result);

    }
    //xài process2 để test
    @Test
    public void test02(){
        TwoSum twoSumArray = new TwoSum();
        int[] nums = {3,2,4};
        int target =6;
        int[] result =twoSumArray.process2(nums, target);
        //expected result= vị trí array 1 và 2
        System.out.println(Arrays.toString(result));
        Assert.assertArrayEquals(new int[]{1,2}, result);

    }

    @Test
    public void test03() {
        TwoSum twoSumArray = new TwoSum();
        int[] nums = {3, 3};
        int target = 6;
        int[] result = twoSumArray.process(nums, target);
        System.out.println(Arrays.toString(result));
        Assert.assertArrayEquals(new int[]{0, 1}, result);
    }
    @Test
        public void test04() {
            TwoSum twoSumArray = new TwoSum();
            int[] nums = {2, 6, 11, 15, 7, 3};
            int target = 259;
            int[] result = twoSumArray.process(nums, target);
            System.out.println(Arrays.toString(result));
            Assert.assertArrayEquals(new int[]{}, result);
        }


}
