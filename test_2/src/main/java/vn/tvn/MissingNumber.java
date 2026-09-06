package vn.tvn;

import java.util.Arrays;

public class MissingNumber {
    /*
     * CÁCH 1: SORT
     *
     * Ý tưởng:
     * - nums có n phần tử.
     * - Các số hợp lệ nằm trong khoảng [0, n].
     * - Sau khi sort, nếu không thiếu số nào thì:
     *
     *      nums[0] = 0
     *      nums[1] = 1
     *      nums[2] = 2
     *      ...
     *      nums[i] = i
     *
     * - Vì bị thiếu đúng 1 số, tại vị trí đầu tiên mà:
     *
     *      nums[i] != i
     *
     *   thì i chính là số bị thiếu.
     *
     * Ví dụ:
     *      nums = [3, 0, 1]
     *
     *      Sau sort:
     *      [0, 1, 3]
     *
     *      i = 0 → nums[0] = 0  → đúng
     *      i = 1 → nums[1] = 1  → đúng
     *      i = 2 → nums[2] = 3  → sai
     *
     *      → số 2 bị thiếu
     *
     * Lưu ý:
     * - Nếu vòng for chạy hết mà không tìm thấy nums[i] != i,
     *   nghĩa là số bị thiếu chính là n.
     *
     * Ví dụ:
     *      nums = [0, 1, 2]
     *      n = 3
     *
     *      Không có i nào sai.
     *      → số 3 bị thiếu.
     *
     * Độ phức tạp:
     * - Time: O(n log n) vì Arrays.sort()
     * - Space: tùy cách triển khai của Java sort.
     */
    public int process (int[] nums){
        // Sắp xếp nums theo thứ tự tăng dần.
        // Ví dụ: [3, 0, 1] → [0, 1, 3]
        Arrays.sort(nums);
        /*
         * Sau khi sort:
         *
         * Nếu số i tồn tại đúng vị trí thì:
         *
         *      nums[i] == i
         *
         * Nếu:
         *
         *      nums[i] != i
         *
         * thì i chính là số đầu tiên bị thiếu.
         */
            for(int i=0; i< nums.length; i++){
                // Kiểm tra xem giá trị tại vị trí i có đúng bằng i hay không.
                if(nums[i] != i){
                    // i không xuất hiện đúng vị trí → i là số bị thiếu.
                    return i;
                }
        }
        /*
         * Nếu chạy hết vòng for mà chưa return:
         *
         * nums = [0, 1, 2, ..., n-1]
         *
         * Khi đó số duy nhất còn thiếu là n.
         *
         * Ví dụ:
         * nums = [0, 1, 2]
         * n = nums.length = 3
         * → thiếu 3
         */
        return nums.length;
    }
    /*
     * CÁCH 2: GAUSS FORMULA
     *
     * Ý tưởng:
     *
     * Các số đầy đủ phải có là:
     *
     *      0, 1, 2, ..., n
     *
     * Tổng của chúng được tính bằng công thức:
     *
     *      n * (n + 1) / 2
     *
     * Sau đó:
     *
     *      Tổng đầy đủ
     *      - Tổng thực tế trong nums
     *      --------------------------
     *      = Số bị thiếu
     *
     * Ví dụ:
     *
     *      nums = [3, 0, 1]
     *      n = 3
     *
     *      Tổng đầy đủ:
     *      0 + 1 + 2 + 3 = 6
     *
     *      Tổng thực tế:
     *      3 + 0 + 1 = 4
     *
     *      Missing Number:
     *      6 - 4 = 2
     *
     * Điểm cần nhớ:
     * - sumFullArray = tổng những số ĐÁNG LẼ phải có.
     * - sumActualArray = tổng những số THỰC TẾ đang có.
     * - Lấy hai tổng trừ nhau → số bị thiếu.
     *
     * Độ phức tạp:
     * - Time: O(n)
     * - Space: O(1)
     */
    public int process2(int[] nums){
        // nums.length chính là n.
        // Vì nums có n phần tử nhưng phạm vi là [0, n],
        // nên có tổng cộng n + 1 số có thể xuất hiện.
        int n = nums.length;
        // Tính tổng tất cả các số từ 0 đến n.
        //
        // Công thức Gauss:
        // n * (n + 1) / 2
        //
        // Ví dụ n = 3:
        // 3 * 4 / 2 = 6
        // tương đương 0 + 1 + 2 + 3 = 6
        int sumFullArray = n * (n + 1) /2;
        // Biến dùng để cộng dồn tất cả các phần tử
        // thực tế đang có trong nums.
        int sumActualArray =0;

        /*
         * Duyệt từng phần tử trong nums.
         *
         * num lần lượt nhận giá trị:
         * 9 → 6 → 4 → 2 → ...
         *
         * Mỗi lần lấy tổng hiện tại cộng thêm num.
         */
        for (int num:nums){
                    // Cộng dồn giá trị num vào tổng thực tế.
                    //
                    // Viết đầy đủ:
                    // sumActualArray = sumActualArray + num;
                    //ví dụ: 0+9+6+4+2+3+5+7+0+1
            sumActualArray = sumActualArray+num;
        }
        /*
         * Tổng đầy đủ bao gồm cả số bị thiếu.
         * Tổng thực tế không có số bị thiếu.
         *
         * Vì vậy:
         *
         *      sumFullArray - sumActualArray
         *
         * chính là số bị thiếu.
         */
        return sumFullArray -sumActualArray;
    }

