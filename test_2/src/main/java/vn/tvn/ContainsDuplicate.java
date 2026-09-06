package vn.tvn;

import java.util.Arrays;// Lớp Arrays của Java, cung cấp các method tiện ích để xử lý array.
import java.util.HashSet; // HashSet: tập hợp không cho phép lưu phần tử trùng nhau.
import java.util.Map; // Map: interface dùng để lưu dữ liệu theo dạng key -> value.
import java.util.Set; // Set: interface đại diện cho một tập hợp các phần tử không trùng nhau.
import java.util.HashMap;

public class ContainsDuplicate {

    // ============================================================
    // CÁCH 1: STREAM + DISTINCT
    // ============================================================
    public boolean process(int[] nums){
        //giải thích Arrays.stream(nums).distinct().count();
        // Chuyển mảng int[] nums thành một IntStream.
        // IntStream cho phép chúng ta xử lý lần lượt các số trong array
        // bằng các operation có sẵn như distinct(), count(), filter(),...
        //
        // Ví dụ:
        // nums = [1, 2, 2, 3]
        //
        // Arrays.stream(nums)
        // → 1 → 2 → 2 → 3


        // .distinct():
        // Loại bỏ các phần tử bị trùng.
        //
        // [1, 2, 2, 3]
        //        ↓ distinct()
        // [1, 2, 3]
        //
        // Nếu array ban đầu có duplicate thì sau distinct()
        // số lượng phần tử sẽ giảm.


        // .count():
        // Đếm xem sau khi distinct() còn bao nhiêu phần tử.
        //
        // [1, 2, 2, 3]
        //        ↓ distinct()
        // [1, 2, 3]
        //        ↓ count()
        // 3
        //
        // count() trả về kiểu long, nên biến count cũng phải là long.
        long count = Arrays.stream(nums).distinct().count();
        // nums.length:
        // Số lượng phần tử ban đầu của array.
        //
        // Ví dụ:
        // nums = [1, 2, 2, 3]
        // nums.length = 4


        // count != nums.length:
        //
        // Nếu số phần tử SAU KHI loại duplicate
        // khác số phần tử BAN ĐẦU
        // → chắc chắn đã có ít nhất một số bị trùng.
        //
        // Ví dụ:
        // nums = [1, 2, 2, 3]
        // count = 3
        // nums.length = 4
        //
        // 3 != 4 → true
        // → Có duplicate.
        //
        // Ngược lại:
        // nums = [1, 2, 3]
        // count = 3
        // nums.length = 3
        //
        // 3 != 3 → false
        // → Không có duplicate.

        //!= → tạo ra boolean
        return count != nums.length;
    }

    // ============================================================
    // CÁCH 2: SORT → CHECK PHẦN TỬ KỀ NHAU
    // ============================================================
    public boolean process2(int[] nums){
        // Arrays.sort(nums):
        // Sắp xếp array theo thứ tự tăng dần.
        //
        // Ví dụ:
        // [4, 2, 7, 2, 5]
        //        ↓ sort()
        // [2, 2, 4, 5, 7]
        //
        // Sau khi sort, những số giống nhau sẽ đứng cạnh nhau.
        // Đây chính là điểm quan trọng để tìm duplicate.
        Arrays.sort(nums);
        // Vì array đã được sort,
        // nếu hai phần tử đứng cạnh nhau bằng nhau
        // → chúng ta đã tìm thấy duplicate.
        //
        // Ví dụ:
        // [2, 2, 4, 5, 7]
        //  ↑  ↑
        // nums[0] = 2
        // nums[1] = 2
        //
        // nums[1] == nums[0] → true
        //
        // → Có duplicate → return true ngay.
        for (int i= 1; i< nums.length; i++){
            if (nums[i]==nums[i-1]){
                return true;
            }
        }

        // Nếu vòng for chạy hết mà không return true
        // → không có hai phần tử nào đứng cạnh nhau giống nhau.
        //
        // Vì array đã được sort,
        // nếu có duplicate thì chắc chắn chúng phải đứng cạnh nhau.
        //
        // Do đó:
        // chạy hết vòng for → tất cả phần tử đều khác nhau
        // → return false.
        return false;
    }

