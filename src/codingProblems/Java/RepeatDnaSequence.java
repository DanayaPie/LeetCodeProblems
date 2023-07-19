package codingProblems.Java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatDnaSequence {

    public static void main(String[] args) {

        String s = "AAAAAAAAAAA";

        System.out.println(findRepeatDnaSequences(s));
    }

    /**
     * HashSet approach
     * TC: O(n)
     * SC: O(n)
     */
    public static List<String> findRepeatDnaSequences(String s) {

        List<String> seqList = new ArrayList<>();
        Set<String> seenSeq = new HashSet<>();
        Set<String> repeatSeq = new HashSet<>();

        for (int i = 0; i < s.length() - 9; i++) {

            String seq = s.substring(i, i + 10);

            if (seenSeq.contains(seq) && !repeatSeq.contains(seq)) {

                repeatSeq.add(seq);
            } else {
                seenSeq.add(seq);
            }
        }

        seqList.addAll(repeatSeq);

        return seqList;
    }

    /**
     * Sliding Window - hashmap
     * TC: O(n)
     * SC: O(n)
     */
//    public static List<String> findRepeatDnaSequences(String s) {
//
//        List<String> seqList = new ArrayList<>();
//        HashMap<String, Integer> seqMap = new HashMap<>();
//        StringBuilder sb = new StringBuilder();
//        int rEnd = 0;
//
//        while (rEnd < s.length()) {
//
//            while (sb.length() < 10 && rEnd < s.length()) {
//
//                sb.append(s.charAt(rEnd));
//                rEnd++;
//            }
//
//            String seq = sb.toString();
//
//            if (seqMap.containsKey(seq)) {
//                seqMap.put(seq, seqMap.get(seq) + 1);
//
//                if (seqMap.get(seq) == 1) {
//                    seqList.add(seq);
//                }
//            } else {
//
//                seqMap.put(seq, 0);
//            }
//
//            // delete first char in sb
//            if (sb.length() > 9) {
//
//                sb.deleteCharAt(0);
//            }
//
//        }
//
//        return seqList;
//    }
}
