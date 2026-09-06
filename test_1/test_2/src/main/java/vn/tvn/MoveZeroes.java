package vn.tvn;

public class MoveZeroes {

    // =========================================================
    // CÁCH 1: TẠO ARRAY MỚI
    // =========================================================
    //
    // Ý tưởng:
    // - Không sửa trực tiếp array nums.
    // - Tạo một array mới tên result có cùng độ dài với nums.
    // - Duyệt qua nums.
    // - Gặp số khác 0 thì đưa số đó vào result từ trái sang phải.
    // - Những vị trí còn lại của result tự động là 0
    //   vì array int mới trong Java mặc định chứa toàn số 0.
    //
    // Ví dụ:
    // nums   = [0, 1, 0, 3, 12]
    // result = [0, 0, 0, 0, 0]  (array mới)
    //
    // Sau khi duyệt:
    // result = [1, 3, 12, 0, 0]
    //
    // Kết quả đúng, NHƯNG cách này không phải "in-place"
    // vì ta tạo thêm một array mới.
    //
    public int[] process(int[] nums){
        // Tạo array result mới có cùng độ dài với nums.
        // Ban đầu tất cả phần tử của result đều là 0.
        //
        // nums   = [0, 1, 0, 3, 12]
        // result = [0, 0, 0, 0, 0]
        int[] result = new int[nums.length];
        // index là vị trí tiếp theo trong result
        // mà ta sẽ đặt một số KHÁC 0.
        //
        // Ban đầu chưa có số khác 0 nào được đưa vào,
        // nên bắt đầu từ vị trí 0.
        int index= 0;
        // for-each:
        // "num lần lượt nhận từng phần tử trong nums"
        //
        // Ví dụ:
        // lần 1: num = 0
        // lần 2: num = 1
        // lần 3: num = 0
        // lần 4: num = 3
        // lần 5: num = 12
        for(int num: nums){
            // Chỉ xử lý những số khác 0.
            // Vì mục tiêu là đưa tất cả số khác 0
            // lên đầu result.
            if(num != 0){
                // Đưa num vào vị trí index của result.
                //
                // index++ có nghĩa:Dùng index hiện tại để đặt num trước → sau đó mới tăng index lên 1
                // 1. dùng giá trị hiện tại của index
                //    để truy cập result[index]
                // 2. sau đó tăng index lên 1.
                //
                // Ví dụ:
                // index = 0 (index hiện tai), num = 1(số khác 0)
                // result[0] = 1 (place cái số khác 0 đó vào index hiện tai)
                // sau đó index = 1 (sau khi place như tren)
                //num không có index riêng ở đây. Ta chỉ quan tâm nó đang có giá trị gì
                //index = vị trí tiếp theo cần place num != 0 vào result
                // result = [0, 0, 0, 0, 0]
                result[index++]=num;
            }
        }
        //nhưng không đúng yêu cầu của bài toán
        // Các vị trí chưa được gán trong result
        // vẫn giữ giá trị mặc định là 0.
        //
        // Ví dụ:
        // result = [1, 3, 12, 0, 0]
        //
        // Trả về array mới result.
        return  result;

    }

    // =========================================================
    // CÁCH 2: IN-PLACE + TWO POINTER
    // =========================================================
    //
    // "In-place" nghĩa là:
    // - Không tạo array mới.
    // - Sửa trực tiếp array nums.
    //
    // Ý tưởng:
    // - Dùng inserPos để đánh dấu vị trí tiếp theo
    //   cần đặt một số khác 0.
    // - Duyệt qua nums.
    // - Gặp số khác 0 → đưa nó về nums[inserPos].
    // - Sau khi đưa hết số khác 0 lên đầu,
    //   những vị trí còn lại được đổi thành 0.
    //
    // Ví dụ:
    // nums = [0, 1, 0, 3, 12]
    //
    // Sau khi đưa số khác 0 lên đầu:
    // nums = [1, 3, 12, 3, 12]
    //--------------------↑--↑
    //--------------phần cuối chưa xử lý
    //
    // Sau while:
    // nums = [1, 3, 12, 0, 0]
    public  int[] process2 (int[] nums){
        // inserPos = vị trí tiếp theo trong nums
        // mà ta muốn đặt số khác 0.
        //
        // Ban đầu chưa có số khác 0 nào,
        // nên bắt đầu tại vị trí 0.
        int inserPos = 0;
        // Duyệt lần lượt từng phần tử của nums.
        //
        // num chỉ là giá trị của phần tử hiện tại,
        // không phải index.
        for (int num: nums){

            // Nếu num khác 0,
            // ta muốn đưa num lên phía trước.
            if (num !=0){
                // Đặt num vào vị trí inserPos.
                //
                // Ví dụ:
                // inserPos = 0 (đây là vị trí trỏ, không phải vị trí index theo nums đề cho
                //gặp nums khác không thì place vào inserPos = 0 (đầu tiên)
                //rồi dời con trỏ sang inserPos kế tiếp
                // num = 1
                //
                // nums[0] = 1
                nums[inserPos]= num;
                // Đã đặt xong một số khác 0.
                // Vì vậy vị trí tiếp theo cũng phải tiến lên 1.
                inserPos++;
            }
        }
        // Lúc này tất cả số khác 0 đã được đưa lên đầu.
        //
        // inserPos đang đứng tại:
        // "vị trí đầu tiên chưa được điền"
        //
        // Ví dụ:Vì cách 2 chỉ "ghi đè" các số khác 0 lên đầu,
        // chứ chưa xóa những giá trị cũ ở phía sau.
        // nums      = [1, 3, 12, 3, 12]
        // Hai số 3 và 12 vẫn còn ở đó, vì chúng chưa bị xóa.
        // inserPos  = 3
        //
        // Từ index 3 trở đi phải là 0.
       while (inserPos < nums.length){
           // Gán 0 cho vị trí còn lại.
           nums[inserPos]=0;
           // Phải tăng inserPos để chuyển sang vị trí tiếp theo.
           //
           // Nếu quên dòng này → while sẽ lặp vô hạn
           // vì inserPos luôn giữ nguyên.
           inserPos++;
       }
        // Trả về chính nums đã được sửa.
       return nums;
    }

