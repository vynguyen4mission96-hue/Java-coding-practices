package vn.tvn;

//nếu không có gợi ý import (nó không tự tạo), thì tự import
//hasmap
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    //nums = [2,7,11,15], target = 26
    // dùng vòng lặp for lop thứ 1 để chạy qua từng phần tử nums
    //i=0 -> nums[0] = 2
    //dùng vòng for thứ loop 2
    //j= i+1
    //j = 1 -> num[1]=7 -> 2+7=9!=26
    //j = 2 -> num[2]=11 -> 2+11=13!=26
    //j = 3 -> num[3]=15 -> 2+15=17!=26
    //hết for loop 2 vì không có giá trị nào thỏa target=26
    // i tăng lên 1 -> i= 0+1=1 -> num[1]= 7
    // for loop
    //j= i+1
    //j = 2 -> num[2]=11 -> 7+11=18!=26
    //j = 3 -> num[3]=15 -> 7+15=22!=26

    //chạy vòng lặp i và vòng lặp j đến khi nào tìm được num[i] + num[j]= 26 thì kết thúc. Return kết quả cuối

    //CÁCH 1: brute force solution (time complexity 0(n^2))
    public int[] process (int[] nums, int target){
        //i chạy từ 0 đến hết độ dài của Array
        for (int i=0; i< nums.length; i++){
            for (int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j]== target){
                    //KẾT THÚC- DỪNG METHOD NGAY TẠI ĐÂY và trả giá trị này (nếu kết quả thảo đề bài)
                    return new int[]{i, j};
                }
            }
        }
        //Nếu chạy hết tất cả các vòng lặp mà không tìm thấy đáp án, hãy trả về một mảng int rỗng.
        // Nếu tìm thấy cặp phù hợp:
        // return new int[]{i, j} sẽ kết thúc toàn bộ method ngay lập tức.
        //
        // Nếu không tìm thấy ở một cặp:
        // KHÔNG return [] ngay,
        // vì vẫn còn những cặp khác cần kiểm tra.
        //
        // Chỉ khi đã chạy hết cả 2 vòng for mà vẫn không tìm thấy,
        // lúc đó mới kết luận là không có cặp nào thỏa target.
        return new int[]{};

    }
    // CÁCH 2: hashmap solution (time comp[lexity 0(n))
    //Map<key, value>
    //target= 26 - item= result
    //result đi tìm trong MAP ->có giá trị thì lấy ra (return), còn không có gía (không tồn tại) tr thì add vào MAP

    //**test02 làm test case chạy mẫu***
    //bài này coi debug để thấy trực quan keết quả hơn comments
    //nums = {3,2,4};
    //target =6;
    public  int[] process2(int[] nums, int target){
        //hiện tại Map được tạo ra là empty. size= 0
        Map<Integer, Integer> map = new HashMap<>();
                for(int i=0; i< nums.length; i++){
                    //rs la viết tắt của biến result
                    //bắt đầu từ i=0
                    // rs= 6- nums[vị trí 0]= 6-3=3

                    // rs = số còn thiếu để nums[i] + rs = target
            int rs =target -nums[i];

                    //kiểm tra thứ rs có tồn tại trong map hay không?
                    // rs= 6- nums[vị trí 0]= 6-3=3 nhưng map = empty vì map.containsKey() không thấy rs --> map.put(nums[0], 0)=(3,0);

                    // Hỏi Map:
                    // "Số còn thiếu này trước đây tôi đã gặp chưa?"
            if (map.containsKey(rs)){
                //nếu rs tồn tại trong map thì return nó ra bằng "map.get()"
                //sau khi map.put (3 và 2) tức là (nums[0], 3) và (nums[1],2)
                //thì vòng lặp i chạy tới i=2
                //rs=6-nums[3]= 6-4=2
                //rs=2 có nằm trong map ((nums[0], 3) và (nums[1],2) giải thích ở comemnt trên: (3 và 2))
                //vậy lúc này nó sẽ lấy index của rs=2 ra (tức là index1=nums[1]) bằng map.get(rs)
                //return array ra {index1 và vị trí hiện tại}= {1,2}
                //kết thúc chương trình (return nào trả về kết quả trước, thì ngưng tại đó)

                int index1 = map.get(rs);// lấy vị trí index của rs
                return  new int[]{index1, i};//return về index của 2 số công nhau = target. Tức là nums[index1]+nums[i]= target

            }
            //nếu rs không tồn tại trong map thì put vào trong map bằng "map.put()"
            //vị trí index mà i chạy qua

                // Nếu chưa gặp số còn thiếu,
                // lưu số hiện tại lại để các phần tử phía sau có thể tìm thấy nó.
            map.put(nums[i], i);

        }
        //Nếu chạy hết tất cả các vòng lặp mà không tìm thấy gì, hãy trả về một mảng int rỗng.
        return new int[]{};
    }



}
