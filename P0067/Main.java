package P0067;

public class Main {
    public static void main(String[] args) {
        AnalysisString analysisString = new AnalysisString();
        Validate validate = new Validate();
        System.out.println("===== Analysis String program ====");
        System.out.print("Input String: ");
        String input = validate.checkInputString();
        System.out.println("");
        System.out.println("-----Result Analysis------");
        analysisString.showResultOfNumber(analysisString.getNumber(input));
        analysisString.showResultOfCharacter(analysisString.getCharacter(input));
    }
}
