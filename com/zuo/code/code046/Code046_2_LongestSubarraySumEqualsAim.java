package com.zuo.code.code046;

import java.util.HashMap;

public class Code046_2_LongestSubarraySumEqualsAim {

    public static int MAXN = 100001;
    public static int[] arr = new int[MAXN];
    public static int n, aim;

    public static HashMap<Integer, Integer> map = new HashMap<>();

    public static int compute() {
        map.clear();
        map.put(0, -1);
        int ans = 0;
        for (int i = 0, sum = 0; i < n; i++) {
            sum += arr[i];
            if (map.containsKey(sum - aim)) {
                ans = Math.max(ans, i - map.get(sum - aim));
            }
            if (!map.containsKey(sum)){
                map.put(sum,i);
            }
        }
        return ans;
    }
}
