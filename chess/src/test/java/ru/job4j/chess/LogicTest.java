package ru.job4j.chess;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.assertj.core.api.Assertions.assertThat;

public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () ->
                                            logic.move(Cell.C1, Cell.H6));
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    public void whenMoveThenImpossibleMoveException()
            throws ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        ImpossibleMoveException exception = assertThrows(ImpossibleMoveException.class, () ->
                                            logic.move(Cell.C1, Cell.H2));
        assertThat(exception.getMessage()).isEqualTo(String.format(
                "Could not way by diagonal from %s to %s", Cell.C1, Cell.H2));
    }

    @Test
    public void whenMoveThenOccupiedCellException()
            throws ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.add(new BishopBlack(Cell.D2));
        OccupiedCellException exception = assertThrows(OccupiedCellException.class, () ->
                                            logic.move(Cell.C1, Cell.H6));
        assertThat(exception.getMessage()).isEqualTo("The Way Is Not Clear");
    }
 }