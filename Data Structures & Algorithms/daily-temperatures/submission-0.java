class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        Stack<int[]> stack = new Stack<>(); // val , index

        for (int i=0; i<n; i++) {
            while (!stack.isEmpty() && stack.peek()[0] < temperatures[i]) {
                int[] ans = stack.pop();
                res[ans[1]] = i - ans[1];
            }
            stack.push(new int[]{temperatures[i], i});
        }
        return res;
    }
}


// there are two scenario if stack.peek() greater 
// stack.peek() smaller

//if our current element is greater than stack element that means it is the next
//largest element therefore we process it