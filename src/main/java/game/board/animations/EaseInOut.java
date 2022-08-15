package game.board.animations;

public class EaseInOut implements Animation
{
    public double getTransition(double value, double duration)
    {
        return value < duration / 2 ? 4 * value * value * value : 1 - Math.pow(-2 * value + 2, 3) / 2;
    }
}