    // ============================================================
    // CÁCH 3: HASHMAP
    // ============================================================
    public boolean process3(int[] nums){
        // Map<Integer, Integer>:
        //
        // Map lưu dữ liệu theo cặp:
        // key -> value
        //
        // Trong bài này:
        // key   = số trong array
        // value = số lần / trạng thái đã gặp
        //
        // Ví dụ:
        // nums = [4, 7, 2]
        //
        // map có thể trở thành:
        // {
        //     4 -> 1,
        //     7 -> 1,
        //     2 -> 1
        // }
        //
        // Ở bài này value = 1 chỉ đơn giản mang ý nghĩa:
        // "số này đã xuất hiện".
        Map<Integer, Integer> map= new HashMap<>();
        // for:
        // Duyệt từng phần tử trong array.
        //
        // i = 0 → nums[0]
        // i = 1 → nums[1]
        // i = 2 → nums[2]
        // ...
        //
        // i < nums.length:
        // dừng khi i vượt index cuối cùng.
        for(int i=0; i< nums.length; i++){
            // map.containsKey(nums[i]):
            // Kiểm tra xem số nums[i] đã tồn tại trong Map hay chưa.
            //
            // Ví dụ:
            // map = {4=1, 7=1}
            //
            // nums[i] = 7
            //
            // map.containsKey(7)
            // → true
            // → 7 đã xuất hiện trước đó.
            //
            // Nếu đã tồn tại → duplicate.
            // Không cần kiểm tra tiếp → return true.
            if(map.containsKey(nums[i])){
                return true;
            }
            // Nếu containsKey() trả về false:
            // → số nums[i] chưa xuất hiện trong Map.
            //
            // map.put(nums[i], 1):
            // Thêm số đó vào Map.
            //
            // Ví dụ:
            // nums[i] = 5
            //
            // map.put(5, 1)
            //
            // Map:
            // {4=1, 7=1, 5=1}
            //
            // Lần sau nếu gặp 5:
            // containsKey(5) → true
            // → duplicate.
            else {
                map.put(nums[i],1 );
            }

        }

        // Nếu duyệt hết array mà không phát hiện số nào
        // đã tồn tại trong Map
        // → tất cả phần tử đều distinct.
        //
        // distinct = mỗi giá trị chỉ xuất hiện một lần.
        //
        // → return false.
        return false;

    }
    // ============================================================
    // CÁCH 4: HASHSET
    // ============================================================
    public boolean process4(int[] nums){
        // Set<Integer>:
        // Set là collection không cho phép chứa duplicate.
        //
        // HashSet là một implementation của Set.
        //
        // Ta tạo một Set rỗng để lưu những số đã gặp.
        //
        // Ví dụ ban đầu:
        // set = {}
        //
        // Gặp 5:
        // set = {5}
        //
        // Gặp 7:
        // set = {5, 7}
        Set<Integer> set =new HashSet<>();
        // for-each:
        //
        // for (int num : nums)
        //
        // có nghĩa là:
        // "Lấy từng phần tử trong nums và đặt nó vào biến num."
        //
        // Ví dụ:
        // nums = [4, 7, 4]
        //
        // vòng 1 → num = 4
        // vòng 2 → num = 7
        // vòng 3 → num = 4
        for(int num: nums){
            //giải thích !set.add(num)
            // set.add(num):
            //
            // Cố gắng thêm num vào Set.
            //
            // Quan trọng:
            // add() trả về boolean.
            //
            // Nếu num CHƯA có trong Set:
            // → thêm thành công
            // → add() trả về true.
            //
            // Nếu num ĐÃ có trong Set:
            // → Set không thêm duplicate
            // → add() trả về false.
            //
            // Ví dụ:
            //
            // set = {4, 7}
            //
            // set.add(2)
            // → 2 chưa có
            // → thêm 2
            // → return true
            //
            // set = {4, 7, 2}
            //
            // Nhưng:
            //
            // set.add(4)
            // → 4 đã có
            // → không thêm
            // → return false.

            // ! có nghĩa là NOT (phủ định).
            //
            // Nếu:
            // set.add(num) == true
            // → !true == false
            //
            // Nếu:
            // set.add(num) == false
            // → !false == true
            //
            // Vì vậy:
            //
            // !set.add(num)
            //
            // có nghĩa là:
            // "Thêm num thất bại vì num đã tồn tại trong Set."
            //
            // → đó chính là duplicate.
            if(!set.add(num)){
                return true;
            }
        }
        // Nếu duyệt hết array mà không có lần nào
        // set.add(num) trả về false
        // → không có phần tử nào bị trùng.
        //
        // → tất cả phần tử đều distinct.
        // → return false.
        return false;
    }

}
