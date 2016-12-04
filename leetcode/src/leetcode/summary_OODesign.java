package leetcode;

import java.util.*;

/**
 * Created by Hua on 11/30/2016.


 design parking lot, assume there are 3 types of car and spaces.(regular, compact, handicap)

 */
public class summary_OODesign {
    enum CarType{regular, compact, handicap}

    public class Car{
        int license;
        CarType type;
    }

    public class ParkingSpace{
        int number;
        boolean isEmpty;
        Car car;
        CarType type;

        // constructor
        ParkingSpace(int num, CarType type){
            this.number = num;
            this.type = type;
            this.isEmpty = true;
            this.car = null;
        }
    }


    public class ParkingLot{
        // variables
        int numTotalParkingSpaces;
        int numParkedSpaces;
        List<ParkingSpace> spaces;

        // constructor
        ParkingLot(){
            this.numTotalParkingSpaces = 50;
            this.numParkedSpaces = 0;
            int handicapSpace = 5, compact=15, regular = 30;
            this.spaces = new ArrayList();
            int seq = 1;
            for(int i=0;i<handicapSpace;i++) this.spaces.add(new ParkingSpace(seq++, CarType.handicap));
            for(int i=0;i<compact;i++) this.spaces.add(new ParkingSpace(seq++, CarType.compact));
            for(int i=0;i<regular;i++) this.spaces.add(new ParkingSpace(seq++, CarType.regular));
        }


        // method
        // assume the type must match to park
        public boolean parkCar(Car car){
            if(this.isFull()) return false; // cant' park because it's full

            for(ParkingSpace e : spaces){
                if(e.isEmpty && e.type == car.type){
                    e.isEmpty = false;
                    e.car = car;
                    numParkedSpaces++;
                    return true;
                }
            }
            return false; // can't park because no type match
        }

        // o(n) time, can be o(1) with extra space with hashmap.
        public boolean exitCar(Car car){
            for(ParkingSpace e : spaces){
                if(!e.isEmpty && e.car.equals(car)){
                    numParkedSpaces--;
                    e.isEmpty = true;
                    e.car = null;
                    return true;
                }
            }
            return false; //no such car
        }

        public boolean isFull(){
            return numParkedSpaces == numTotalParkingSpaces;
        }

    }

    // the operation of exitCar can be improved by using hashmap
    // the operation of parkCar can be improved by separate counting of each type of car.








    // ************************************************************************************* //
    // Design Elevator, assume only one elevator.
    public enum Status {up, down, standby, maintainance}

    public class Elevator{
        Status status;
        int capacity;
        int currentCapacity;
        int currentFloor;

        // method
        void openDoor(){}
        void closeDoor(){}
        void moveUp(){}
        void moveDown(){}



    }






}
