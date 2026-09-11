package vn.tvn;

public class SquaresSortedArray {
//    /SquaresSortedArray bằng Two pointers solution
// Bài toán:
// Cho một mảng nums ĐÃ ĐƯỢC SẮP XẾP TĂNG DẦN.
//
// Ví dụ:
// nums = [-4, -1, 0, 3, 10]
//
// Bình phương từng số:
// [-4]^2 = 16
// [-1]^2 = 1
//  0 ^2 = 0
//  3 ^2 = 9
// 10 ^2 = 100
//
// Nếu bình phương rồi sắp xếp lại:
// [0, 1, 9, 16, 100]
//
// Mục tiêu:
// Trả về mảng bình phương đã được sắp xếp tăng dần.
//
// Đây là cách giải bằng TWO POINTERS.
//
// Ý tưởng quan trọng:
// Vì nums đã được sắp xếp tăng dần nên:
//
// - Số lớn nhất về trị tuyệt đối có thể nằm ở BÊN TRÁI
//   (ví dụ -10)
//
// - Hoặc nằm ở BÊN PHẢI
//   (ví dụ 10)
//
// Vì vậy mỗi lần ta chỉ cần so sánh:
//     bình phương của phần tử bên trái
//     với
//     bình phương của phần tử bên phải
//
// Số nào lớn hơn -> đưa vào CUỐI result trước.
//
// Sau đó di chuyển pointer tương ứng vào trong.
    public int[] process3 (int[] nums){
        // n là số lượng phần tử của nums.
        //
        // Ví dụ:
        // nums = [-4, -1, 0, 3, 10]
        // n = 5
        int n =nums.length;
        // Tạo mảng result có kích thước bằng nums.
        //
        // Tại sao không dùng ArrayList?
        // Vì ta biết trước chính xác result sẽ có bao nhiêu phần tử:
        // -> n phần tử.
        //
        // result ban đầu:
        // [0, 0, 0, 0, 0]
        int [] result = new int[n];
        // LEFT POINTER
        //
        // left bắt đầu từ phần tử đầu tiên của mảng.
        //
        // index = 0
        //
        // Ví dụ:
        // [-4, -1, 0, 3, 10]
        //  ↑
        // left
        int left =0;
        // RIGHT POINTER
        //
        // right bắt đầu từ phần tử cuối cùng của mảng.
        //
        // index = n - 1
        //
        // Nếu n = 5:
        // right = 4
        //
        // [-4, -1, 0, 3, 10]
        //                 ↑
        //               right
        int right =n-1;
        // index cho biết vị trí trong result
        // mà chúng ta sẽ điền kết quả.
        //
        // Vì ta đang tìm SỐ LỚN NHẤT trước,
        // nên số lớn nhất phải được đặt ở CUỐI result.
        //
        // Vì vậy:
        // index bắt đầu từ n - 1.
        //
        // Ví dụ n = 5:
        //
        // result:
        // [0, 0, 0, 0, 0]
        //              ↑
        //            index
        //
        // Ta sẽ điền từ PHẢI sang TRÁI.
        int index = n-1;
        // Tiếp tục khi left và right chưa vượt qua nhau.
        //
        // left <= right có nghĩa là:
        // vẫn còn ít nhất một phần tử chưa được xử lý.
        //
        // Ví dụ:
        //
        // left = 0, right = 4 -> còn nhiều phần tử
        // left = 2, right = 2 -> còn đúng 1 phần tử
        // left = 3, right = 2 -> đã xử lý hết -> dừng
        while (left<=right){
            // Tính bình phương của phần tử tại vị trí left.
            //
            // Ví dụ:
            // nums[left] = -4
            //
            // leftSquare = (-4) * (-4)
            //             = 16
            int leftSquare = nums[left]*nums[left];
            // Tính bình phương của phần tử tại vị trí right.
            //
            // Ví dụ:
            // nums[right] = 10
            //
            // rightSquare = 10 * 10
            //              = 100
            int rightSquare = nums[right]*nums[right];
            // So sánh bình phương ở hai đầu.
            //
            // Đây chính là PHẦN CỐT LÕI của Two Pointers.
            //
            // Ta không cần kiểm tra tất cả các phần tử.
            // Chỉ cần kiểm tra:
            //
            //     LEFT  <------->  RIGHT
            //
            // Vì mảng ban đầu đã được sắp xếp tăng dần,
            // phần tử có bình phương lớn nhất còn lại
            // chắc chắn nằm ở một trong hai đầu.
            if (leftSquare>rightSquare){
                // Nếu bình phương bên trái lớn hơn
                // bình phương bên phải,
                // thì leftSquare chính là số lớn nhất
                // trong những phần tử chưa xử lý.
                //
                // Vì đang điền result từ PHẢI sang TRÁI,
                // ta đặt leftSquare vào vị trí index.
                //
                // Ví dụ:
                //
                // leftSquare = 16
                // index = 3
                //
                // result[3] = 16
                result[index] =leftSquare;
                // Đã sử dụng nums[left]
                // nên không cần xét lại phần tử này.
                //
                // Di chuyển left sang phải 1 vị trí.
                //
                // left++;
                //
                // có nghĩa là:
                // left = left + 1
                left++;
            }
            else{
                // Trường hợp ngược lại:
                //
                // rightSquare >= leftSquare
                //
                // Nghĩa là bình phương bên phải lớn hơn
                // hoặc bằng bình phương bên trái.
                //
                // Vì vậy rightSquare là số lớn nhất
                // trong những phần tử còn lại.
                //
                // Đưa rightSquare vào result[index].
                result[index]=rightSquare;
                // Đã sử dụng nums[right]
                // nên không cần xét lại phần tử này.
                //
                // Di chuyển right sang trái 1 vị trí.
                //
                // right--;
                //
                // có nghĩa là:
                // right = right - 1
                right--;
            }
            // Sau khi đã đặt được MỘT số vào result,
            // ta chuyển sang vị trí kế tiếp ở bên trái.
            //
            // Ví dụ:
            //
            // Lần đầu:
            // index = 4
            // -> đặt số lớn nhất vào result[4]
            //
            // Sau đó:
            // index = 3
            // -> đặt số lớn thứ hai vào result[3]
            //
            // Tiếp tục như vậy cho đến đầu mảng.
            index--;
        }
        // Khi vòng while kết thúc:
        // left đã vượt qua right.
        //
        // Nghĩa là tất cả phần tử trong nums
        // đã được bình phương và đưa vào result.
        //
        // result lúc này đã được sắp xếp tăng dần.
        return result;

    }
}
