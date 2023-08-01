package codingProblems.Java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public static void main(String[] args) {

        int[] nums = {1, -1, 1, 2, 2, 1, 3};
        int k = 2;

        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

    /**
     * HashMap with Bucket Sort
     * TC: O(n log n), best O(n)
     * SC: O(n)
     */
//    public static int[] topKFrequent(int[] nums, int k) {
//
//        int[] res = new int[k];
//
//        HashMap<Integer, Integer> freqMap = new HashMap<>();
//        for (int num : nums) {
//            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
//        }
//
//        List<Integer> freqBucket[] = new ArrayList[nums.length + 1]; // create bucket to store ele based on its freq
//        for (int key : freqMap.keySet()) {
//
//            int freq = freqMap.get(key);
//            if (freqBucket[freq] == null) {
//                freqBucket[freq] = new ArrayList<>();
//            }
//
//            freqBucket[freq].add(key); // add ele to bucket according to its freq
//        }
//
//        int index = 0;
//        for (int i = freqBucket.length - 1; i >= 0; i--) {
//            if (freqBucket[i] != null) {
//                for (int ele : freqBucket[i]) { // get each ele in the bucket
//
//                    res[index] = ele;
//                    index++;
//                    if (index == k) {
//                        return res;
//                    }
//                }
//            }
//        }
//
//        return res;
//    }

    /**
     * HashMap with PriorityQueue (binary heap data structure) - created custom comparator based on frequency using lambda expression
     * TC: O(n log k)
     * SC: O(n) from O(n + k)
     */
    public static int[] topKFrequent(int[] nums, int k) {

        int[] res = new int[k];

        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // create PQ with largest freq at the bottom using lambda expression to create custom comparator
        /*
            if a - b, return negative value, a have higher priority
            if a - b, return positive value, b have higher priority
            if a - b, return 0, priority is determined by the natural order

            - priority = top most element, will get poll() out first
         */
        PriorityQueue<Integer> minFreqHeap = new PriorityQueue<>((a, b) -> freqMap.get(a) - freqMap.get(b));

        // iterate through freqMap and add ele to topKFreq PQ, if PQ size > k, remove from top (smallest freq)
        for (int key : freqMap.keySet()) {

            minFreqHeap.offer(key); // offer() add ele to PQ
            if (minFreqHeap.size() > k) {
                minFreqHeap.poll();
            }
        }

        // add largest freq from PQ to res while removing it
        int index = k - 1;
        while (!minFreqHeap.isEmpty()) {
            res[index--] = minFreqHeap.poll();
        }

        return res;
    }

    /**
     * Brute Force - HashMap
     * TC: O(n * k)
     * SC: O(n)
     */
//    public static int[] topKFrequent(int[] nums, int k) {
//
//        int[] res = new int[k];
//        HashMap<Integer, Integer> freqMap = new HashMap<>();
//
//        for (int num : nums) {
//            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
//        }
//
//        for (int i = 0; i < k; i++) {
//
//            int maxFreq = 0;
//            int maxFreqEle = 0;
//
//            for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
//
//                int freq = entry.getValue();
//                int freqEle = entry.getKey();
//
//                if (freq > maxFreq) {
//                    maxFreq = freq;
//                    maxFreqEle = freqEle;
//                }
//            }
//
//            res[i] = maxFreqEle;
//            freqMap.remove(maxFreqEle);
//        }
//
//        return res;
//    }
}
