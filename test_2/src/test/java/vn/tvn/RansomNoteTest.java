package vn.tvn;

import org.junit.Assert;
import org.junit.Test;

public class RansomNoteTest {

    @Test
    public void test01(){
        RansomNote ransomNote = new RansomNote();
        boolean result = ransomNote.process("a", "b");
        Assert.assertFalse(result);
    }

    @Test
    public void test02(){
        RansomNote ransomNote = new RansomNote();
        boolean result = ransomNote.process("aa", "ab");
        Assert.assertFalse(result);
    }

    @Test
    public void test03(){
        RansomNote ransomNote = new RansomNote();
        boolean result = ransomNote.process("aa", "aab");
        Assert.assertTrue(result);
    }

    //xài progress2
    @Test
    public void test04(){
        RansomNote ransomNote = new RansomNote();
        boolean result = ransomNote.process2("aa", "aab");
        Assert.assertTrue(result);
    }

}
