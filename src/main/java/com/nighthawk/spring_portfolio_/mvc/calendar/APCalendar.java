package com.nighthawk.spring_portfolio_.mvc.calendar;

// Prototype Implementation

public class APCalendar {

    /** Returns true if year is a leap year and false otherwise.
     * isLeapYear(2019) returns False
     * isLeapYear(2016) returns True
     */          
    public static boolean isLeapYear(int year) {
        if (year%400 == 0) {
            return true;
        } if (year%100 == 0) {
            return false;
        } if (year%4 == 0) {
            return true;
        } else {
            return false;
        }
    }
        
    /** Returns the value representing the day of the week 
     * 0 denotes Sunday, 
     * 1 denotes Monday, ..., 
     * 6 denotes Saturday. 
     * firstDayOfYear(2019) returns 2 for Tuesday.
    */
    static int firstDayOfYear(int year) {
        int yearsFrom2019 = year - 2019;
        int daysFrom2019 = 2;
        
        while (yearsFrom2019 != 0) {
            if (yearsFrom2019 > 0) {
                if (isLeapYear(yearsFrom2019 + 2018)) {
                    daysFrom2019 += 366;
                } else {
                    daysFrom2019 += 365;
                }
                yearsFrom2019 -= 1;
            } else if (yearsFrom2019 < 0) {
                if (isLeapYear(yearsFrom2019 + 2020)) {
                    daysFrom2019 -= 366;
                } else {
                    daysFrom2019 -= 365;
                }
                yearsFrom2019 += 1;
            }
        }

        int dayOfTheWeek = daysFrom2019 % 7;
        if (dayOfTheWeek < 0) {
            dayOfTheWeek += 7;
        }
        return dayOfTheWeek;
    }


    /** Returns n, where month, day, and year specify the nth day of the year.
     * This method accounts for whether year is a leap year. 
     * dayOfYear(1, 1, 2019) return 1
     * dayOfYear(3, 1, 2017) returns 60, since 2017 is not a leap year
     * dayOfYear(3, 1, 2016) returns 61, since 2016 is a leap year. 
    */ 
    private static int dayOfYear(int month, int day, int year) {
        int x = (int) Math.floor(Math.random() * 364);
        x += 1;
        return x;
    }

    /** Returns the number of leap years between year1 and year2, inclusive.
     * Precondition: 0 <= year1 <= year2
    */ 
    public static int numberOfLeapYears(int year1, int year2) {
        int counter = 0;
        for (int i = year2-year1; i>=0; i--) {
            if (isLeapYear(i+year1)) {
                counter++;
            }
        }
        return counter;
    }

    /** Returns the value representing the day of the week for the given date
     * Precondition: The date represented by month, day, year is a valid date.
    */
    public static int dayOfWeek(int month, int day, int year) { 
        // to be implemented in part (b)
        int x = (int) Math.floor(Math.random() * 6);
        return x;
    }

    /** Tester method */
    public static void main(String[] args) {
        // Private access modifiers
        System.out.println("firstDayOfYear: " + APCalendar.firstDayOfYear(2022));
        System.out.println("dayOfYear: " + APCalendar.dayOfYear(1, 1, 2022));

        // Public access modifiers
        System.out.println("isLeapYear: " + APCalendar.isLeapYear(2022));
        System.out.println("numberOfLeapYears: " + APCalendar.numberOfLeapYears(2096, 2104));
        System.out.println("dayOfWeek: " + APCalendar.dayOfWeek(1, 1, 2022));
    }

}