package vn.tvn;

// Arrays: class cung cấp các method làm việc với mảng.
// Trong bài này dùng Arrays.sort() để sắp xếp mảng.
import java.util.Arrays;
// HashMap: cấu trúc dữ liệu lưu theo cặp KEY - VALUE.
// Trong bài này:
// KEY   = một phần tử trong nums
// VALUE = số lần phần tử đó xuất hiện.
import java.util.HashMap;//tự nó tạo ra
// Map: interface mà HashMap implement.
// Viết Map<Integer, Integer> giúp code khai báo theo kiểu interface,
// còn new HashMap<>() tạo ra object HashMap thực tế.
import java.util.Map;//tự nó tạo ra

public class MajorityElement {
    // =========================================================
    // CÁCH 1: HASHMAP
    // =========================================================
    public Integer process(int[] nums){
        //hashmap
        //đếm số lần xuất hiện của mỗi phần tử trong mảng
        //lấy số lần xuất hiện so sánh với n/2 (n=nums.length)
        //nếu count > n/2 thì return phần tử đó

        // Mục tiêu:
        // Duyệt qua từng phần tử trong nums
        // và đếm xem mỗi phần tử xuất hiện bao nhiêu lần.
        //
        // Ví dụ:
        // nums = [2, 2, 1, 1, 1, 2, 2]
        //
        // Sau khi đếm:
        // map = {
        //     2 = 4,
        //     1 = 3
        // }
        //
        // Vì majority element phải xuất hiện > n/2 lần
        // nên với n = 7:
        //
        // n / 2 = 7 / 2 = 3  (int division)
        //
        // majority phải xuất hiện > 3 lần
        // → phải xuất hiện ít nhất 4 lần.
        //
        // → 2 là majority element.


        // Tạo một HashMap rỗng.
        //
        // Key   = Integer: phần tử trong mảng nums.
        // Value = Integer: số lần phần tử đó đã xuất hiện.
        //
        // Ví dụ sau khi duyệt một phần:
        //
        // map = {2=2, 1=1}
        //
        // nghĩa là:
        // số 2 đã xuất hiện 2 lần
        // số 1 đã xuất hiện 1 lần.
        Map<Integer, Integer> map = new HashMap<>();

        // for-each:
        //
        // "num" sẽ lần lượt nhận từng phần tử của mảng nums.
        //
        // Ví dụ:
        // nums = [2, 2, 1]
        //
        // lần 1 → num = 2
        // lần 2 → num = 2
        // lần 3 → num = 1
        for (int num: nums){
            // Cập nhật số lần xuất hiện của num trong HashMap.
            //
            // map.getOrDefault(num, 0):
            //
            // - Nếu num ĐÃ tồn tại trong map
            //   → lấy số lần xuất hiện hiện tại.
            //
            // - Nếu num CHƯA tồn tại trong map
            //   → lấy giá trị mặc định là 0.
            //
            //
            // Sau đó + 1 vì chúng ta vừa gặp num thêm một lần.
            //
            // Ví dụ:
            //
            // map = {}
            // num = 2
            //
            // map.getOrDefault(2, 0)
            // → 2 chưa có
            // → trả về 0
            //
            // 0 + 1 = 1
            //
            // map.put(2, 1)
            //
            // Kết quả:
            // map = {2=1}
            //
            //
            // Lần tiếp theo num = 2:
            //
            // map.getOrDefault(2, 0)
            // → 2 đã có value = 1
            //
            // 1 + 1 = 2
            //
            // map.put(2, 2)
            //
            // Kết quả:
            // map = {2=2}
            map.put(num, map.getOrDefault(num, 0)+1);
            //check điều kiên xem số lần xuất hiện của num có lớn hơn n/2 hay không?

            // Sau khi cập nhật số lần xuất hiện của num,
            // kiểm tra xem num đã trở thành majority element chưa.
            //
            // map.get(num)
            // → lấy số lần xuất hiện hiện tại của num.
            //
            // nums.length
            // → số lượng phần tử của toàn bộ mảng.
            //
            // nums.length / 2
            // → floor(n / 2), vì nums.length là int.
            //
            // Đề bài yêu cầu:
            //
            // count > floor(n / 2)
            //
            // Nếu đúng → num chính là majority element
            // → return num ngay lập tức.
            if (map.get(num)>nums.length/2){
                // Trả về chính phần tử num đang có số lần xuất hiện
                // lớn hơn n/2.
                //
                // Ví dụ:
                // nums = [2,2,1,1,1,2,2]
                //
                // Khi num = 2 lần thứ 4:
                //
                // map.get(2) = 4
                // nums.length / 2 = 7 / 2 = 3
                //
                // 4 > 3 → true
                //
                // return 2;
                return num;
            }
        }
        //không phù hợp với bài kiểu nums= [1,2,3]
        // Theo đề bài:
        // "You may assume that the majority element always exists."
        //
        // Nghĩa là đề đảm bảo luôn có majority element.
        //
        // Vì vậy trên dữ liệu hợp lệ, đoạn code phía trên
        // sẽ luôn return num trước khi chạy đến đây.
        //
        // return null chỉ là giá trị dự phòng nếu somehow
        // không tìm thấy majority element.
        //
        // Nó không có nghĩa là bài toán bình thường sẽ trả null.
        return null;

    }
    // =========================================================
    // CÁCH 2: SORT SOLUTION
    // =========================================================
    public Integer process2 (int[] nums){
        // Sắp xếp mảng theo thứ tự tăng dần.
        //
        // Ví dụ:
        //
        // Trước:
        // [2, 2, 1, 1, 1, 2, 2]
        //
        // Sau khi sort:
        // [1, 1, 1, 2, 2, 2, 2]
        Arrays.sort(nums);

        //do số lần xuất hiện của phần tư lớn hơn n/2
        //nên phần tử đó sẽ naằm ở giau74 mảng sau khi sort

        // Đây là ý tưởng quan trọng của cách 2.
        //
        // Majority element xuất hiện nhiều hơn n/2 lần.
        //
        // Vì vậy sau khi sort, majority element bắt buộc
        // phải nằm ở vị trí chính giữa mảng.
        //
        //
        // Ví dụ:
        //
        // nums = [1, 1, 1, 2, 2, 2, 2]
        // index:
        //          0  1  2  3  4  5  6
        //
        // nums.length = 7
        // nums.length / 2 = 3
        //
        // nums[3] = 2
        //
        // → 2 chính là majority element.


        // nums.length / 2:
        //
        // lấy vị trí giữa mảng.
        //
        // nums[...]:
        // lấy phần tử tại vị trí đó.
        //
        // Vì đề bài đảm bảo majority element luôn tồn tại,
        // phần tử ở giữa chắc chắn là majority element.
        return nums[nums.length/2];
        // Không cần kiểm tra null ở đây vì:
        //
        // 1. Đề bài đảm bảo majority element tồn tại.
        // 2. Nếu nums hợp lệ thì nums.length > 0.
        // 3. Ta trực tiếp lấy một phần tử trong mảng.
    }

