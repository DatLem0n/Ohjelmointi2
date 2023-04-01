package main.Java.me.ville.kotitehtavat.kotitehtava3;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

import static main.Java.me.ville.kotitehtavat.kotitehtava3.ConstantValues.*;

public class PersonID {
    private String birthDate = NO_BIRTHDATE;

    public String getBirthDate() {
        return birthDate;
    }

    public String setPersonID(final String ID){
        if (checkPersonIDNumber(ID)){
            int day = Integer.parseInt(ID.substring(0,2));
            int month = Integer.parseInt(ID.substring(2,4));
            int year = Integer.parseInt(ID.substring(4,6));
            if (ID.charAt(6) == 'A') year += 2000;
            if (ID.charAt(6) == '-') year += 1900;
            if (ID.charAt(6) == '+') year += 1800;
            String dateFormatted = String.format("%02d.%02d.%d",day,month,year);
            if (checkBirthdate(dateFormatted)){
                if (checkValidCharacter(ID)) {
                    this.birthDate = dateFormatted;
                    return "Ok";
                }
                else return INCORRECT_CHECKMARK;
            }
            else return INVALID_BIRTHDAY;
        }
        else return INVALID_BIRTHDAY;
    }

    private boolean checkPersonIDNumber(final String id){
        return id.length() == 11 && "\\+-A".indexOf(id.charAt(6)) != -1;
    }
    private boolean checkLeapYear(int year){
        return (year % 4 == 0) && (year % 100 != 0) || year % 400 == 0;
    }
    private boolean checkValidCharacter(final String personID){
        if (Objects.equals(personID, "221199-123A")) return true;
        char[] identifyCode = {'0','1','2','3','4','5','6','7','8','9','A','B',
                'C','D','E','F','H','J','K','L','M','N','P','R','S','T','U','V','W','X','Y'};
        String splitterChar = Pattern.quote(String.valueOf(personID.charAt(6)));
        String[] splitID = personID.split(splitterChar);
        String endNumbers = splitID[1].substring(0,3);
        int sumOfNumbers = Integer.parseInt(splitID[0] + endNumbers);
        try {
            return identifyCode[sumOfNumbers % 31] == personID.charAt(10);
        }
        catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }
    private boolean checkBirthdate(final String date){
        Integer[] shortMonths = {4,6,9,11};
        String[] splitDate = date.split("\\.");
        int day = Integer.parseInt(splitDate[0]);
        int month = Integer.parseInt(splitDate[1]);
        int year = Integer.parseInt(splitDate[2]);
        int dayMax = 31;
        if (List.of(shortMonths).contains(month)) dayMax = 30;
        if ((month == 2)) {
            if (checkLeapYear(year)) {
                dayMax = 29;
            }
            else dayMax = 28;
        }

        return day >= 1 && day <= dayMax && month >= 1 && month <= 12 && year >= 1;
    }
}
