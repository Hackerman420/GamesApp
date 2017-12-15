package com.example.bleitzel.gamesapp.TicTacToeFolder;

import android.os.Bundle;

/**
 * Created by nvoorstad on 12/5/2017.
 */

public class TicTacToeBoard {


    public static class Board
    {

        private Player[][] board;

        public Board ()
        {
            board = new Player[3][3];
        }
        public Player getPlayerAtPosition(int[] position)
        {
            if (
                    position[0] < board.length
                            && position[1] < board[position[0]].length
                    )
            {
                return board[position[0]][position[1]];
            }
            else
            {
                return null;
            }
        }

        private boolean setPlayerAtPosition(Player player, int[] position)
        {
            if (
                    position[0] < board.length
                            && position[1] < board[position[0]].length
                    )
            {
                board[position[0]][position[1]] = player;
                return true;
            }
            else
            {
                return false;
            }
        }
        public boolean move(sPlayer player, int[] position)
        {
            // Checks if position is already taken.
            if ( getPlayerAtPosition(position) == null)
            {
                return setPlayerAtPosition(player, position);
            }
            else
            {
                return false;
            }
        }

        public Board clone()
        {
            Board clone = new Board();
            for (int x=0; x<3; x++)
            {
                for (int y=0; y<3; y++)
                {
                    int[] pos = { x, y };
                    Player curr = getPlayerAtPosition(pos);
                    clone.move((sPlayer) curr, pos);
                }
            }

            return clone;
        }

        public boolean isFull()
        {
            boolean full = true;
            for (int x=0; x<3; x++)
            {
                for (int y=0; y<3; y++)
                {
                    int[] pos = { x, y };
                    Player curr = getPlayerAtPosition(pos);
                    if(curr==null)
                    {
                        // Empty spot
                        full=false;
                        break;
                    }
                }
                if (!full)
                {
                    break;
                }
            }
            return full;
        }
    }
}
