package battleship;

public enum Cell {

    FOG, O, X, M;

    @Override
    public String toString() {
        return this.equals(FOG) ? "~" : this.equals(O) ? "O" : this.equals(X) ? "X" : "M";
    }

}
