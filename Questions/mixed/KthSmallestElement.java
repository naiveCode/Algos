import java.util.*;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] a = {48, 77, 77, 6, 95, 19, 2, 97, 29, 27, 9 };
        int k = 8;
        List<Integer> p = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            p.add(a[i]);
        }
        KthSmallestElement b = new KthSmallestElement();
        System.out.println(b.kthsmallest(p, k));
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int kthsmallest(final List<Integer> a, int k) {
        int listSize = a.size();
        MaxHeap m = new MaxHeap(k);
        HashSet<Integer> numbers = new HashSet<>();
        for (int i = 0; i < listSize; i++) {
//            if (!numbers.contains(a.get(i))) {
                m.add(a.get(i));
//                numbers.add(a.get(i));
//            }
        }
        return m.data[1];
    }

    class MaxHeap {
        private int heapSize;
        private int[] data;
        private int currentSize = 0;

        MaxHeap(int s) {
            heapSize = s;
            data = new int[heapSize + 1];
        }

        public void add(int inpdata) {
            if (currentSize == heapSize) {
                if (inpdata < data[1])
                    data[1] = inpdata;
                heapifyFromTop();
            } else {
                currentSize++;
                data[currentSize] = inpdata;
                heapify();
            }
        }

        private void heapifyFromTop() {
            int l = 1;
            while (l < heapSize) {
                if (2 * l + 1 <= heapSize) {
                    if (data[2 * l + 1] > data[2 * l]) {
                        if (data[l] < data[2 * l + 1]) {
                            data[l] = data[l] ^ data[2 * l + 1]; //a^b
                            data[2 * l + 1] = data[l] ^ data[2 * l + 1]; //b^a^b = a
                            data[l] = data[l] ^ data[2 * l + 1];//a^b^a = b
                            l=2*l+1;
                        }else break;
                    } else {
                        if (data[l] < data[2 * l]) {
                            data[l] = data[l] ^ data[2 * l]; //a^b
                            data[2 * l] = data[l] ^ data[2 * l]; //b^a^b = a
                            data[l] = data[l] ^ data[2 * l];//a^b^a = b
                            l=2*l;
                        }else {
                            break;
                        }
                    }
                }else if(2*l==heapSize){
                    if (data[l] < data[2 * l]) {
                        data[l] = data[l] ^ data[2 * l]; //a^b
                        data[2 * l] = data[l] ^ data[2 * l]; //b^a^b = a
                        data[l] = data[l] ^ data[2 * l];//a^b^a = b

                    }
                    break;
                }
                else {
                    break;
                }

            }
        }

        public void heapify() {
            int l = currentSize;
            while (l > 1) {
                if (data[l] > data[l / 2]) {
                    data[l] = data[l] ^ data[l / 2]; //a^b
                    data[l / 2] = data[l / 2] ^ data[l];//b^a^b = a
                    data[l] = data[l] ^ data[l / 2];//a^a^b = b
                } else {
                    break;
                }
                l = l / 2;
            }
        }


    }

}
