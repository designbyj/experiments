import java.util.ArrayList;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SquargController {

        @FXML
        Pane pane;
        private int size = 450;
        private int spots = 3;
        private int squareSize = size / spots;
        private int count = 0;
        private int turn = 1000;
        private int iter = 0;
        private boolean gameCont = true;
        private String winner;
        ArrayList<Rect> rec = new ArrayList<>();

        @FXML
        public void initialize() {
            System.out.println("Первый ход длеает компьютер, нажмите ЛКМ в любую область");

            for(int i = 0; i < size; i += squareSize) {
                for(int j = 0; j < size; j += squareSize) {
                    Rectangle r = new Rectangle();
                    Rect rect = new Rect(i, j, squareSize, r);
                    r.setFill(Color.WHITE);
                    r.setStroke(Color.BLACK);
                    pane.getChildren().add(r);
                    rect.draw();
                    rec.add(count, rect);
                    ++count;

                    r.setOnMouseClicked((e) -> {
                        if (gameCont == true && iter < 9) {
                            int colorCheck = 0;

                            if (turn % 2 == 0) {
                                System.out.println("Ход длеает игрок, нажмите ЛКМ в любую доступную область");
                                colorCheck = artificialIntelligence();
                                //colorCheck = rect.setColor(Color.RED); - Код для pvp режима
                            } else if (turn % 2 == 1) {
                                System.out.println("Ход длеает компьютер, нажмите ЛКМ в любую область");
                                colorCheck = rect.setColor(Color.GREEN);
                            }

                            if (colorCheck == 0) {
                                --turn;
                                ++iter;
                            }
                            // чек по цвету проверяет былы изменен цвет относительно исходного
                            // и не включает в счетчик повторные нажатия в занятую область
                            // если цвет изменен сокращается количество ходов (для отслеживания того кто делает ход)
                            // и увеличивается количество итераций цикла для (для включения проверки на победителя после 4го хода)

                            if (iter >= 4) {
                                gameContinue();
                            }

                        } else if (gameCont == false && iter <= 9) {
                            winner = turn % 2 == 1 ? "искусственный интеллект" : "игрок";
                            System.out.printf("Победил %s \n", winner);
                        } else {
                            System.out.println("Победитель не выявлен, закончились свободные секторы");
                        }
                    });
                }
            }

        }

        public void gameContinue() {
            if (rec.get(0).getColor().equals(rec.get(1).getColor())
                    && rec.get(2).getColor().equals(rec.get(1).getColor())
                    && !rec.get(1).getColor().equals("0xffffffff")) {
                gameCont = false;
            }

            if (rec.get(3).getColor().equals(rec.get(4).getColor())
                    && rec.get(5).getColor().equals(rec.get(4).getColor())
                    && !rec.get(4).getColor().equals("0xffffffff")) {
                gameCont = false;
            }

            if (rec.get(6).getColor().equals(rec.get(7).getColor())
                    && rec.get(8).getColor().equals(rec.get(7).getColor())
                    && !rec.get(7).getColor().equals("0xffffffff")) {
                gameCont = false;
            }

            if (rec.get(0).getColor().equals(rec.get(3).getColor())
                    && rec.get(6).getColor().equals(rec.get(3).getColor())
                    && !rec.get(3).getColor().equals("0xffffffff")) {
                gameCont = false;
            }

            if (rec.get(1).getColor().equals(rec.get(4).getColor())
                    && rec.get(7).getColor().equals(rec.get(4).getColor())
                    && !rec.get(4).getColor().equals("0xffffffff")) {
                gameCont = false;
            }

            if (rec.get(2).getColor().equals(rec.get(5).getColor())
                    && rec.get(8).getColor().equals(rec.get(5).getColor())
                    && !rec.get(5).getColor().equals("0xffffffff")) {
                gameCont = false;
            }

            if (rec.get(0).getColor().equals(rec.get(4).getColor())
                    && rec.get(8).getColor().equals(rec.get(4).getColor())
                    && !rec.get(4).getColor().equals("0xffffffff")) {
                gameCont = false;
            }

            if (rec.get(6).getColor().equals(rec.get(4).getColor())
                    && rec.get(2).getColor().equals(rec.get(4).getColor())
                    && !rec.get(4).getColor().equals("0xffffffff")) {
                gameCont = false;
            }

        }

        public int artificialIntelligence() {
            int colorCheck = 0;

            while(gameCont == true) {
                int rand = (int)(Math.random() * 9);
                if (rec.get(rand).getColor().equals("0xff0000ff")
                        || rec.get(rand).getColor().equals("0x008000ff")) {
                } else {
                    colorCheck = rec.get(rand).setColor(Color.RED);
                    break;
                }
            }

            return colorCheck;
        }

    }

