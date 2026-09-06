package vn.tvn;

import org.junit.Test;

public class MajorityElementTest {

    @Test
    public void test01(){
        MajorityElement majorityElement = new MajorityElement();
        int[] nums = {3,2,3};
        int result =majorityElement.process(nums);
        System.out.println(result);
        assert result ==3;
    }

    @Test
    public void test02(){
        MajorityElement majorityElement = new MajorityElement();
        int[] nums = {2,2,1,1,1,2,2};
        int result =majorityElement.process(nums);
        System.out.println(result);
        assert result ==2;
    }

    @Test
    public void test03(){
        MajorityElement majorityElement = new MajorityElement();
        int[] nums = {2,2,1,1,1,2,2};
        int result =majorityElement.process2(nums);
        System.out.println(result);
        assert result ==2;
    }

    @Test
    public void test04(){
        MajorityElement majorityElement = new MajorityElement();
        int[] nums = {2,2,1,1,1,2,2};
        int result =majorityElement.process3(nums);
        System.out.println(result);
        assert result ==2;
    }

}
