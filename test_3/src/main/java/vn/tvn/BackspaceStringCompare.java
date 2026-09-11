package vn.tvn;

public class BackspaceStringCompare {
    //s= "ab#c", t="ad#c" -> true
    //step1: i=3 -> c, j= 3-> c
    //compare c==c -> i--, j--
    //step 2: i=2 -> #, j=2 -> #
    //skip backspace, i=0, j=0


    /*
     * BÀI TOÁN:
     *
     * Cho 2 String s và t.
     *
     * Khi gõ vào text editor:
     * - Ký tự bình thường: được giữ lại.
     * - '#' : giống phím Backspace → xóa 1 ký tự ngay trước nó.
     *
     * Mục tiêu:
     * Kiểm tra xem sau khi gõ xong s và t,
     * hai String cuối cùng có giống nhau hay không.
     *
     *
     * Ví dụ:
     *
     * s = "ab#c"
     *
     * Gõ:
     * a  → "a"
     * b  → "ab"
     * #  → xóa b → "a"
     * c  → "ac"
     *
     * => s cuối cùng trở thành "ac"
     *
     *
     * t = "ad#c"
     *
     * Gõ:
     * a  → "a"
     * d  → "ad"
     * #  → xóa d → "a"
     * c  → "ac"
     *
     * => t cuối cùng cũng trở thành "ac"
     *
     * => kết quả true
     *
     *
     * Ý TƯỞNG QUAN TRỌNG CỦA BÀI:
     *
     * Không tạo String mới sau khi xử lý.
     *
     * Thay vào đó:
     * - đi từ CUỐI String về đầu
     * - dùng pointer i cho s
     * - dùng pointer j cho t
     * - dùng backspaceCount để biết có bao nhiêu ký tự
     *   phía trước đang cần bị bỏ qua.
     *
     * Nhờ vậy:
     *
     * Time  = O(n)
     * Space = O(1)
     */
    public  boolean process (String s, String t){
        // i là pointer dùng để duyệt String s.
        //
        // s.length() là số lượng ký tự của s.
        //
        // Vì index của String bắt đầu từ 0,
        // nên index cuối cùng sẽ là:
        //
        // s.length() - 1
        //
        // Ví dụ:
        // s = "ab#c"
        //
        // index:
        //   0  1  2  3
        //   a  b  #  c
        //
        // => i = 3
        int i= s.length() -1;
        // j là pointer dùng để duyệt String t
        // từ cuối về đầu.
        //
        // Ví dụ:
        // t = "ad#c"
        //
        // index:
        //   0  1  2  3
        //   a  d  #  c
        //
        // => j = 3
        int j= t.length() -1;

        // Vòng lặp tiếp tục khi:
        //
        // i vẫn còn nằm trong s
        // HOẶC
        // j vẫn còn nằm trong t.
        //
        // Tại sao dùng || (OR)?
        //
        // Vì có thể một String hết trước String còn lại.
        //
        // Ví dụ:
        // s = "ab#"
        // t = "a"
        //
        // s sau xử lý = ""
        // t sau xử lý = "a"
        //
        // Ta vẫn cần kiểm tra trường hợp này.
        while (i >=0 || j>=0){
            // getNextValidCharIndex() có nhiệm vụ:
            //
            // Từ vị trí hiện tại của i,
            // đi ngược về bên trái
            // để tìm ra KÝ TỰ THỰC SỰ CÒN TỒN TẠI.
            //
            // Ví dụ:
            //
            // s = "ab#c"
            //
            // đang ở:
            //
            // a  b  #  c
            //          ↑
            //          i = 3
            //
            // Hàm trả về index của ký tự hợp lệ tiếp theo.
            //
            // Sau khi gọi:
            // i = getNextValidCharIndex(s, i);
            i =getNextValidCharIndex(s,i);

            // Làm tương tự với String t.
            //
            // j sẽ được đưa tới index của
            // ký tự thực sự còn tồn tại trong t.
            j= getNextValidCharIndex(t,j);

            // Nếu cả i và j đều < 0:
            //
            // Có nghĩa là:
            // - s không còn ký tự hợp lệ
            // - t cũng không còn ký tự hợp lệ
            //
            // Ví dụ:
            //
            // s = "ab##" → ""
            // t = "c#d#" → ""
            //
            // Hai String cuối cùng đều rỗng.
            //
            // => giống nhau
            // => return true
            if (i< 0&& j<0){
                return true;
            }

            // Nếu chỉ MỘT trong hai String hết ký tự:
            //
            // i < 0 → s hết
            // j < 0 → t hết
            //
            // nhưng String còn lại vẫn có ký tự.
            //
            // Ví dụ:
            //
            // s = "ab#"
            // → ""
            //
            // t = "a"
            // → "a"
            //
            // Một bên rỗng, một bên có "a".
            //
            // => chắc chắn khác nhau.
            if (i<0|| j <0){
                return false;
            }

            // Lúc này:
            //
            // i đang trỏ vào ký tự hợp lệ của s
            // j đang trỏ vào ký tự hợp lệ của t.
            //
            // charAt(i):
            // lấy ký tự tại index i của String s.
            //
            // charAt(j):
            // lấy ký tự tại index j của String t.
            //
            // Nếu 2 ký tự khác nhau:
            //
            // s và t chắc chắn khác nhau.
            //
            // => không cần kiểm tra tiếp.
            if (s.charAt(i) != t.charAt(j)){
                return false;
            }

            // Nếu chạy tới đây:
            //
            // s.charAt(i) == t.charAt(j)
            //
            // Hai ký tự hiện tại giống nhau.
            //
            // Vậy ta đã kiểm tra xong cặp ký tự này.
            //
            // Bây giờ di chuyển cả 2 pointer sang trái
            // để kiểm tra cặp ký tự tiếp theo.
            //
            // Ví dụ:
            //
            // i = 3 → sau khi kiểm tra c
            // i-- → i = 2
            //
            // j = 3 → sau khi kiểm tra c
            // j-- → j = 2
            i--;
            j--;
        }
        // Nếu vòng while kết thúc mà chưa gặp:
        //
        // return false
        //
        // thì có nghĩa là tất cả ký tự hợp lệ
        // của s và t đều đã được so sánh
        // và không phát hiện ký tự nào khác nhau.
        //
        // => hai String giống nhau.
        return true;

    }
    /*
     * ==========================================================
     * getNextValidCharIndex()
     * ==========================================================
     *
     * NHIỆM VỤ:
     *
     * Từ index hiện tại,
     * đi từ phải → trái
     * để tìm ra index của ký tự THỰC SỰ CÒN TỒN TẠI.
     *
     *
     * Ví dụ:
     *
     * str = "ab#c"
     *
     * index = 3
     *
     *       i
     *       ↓
     * a  b  #  c
     * 0  1  2  3
     *
     * Hàm phải tìm ra:
     *
     * c
     *
     * => return 3
     *
     *
     * Nhưng nếu:
     *
     * index = 2
     *
     *       i
     *       ↓
     * a  b  #
     * 0  1  2
     *
     * gặp '#'
     *
     * '#' sẽ xóa 'b'
     *
     * => bỏ qua '#'
     * => bỏ qua 'b'
     * => tìm tiếp 'a'
     *
     * => return 0
     *
     *
     * Biến quan trọng nhất ở đây:
     *
     * backspaceCount
     *
     * Nó đại diện cho:
     *
     * "Có bao nhiêu ký tự bình thường phía trước
     * đang cần bị xóa?"
     *
     */
    private int getNextValidCharIndex(String str, int index){

        // Ban đầu chưa gặp dấu '#'
        // nên chưa có ký tự nào cần bỏ qua.
        //
        // Ví dụ:
        //
        // str = "ab#c"
        // index = 3
        //
        // đang xét từ c.
        //
        // backspaceCount = 0
        int backspaceCount =0;

        // Tiếp tục đi sang trái
        // miễn là index vẫn còn nằm trong String.
        //
        // index >= 0 nghĩa là:
        //
        // index = 0 → vẫn còn ký tự để xét
        // index = -1 → đã đi qua đầu String
        while (index >=0){

            // charAt(index):
            // lấy ký tự tại vị trí index.
            //
            // Nếu ký tự đó là '#':
            //
            // '#' chính là Backspace.
            //
            // Nó sẽ xóa một ký tự bình thường
            // nằm phía trước nó.
            //
            // Vì đang duyệt từ phải → trái,
            // ta chưa xóa ngay.
            //
            // Ta chỉ ghi nhớ rằng:
            //
            // "Phía trước cần bỏ qua 1 ký tự."
            if (str.charAt(index)=='#'){

                // Có thêm 1 backspace cần xử lý.
                //
                // Ví dụ:
                //
                // gặp:
                //
                // #
                //
                // => backspaceCount = 1
                //
                // Nếu gặp tiếp:
                //
                // ##
                //
                // => backspaceCount = 2
                backspaceCount++;
            }
            else {

                // Nếu đây KHÔNG phải '#',
                // thì đây là một ký tự bình thường.
                //
                // Nhưng phải kiểm tra xem
                // phía sau nó có Backspace nào
                // đang chờ xóa nó hay không.
                if(backspaceCount >0){
                    // Có ít nhất 1 Backspace đang chờ.
                    //
                    // Ví dụ:
                    //
                    // a  b  #
                    //    ↑  ↑
                    //    b  #
                    //
                    // '#' sẽ xóa b.
                    //
                    // Vì vậy b không được đem đi so sánh.
                    //
                    // Ta tiêu thụ 1 Backspace:
                    backspaceCount--;
                    // Sau đó tiếp tục đi sang trái
                    // để tìm ký tự hợp lệ tiếp theo.
                }
                else {
                    // backspaceCount == 0
                    //
                    // Có nghĩa là:
                    //
                    // - ký tự hiện tại không phải '#'
                    // - không có Backspace nào đang chờ xóa nó
                    //
                    // => đây chính là ký tự THỰC SỰ CÒN TỒN TẠI.
                    //
                    // Vì đã tìm được rồi
                    // nên dừng vòng while.
                    break;
                }
            }
            // Sau khi xử lý ký tự hiện tại,
            // di chuyển index sang trái 1 vị trí.
            //
            // Ví dụ:
            //
            // index = 3
            // index-- → 2
            //
            // index = 2
            // index-- → 1
            //
            // index = 1
            // index-- → 0
            index--;
        }
        // Trả về index của ký tự hợp lệ.
        //
        // Có 2 khả năng:
        //
        // 1. index >= 0
        //    → tìm được ký tự hợp lệ.
        //
        // 2. index < 0
        //    → không còn ký tự hợp lệ nào.
        //
        // Ví dụ:
        //
        // "ab##"
        //
        // tất cả a và b đều bị xóa
        //
        // => index sẽ đi xuống -1
        // => return -1
        return index;
    }
}
