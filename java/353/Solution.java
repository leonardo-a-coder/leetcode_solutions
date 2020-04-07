public class SnakeGame {
    private int width;
    private int height;
    private int[][] food;
    private int foodIndex;
    private boolean isOver;
    private Deque<Integer> snake;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        snake = new LinkedList<>();
        snake.add(0);
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if (isOver) {
            return -1;
        }
        int head = snake.getLast();
        int i = head / width;
        int j = head % width;
        switch (direction) {
            case "U":
                i--;
                break;
            case "L":
                j--;
                break;
            case "R":
                j++;
                break;
            case "D":
                i++;
                break;
            default:
                throw new IllegalArgumentException("Invalid move:" + direction);
        }
        if (i < 0 || i == height || j < 0 || j == width) {
            isOver = true;
            return -1;
        }
        head = i * width + j;
        if (foodIndex < food.length && food[foodIndex][0] == i && food[foodIndex][1] == j) {
            foodIndex++;
        } else {
            snake.poll();
            if (snake.contains(head)) {
                isOver = true;
                return -1;
            }
        }
        snake.add(head);
        return snake.size() - 1;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
