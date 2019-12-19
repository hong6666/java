package lhh.test;

/**
 * @program: IdeaJava
 * @Date: 2019/12/1 20:00
 * @Author: lhh
 * @Description: 菱形
 */
public class Diamond {
    public static void main(String[] args) {
        printDiamond(4);
    }
    public static void printDiamond(int size){
        if(size % 2 == 0 ){
            size++;
        }
        for (int i = 0;i < size/2 + 1;i++){
            for(int j = size/2 + 1;j > i + 1;j--){
                System.out.print("-");
            }
            for(int j = 0;j < 2 * i + 1;j++){
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
