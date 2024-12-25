import java.util.Hashtable;

public class TaxIdCode {
    private static final Hashtable<String, Integer> odd_dictionary = new Hashtable<>();  //dizionario dispari
    private static final Hashtable<String, Integer> even_dictionary = new Hashtable<>();  //dizionario pari
    private static final Hashtable<String,String> month_dictionary =new Hashtable<>();  //dizionario mesi


    public String build(String[] array) throws StringIndexOutOfBoundsException {
        StringBuilder rst = new StringBuilder();
        array[1] = letterExtraction(array[1].trim(), true);  //cognome
        array[2] = letterExtraction(array[2].trim(), false);  //nome
        array[3]=array[3].substring(2);
        array[4]= month_dictionary.get(array[4]);  //mese

        if((!array[5].trim().isEmpty())&& array[0].equalsIgnoreCase("rst")){  //giorno
            byte g=Byte.parseByte(array[5]);
            array[5]=(g+40)+"";
        }

        if(array[6].length()>=4){
            array[6]=array[6].substring(0,4);   //luogo
        }else{
            array[6]="XXXX";
        }

        for (int i = 1; i < array.length - 1; i++) {  //ESCLUDE LA LETTERA DEL SESSO E L'ULTIMO CARATTERE(per ora)
            rst.append(array[i]);
        }
        array[7] = String.valueOf(finalCharacter(rst.toString()));
        return (rst + array[7]).trim().toUpperCase();
    }


    private String letterExtraction(String code, boolean b) {  //b true=Cognome    b false=Nome
        String consonants = code.replaceAll("[a,e,i,o,u]", "");
        String vowelFound = "";
        code = code.toLowerCase();
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == 'a') {           //CONTEGGIO VOCALI,APPENA TROVA LA 1°,ESCE DAL CICLO
                vowelFound = "a";
                break;
            }
            if (code.charAt(i) == 'e') {
                vowelFound = "e";
                break;
            }
            if (code.charAt(i) == 'i') {
                vowelFound = "i";
                break;
            }
            if (code.charAt(i) == 'o') {
                vowelFound = "o";
                break;
            }
            if (code.charAt(i) == 'u') {
                vowelFound = "u";
                break;
            }
        }
        if (consonants.length() == 1) {  // 1 CONSONANTE + 1 VOCALE + "X"
            return consonants + vowelFound + "x";
        }
        if (consonants.length() == 2) {
            return consonants.substring(0, 2) + vowelFound;  //2 consonanti ed una vocale
        }
        if (!b && consonants.length() >= 4) {
            return consonants.substring(0,1) + consonants.substring(2,4);  //la prima,la terza e la quarta consonante
        }
        if (consonants.length() >= 3) {
            return consonants.substring(0, 3);  // 3 consonanti
        }
        return "XXX";
    }


    static {
        odd_dictionary.put("0", 1);
        odd_dictionary.put("1", 0);
        odd_dictionary.put("2", 5);
        odd_dictionary.put("3", 7);
        odd_dictionary.put("4", 9);
        odd_dictionary.put("5", 13);
        odd_dictionary.put("6", 15);
        odd_dictionary.put("7", 17);
        odd_dictionary.put("8", 19);
        odd_dictionary.put("9", 21);
        odd_dictionary.put("A", 1);
        odd_dictionary.put("B", 0);
        odd_dictionary.put("C", 5);
        odd_dictionary.put("D", 7);
        odd_dictionary.put("E", 9);
        odd_dictionary.put("F", 13);
        odd_dictionary.put("G", 15);
        odd_dictionary.put("H", 17);
        odd_dictionary.put("I", 19);
        odd_dictionary.put("J", 21);
        odd_dictionary.put("K", 2);
        odd_dictionary.put("L", 4);
        odd_dictionary.put("M", 18);
        odd_dictionary.put("N", 20);
        odd_dictionary.put("O", 11);
        odd_dictionary.put("P", 3);
        odd_dictionary.put("Q", 6);
        odd_dictionary.put("R", 8);
        odd_dictionary.put("S", 12);
        odd_dictionary.put("T", 14);
        odd_dictionary.put("U", 16);
        odd_dictionary.put("V", 10);
        odd_dictionary.put("W", 22);
        odd_dictionary.put("X", 25);
        odd_dictionary.put("Y", 24);
        odd_dictionary.put("Z", 23);
////////////////////////////////
        even_dictionary.put("0", 0);
        even_dictionary.put("1", 1);
        even_dictionary.put("2", 2);
        even_dictionary.put("3", 3);
        even_dictionary.put("4", 4);
        even_dictionary.put("5", 5);
        even_dictionary.put("6", 6);
        even_dictionary.put("7", 7);
        even_dictionary.put("8", 8);
        even_dictionary.put("9", 9);
        even_dictionary.put("A", 0);
        even_dictionary.put("B", 1);
        even_dictionary.put("C", 2);
        even_dictionary.put("D", 3);
        even_dictionary.put("E", 4);
        even_dictionary.put("F", 5);
        even_dictionary.put("G", 6);
        even_dictionary.put("H", 7);
        even_dictionary.put("I", 8);
        even_dictionary.put("J", 9);
        even_dictionary.put("K", 10);
        even_dictionary.put("L", 11);
        even_dictionary.put("M", 12);
        even_dictionary.put("N", 13);
        even_dictionary.put("O", 14);
        even_dictionary.put("P", 15);
        even_dictionary.put("Q", 16);
        even_dictionary.put("R", 17);
        even_dictionary.put("S", 18);
        even_dictionary.put("T", 19);
        even_dictionary.put("U", 20);
        even_dictionary.put("V", 21);
        even_dictionary.put("W", 22);
        even_dictionary.put("X", 23);
        even_dictionary.put("Y", 24);
        even_dictionary.put("Z", 25);

        month_dictionary.put("01","a");
        month_dictionary.put("02","b");
        month_dictionary.put("03","c");
        month_dictionary.put("04","d");
        month_dictionary.put("05","e");
        month_dictionary.put("06","h");
        month_dictionary.put("07","l");
        month_dictionary.put("08","m");
        month_dictionary.put("09","p");
        month_dictionary.put("10","r");
        month_dictionary.put("11","s");
        month_dictionary.put("12","t");

    }


    /**
     * calcola il carattere finale,metodo privato
     * @param cf [string]
     * @return Last Character
     */
    private char finalCharacter(String cf) {
        cf=cf.toUpperCase();
        boolean switcher = true;  //si mette TRUE in modo che inizi con i dispari
        int sum = 0;
        int remainder;  //resto
        char carattere;
        for (int i = 0; i < cf.length(); i++) {
            carattere = cf.charAt(i);
            if ('a' <= carattere && carattere <= 'z') {
                carattere -= 32;
            }
            if (switcher) {
                sum += odd_dictionary.get(Character.toString(carattere));
            } else {
                sum += even_dictionary.get(Character.toString(carattere));
            }
            switcher = !switcher;
        }
        remainder = sum % 26;
        return (char) ('A' + remainder);

    }
}
