package br.edu.ifsp.testing.class03.exercises;

public class Identifier {

    public static boolean verify(String identifier) {
        if(identifier.length() > 6 || identifier.isEmpty()) throw new IllegalArgumentException("The identifier has to be less than 6 characters and not empty");
        if(Character.isDigit(identifier.charAt(0))) throw new IllegalArgumentException("The identifier cannot start with a digit");
        if(!identifier.matches("[a-zA-Z0-9]+")) throw new IllegalArgumentException("The identifier must contain only letters and digits");
        return true;
    }

}