    /*
     * CÁCH 3: XOR
     *
     * Ý tưởng:
     * Dựa vào 2 tính chất quan trọng của XOR (^):
     *
     *      a ^ a = 0
     *      a ^ 0 = a
     *
     * Vì vậy nếu XOR một số với chính nó,
     * hai số đó sẽ "triệt tiêu" nhau.
     *
     * Ví dụ:
     *
     *      5 ^ 5 = 0
     *
     * Và:
     *
     *      5 ^ 0 = 5
     *
     * Với Missing Number:
     *
     * Ta XOR:
     *
     *      tất cả các số từ 0 → n
     *
     * với:
     *
     *      tất cả các số thực tế trong nums
     *
     * Các số xuất hiện ở cả hai bên sẽ triệt tiêu.
     * Chỉ còn lại số bị thiếu.
     *
     * Ví dụ:
     *
     *      nums = [3, 0, 1]
     *
     * Các số cần có:
     *      0, 1, 2, 3
     *
     * Các số thực tế:
     *      3, 0, 1
     *
     * XOR tất cả:
     *
     *      0 ^ 1 ^ 2 ^ 3
     *      ^ 3 ^ 0 ^ 1
     *
     * Các cặp giống nhau triệt tiêu:
     *
     *      0 ^ 0 = 0
     *      1 ^ 1 = 0
     *      3 ^ 3 = 0
     *
     * Còn lại:
     *
     *      2
     *
     * → Missing Number = 2
     *
     * Độ phức tạp:
     * - Time: O(n)
     * - Space: O(1)
     */
    //Phép tính XOR (viết tắt của Exclusive OR,
    // nghĩa là "hoặc loại trừ") là một phép toán logic trả về giá trị đúng (1)
    // khi chỉ có một trong hai điều kiện đầu vào là đúng,
    // và trả về sai (0) nếu cả hai giống nhau.
    //ví dụ:XOR 1 (0 0 0 1) và 2 (0 0 1 0)
    //0 0 0 1
    //0 0 1 0
    //-------
    //0 0 1 1
    //0 0 1 1 là 3(decimal)
    public int process3(int[] nums){
        /*
         * Bắt đầu xor bằng nums.length.
         *
         * Nếu:
         *      nums.length = n
         *
         * thì n chính là số lớn nhất trong phạm vi [0, n].
         *
         * Sau đó vòng for sẽ xử lý thêm:
         *      i
         * và:
         *      nums[i]
         *
         * Vì vậy cuối cùng tất cả số từ 0 → n
         * đều được XOR.
         */
        int xor = nums.length;
        /*
         * Mỗi vòng lặp xử lý cùng lúc 2 số:
         *
         * 1. i
         * 2. nums[i]
         *
         * Khi đó:
         *
         *      xor = xor ^ i;
         *
         * thêm số i vào phép XOR.
         *
         *      xor = xor ^ nums[i];
         *
         * thêm số thực tế trong nums vào phép XOR.
         *
         * Những số xuất hiện ở cả hai phía sẽ triệt tiêu.
         */
        for (int i=0; i< nums.length; i++){

            // XOR với chỉ số i.
            // Qua toàn bộ vòng lặp, i sẽ đại diện cho:
            // 0, 1, 2, ..., n - 1
            xor=xor^i; // đưa nhóm 0 → n-1 vào
            // XOR với giá trị thực tế tại vị trí i.
            xor=xor ^nums[i]; // đưa các số thực tế vào
        }
        /*
         * Sau khi XOR xong:
         *
         *      các số xuất hiện 2 lần → triệt tiêu
         *      số bị thiếu xuất hiện 1 lần → còn lại
         *
         * Vì vậy xor chính là Missing Number.
         */
        return xor;
    }


}
