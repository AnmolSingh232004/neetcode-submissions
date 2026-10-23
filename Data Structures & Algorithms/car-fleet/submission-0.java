class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = speed.length;
        int[][] pair = new int[n][2];
        for (int i=0; i<n; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
     Arrays.sort(pair, (a, b) -> Integer.compare(a[0], b[0])); // sorts pair[][] based on pos

     int res = 1;
     double newMax = 0;

     for (int i=n-1; i>=0; i--) {
        int posi = pair[i][0];
        int spd = pair[i][1];
        int dist = target - posi;
        double currTime = (double) dist / spd; 
        if (i == n-1) {
            newMax = currTime;
        }
        if (currTime > newMax) {
            res++;
            newMax = currTime;
        }


     }

     return res;
     }
    }

// sorted pos for case 4, pos = [6,8], speed = [3,2], target = 10
// sorted pos = [0,3,5,8,10], speed = [1,3,1,4,2], target = 12
// speed = dist / time
// time = dist / speed


