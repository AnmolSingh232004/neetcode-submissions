// My future self if you are looking at the notes look at the comments alteast your past self tried hard to write these
class Solution {
    public int findMin(int[] nums) {
      int lo = 0;
      int hi = nums.length - 1;


      while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (mid+1 <= nums.length -1 && nums[mid] > nums[mid+1]) { 
        // in no sorted array can mid be > than mid + 1 this must be smallest
        return nums[mid+1];
        }
        
        if (mid-1 >= 0 && nums[mid] < nums[mid-1]) { 
        // [4,5,6,0,1,2,3] breaks order again nums[mid] is smallest
        return nums[mid];
        }

        if (nums[lo] <= nums[mid]) { 
        // smallest element cant be on left if it is on left its nums[0]
        lo = mid + 1;
        } else if (nums[lo] > nums[mid]) {
        // answer has to be on right
        hi = mid - 1;
        }
      }


      return nums[0]; // if array is normally sorted this means smallest is 0th element  
    }
}
