
class Start {

    public static void main(String[] args) {
        int[] a = { 9, 8, 5, 4, 3, 1, 7, 2, 6 };
        
        Tool.sort(a);
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}

class Tool {
    static void sort(int[] data) {
        sort(data, 0, data.length - 1);
    }
    
    static void sort(int[] data, int left, int right) {
        if (left >= right) return;
        int pivot = partition(data, left, right);
        sort(data, left, pivot -1); 
        sort(data, pivot + 1, right);
    }
    
    static int partition(int[] data, int left, int right) {
        int total = right - left + 1;
        int r = (int)Math.random() * total;
        int pivot = left + r;
        int t  = data[pivot];       // data[pivot] <=> data[right]
        data[right] = t;
        pivot = right;
        
        int turtle = left;
        for (int rabbit = left; rabbit < right; rabbit++) {
            
            // found less that pivot, what to do?
            if(data[rabbit] < data[pivot]) {
                int box = data[rabbit];         // swap value
                data[rabbit] = data[turtle];    // data[rabbit] <=> data[turtle]
                data[turtle] = box;
                turtle++;
            }
            
            // found greater than pivot, what to do?
            // found equal to pivot, what to do?
        }
        if(left == 0 && right == data.length - 1) {
            for (int i = 0; i < data.length; i++) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
            System.out.println("This is turtle " + turtle);
        }
        int temporary = data[pivot];
        data[pivot] = data[turtle];
        data[turtle] = temporary;
        return turtle; // don't forget to move to somewhere between left & right
    }
}