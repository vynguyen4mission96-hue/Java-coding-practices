package vn.tvn;

public class task05_1_printinBox {
    // printInbox là method
    //String[] là data type (kiểu dữ liệu)- Array
    //numberString là parameter (tham số)-tên biến nhận dữ liệu
    // void là data type không có RETURN
    public static void printInBox(String[] numberStrings) {
        //code chưa tối ưu
//        System.out.println(numberStrings[0]+ numberStrings[1]+numberStrings[2]);
//        System.out.println(numberStrings[3]+ numberStrings[4]+numberStrings[5]);
//        System.out.println(numberStrings[6]+ numberStrings[7]+numberStrings[8]);
        for (int i = 0; i < numberStrings.length; i++) {
            System.out.println(numberStrings[i]);
        }
        // so sánh chiều rộng cốt lớn nhất để làm chuẩn, "1234" có width lớn nhất
        //1 2 3
        //1234 5 6
        //45 8 9
        //tìm width-Cột 1 bao gồm mảng [0, 3, 6]
        int width1 = 0;
        for (int i = 0; i < numberStrings.length; i = i + 3) {
            if (numberStrings[i].length() > width1) {
                width1 = numberStrings[i].length();
            }
            //test
            System.out.println("width_1" + "[" + i + "]" + width1);
        }

        //tim width-Cột 2 bao gồm mảng [1, 4, 7]
        int width2 = 0;
        for (int i = 1; i < numberStrings.length; i = i + 3) {
            if (numberStrings[i].length() > width2) {
                width2 = numberStrings[i].length();
            }
            //test
            System.out.println("width_2" + "[" + i + "]" + width2);
        }

        //tìm width-Cột 3 bao gồm mảng [2, 5, 8]
        int width3 = 0;
        for (int i = 2; i < numberStrings.length; i = i + 3) {
            if (numberStrings[i].length() > width3) {
                width3 = numberStrings[i].length();
            }
            //test
            System.out.println("width_3" + "[" + i + "]" + width3);
        }

        //vẽ khung từng cột
        //cột 1
        //vẽ +-----+
        String col1row ="-";

        for (int i= 0; i< width1; i++){
            col1row = col1row + "-";
        }
        //cột 2
        //vẽ +-----+
        String col2row ="-";

        for (int i= 0; i< width2+1; i++){
            col2row = col2row + "-";
        }
        //cột 3
        //vẽ +-----+
        String col3row ="-";

        for (int i= 0; i< width3+1; i++){
            col3row = col3row + "-";
        }

        //draw spaces " "
        //vị trí [0] trong array
        String drawspace ="";
        for (int i= 0;i< width1-numberStrings[0].length();i++) {
            drawspace= drawspace+ " ";

        }
        //vị trí [3] trong array
        String drawspace2 ="";
        for (int i= 0;i < width1-numberStrings[3].length();i++) {
            drawspace2= drawspace2+ " ";

        }
        //vị trí [6] trong array
        String drawspace3 ="";
        for (int i= 0;i < width1-numberStrings[6].length();i++) {
            drawspace3= drawspace3+ " ";

        }


        System.out.println("+"+ col1row +"+"+col2row+"+"+col3row+"+");
        System.out.println("|"+" "+numberStrings[0]+drawspace+"|"+" "+numberStrings[1]+" "+"|"+" "+numberStrings[2]+" "+"|");// cột 1 hàng 1
        System.out.println("+"+ col1row +"+"+col2row+"+"+col3row+"+");
        System.out.println("|"+" "+ numberStrings[3]+drawspace2+"|"+" "+numberStrings[4]+" "+"|"+" "+numberStrings[5]+" "+"|"); // cột 1 hàng 2
        System.out.println("+"+ col1row +"+"+col2row+"+"+col3row+"+");
        System.out.println("|"+" "+ numberStrings[6]+drawspace3+"|"+" "+numberStrings[7]+" "+"|"+" "+numberStrings[8]+" "+"|"); // cột 1 hàng 3
        System.out.println("+"+ col1row +"+"+col2row+"+"+col3row+"+");

        }


    }

