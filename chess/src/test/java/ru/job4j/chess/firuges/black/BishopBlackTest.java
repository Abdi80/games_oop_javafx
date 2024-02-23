package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import static org.assertj.core.api.Assertions.assertThat;


class BishopBlackTest {

    @Test
    void whenPositionC8() {
        Cell cell = Cell.C1;
        BishopBlack bishopBlack = new BishopBlack(cell);
        assertThat(bishopBlack.position()).isEqualTo(cell);
    }

    @Test
    void whenCopy() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell newPosition = Cell.A3;
        Figure copyBishopBlack = bishopBlack.copy(newPosition);
        assertThat(copyBishopBlack.position()).isEqualTo(newPosition);

    }

    @Test
    void whenWayC1G5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell[] way = bishopBlack.way(Cell.G5);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        assertThat(way).isEqualTo(expected);
    }

    @Test
    void whenWayG5C1() {
        BishopBlack bishopBlack = new BishopBlack(Cell.G5);
        Cell[] way = bishopBlack.way(Cell.C1);
        Cell[] expected = {Cell.F4, Cell.E3, Cell.D2, Cell.C1};
        assertThat(way).isEqualTo(expected);
    }

    @Test
    void whenWayF4D6() {
        BishopBlack bishopBlack = new BishopBlack(Cell.F4);
        Cell[] way = bishopBlack.way(Cell.D6);
        Cell[] expected = {Cell.E5, Cell.D6};
        assertThat(way).isEqualTo(expected);
    }

    @Test
    void whenWayB5F1() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B5);
        Cell[] way = bishopBlack.way(Cell.F1);
        Cell[] expected = {Cell.C4, Cell.D3, Cell.E2, Cell.F1};
        assertThat(way).isEqualTo(expected);
    }




}