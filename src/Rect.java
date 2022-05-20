import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Rect {
        private int size;
        private int cordX;
        private int cordY;
        private Rectangle r;

        public Rect(int cordX, int cordY, int size, Rectangle r) {
            this.cordX = cordX;
            this.cordY = cordY;
            this.size = size;
            this.r = r;
        }

        public int getCordX() {
            return cordX;
        }

        public void setCordX(int cordX) {
            this.cordX = cordX;
        }

        public int getCordY() {
            return cordY;
        }

        public void setCordY(int cordY) {
            this.cordY = cordY;
        }

        public int setColor(Color color) {
            if (r.getFill().equals(Color.GREEN)) {
                System.out.println("Здесь установлен зеленый цвет");
                return 1;
            } else if (r.getFill().equals(Color.RED)) {
                System.out.println("Здесь установлен красный цвет");
                return 2;
            } else {
                r.setFill(color);
                return 0;
            }
        }

        public String getColor() {
            return r.getFill().toString();
        }

        public void draw() {
            r.setHeight(size);
            r.setWidth(size);
            r.setX(cordX);
            r.setY(cordY);
        }
    }


