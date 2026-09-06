package vn.tvn;

import org.junit.Assert;
import org.junit.Test;

public class MissingNumberTest {
    @Test
            public void test01() {
            MissingNumber missingNumber = new MissingNumber();
            int[] nums = {3, 0, 1};
            int result = missingNumber.process(nums);
            Assert.assertEquals(2, result);
            System.out.println(result);

    }

    @Test
    public void test02() {
        MissingNumber missingNumber = new MissingNumber();
        int[] nums = {0,1};
        int result = missingNumber.process(nums);
        Assert.assertEquals(2, result);
        System.out.println(result);

    }

    @Test
    public void test03() {
        MissingNumber missingNumber = new MissingNumber();
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int result = missingNumber.process(nums);
        Assert.assertEquals(8, result);
        System.out.println(result);
    }

    @Test
    public void test04() {
        MissingNumber missingNumber = new MissingNumber();
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int result = missingNumber.process2(nums);
        Assert.assertEquals(8, result);
        System.out.println(result);
    }

    @Test
    public void test05() {
        MissingNumber missingNumber = new MissingNumber();
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int result = missingNumber.process3(nums);
        Assert.assertEquals(8, result);
        System.out.println(result);
    }
}
