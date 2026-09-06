package vn.tvn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class MoveZeroesTest {
    @Test
    public  void test01(){
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums= {0,1,0,3,12};
        int[] result = moveZeroes.process(nums);
        int[] expected = {1,3,12,0,0};
        Assert.assertArrayEquals(expected, result);
        boolean rs = Arrays.equals(expected, result);
        System.out.println(rs);
        String rs2 = Arrays.toString(result);
        System.out.println(rs2);

    }

    @Test
    public  void test02(){
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums= {0};
        int[] result = moveZeroes.process(nums);
        int[] expected = {0};
        Assert.assertArrayEquals(expected, result);
        boolean rs = Arrays.equals(expected, result);
        System.out.println(rs);
        String rs2 = Arrays.toString(result);
        System.out.println(rs2);

    }

    @Test
    public  void test03(){
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums= {0,1,0,3,12};
        int[] result = moveZeroes.process2(nums);
        int[] expected = {1,3,12,0,0};
        Assert.assertArrayEquals(expected, result);
        boolean rs = Arrays.equals(expected, result);
        System.out.println(rs);
        String rs2 = Arrays.toString(result);
        System.out.println(rs2);

    }

    @Test
    public  void test04(){
        MoveZeroes moveZeroes = new MoveZeroes();
        int[] nums= {0,1,0,3,12};
        int[] result = moveZeroes.process3(nums);
        int[] expected = {1,3,12,0,0};
        Assert.assertArrayEquals(expected, result);
        boolean rs = Arrays.equals(expected, result);
        System.out.println(rs);
        String rs2 = Arrays.toString(result);
        System.out.println(rs2);

    }

}
