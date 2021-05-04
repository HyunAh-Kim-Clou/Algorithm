public class HashCode {
    int[] convertInts(String str) {
        int[] asciiArray = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            asciiArray[i] = Integer.valueOf(str.charAt(i));
        }
        return asciiArray;
    }

    // 최적화 고민
    int getHashcode(String target, int a) {
        int hashcode = 0;
        int[] ch = convertInts(target);

        // case: len 1
        if (target.length() == 1) {
            return target.charAt(0);
        }
        // case:  len 2
        for (int i = 1; i < target.length(); i++) {
            // 0[2] + a ( 82[1] + a*81[0])
            if (i > 1) {
                hashcode = ch[i] + a * hashcode;
            } else {
                hashcode = (ch[i] + a * ch[i-1]);
            }
        }

        if (hashcode < 0) {
            String tmp = ((String[]) target.split(" "))[0];
            hashcode = getHashcode(tmp, a);
        }

        return hashcode;
    }

    int[] getHashcode(String[] target, int a) {
        int[] hcodes = new int[target.length];
        for (int i = 0; i < target.length; i++) {
            hcodes[i] = getHashcode(target[i], a);
        }
        return hcodes;
    }

}
