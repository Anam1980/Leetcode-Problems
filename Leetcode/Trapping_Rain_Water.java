/*
Problem Name : Trapping Rain Water
Problem Link : https://leetcode.com/problems/trapping-rain-water/
*/

class Solution {
    public int trap(int[] arr) {
        // TC: O(N), SC: O(1)
        int n = arr.length;

        //Take two pointer at first element at left and last element at right
            int LB = arr[0];
            int RB = arr[n - 1];

            //Take two pointer at second index from left and second index from right
            int l = 1;
            int r = n - 2;

            //take total water as 0
            int totalWater = 0;

            //O(N)
            while (l <= r) {
                //left ele < right ele
                if (LB <= RB) {
                    //finding the bigger level of building at left
                    if (LB < arr[l]) {
                        //curr set to bigger one
                        LB = arr[l];
                    }
                    else {
                        //finally add the diff of curr(big) and next(small) to the total water
                        // as upto that water is filled--> level of water
                        totalWater += LB - arr[l];
                    }
                    l++;
                }
                //left ele > right ele
                else {
                    //finding the bigger level of building at right
                    if (RB < arr[r]) {
                        RB = arr[r];
                    } else {
                        //finally add the diff of curr(big) and prev(small) to the total water amount
                        totalWater += RB - arr[r];
                    }
                    r--;
                }
            }

           return totalWater;
        }
    }

