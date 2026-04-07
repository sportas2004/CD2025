package com.sergioportas;

public class ValidadorContraseña {

    public boolean esValida(String pass) {
        String regex = ".*[^a-zA-Z0-9\\s].*";
        if (pass.length() < 8){
            return false;
        }
        int estado1=0;
        for(int i=0;i<pass.length();i++){
           if(Character.isUpperCase(pass.charAt(i))) estado1++;
        }
        if(estado1<=0) return false;
        if(!pass.matches(regex)) return false;

        return true;
    }
}

