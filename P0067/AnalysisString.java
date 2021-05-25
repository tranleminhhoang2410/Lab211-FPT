package P0067;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class AnalysisString {

    public HashMap<String, List<Integer>> getNumber(String input) {
        Validate validate = new Validate();
        HashMap<String, List<Integer>> numbersMap = new HashMap<>();
        String number = input.replaceAll("\\D+", ",");
        if (number.charAt(0) == ',') {
            number = number.substring(1);
        } else if (number.charAt(number.length() - 1) == ',') {
            number = number.substring(0, number.length() - 1);
        }

        StringTokenizer numberList = new StringTokenizer(number, ",");
        List<Integer> perfectSquareList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();
        List<Integer> evenList = new ArrayList<>();
        List<Integer> allNumberList = new ArrayList<>();
        while (numberList.hasMoreTokens()) {
            int numberCheck = Integer.parseInt(numberList.nextToken());
            if (validate.checkPerfectSquareNumber(numberCheck)) {
                perfectSquareList.add(numberCheck);
            }
            if (validate.checkOddNumber(numberCheck)) {
                oddList.add(numberCheck);
            }
            if (validate.checkEvenNumber(numberCheck)) {
                evenList.add(numberCheck);
            }
            allNumberList.add(numberCheck);

        }
        numbersMap.put("Perfect Square Numbers ", perfectSquareList);
        numbersMap.put("Odd Numbers ", oddList);
        numbersMap.put("Even Numbers ", evenList);
        numbersMap.put("All numbers ", allNumberList);
        return numbersMap;
    }

    public HashMap<String, StringBuilder> getCharacter(String input) {
        HashMap<String, StringBuilder> charactersMap = new HashMap<>();
        String upperCase = input.replaceAll("\\W|[0-9]|[a-z]", "");
        String lowerCase = input.replaceAll("\\W|[0-9]|[A-Z]", "");
        String special = input.replaceAll("\\w", "");
        String all = input.replaceAll("\\d", "");

        StringBuilder upperCaseCharacter = new StringBuilder(upperCase);
        charactersMap.put("Uppercase Characters ", upperCaseCharacter);
        StringBuilder lowerCaseCharacter = new StringBuilder(lowerCase);
        charactersMap.put("Lowercase Characters ", lowerCaseCharacter);
        StringBuilder specialCharacter = new StringBuilder(special);
        charactersMap.put("Special Characters ", specialCharacter);
        StringBuilder allCharacter = new StringBuilder(all);
        charactersMap.put("All Characters ", allCharacter);
        return charactersMap;
    }

    public void showResultOfNumber(HashMap<String, List<Integer>> numberMap) {
        Set<String> keySet = numberMap.keySet();
        for (String key : keySet) {
            if (numberMap.get(key).isEmpty()) {
                System.out.println(key + ": " + "No data");
            } else {
                System.out.println(key + ": " + numberMap.get(key));
            }

        }
    }

    public void showResultOfCharacter(HashMap<String, StringBuilder> characterMap) {
        Set<String> keySet = characterMap.keySet();
        for (String key : keySet) {
            if (characterMap.get(key).length() == 0) {
                System.out.println(key + ": " + "No data");
            } else {
                System.out.println(key + ": " + characterMap.get(key));
            }

        }
    }
}
