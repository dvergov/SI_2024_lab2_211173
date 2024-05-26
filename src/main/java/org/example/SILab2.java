package org.example;

import java.util.List;


public class SILab2 {
    public static boolean checkCart(List<Item> allItems, int payment){//1
        if (allItems == null){//2
            throw new RuntimeException("allItems list can't be null!"); //3
        }

        float sum = 0;//4

        for (int i = 0; i < allItems.size(); i++){//5
            Item item = allItems.get(i);//6
            if (item.getName() == null || item.getName().length() == 0){//7
                item.setName("unknown");//8
            }
            if (item.getBarcode() != null){//9
                String allowed = "0123456789";//10
                char chars[] = item.getBarcode().toCharArray();//11
                for (int j = 0; j < item.getBarcode().length(); j++){//12
                    char c = item.getBarcode().charAt(j);//13
                    if (allowed.indexOf(c) == -1){//14
                        throw new RuntimeException("Invalid character in item barcode!");//15
                    }
                }//16 end for
                if (item.getDiscount() > 0){//17
                    sum += item.getPrice()*item.getDiscount();//18
                }
                else {
                    sum += item.getPrice();//19
                }
            }//end if
            else {
                throw new RuntimeException("No barcode!");//20
            }
            if (item.getPrice() > 300 && item.getDiscount() > 0 && item.getBarcode().charAt(0) == '0'){//21
                sum -= 30;//22
            }
        }//23 end for
        if (sum <= payment){//24
            return true;//25
        }
        else {
            return false;//26
        }
    }//27(izlez klasa)
}