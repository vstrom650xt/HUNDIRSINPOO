package logic;

import tools.Screen;

/**
 * Do not modify any sentence
 * This class load all the necessary variables ,metods and functions to make the program work
 */
public class Game {

    public static char[][] playerBoard = Board.createBoard();
    public static char[][] pcBoard = Board.createBoard();
    public static char[][] PlayerShotsBoard = Board.createBoard();
    public static char[][] pcShotsBoard = Board.createBoard();
    public static int[][] shipsPlayer;
    public static int[][] shipsPc;
    public static String name = Player.getUser();

    /**
     * this metod make the program run
     * */

    public static void start() {
        int playerHealth, enemyHealth;

        System.out.println(" WELCOME TO SINK THE FLOAT " + name.toUpperCase() + " >\n" +
                " ---------------------------\n" +
                "     \\\n" +
                "      \\\n" +
                "          oO)-.                       .-(Oo\n" +
                "         /__  _\\                     /_  __\\\n" +
                "         \\  \\(  |     ()~()         |  )/  /\n" +
                "          \\__|\\ |    (-___-)        | /|__/\n" +
                "          '  '--'    ==`-'==        '--'  '\n ");

        System.out.println(" ---------------------------\n");
        System.out.println(" ---------------------------\n");
        System.out.println();
        System.out.println();
        Board.viewBoards(playerBoard, PlayerShotsBoard, pcBoard, pcShotsBoard);
        System.out.println();
        shipsPlayer = Ship.crearBarcos();
        playerHealth = Ship.totalVidas(shipsPlayer);
        enemyHealth = playerHealth;
        shipsPc = Pc.copyArry(shipsPlayer);
        Player.putShip(playerBoard, shipsPlayer);
        Pc.putPcShip(pcBoard, shipsPc);
        System.out.println();
        System.out.println();
        Board.viewBoards(playerBoard, PlayerShotsBoard, pcBoard, pcShotsBoard);
        System.out.println();
        System.out.println();
        Game.shoots(playerHealth, enemyHealth);
    }

    /**
     *
     * This method is used to make the shooting turns, it makes the program finish when the enemy´s
     * health or the player´s health end.
     *
     * @param playerHealth number of lifes
     * @param enemyHealth number of lifes
     * */
    public static void shoots(int playerHealth, int enemyHealth) {

        do {
            System.out.println("your turn");
       //     Board.viewBoards(playerBoard, PlayerShotsBoard, pcBoard, pcShotsBoard);
            if (Player.shootPlayer(PlayerShotsBoard, pcBoard, enemyHealth)) {
                enemyHealth--;
            }
            System.out.println();
            Screen.clear();
            System.out.println("-------------------------------------------------------------------------------");
            System.out.println();
            if (Pc.shootPc(pcShotsBoard, playerBoard, playerHealth)) {
                playerHealth--;
            }
            Board.viewBoards(playerBoard, PlayerShotsBoard, pcBoard, pcShotsBoard);
            if (playerHealth == 0) {
                System.out.println("""
                         __________
                        < YOU LOSE >
                         ----------
                         \\                   .,
                           \\         .      .TR   d'
                             \\      k,l    .R.b  .t .Je
                               \\   .P q.   a|.b .f .Z%
                                   .b .h  .E` # J: 2`     .
                              .,.a .E  ,L.M'  ?:b `| ..J9!`.,
                               q,.h.M`   `..,   ..,""` ..2"`
                               .M, J8`   `:       `   3;
                           .    Jk              ...,   `^7"90c.
                            j,  ,!     .7"'`j,.|   .n.   ...
                           j, 7'     .r`     4:      L   `...
                          ..,m.      J`    ..,|..    J`  7TWi
                          ..JJ,.:    %    oo      ,. ....,
                            .,E      3     7`g.M:    P  41
                           JT7"'      O.   .J,;     ``  V"7N.
                           G.           ""Q+  .Zu.,!`      Z`
                           .9.. .         J&..J!       .  ,:
                              7"9a                    JM"!
                                 .5J.     ..        ..F`
                                    78a..   `    ..2'
                                        J9Ksaw0"'
                                       .EJ?A...a.
                                       q...g...gi
                                      .m...qa..,y:
                                      .HQFNB&...mm
                                       ,Z|,m.a.,dp
                                    .,?f` ,E?:"^7b
                                    `A| . .F^^7'^4,
                                     .MMMMMMMMMMMQzna,
                                 ...f"A.JdT     J:    Jp,
                                  `JNa..........A....af`
                                       `^^^^^'`
                        """);
            } else if (enemyHealth == 0) {
                System.out.println("""
                         _________
                        < YOU WON >
                         ---------
                         \\                   .,
                           \\         .      .TR   d'
                             \\      k,l    .R.b  .t .Je
                               \\   .P q.   a|.b .f .Z%
                                   .b .h  .E` # J: 2`     .
                              .,.a .E  ,L.M'  ?:b `| ..J9!`.,
                               q,.h.M`   `..,   ..,""` ..2"`
                               .M, J8`   `:       `   3;
                           .    Jk              ...,   `^7"90c.
                            j,  ,!     .7"'`j,.|   .n.   ...
                           j, 7'     .r`     4:      L   `...
                          ..,m.      J`    ..,|..    J`  7TWi
                          ..JJ,.:    %    oo      ,. ....,
                            .,E      3     7`g.M:    P  41
                           JT7"'      O.   .J,;     ``  V"7N.
                           G.           ""Q+  .Zu.,!`      Z`
                           .9.. .         J&..J!       .  ,:
                              7"9a                    JM"!
                                 .5J.     ..        ..F`
                                    78a..   `    ..2'
                                        J9Ksaw0"'
                                       .EJ?A...a.
                                       q...g...gi
                                      .m...qa..,y:
                                      .HQFNB&...mm
                                       ,Z|,m.a.,dp
                                    .,?f` ,E?:"^7b
                                    `A| . .F^^7'^4,
                                     .MMMMMMMMMMMQzna,
                                 ...f"A.JdT     J:    Jp,
                                  `JNa..........A....af`
                                       `^^^^^'`
                        """);
            }
        } while (playerHealth != 0 && enemyHealth != 0);
    }
}
