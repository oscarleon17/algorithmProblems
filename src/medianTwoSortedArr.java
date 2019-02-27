/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.
Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
You may assume nums1 and nums2 cannot be both empty.
 */

public class medianTwoSortedArr {

    public double findMedianSortedarrays(int[] nums1, int[] nums2){

        int m = nums1.length, n = nums2.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getKth(nums1, 0, nums2, 0, l) + getKth(nums1, 0, nums2, 0, r) / 2.0);
    }

    public double getKth(int[] nums1, int num1Start, int[] nums2, int num2Start, int k){

        if(num1Start > nums1.length - 1) return nums2[num2Start + k - 1];
        if (num2Start > nums2.length - 1) return nums1[num1Start + k - 1];
        if (k == 1) return Math.min(nums1[num1Start], nums2[num2Start]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (num1Start + k/2 - 1 < nums1.length) aMid = nums1[num1Start + k/2 - 1];
        if (num2Start + k/2 - 1 < nums2.length) bMid = nums1[num2Start + k/2 - 1];

        if (aMid < bMid)
            return getKth(nums1, num1Start + k/2, nums2, num2Start,k - k/2);// Check: aRight + bLeft
        else
            return getKth(nums1, num1Start, nums2, num2Start + k/2, k - k/2);// Check: bRight + aLeft
    }


}
