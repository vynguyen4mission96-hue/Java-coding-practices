package vn.tvn;

// nếu không có gợi ý import, thì tự import
//hasmap
import java.util.HashMap;
import java.util.Map;

//class twoSum2 nay để giải thích lần nữa code của progress2 một cách dễ hiểu hơn
public class twoSum2 {
    // CÁCH 2: hashmap solution (time complexity O(n))
//
// Ý tưởng:
// Thay vì dùng 2 vòng for để thử từng cặp,
// ta dùng Map để ghi nhớ những số đã đi qua.
//
// Map lưu theo dạng:
// KEY   = giá trị của số trong array
// VALUE = index của số đó
//
// Ví dụ:
// nums[0] = 3
// map.put(3, 0)
// Map lúc này: {3=0}
//
// nums[1] = 2
// map.put(2, 1)
// Map lúc này: {3=0, 2=1}
//
// Với mỗi nums[i], ta tính:
// result = target - nums[i]
//
// result chính là "số còn thiếu" để nums[i] + result = target.
//
// Sau đó:
// 1. Nếu result đã có trong Map:
//    → ta đã từng gặp số còn thiếu
//    → lấy index của result bằng map.get(result)
//    → return 2 index.
//
// 2. Nếu result chưa có trong Map:
//    → chưa tìm thấy cặp
//    → lưu nums[i] và index i vào Map
//    → tiếp tục sang phần tử tiếp theo.

// **test02 dùng để chạy mẫu và debug trực quan**
//
// nums = {3, 2, 4}
// target = 6
//
// Mong muốn:
// 2 + 4 = 6
// index của 2 là 1
// index của 4 là 2
// kết quả: {1, 2}

    public int[] process2(int[] nums, int target) {

        // Tạo một Map rỗng.
        //
        // KEY   = giá trị của nums
        // VALUE = index của nums
        //
        // Ban đầu chưa duyệt qua phần tử nào:
        // map = {}
        Map<Integer, Integer> map = new HashMap<>();

        // Duyệt từng phần tử trong nums.
        //
        // Ví dụ:
        // i = 0 → nums[0] = 3
        // i = 1 → nums[1] = 2
        // i = 2 → nums[2] = 4
        for (int i = 0; i < nums.length; i++) {

            // Tìm số còn thiếu để nums[i] + rs = target.
            //
            // Ví dụ:
            // target = 6
            //
            // i = 0:
            // nums[0] = 3
            // rs = 6 - 3 = 3
            //
            // Nghĩa là:
            // 3 + 3 = 6
            //
            // Ta sẽ kiểm tra xem số 3 đã xuất hiện trước đó
            // và được lưu trong Map hay chưa.
            int rs = target - nums[i];

            // Kiểm tra xem "số còn thiếu" rs
            // có tồn tại trong Map hay không.
            //
            // containsKey(rs) chỉ kiểm tra KEY.
            //
            // Ví dụ lần đầu:
            // rs = 3
            // map = {}
            //
            // 3 chưa có trong Map
            // → điều kiện false
            //
            // Nếu rs đã có trong Map:
            // → nghĩa là ta đã gặp số cần tìm trước đó
            // → có thể tạo thành target với nums[i].
            if (map.containsKey(rs)) {

                // Lấy VALUE tương ứng với KEY rs.
                //
                // VALUE chính là index của số rs
                // đã được lưu trước đó.
                //
                // Ví dụ:
                // map = {3=0, 2=1}
                //
                // rs = 2
                //
                // map.get(2) → 1
                //
                // Vì số 2 nằm ở index 1.
                int index1 = map.get(rs);

                // Đã tìm thấy đủ 2 số:
                //
                // số thứ nhất:
                // nums[index1]
                //
                // số thứ hai:
                // nums[i]
                //
                // Hai số này có tổng bằng target.
                //
                // Ví dụ:
                // index1 = 1
                // i = 2
                //
                // nums[1] = 2
                // nums[2] = 4
                //
                // 2 + 4 = 6
                //
                // → return {1, 2}
                //
                // return kết thúc toàn bộ method ngay tại đây.
                return new int[]{index1, i};
            }

            // Nếu chạy tới đây nghĩa là:
            // rs CHƯA có trong Map.
            //
            // Vì chưa tìm thấy cặp phù hợp,
            // ta lưu nums[i] vào Map để những phần tử
            // phía sau có thể tìm thấy nó.
            //
            // map.put(KEY, VALUE)
            //
            // KEY   = nums[i]
            // VALUE = i
            //
            // Ví dụ:
            // i = 0
            // nums[0] = 3
            //
            // map.put(3, 0)
            // map = {3=0}
            //
            // Sau đó vòng lặp tiếp tục với i = 1.
            map.put(nums[i], i);
        }

        // Nếu chạy hết vòng for mà chưa return ở phía trên,
        // nghĩa là đã kiểm tra tất cả phần tử
        // nhưng không tìm thấy 2 số nào có tổng bằng target.
        //
        // Khi đó trả về một int array rỗng: [].
        return new int[]{};
    }
}
