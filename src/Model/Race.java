package Model;

@Deprecated
public class Race {
    private int startX, startY, endX, endY;
    private Organism rabbit;
    private Organism turtle;
    private State state;
    public Race(int sx, int sy, int ex, int ey) {
        startX = sx;
        startY = sy;
        endX = ex;
        endY = ey;
        state = State.RECRUITMENT;
        rabbit = null;
        turtle = null;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getFinishX() {
        return endX;
    }

    public int getFinishY() {
        return endY;
    }

    public State getState() {
        return state;
    }

    public boolean joinRabbit(Organism _rabbit) {
        if (rabbit == null) {
            rabbit = _rabbit;
            return true;
        }

        return false;
    }

    public boolean joinTurtle(Organism _turtle) {
        if (turtle == null) {
            turtle = _turtle;
            return true;
        }

        return false;
    }

    public void updateRace() {
        if (state == State.RACE_END) return;
        if (rabbit == null || turtle == null)
            state = State.RECRUITMENT;
        else if (state == State.RECRUITMENT) {
            state = State.WAITING_FOR_COMPETITOR;
        } else if (state == State.WAITING_FOR_COMPETITOR) {
            if (
                    rabbit.getX() == startX && rabbit.getY() == startY &&
                            turtle.getX() == startX && turtle.getY() == startY) {
                state = State.RACING;
            }
        } else if (state == State.RACING) {
            if (
                    rabbit.getX() == endX && rabbit.getY() == endY &&
                            turtle.getX() == endX && turtle.getY() == endY) {
                state = State.RACE_END;
            }
        }
    }

    public enum State {
        RECRUITMENT,
        WAITING_FOR_COMPETITOR,
        RACING,
        RACE_END
    }
}