    // =========================================================
    // CÁCH 3: BOYER-MOORE VOTING ALGORITHM
    // =========================================================
    //
    // Đây là cách khó hiểu nhất trong 3 cách.
    //
    // Ý tưởng:
    //
    // Majority element xuất hiện > n/2 lần.
    //
    // Nghĩa là số lần xuất hiện của majority element
    // nhiều hơn tổng số lần xuất hiện của TẤT CẢ
    // các phần tử khác cộng lại.
    //
    // Vì vậy ta có thể cho:
    //
    //     majority element → +1
    //     phần tử khác      → -1
    //
    // Các phần tử khác nhau sẽ "triệt tiêu" nhau.
    //
    // Cuối cùng majority element vẫn còn lại.


    // Ví dụ:
    //
    // nums = [2, 2, 1, 1, 1, 2, 2]
    //
    // 2 xuất hiện 4 lần.
    // 1 xuất hiện 3 lần.
    //
    // 2 là majority.
    public Integer process3 (int[] nums){
        // count dùng để theo dõi "số phiếu hiện tại"
        // của candidate.
        //
        // count không đơn giản chỉ là:
        // "candidate xuất hiện bao nhiêu lần".
        //
        // Nó là sự chênh lệch giữa:
        //
        // số lần candidate gặp
        // MINUS
        // số lần gặp phần tử khác candidate
        //
        // Ví dụ:
        //
        // candidate = 2
        //
        // gặp 2 → count tăng 1
        // gặp số khác 2 → count giảm 1
        int count = 0;

        // candidate = phần tử hiện tại mà chúng ta
        // đang "nghi ngờ" là majority element.
        //
        // Ban đầu chưa có candidate
        // nên gán null.
        //
        // Khi count == 0,
        // ta sẽ chọn phần tử hiện tại làm candidate mới.
        Integer candidate = null;

        // Duyệt lần lượt từng phần tử trong nums.
        //
        // num sẽ lần lượt nhận từng phần tử của mảng.

        for (int num: nums){

            // Nếu count == 0:
            //
            // candidate hiện tại đã bị "triệt tiêu" hết
            // bởi các phần tử khác.
            //
            // Vì vậy ta bỏ candidate cũ
            // và chọn num hiện tại làm candidate mới.
            if (count ==0){
                // num trở thành candidate mới.
                //
                // Ví dụ:
                // num = 2
                //
                // candidate = 2
                candidate = num;
            }
            //count+= (num==candidate)?1:-1;
            // Nếu num giống candidate:
            //
            // candidate nhận thêm 1 "phiếu".
            //
            // count tăng lên 1.
            //
            // Nếu num khác candidate:
            //
            // một phần tử khác đang "triệt tiêu"
            // một phiếu của candidate.
            //
            // count giảm đi 1.
            if (num== candidate){

                // num giống candidate
                // → tăng sức mạnh của candidate.
                count++;
            }
            else {
                // num khác candidate
                // → triệt tiêu một phiếu của candidate.
                count--;
            }
        }
        // Sau khi duyệt hết mảng,
        // candidate chính là majority element.
        //
        // Điều này đúng vì đề bài đảm bảo
        // majority element luôn tồn tại
        // và nó xuất hiện nhiều hơn tất cả phần tử khác cộng lại.
        //
        // Vì vậy sau quá trình "triệt tiêu",
        // majority element vẫn là candidate cuối cùng.

        return  candidate;
    }


}
