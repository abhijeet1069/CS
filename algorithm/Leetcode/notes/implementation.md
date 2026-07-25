# Arrays

## Largest Time for Given Digits

Given an array arr of 4 digits, find the latest 24-hour time that can be made using each digit exactly once.

24-hour times are formatted as "HH:MM", where HH is between 00 and 23, and MM is between 00 and 59. 
The earliest 24-hour time is 00:00, and the latest is 23:59.

Return the latest 24-hour time in "HH:MM" format. If no valid time can be made, return an empty string.

Example 1:
Input: arr = [1,2,3,4]
Output: "23:41"
Explanation: The valid 24-hour times are "12:34", "12:43", "13:24", "13:42", "14:23", "14:32", "21:34", "21:43", 
"23:14", and "23:41". Of these times, "23:41" is the latest.

Example 2:
Input: arr = [5,5,5,5]
Output: ""
Explanation: There are no valid 24-hour times as "55:55" is not valid.

### Concept
- Here we just brute forced, as we had just 24 combinations
- This loop also shows how to generate all 4! permutations of arr

### Code
```java
    public String largestTimeFromDigits(int[] arr) {
    int max = -1;
    String ans = "";
    for(int i = 0; i < 4; i++){
        for(int j = 0; j < 4; j++){
            if(j == i)
                continue;
            for(int k = 0; k < 4; k++){
                if(k == i || k == j)
                    continue;

                for(int l = 0; l < 4; l++){
                    if(l == i || l == j || l == k)
                        continue;

                    int hour = arr[i]*10+arr[j];
                    int min = arr[k]*10+arr[l];
                    if(hour < 24 && min < 60){
                        int total = hour*60+min;
                        if(max < total){
                            max = total;
                            ans = ""+arr[i]+""+arr[j]+":"+arr[k]+""+arr[l];
                        }
                    }
                }
            }
        }
    }
    return ans;
}
```

### Mistakes

Earlier I tried to find the max hour and max min, but that was the bad approach, simpler approach was to just count
minutes.