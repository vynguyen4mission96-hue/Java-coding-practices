package vn.tvn;

import org.junit.Assert;// tự nó tạo
import org.junit.Test;// tự nó tạo

public class ContainsDuplicateTest {

    @Test
    public void test01(){
        //method này non- static nên phải khởi tạo new object
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] nums = {1,2,3,1};
        boolean result = containsDuplicate.process(nums);
        Assert.assertTrue(result);
        System.out.println(result);

        }

    @Test
    public void test02(){
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] nums = {1,2,3,4};
        boolean result = containsDuplicate.process(nums);
        Assert.assertFalse(result);
        System.out.println(result);

    }

    @Test
    public void test03(){
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        boolean result = containsDuplicate.process(nums);
        Assert.assertTrue(result);
        System.out.println(result);

    }

    @Test
    public void test04(){
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        boolean result = containsDuplicate.process2(nums);
        Assert.assertTrue(result);
        System.out.println(result);

    }

    @Test
    public void test05(){
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        boolean result = containsDuplicate.process3(nums);
        Assert.assertTrue(result);
        System.out.println(result);

    }

    @Test
    public void test06(){
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        boolean result = containsDuplicate.process4(nums);
        Assert.assertTrue(result);
        System.out.println(result);

    }
}



