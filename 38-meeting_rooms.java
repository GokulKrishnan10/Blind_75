/*
920 · Meeting Rooms

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
determine if a person could attend all meetings.
(0,8),(8,10) is not conflict at 8

Example1
Input: intervals = [(0,30),(5,10),(15,20)]
Output: false
Explanation: 
(0,30), (5,10) and (0,30),(15,20) will conflict

Example2
Input: intervals = [(5,8),(9,15)]
Output: true
Explanation: 
Two times will not conflict 

Approach:
    Intervals,Sorting
Timecomplexity:O(nlogn)
Spacecomplexity:O(1)
 */
public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        Collections.sort(intervals,(a,b)->(a.start-b.start));
        int c=0,n=intervals.size();
        for(int i=0;i<n-1;i++){
            if(intervals.get(i).end>intervals.get(i+1).start){
                return false;
            }
        }
        return true;
    }
}