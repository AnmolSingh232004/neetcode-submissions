class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        int[][] pair = new int[n][2];

        for (int i=0; i<n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }

        Arrays.sort(pair, (a,b) -> Integer.compare(a[0], b[0]));
        // sorts in ascending order using just pos

        int i = n-1;
        Stack<Double> timeStack = new Stack<>();

        while (i >= 0) {
            int pos = pair[i][0];
            int spd = pair[i][1];

            int dist = target - pos;

            double time = (double) dist / spd; // cur car time needed to reach target

            if (i == n-1) {
                timeStack.push(time);
                i--;
                continue;
            }


            if (timeStack.peek() < time) { // new fleet
            timeStack.push(time);
            } 

            i--;
        }

        return timeStack.size();
    }
}

//pos = [0,1,4,7], speed = [1,2,2,1] target = 10, time = [10,5,3,3]
// speed = dist / time
// time = dist / speed
// dist = target - pos 
