package vn.tvn;

import java.util.Arrays;

public class TwoPointersTest {

    public static void main(String[] args){
        TwoPointers twoPointers = new TwoPointers();
        int[] nums ={1,2,3,4,5};
        int[] reverse = twoPointers.reverseArray(nums);
        System.out.println("reverse"+Arrays.toString(reverse));

        int[] numsDup = {1,1,2,2,3,4,4};
        int[] unique =twoPointers.removeDuplicate(numsDup);
        System.out.println("removeDuplicate"+Arrays.toString(unique));

        //[1,5,6,8,9,10]
        int[] numModulo ={1,5,6,8,9,10};
        int[] rsModulo = twoPointers.modulo(numModulo);
        System.out.println("rsModulo"+Arrays.toString(rsModulo));

        //[1,5,6,8,9,10]. target=15
        int[] numsTS ={1,5,6,8,9,10};
        int targetTS= 15;
        int[] rsTW = twoPointers.twoSum(numsTS, targetTS);
        System.out.println("TwoSum_index"+Arrays.toString(rsTW));

        //[1,5,6,8,9,10]
        int[] numEven ={1,5,6,8,9,10};
        int[] rsEven = twoPointers.getEvenNumber(numEven);
        System.out.println("rsEven"+Arrays.toString(rsEven));

    }

}
