package vn.tvn;

import org.junit.Assert;// nó tự tạo
import org.junit.Test;// nó tự tạo

public class ValidAnagramTest {

    @Test
    public void test01(){
        ValidAnagram validAnagram = new ValidAnagram();
        boolean result = validAnagram.process("rat", "car");
        System.out.println(result);
        Assert.assertFalse(result);
    }

    //xài process2 code để kiểm thử
    @Test
    public void test02(){
        ValidAnagram validAnagram = new ValidAnagram();
        boolean result = validAnagram.process2("anagram", "nagaram");
        System.out.println(result);
        Assert.assertTrue(result);
    }
    //xài process2 code để kiểm thử
    //test thử chuỗi không bằng nhau(False)
    @Test
    public void test03(){
        ValidAnagram validAnagram = new ValidAnagram();
        boolean result = validAnagram.process2("anagram", "nagaramss");
        System.out.println(result);
        Assert.assertFalse(result);
    }

    @Test
    public void test04(){
        ValidAnagram validAnagram = new ValidAnagram();
        boolean result = validAnagram.process("anagram", "nagaram");
        System.out.println(result);
        Assert.assertTrue(result);
    }

    //xài process3 code để kiểm thử
    @Test
    public void test05(){
        ValidAnagram validAnagram = new ValidAnagram();
        boolean result = validAnagram.process3("anagram", "nagaram");
        System.out.println(result);
        Assert.assertTrue(result);
    }

    //xài process4 code để kiểm thử
    @Test
    public void test06(){
        ValidAnagram validAnagram = new ValidAnagram();
        boolean result = validAnagram.process4("anagram", "nagaram");
        System.out.println(result);
        Assert.assertTrue(result);
    }

}
