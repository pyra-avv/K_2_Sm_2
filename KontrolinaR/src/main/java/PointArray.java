public class PointArray {
    private Point start;
    private Point[] arr;
    public PointArray(int n, double x, double y) {
        this.arr = new Point[n];
        for (int i = 0; i < n; i++) {
            arr[i].setX(x);
            arr[i].setY(y);
        }
    }

}
