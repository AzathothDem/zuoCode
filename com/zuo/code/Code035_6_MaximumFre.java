package com.zuo.code;

import java.util.ArrayList;
import java.util.HashMap;

public class Code035_6_MaximumFre {

    class FreqStack {
        private int topTimes;
        private HashMap<Integer, ArrayList<Integer>> cntValues = new HashMap<>();

        //词频表
        private HashMap<Integer, Integer> valuesTimes = new HashMap<>();

        public void push(int val) {
            valuesTimes.put(val, valuesTimes.getOrDefault(val, 0) + 1);
            int curTopTimes = valuesTimes.get(val);
            if (!cntValues.containsKey(curTopTimes)) {
                cntValues.put(curTopTimes, new ArrayList<>());
            }
            ArrayList<Integer> curTimeValues = cntValues.get(curTopTimes);
            curTimeValues.add(val);
            topTimes = Math.max(topTimes, curTopTimes);
        }

        public int pop() {
            ArrayList<Integer> topTimeValues = cntValues.get(topTimes);
            int ans = topTimeValues.remove(topTimeValues.size() - 1);
            if (topTimeValues.size() == 0) {
                cntValues.remove(topTimes--);
            }
            int times = valuesTimes.get(ans);
            if (times == 1) {
                valuesTimes.remove(ans);
            }else {
                valuesTimes.put(ans,times -1);
            }
            return ans;
        }
    }
}
