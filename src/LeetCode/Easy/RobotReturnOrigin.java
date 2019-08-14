package LeetCode.Easy;

public class RobotReturnOrigin {

    public static void main(String[] args) {
        String moves = "UD";
        System.out.println(judgeCircle(moves));
    }

    public static boolean judgeCircle(String moves) {
        int UP = 0, DOWN = 0, LEFT = 0, RIGHT = 0;
        for (int i = 0; i < moves.length(); i++) {
            char move = moves.charAt(i);

            switch(move)
            {
                case 'U': ++UP; break;
                case 'D': ++DOWN; break;
                case 'L': ++LEFT; break;
                case 'R': ++RIGHT; break;
            }
        }

        if (UP == DOWN && LEFT == RIGHT)
            return true;

        return false;
    }
}
