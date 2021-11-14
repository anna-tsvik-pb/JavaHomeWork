package com.pb.tsvik.hw7;


public class Atalier {
    private static Object Clothes;

    public static void main(String[] args)  {
        Tshirt tshirt = new Tshirt();
        Pants pants = new Pants();
        Skirt skirt = new Skirt();
        Tie tie = new Tie();

        Clothes[] clothes = new Clothes[] {tshirt, pants, skirt, tie};
        dressMan(clothes);
        dressWoman(clothes);
    }


    public static void dressMan(Clothes[] clothes){
        System.out.println("Мужская одежда: ");
        for (Clothes clothes1:  clothes){
            if (clothes1 instanceof ManClothes) {
                ManClothes manClothes = (ManClothes) clothes1;
                                manClothes.dressMan();
            }
        }
    }

    public static void dressWoman(Clothes[] clothes){
        System.out.println("Женская одежда: ");
        for (Clothes clothes2:  clothes){
            if (clothes2 instanceof WomanClothes) {
                WomanClothes womanClothes = (WomanClothes) clothes2;
                womanClothes.dressWoman();

            }
        }
    }


}
