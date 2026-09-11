package vn.tvn;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoPointers {
    /*
     * ============================================================
     * TWO POINTERS
     * ============================================================
     *
     * Two Pointers = dùng 2 biến để "đứng" tại 2 vị trí khác nhau
     * trong array/string và di chuyển chúng theo một quy tắc.
     *
     * Ví dụ:
     *
     * [1, 3, 5, 7, 9]
     *  ↑           ↑
     * left       right
     *
     * left  bắt đầu từ bên trái  -> index 0
     * right bắt đầu từ bên phải  -> index cuối
     *
     * Hai pointer có thể di chuyển:
     *
     * 1. left  -> bên phải
     * 2. right -> bên trái
     *
     * Ngoài ra còn có một dạng khác:
     *
     * slow -> đi chậm
     * fast -> đi nhanh
     *
     * Quan trọng:
     * Không phải cứ có 2 biến là Two Pointers.
     * Quan trọng là 2 biến đó đang đại diện cho 2 vị trí
     * và di chuyển để giải quyết bài toán.
     */


    // ============================================================
    // BÀI 1: ĐẢO NGƯỢC ARRAY
    // ============================================================
    //
    // Input:
    // [1, 2, 3, 4, 5]
    //
    // Output:
    // [5, 4, 3, 2, 1]
    //
    // Ý tưởng:
    //
    // Ta lấy phần tử đầu tiên đổi chỗ với phần tử cuối cùng.
    //
    // [1, 2, 3, 4, 5]
    //  ↑           ↑
    // left        right
    //
    // Sau đó:
    //
    // left  tiến vào 1 bước
    // right lùi vào 1 bước
    //
    // [1, 2, 3, 4, 5]
    //     ↑       ↑
    //    left    right
    //
    // Tiếp tục đổi:
    //
    // [5, 2, 3, 4, 1]
    //     ↑       ↑
    //
    // Cho đến khi left >= right thì dừng.
    //
    // ============================================================
    public int[] reverseArray(int[] nums) {
        // left là pointer bắt đầu từ phần tử đầu tiên.
        //
        // Array:
        // [1, 2, 3, 4, 5]
        //  ↑
        // left = 0
        //
        int left = 0;
        // right là pointer bắt đầu từ phần tử cuối cùng.
        //
        // nums.length = 5
        // index cuối cùng = 5 - 1 = 4
        //
        // [1, 2, 3, 4, 5]
        //              ↑
        //           right = 4
        //
        int right = nums.length - 1;

        // Chỉ cần tiếp tục khi left vẫn còn đứng
        // ở bên trái right.
        //
        // Ví dụ:
        //
        // left = 0, right = 4 -> tiếp tục
        // left = 1, right = 3 -> tiếp tục
        // left = 2, right = 2 -> dừng
        //
        // Khi left == right:
        // Hai pointer đang đứng cùng một phần tử.
        // Không cần đổi phần tử đó với chính nó.
        //
        while (left < right) {
            // Lưu tạm giá trị ở vị trí left.
            //
            // Ví dụ:
            // nums[left] = 1
            //
            // temp = 1
            //
            // Ta cần temp vì ngay sau đó nums[left]
            // sẽ bị thay bằng nums[right].
            //
            int temp = nums[left];

            // Đưa giá trị ở bên phải sang bên trái.
            //
            // Ví dụ:
            //
            // [1, 2, 3, 4, 5]
            //  ↑           ↑
            // left        right
            //
            // nums[left]  = 1
            // nums[right] = 5
            //
            // Sau dòng này:
            //
            // [5, 2, 3, 4, 5]
            //
            nums[left] = nums[right];
            // Đưa giá trị cũ của bên trái
            // (đang được lưu trong temp)
            // sang bên phải.
            //
            // [5, 2, 3, 4, 1]
            //
            nums[right] = temp;
            // Sau khi đã đổi xong cặp đầu-cuối,
            // left tiến sang phải 1 vị trí.
            //
            // left: 0 -> 1
            //
            left++;

            // right lùi sang trái 1 vị trí.
            //
            // right: 4 -> 3
            //
            right--;
        }
        // Sau khi while kết thúc,
        // array đã được đảo ngược.
        //
        // Ví dụ:
        // [5, 4, 3, 2, 1]
        //
        return nums;
    }

    //remove duplicate in sorted array
    //[1,1,2,2,3,4,4]-. [1,2,3,4]
    //slow-> 0, fast-> 1

    // ============================================================
    // BÀI 2: REMOVE DUPLICATE IN SORTED ARRAY
    // ============================================================
    //
    // Input:
    // [1, 1, 2, 2, 3, 4, 4]
    //
    // Output:
    // [1, 2, 3, 4]
    //
    // ĐIỀU KIỆN QUAN TRỌNG:
    // Array phải được SORTED (sắp xếp tăng dần).
    //
    // Vì array đã sorted nên những số giống nhau
    // sẽ nằm cạnh nhau.
    //
    // [1, 1, 2, 2, 3, 4, 4]
    //  ↑  ↑
    // slow fast
    //
    // slow:
    // Đại diện cho vị trí cuối cùng của vùng
    // chứa các giá trị KHÔNG bị duplicate.
    //
    // fast:
    // Đi qua array để tìm những giá trị mới.
    //
    // ============================================================

    public int[] removeDuplicate(int[] numsDup) {
        // Nếu array không có phần tử nào,
        // không có duplicate để xử lý.
        //
        // numsDup.length == 0
        //
        // trả về một array rỗng:
        //
        // []
        //
        if (numsDup.length == 0) {
            return new int[0];
        }
        // slow bắt đầu tại index 0.
        //
        // [1, 1, 2, 2, 3, 4, 4]
        //  ↑
        // slow
        //
        // Phần tử đầu tiên luôn được giữ lại.
        //
        int slow = 0;
        // fast bắt đầu từ index 1.
        //
        // Vì slow đang giữ phần tử đầu tiên,
        // fast sẽ đi tìm xem phía sau có giá trị mới hay không.
        //
        // [1, 1, 2, 2, 3, 4, 4]
        //  ↑  ↑
        // slow fast
        //
        for (int fast = 1; fast < numsDup.length; fast++) {
            // So sánh giá trị ở slow với giá trị ở fast.
            //
            // Nếu bằng nhau:
            //
            // numsDup[slow] == numsDup[fast]
            //
            // => fast đang gặp duplicate.
            //
            // Không làm gì.
            //
            // fast vẫn tiếp tục đi sang phải.
            //
            //
            // Nếu khác nhau:
            //
            // numsDup[slow] != numsDup[fast]
            //
            // => fast đã tìm được một giá trị mới.
            //
            if (numsDup[slow] != numsDup[fast]) {
                // Tăng slow lên 1 vị trí.
                //
                // Ví dụ:
                //
                // slow = 0
                //
                // gặp số mới là 2
                //
                // slow:
                // 0 -> 1
                //
                slow++;
                // Đưa giá trị mới tìm được bởi fast
                // vào vị trí mới của slow.
                //
                // Ví dụ:
                //
                // trước:
                // [1, 1, 2, 2, 3, 4, 4]
                //  ↑        ↑
                // slow     fast
                //
                // sau khi slow++:
                //
                // [1, 1, 2, 2, 3, 4, 4]
                //     ↑      ↑
                //    slow   fast
                //
                // numsDup[slow] = numsDup[fast]
                //
                // => đưa số mới vào vùng kết quả.
                //
                numsDup[slow] = numsDup[fast];
            }
        }

        // slow đang nằm tại vị trí cuối cùng
        // của vùng chứa các số unique.
        //
        // Ví dụ:
        //
        // [1, 2, 3, 4, 3, 4, 4]
        //           ↑
        //          slow
        //
        // slow = 3
        //
        // Các phần tử có index:
        //
        // 0 -> 1
        // 1 -> 2
        // 2 -> 3
        // 3 -> 4
        //
        // => vùng kết quả có 4 phần tử.
        //
        // Vì index bắt đầu từ 0:
        //
        // số lượng phần tử = slow + 1
        //
        // Arrays.copyOf(...) tạo một array mới
        // chỉ lấy từ index 0 đến slow.
        //
        return Arrays.copyOf(numsDup, slow + 1);
    }

    //two sum (array is sorted)
    //[1,2,3,4,5], target =6
    //[1,5,6,8,9,10]. target=13
    //left -> right, right-> left
    // ============================================================
    // BÀI 3: TWO SUM - ARRAY ĐÃ SORTED
    // ============================================================
    //
    // Ví dụ:
    //
    // [1, 2, 3, 4, 5]
    // target = 6
    //
    // Ta cần tìm 2 số có tổng = 6.
    //
    // 1 + 5 = 6
    //
    // Vì array đã sorted,
    // ta có thể đặt:
    //
    // left  ở đầu
    // right ở cuối
    //
    // [1, 2, 3, 4, 5]
    //  ↑           ↑
    // left        right
    //
    // ============================================================
    public int[] twoSum(int[] numsTS, int targetTS) {
        // left bắt đầu ở index 0.
        //
        // [1, 2, 3, 4, 5]
        //  ↑
        // left = 0
        //
        int left = 0;
        // right bắt đầu ở index cuối cùng.
        //
        // [1, 2, 3, 4, 5]
        //              ↑
        //           right = 4
        //
        int right = numsTS.length - 1;
        // Tiếp tục khi left vẫn đứng trước right.
        //
        // Khi left == right:
        // chỉ còn một phần tử,
        // không thể dùng một phần tử làm cả hai số.
        //
        while (left < right) {
            // Tính tổng của 2 phần tử
            // mà left và right đang trỏ tới.
            //
            // Ví dụ:
            //
            // [1, 2, 3, 4, 5]
            //  ↑           ↑
            // left        right
            //
            // nums[left]  = 1
            // nums[right] = 5
            //
            // sum = 1 + 5 = 6
            //
            int sum = numsTS[left] + numsTS[right];
            // Nếu tổng đúng bằng target:
            //
            // sum == target
            //
            // => đã tìm thấy đáp án.
            //
            // return ngay index của 2 phần tử.
            //
            if (sum == targetTS) {
                return new int[] {left, right};// trả về index

            }

            // Nếu tổng nhỏ hơn target:
            //
            // Ví dụ:
            //
            // target = 13
            // sum = 11
            //
            // Ta cần tổng LỚN hơn.
            //
            // Vì array đã SORTED:
            //
            // right đang ở phía bên phải.
            // Nếu giảm right -> tổng sẽ nhỏ hơn hoặc bằng.
            //
            // Vì vậy phải tăng left
            // để lấy một số lớn hơn.
            //
            else if (sum < targetTS) {
                left++;
            }

            // Nếu tổng lớn hơn target:
            //
            // Ví dụ:
            //
            // target = 6
            // sum = 9
            //
            // Ta cần tổng NHỎ hơn.
            //
            // Vì array đã SORTED:
            // left đang ở bên trái.
            //
            // Nếu tăng left -> số sẽ lớn hơn,
            // tổng sẽ càng lớn.
            //
            // Vì vậy phải giảm right
            // để lấy một số nhỏ hơn.
            //
            else {
                right--;
            }
        }
        // Nếu while kết thúc mà chưa return
        // thì không tìm thấy cặp số nào có tổng = target.
        //
        // {-1, -1} chỉ là cách quy ước:
        //
        // index -1 không tồn tại trong array
        // => báo hiệu "không tìm thấy".
        //
        return new int[]{-1,-1};//not found
    }

    //bài tập: [1,2,6,4,5]lay all number chia het cho 2
    //cách giải này không phải Two Pointers
    public int[] modulo(int[] numsModulo){
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i< numsModulo.length; i++){
            if(numsModulo[i]% 2==0){
                result.add(numsModulo[i]);
            }
        }
        // vi method khai báo là int[] (ở public int[] modulo)
        // nen phải chuyển Arrays<Interger> thanh int
        //xong mới return kết quả được
        int[] numsResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            numsResult[i] = result.get(i);
        }
        return numsResult;

    }
    //thử giải bài tập: [1,2,6,4,5]lay all number chia het cho 2 bằng Two Pointers
    //left: chạy qua mảng để tìm số chẵn
    //right: chỉ vị trí tiếp theo trong result để lưu số chẵn
    public int[] getEvenNumber(int[] numEven){
        // left dùng để duyệt từng phần tử trong nums
        int left=0;
        // Tạo result có kích thước bằng nums.
        // Đây là kích thước tối đa mà result có thể cần.
        //
        // Ví dụ:
        // nums = [1, 2, 6, 4, 5]
        //
        // nums.length = 5
        //
        // result ban đầu:
        // [0, 0, 0, 0, 0]
        //
        int [] result = new int[numEven.length];
        // right là vị trí tiếp theo trong result
        // mà chúng ta sẽ lưu số chẵn vào.
        //
        // Ban đầu chưa có số chẵn nào
        // nên vị trí đầu tiên cần lưu là index 0.
        int right=0;
        // left sẽ chạy từ đầu đến cuối nums
        while (left<numEven.length){
            // Lấy số hiện tại mà left đang đứng.
            //
            // Ví dụ ban đầu:
            //
            // [1, 2, 6, 4, 5]
            //  ↑
            // left
            //
            // nums[left] = 1
            //
            int num =numEven[left];
            // Kiểm tra num có chia hết cho 2 hay không.
            //
            // Nếu num % 2 == 0
            // thì num là số chẵn.
            if (num%2==0){
                // Nếu là số chẵn,
                // lưu nó vào result tại vị trí right.
                //
                // Ví dụ tìm thấy số 2:
                //
                // result = [0, 0, 0, 0, 0]
                //            ↑
                //          right
                //
                // Sau câu lệnh này:
                //
                // result = [2, 0, 0, 0, 0]
                //
                result[right]= num;
                // Đã lưu xong một số chẵn.
                // Vì vậy right phải di chuyển sang vị trí
                // tiếp theo để chuẩn bị lưu số chẵn tiếp theo.
                right++;
            }
            // left luôn di chuyển sang phần tử tiếp theo
            // để tiếp tục kiểm tra nums.
            left++;
        }
        // right cho biết hiện tại result đã sử dụng bao nhiêu vị trí.
        //
        // Ví dụ:
        //
        // nums = [1, 2, 6, 4, 5]
        //
        // result lúc này:
        //
        // [2, 6, 4, 0, 0]
        //  ↑  ↑  ↑
        //  đã sử dụng 3 vị trí
        //
        // right = 3
        //
        // Chúng ta chỉ lấy 3 phần tử đầu tiên.

        //Arrays.copyOf(result, right)
        //3 vị trí đầu tiên của result là dữ liệu thật.
        return Arrays.copyOf(result, right);
    }

}
