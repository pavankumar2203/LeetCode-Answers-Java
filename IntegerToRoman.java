public class Solution {
    public String intToRoman(int num) {
        /*
            check range
            thousands t
            hundreds h
            tens te
            units u
            print M t times
            switch h:
                case 1 2 3: print C h times
                case 4: print CD
                case 5 6 7 8: print D then print C h-5 times
                case 9: print CM
            switch te:
                case 1 2 3: print X h times
                case 4: print XL
                case 5 6 7 8: print L then print X te-5 times
                case 9: print XC
            switch u:
                case 1 2 3: print I u times
                case 4: print IV
                case 5 6 7 8: print V then print I u-5 times
                case 9: print IX
        */
        if(num < 1 || num > 3999) {
            throw new IllegalArgumentException("illegal arg");
        }
        int t = num / 1000;
        int h = (num % 1000) / 100;
        int te = (num % 100) / 10;
        int u = num % 10;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < t; i++) {
            sb.append("M");
        }
        switch(h) {
            case 1: sb.append("C"); break;
            case 2: sb.append("CC"); break;
            case 3: sb.append("CCC"); break;
            case 4: sb.append("CD"); break;
            case 5: sb.append("D"); break;
            case 6: sb.append("DC"); break;
            case 7: sb.append("DCC"); break;
            case 8: sb.append("DCCC"); break;
            case 9: sb.append("CM"); break;
            default: break;
        }
        switch(te) {
            case 1: sb.append("X"); break;
            case 2: sb.append("XX"); break;
            case 3: sb.append("XXX"); break;
            case 4: sb.append("XL"); break;
            case 5: sb.append("L"); break;
            case 6: sb.append("LX"); break;
            case 7: sb.append("LXX"); break;
            case 8: sb.append("LXXX"); break;
            case 9: sb.append("XC"); break;
            default: break;
        }
        switch(u) {
            case 1: sb.append("I"); break;
            case 2: sb.append("II"); break;
            case 3: sb.append("III"); break;
            case 4: sb.append("IV"); break;
            case 5: sb.append("V"); break;
            case 6: sb.append("VI"); break;
            case 7: sb.append("VII"); break;
            case 8: sb.append("VIII"); break;
            case 9: sb.append("IX"); break;
            default: break;
        }
        
        return sb.toString();
    }
}
