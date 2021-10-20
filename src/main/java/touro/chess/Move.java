package touro.chess;

import java.util.Objects;

public class Move {

    private final Location from;
    private final Location to;

    /**
     * Only the Knight can jump over other pieces. Every other piece moves in a straight line.
     */
    private final boolean jump;

    /**
     * Specifies that this move can only be done to capture another piece (Pawn moving diagonally)
     */
    private final boolean captureOnly;

    private final boolean isCastle;

    public Move(Location from,
                Location to,
                boolean jump) {
        this(from, to, jump, false);
    }

    public Move(
            Location from,
            Location to,
            boolean jump,
            boolean captureOnly) {
        this.from = from;
        this.to = to;
        this.jump = jump;
        this.captureOnly = captureOnly;
        isCastle = false;
    }

    public Move(Location from,
                Location to,
                boolean jump,
                boolean captureOnly,
                boolean isCastle){
        this.from = from;
        this.to = to;
        this.isCastle = isCastle;
        this.captureOnly = captureOnly;
        this. jump = jump;
    }

    public Location getFrom() {
        return from;
    }

    public Location getTo() {
        return to;
    }

    public boolean isJump() {
        return jump;
    }

    public boolean isCaptureOnly() {
        return captureOnly;
    }

    public boolean isCastle() {return isCastle;}

    @Override
    public String toString() {
        return "Move{" +
                "from=" + from +
                ", to=" + to +
                ", jump=" + jump +
                ", captureOnly=" + captureOnly +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return jump == move.jump && captureOnly == move.captureOnly && from.equals(move.from) && to.equals(move.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, jump, captureOnly);
    }
}
