import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class SpaceShootout2 extends JPanel implements ActionListener {

    // Game variables
    private static final int window_width = 800;
    private static final int window_height = 600;

    private static final int ship_width = 15;
    private static final int ship_height = 15;

    private static final int laser_wid = 5;
    private static final int laser_hi = 5;

    private static final int ALIEN_WIDTH = 80;
    private static final int ALIEN_HEIGHT = 20;

    private static int SHIP_SPEED = 10;

    private static final int LASER_SPEED = 15;

    private static int ALIEN_SPEED = 2;

    private static final int MAX_FAILURES = 3;

    private static final int LEVEL_UP_SCORE = 5;

    private Timer timer;
    private int score = 0;
    private int level = 1;
    private int failures = 0;
    private Rectangle ship;
    private Rectangle laser;
    private boolean laserActive = false;
    private Rectangle alien;
    private Random random;
    private boolean gameOver = false;
    private void levelup() {
        if (score / LEVEL_UP_SCORE > level - 1) {
            level++;
            ALIEN_SPEED=ALIEN_SPEED+1;
            SHIP_SPEED=SHIP_SPEED+2;
            // Increase difficulty: faster alien or other game changes can be added here
        }
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (gameOver) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("GAME OVER", window_width / 2 - 150, window_height / 2);
            g.setFont(new Font("Arial", Font.PLAIN, 30));
            g.drawString("Final Score: " + score, window_width / 2 - 100, window_height / 2 + 50);
            return;
        }

        g.setColor(Color.GREEN);
        g.setFont(new Font("Monospaced", Font.BOLD, 20));
        g.drawString("{M}", ship.x + ship_width / 4, ship.y + ship_height / 2 + 5);

        if (laserActive) {
            g.setColor(Color.RED);
            g.drawString(".", laser.x + laser_wid / 2, laser.y + laser_hi);
        }

        g.setColor(Color.BLUE);
        g.drawString("<A>", alien.x + ALIEN_WIDTH / 4, alien.y + ALIEN_HEIGHT / 2 + 5);

        g.setColor(Color.BLUE);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("SCORE " + String.format("%05d", score), 10, 20);
        g.drawString("LEVEL " + level, window_width - 120, 20);
        g.drawString("LIVES " + (MAX_FAILURES - failures), 10, 50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) return;

        if (laserActive) {
            laser.y -= LASER_SPEED;
            if (laser.y < 0) {
                laserActive = false;
            }
            if (laser.intersects(alien)) {
                score += 125;
                laserActive = false;
                alien.setLocation(random.nextInt(window_width - ALIEN_WIDTH), 50);
                levelup();
            }
        }

        alien.y += ALIEN_SPEED;
        if (alien.y > window_height) {
            alien.setLocation(random.nextInt(window_width - ALIEN_WIDTH), 50);
            failures++;
            if (failures >= MAX_FAILURES) {
                gameOver = true;
            }
        }

        repaint();
    }


    public SpaceShootout2() {
        this.setPreferredSize(new Dimension(window_width, window_height));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (gameOver) return;

                int key = e.getKeyCode();
                if (key == KeyEvent.VK_LEFT && ship.x > 0) {
                    ship.x -= SHIP_SPEED; // move left
                }
                if (key == KeyEvent.VK_RIGHT && ship.x < window_width - ship_width) {
                    ship.x += SHIP_SPEED; // move right
                }
                if (key == KeyEvent.VK_SPACE && !laserActive) {
                    laser = new Rectangle(ship.x + ship_width / 2 - laser_wid / 2, ship.y - laser_hi, laser_wid, laser_hi); // x position is mid of the ship, y position is at the ship height
                    laserActive = true;
                }
            }
        });

        random = new Random();
        ship = new Rectangle(window_width / 2 - ship_width / 2, window_height - ship_height - 10, ship_width, ship_height);
        laser = new Rectangle(-10, -10, laser_wid, laser_hi);
        alien = new Rectangle(random.nextInt(window_width - ALIEN_WIDTH), 50, ALIEN_WIDTH, ALIEN_HEIGHT); // x is random and y is fixed at 50 while they spawn

        timer = new Timer(30, this); // delay of 30 ms
        timer.start();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Space Shootout");
        SpaceShootout2 game = new SpaceShootout2();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