    //cách 3: tối ưu nhất

    // =========================================================
    // CÁCH 3: IN-PLACE + TWO POINTER + SWAP
    // =========================================================
    //
    // Đây là cách tối ưu hơn về số lần ghi ở cuối:
    // - Không cần vòng while để điền toàn bộ số 0.
    // - Khi tìm được số khác 0, ta swap nó về vị trí inserPos.
    //
    // Có 2 vị trí quan trọng:
    //
    // i:
    // - Dùng để duyệt qua toàn bộ array.
    //
    // inserPos:
    // - Vị trí tiếp theo cần đặt số khác 0.
    //
    // Nói đơn giản:
    //
    // i → đang đi tìm số khác 0
    // inserPos  → đang chờ số khác 0 để đưa vào
    //
    public int[] process3(int[] nums){
        // Vị trí tiếp theo để đặt số khác 0.
        //
        // Ban đầu chưa có số khác 0 nào,
        // nên bắt đầu tại index 0.
        int inserPos =0;
        // i là index dùng để duyệt từng vị trí trong nums.
        //
        // i = 0 → kiểm tra nums[0]
        // i = 1 → kiểm tra nums[1]
        // i = 2 → kiểm tra nums[2]
        // ...
        for(int i=0; i<nums.length; i++){
            // Nếu nums[i] khác 0,
            // nghĩa là ta đã tìm được một số cần đưa lên đầu.
            if(nums[i] !=0){
                // Lưu lại số ở vị trí i trước khi swap.
                //
                // Cần làm vậy vì ngay sau đó nums[i]
                // sẽ bị thay đổi.
                //
                // Ví dụ:
                // nums = [0, 1, 0, 3, 12]
                //             ↑
                //             i
                //
                // temp = 1
                int temp= nums[i];
                // Đưa giá trị đang ở inserPos
                // sang vị trí i.
                //
                // Ví dụ:
                // i = 1
                // inserPos = 0
                //
                // nums[1] = nums[0]
                // nums[1] = 0
                //
                // Array tạm thời:
                // [0, 0, 0, 3, 12]

                //nums[i] = nums[inserPos]
                //→ lấy giá trị đang ở vị trí inserPos đưa xuống vị trí i.
                //nums[i]= số khác 0
                //nums[inserPos] = 0
                //[0, 0, 0, 3, 12]
                nums[i]= nums[inserPos];
                // Đưa số khác 0 đã lưu trong temp
                // về vị trí inserPos.
                //
                // temp = 1
                // nums[0] = 1
                //
                // Array:
                // [1, 0, 0, 3, 12]
                //
                // Đây chính là phần còn thiếu nếu muốn
                // thực hiện SWAP đầy đủ.

                //nums[inserPos] = temp
                //→ lấy số ban đầu ở i (được cất trong temp) đưa lên vị trí inserPos.
                //temp là số khác 0 được tìm thấy tại vị trí i,
                // được cất tạm vào temp để chuẩn bị swap và đưa số đó về vị trí inserPos.
                // sau đó đưa nó về vị trí inserPos.
                //[1, 0, 0, 3, 12]
                nums[inserPos]=temp;
                // Đã đưa thành công một số khác 0
                // vào vị trí inserPos.
                //
                // Vì vậy vị trí tiếp theo cũng tiến lên 1.
                inserPos++;
            }
        }
        // Sau khi vòng for kết thúc,
        // tất cả số khác 0 đã được đưa lên đầu
        // và các số 0 tự động bị đẩy về phía sau
        // nhờ các lần swap.
        //
        // Ví dụ:
        // [0,1,0,3,12]
        //       ↓
        // [1,3,12,0,0]
        //
        // Trả về chính nums đã được sửa.
        return nums;
    }

}

