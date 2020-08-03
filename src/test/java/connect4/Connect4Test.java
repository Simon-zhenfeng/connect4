package connect4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThrows;

/**
 * @author Simon
 * @date 2020/8/2 21:11
 */
public class Connect4Test {
    private Connect4 connect4;

    @Before
    public void setUp() throws Exception {
        connect4 = new Connect4();
    }

    @Test
    public void when_the_game_is_started_the_board_is_empty() {
        assertThat(connect4.getNumberOfDiscs(), is(0));
    }

    @Test
    public void when_first_disc_insert_in_column_then_position_is_zero() {
        int column = 1;
        assertThat(connect4.putDiscInColumn(column), is(0));

    }

    @Test
    public void when_second_disc_insert_in_column_then_position_is_one() {
        int column = 1;
        connect4.putDiscInColumn(column);
        assertThat(connect4.putDiscInColumn(column), is(1));

    }

    @Test
    public void when_disc_inserted_then_number_of_discs_increases() {
        int column = 1;
        connect4.putDiscInColumn(column);
        assertThat(connect4.getNumberOfDiscs(), is(1));
    }

    @Test(expected = RuntimeException.class)
    public void when_disc_outside_board_then_runtime_exception() {
        int column = -1;
        connect4.putDiscInColumn(column);
    }

    @Test(expected = RuntimeException.class)
    public void when_no_more_room_in_column_then_runtime_exception() {
        int column = 1;
        for (int i = 0; i < Connect4.ROWS; i++) {
            connect4.putDiscInColumn(column);
        }
        connect4.putDiscInColumn(column);
    }
}
