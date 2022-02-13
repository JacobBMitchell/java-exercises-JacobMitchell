public class tryCatchLearning {
    public static void main(String[] args) {
        int num1 = 6;
        try{
            num1 = 5/0;
        }catch (Exception e){
            System.out.println(e);
            num1 = num1/3;
        }finally { // This is useful for self contained variables in the try catch block to be used then discarded
            System.out.println("6 cannot be divided by 0!");
            //throw new RuntimeException("Yo what the heck is this!"); //stops program

//            num1 = num1/3;
        }
        System.out.println(num1);
        throw new RuntimeException("Yo what the heck is this!"); // has to be the last thing called as it will stop the program.
    }
}
