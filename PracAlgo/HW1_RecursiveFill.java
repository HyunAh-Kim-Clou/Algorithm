package Before;

public class HW1_RecursiveFill {
    static Boolean isOutofIdxBound(char[][] pixelImg, int x, int y) {
        if ((x < 1)||(x > pixelImg[0].length)||(y < 1)||(y > pixelImg.length))
            return true;
        return false;
    }

    // 위치 (x, y)를 색깔 c로 채우는 메소드
    static void fill(char[][] pixelImg, int x, int y, char c) {
        if (isOutofIdxBound(pixelImg, x, y))
            return;

        char value = pixelImg[y-1][x-1];
        pixelImg[y-1][x-1] = c;
        int[][] adjXY = {{x, y-1}, {x+1, y}, {x, y+1}, {x-1, y}};

        for (int i = 0; i < adjXY.length; i++) {
            int adjX = adjXY[i][0];
            int adjY = adjXY[i][1];
            if (!isOutofIdxBound(pixelImg, adjX, adjY)) {
                if (value == pixelImg[adjY - 1][adjX - 1]) {
                    fill(pixelImg, adjX, adjY, c);
                }
            }
        }
    }

    static void printPixelImg(char[][] pixelImg) {
        for (int i = 0; i < pixelImg.length; i++) {
            for (int j = 0; j < pixelImg[i].length; j++)
                System.out.print(pixelImg[i][j]);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char[][] pixelImg = {
                "RGGGRGB".toCharArray(),
                "GRGGRGB".toCharArray(),
                "GGRRGGG".toCharArray(),
                "GGGGGRG".toCharArray(),
                "GBBGGGG".toCharArray(),
                "GBGGBBG".toCharArray(),
                "GGGGBGB".toCharArray(),
                "GGGGGBB".toCharArray()
        };
        printPixelImg(pixelImg);

        fill(pixelImg, 3, 4, 'Y');

        System.out.println(" * fill color on Pixel image : ");
        printPixelImg(pixelImg);
    }
}
