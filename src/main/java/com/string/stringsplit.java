package com.string;

/**
 * @author yangyangl
 * @date 2018-09-20 20:31
 */
public class stringsplit {

    public static void main(String[] args) {
String qq ="12311";
        String[] mobiles = qq.split(",");
        StringBuilder mobileBuffer= new StringBuilder();
        for (String mobile : mobiles) {
            mobile = mobile+"aaa";
            mobileBuffer.append(mobile).append(",");
        }
        String mobileList = mobileBuffer.toString();
        mobileList = mobileList.substring(0,mobileList.length()-1);
        System.out.println(mobileList);




        boolean q = true;
        boolean a = false;
        boolean c = q || a ;
        boolean sc = q && a ;
        System.out.println("c-"+c+"sc"+sc );
    }
}
