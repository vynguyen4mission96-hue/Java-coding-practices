package vn.tvn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SquaresSortedArrayTest {
    @Test
    public void test01(){
        SquaresSortedArray squaresSortedArray = new SquaresSortedArray();
        int[] nums = {-4,-1,0,3,10};
        int[] rs = squaresSortedArray.process3(nums);
        int [] expected ={0,1,9,16,100};
        Assert.assertArrayEquals(expected,rs);
        String rs2 = Arrays.toString(rs);
        System.out.println(rs2);


    }
    @Test
    public void test02(){
        SquaresSortedArray squaresSortedArray = new SquaresSortedArray();
        int[] nums = {-7,-3,2,3,11};
        int[] rs = squaresSortedArray.process3(nums);
        int [] expected ={4,9,9,49,121};
        Assert.assertArrayEquals(expected,rs);
        String rs2 = Arrays.toString(rs);
        System.out.println(rs2);


    }
}
