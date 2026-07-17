# Arrays

## Merge Sorted Array

You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n,
representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]

### Concept
- & operator in while loop, runs till the shorter array
- remaining merging is done by the remaining loops

### Code
```java
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    int[] res = new int[m + n];
    int index = 0, i = 0, j = 0;
    while (i < m && j < n) {
        if (nums1[i] < nums2[j]) {
            res[index] = nums1[i];
            i++;
        } else {
            res[index] = nums2[j];
            j++;
        }
        index++; //index of final merged array
    }
    while(i < m)
        //merge nums1
    while(j < n)
        //merge nums2
}
```

### Mistakes

NA

## Remove Element

Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of 
the elements may be changed. Then return the number of elements in nums which are not equal to val.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]

### Concept
- focus on elements which are not equal to val
- Similar logic can be used to remove duplicates

### Code
```java
    public int removeElement(int[] nums, int val) {
    int usefulElementCount = 0; 
    for(int i = 0; i < nums.length; i++){
        if(nums[i] != val){ //this is the main idea
            nums[usefulElementCount] = nums[i];
            usefulElementCount++;
        }
    }
    return usefulElementCount;
}
```

### Mistakes

I was focusing on elements equal to val, and thinking how to delete making the solution complex.

## Majority element

Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. 
You may assume that the majority element always exists in the array.

Input: nums = [3,2,3]
Output: 3

Input: nums = [2,2,1,1,1,2,2]
Output: 2

### Concept
The code is based on Moore's voting algorithm.
This algorithm only works directly if a majority element is guaranteed to exist.

Every different element cancels one occurrence of the candidate.
If a majority element exists, it can never be completely canceled because it appears more than half the time.

### Code
```java
    public int majorityElement(int[] nums) {
    int count = 0;
    int candidate = 0;

    for (int num : nums) {
        if (count == 0)
            candidate = num;

        if (num == candidate)
            count++;
        else
            count--;
    }
    return candidate;
}
```

### Mistakes

I thought to try with a Hashmap, but the Moore's algorithm is better

## Jump Game

You are given an integer array nums. You are initially positioned at the array's first index, 
and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Input: nums = [2,3,1,1,4]
Output: true

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, 
which makes it impossible to reach the last index.

### Concept
Instead of asking:
“Can I reach the end from index 0?”

it asks the opposite:
“Which indices can reach the end?”

### Code
```java
 public boolean canJump(int[] nums){ //beautiful solution
    int goal = nums.length-1;
    for(int i = nums.length-2; i >= 0; i--){
        if(i+nums[i] >= goal)
            goal = i;
    }
    return goal == 0;
}
```

### Mistakes

Couldn't solve this. New learning

## Trapping Rain Water

Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much 
water it can trap after raining.

Input: height = [4,2,0,3,2,5]
Output: 9

### Concept

```shell
height      =      [4,2,0,3,2,5]
L (max on left)  = [0,4,4,4,4,4]       
R (max on right) = [5,5,5,5,5,0]
res[i] = min(L[i],R[i]) - height[i] # if negative then res[i] will be zero
then sum the res array 
```

### Code

```java
 public boolean canJump(int[] nums){ //beautiful solution
    int goal = nums.length-1;
    for(int i = nums.length-2; i >= 0; i--){
        if(i+nums[i] >= goal)
            goal = i;
    }
    return goal == 0;
}
```

### Mistakes

NA