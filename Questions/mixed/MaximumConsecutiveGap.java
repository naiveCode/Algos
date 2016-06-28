import java.util.List;

class MaximumConsecutiveGap {
    class Bucket {
        int low;
        int high;

        public Bucket() {
            low = -1;
            high = -1;
        }
    }

    public int maximumGap(final List<Integer> num) {
        if (num == null || num.size() < 2) {
            return 0;
        }

        int max = num.get(0);
        int min = num.get(0);
        for (int i = 1; i < num.size(); i++) {
            max = Math.max(max, num.get(i));
            min = Math.min(min, num.get(i));
        }

        // initialize an array of buckets
        Bucket[] buckets = new Bucket[num.size() + 1]; //project to (0 - n)
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new Bucket();
        }

        double interval = (double) num.size() / (max - min);
        //distribute every number to a bucket array
        for (int i = 0; i < num.size(); i++) {
            int index = (int) ((num.get(i) - min) * interval);

            if (buckets[index].low == -1) {
                buckets[index].low = num.get(i);
                buckets[index].high = num.get(i);
            } else {
                buckets[index].low = Math.min(buckets[index].low, num.get(i));
                buckets[index].high = Math.max(buckets[index].high, num.get(i));
            }
        }

        //scan buckets to find maximum gap
        int result = 0;
        int prev = buckets[0].high;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i].low != -1) {
                result = Math.max(result, buckets[i].low - prev);
                prev = buckets[i].high;
            }

        }

        return result;
    }
}


