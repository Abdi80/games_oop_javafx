package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int startX = position.getX();
        int startY = position.getY();
        int finishX = dest.getX();
        int size = Math.max(startX, finishX) - Math.min(startX, finishX);
        Cell[] steps = new Cell[size];
        int deltaX = startX <= finishX ? 1 : -1;
        int deltaY = startY <= dest.getY() ? 1 : -1;
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(startX + (index + 1) * deltaX,
                                        startY + (index + 1) * deltaY);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int maxX = Math.max(source.getX(), dest.getX());
        int minX = Math.min(source.getX(), dest.getX());
        int maxY = Math.max(source.getY(), dest.getY());
        int minY = Math.min(source.getY(), dest.getY());
        return (maxX - minX) == (maxY - minY);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
