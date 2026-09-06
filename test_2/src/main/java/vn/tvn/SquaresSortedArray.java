package vn.tvn;

import java.util.Arrays;

public class SquaresSortedArray {
    // ============================================================
    // CÁCH 1: SIMPLE SOLUTION - Bình phương rồi sort
    // ============================================================
    //
    // Ý tưởng:
    // 1. Đi qua từng phần tử trong nums.
    // 2. Bình phương từng phần tử.
    // 3. Sau khi bình phương xong, dùng Arrays.sort() để sắp xếp.
    //
    // Ví dụ:
    // nums = [-4, -1, 0, 3, 10]
    //
    // Sau vòng for:
    // nums = [16, 1, 0, 9, 100]
    //
    // Sau Arrays.sort():
    // nums = [0, 1, 9, 16, 100]
    //
    // Độ phức tạp:
    // - Vòng for: O(n)
    // - Arrays.sort(): O(n log n)
    // => Tổng thể: O(n log n)
    //
    public int[] process(int[] nums){

        // i là vị trí (index) hiện tại trong mảng.
        //
        // i = 0  → xử lý nums[0]
        // i = 1  → xử lý nums[1]
        // i = 2  → xử lý nums[2]
        // ...
        //
        // i < nums.length:
        // tiếp tục khi i vẫn còn nằm trong phạm vi của mảng.
        for (int i =0; i< nums.length; i++){
            // nums[i] là phần tử hiện tại.
            //
            // nums[i] * nums[i]
            // chính là bình phương của phần tử đó.
            //
            // Ví dụ:
            // nums[i] = -4
            //
            // nums[i] * nums[i]
            // = -4 * -4
            // = 16
            //
            // Sau đó gán 16 ngược lại vào nums[i].
            //
            // Vì vậy dòng này làm thay đổi trực tiếp mảng nums.
            nums[i]= nums[i]*nums[i];
        }

        // Sau khi vòng for kết thúc,
        // tất cả phần tử trong nums đã được bình phương.
        //
        // Nhưng thứ tự có thể chưa đúng.
        //
        // Ví dụ:
        // [16, 1, 0, 9, 100]
        //
        // Arrays.sort(nums) sẽ sắp xếp nums
        // theo thứ tự tăng dần:
        //
        // [0, 1, 9, 16, 100]
        Arrays.sort(nums);

        // Trả về chính mảng nums sau khi
        // đã bình phương và sắp xếp.
        return nums;
    }


    // ============================================================
    // CÁCH 2: STREAM SOLUTION
    // ============================================================
    //
    // Đây là cách viết ngắn hơn bằng Java Stream.
    //
    // Nếu chưa học Stream thì KHÔNG nên cố học thuộc
    // nguyên dòng này.
    //
    // Hãy đọc nó như một "đường ống":
    //
    // nums
    //   ↓
    // Arrays.stream(nums)
    //   ↓
    // map()       → bình phương từng phần tử
    //   ↓
    // sorted()    → sắp xếp
    //   ↓
    // toArray()   → tạo lại thành int[]
    //
    public int[] process2(int[] nums){
        return Arrays.stream(nums).map(item->item*item).sorted().toArray();

        // Arrays.stream(nums):
        //
        // Lấy mảng nums và tạo ra một "Stream"
        // để chúng ta có thể xử lý từng phần tử
        // theo kiểu Stream.
        //
        // Ví dụ:
        // nums = [-4, -1, 0, 3, 10]
        //
        // Stream sẽ lần lượt xử lý:
        // -4 → -1 → 0 → 3 → 10
        //

        // map():
        //
        // "map" có thể hiểu đơn giản là:
        // lấy TỪNG phần tử → biến đổi nó → tạo ra giá trị mới.
        //
        // Ở đây:
        //
        // item đại diện cho phần tử hiện tại.
        //
        // item -> item * item
        //
        // nghĩa là:
        //
        // "Với mỗi item,
        // hãy lấy item nhân với chính nó."
        //
        // Ví dụ:
        //
        // item = -4 → -4 * -4 = 16
        // item = -1 → -1 * -1 = 1
        // item =  0 →  0 *  0 = 0
        // item =  3 →  3 *  3 = 9
        // item = 10 → 10 * 10 = 100
        //
        // Kết quả lúc này về mặt ý tưởng là:
        //
        // [16, 1, 0, 9, 100]
        //
        // sorted():
        //
        // Sắp xếp các giá trị trong Stream
        // theo thứ tự tăng dần.
        //
        // [16, 1, 0, 9, 100]
        //          ↓
        // [0, 1, 9, 16, 100]
        //
        // toArray():
        //
        // Stream không phải là một mảng int[].
        //
        // Vì vậy cuối cùng chúng ta cần chuyển
        // kết quả của Stream trở lại thành mảng.
        //
        // Kết quả:
        //
        // int[]
        //
        // [0, 1, 9, 16, 100]
    }

    // ============================================================
    // CÁCH 3: TWO POINTER SOLUTION
    // ============================================================
    //
    // Sẽ học sau.
    //
    // Đây mới là cách tận dụng việc nums
    // đã được sắp xếp từ đầu để đạt O(n).
    //

}
