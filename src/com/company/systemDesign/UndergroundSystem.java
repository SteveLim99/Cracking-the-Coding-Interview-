package com.company.systemDesign;

import java.util.HashMap;

public class UndergroundSystem {
    HashMap<String,HashMap<String,int[]>> allVisits;
    HashMap<Integer, String[]> currCheckIns;

    public UndergroundSystem() {
        this.allVisits = new HashMap();
        this.currCheckIns = new HashMap();
    }

    public void checkIn(int id, String stationName, int t) {
        if(!this.currCheckIns.containsKey(id)){
            String strTime = Integer.toString(t);
            this.currCheckIns.put(id,new String[]{stationName,strTime});
        }
    }

    public void checkOut(int id, String stationName, int t) {
        String[] checkInDetails = this.currCheckIns.get(id);
        int checkInTime = Integer.parseInt(checkInDetails[1]);
        int totalTime = t - checkInTime;

        if(this.allVisits.containsKey(checkInDetails[0])){
            if(this.allVisits.get(checkInDetails[0]).containsKey(stationName)){
                int[] tmp =  this.allVisits.get(checkInDetails[0]).get(stationName);
                tmp[0] = tmp[0] + totalTime;
                tmp[1] = tmp[1] + 1;
                this.allVisits.get(checkInDetails[0]).put(stationName,tmp);
            }

            else{
                this.allVisits.get(checkInDetails[0]).put(stationName,new int[]{totalTime,1});
            }
        } else {
            HashMap<String, int[]> allTrips = new HashMap();
            allTrips.put(stationName,new int[]{totalTime,1});
            this.allVisits.put(checkInDetails[0],allTrips);
        }

        currCheckIns.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        int[] details = this.allVisits.get(startStation).get(endStation);
        double avg = (double) details[0] / details[1];
        return avg;
    }
}
