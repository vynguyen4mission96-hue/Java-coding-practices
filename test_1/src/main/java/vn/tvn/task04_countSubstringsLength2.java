package vn.tvn;

public class task04_countSubstringsLength2 {
    public static int countSubstringsLength2(String inputString)
    {
        //không có dữ liệu
        if(inputString ==null) {
            return 0;
        }

        //chuỗi rỗng//không cần vì if(inputString.length()<2) đã cover luôn scenario này
//        if(inputString.length() == 0) {
//            return 0;
//        }

        //chuỗi không thể cắt ra thành chuỗi con có 2 ký tự
        if(inputString.length()<2) {
            return 0;
        }
        // khởi tạo biến số nguyên count= 0
        int count= 0;
        //khởi tạo vòng lặp chạy qua từng vị trí trong chuỗi

        //ví dụ "Hello" có index= 4
        //[H][e][l][l][o]
        //[0][1][2][3][4]
        // đến vị trí i=4 là chữ o, không thể cắt thành chuỗi có 2 ký tự được nên chỉ cho i chạy từ 0 đến i <inputString.length()-1
        //vòng lặp từ i=0 đến i=3
        for (int i=0; i <inputString.length()-1; i++){
            //ví dụ "Hello" có index= 4
//                    i = 0->chạy
//                    i = 1->chạy
//                    i = 2->chạy
//                    i = 3->chạy
//                    i = 4->STOP

            // [ĐOẠN CODE NÀY CHƯA TỐI ƯU]
            //tại mỗi vị trí, cắt 1 chuỗi gồm 2 ký tự
            //substring(i, i+2)
//            String subString2= inputString.substring(i, i+2);
//            if(subString2.length() == 2){
//
//                //cout++ tương đương count= count+1
//                count++;
//            }

            count++;
            //bởi vì for (int i=0; i <inputString.length()-1; i++) đã cover việc chạy qua từng cụm chuỗi có 2 ký tự rồi
        }
        return count;
    }

}
