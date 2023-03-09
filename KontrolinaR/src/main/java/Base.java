public class Base {
    public void f() {
        System.out.print("Base");
    }
    boolean check(int[] arrA, int[] arrB) {
        for (int a : arrA) {
            boolean flag = false;
            for (int b : arrB) {
                if (a == b) {
                    flag = true;
                }
            }
            if (!flag) {
                return false;
            }
        }
        return true;
    }




}
