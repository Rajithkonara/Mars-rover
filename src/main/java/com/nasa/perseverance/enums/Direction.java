package com.nasa.perseverance.enums;

import lombok.Getter;

@Getter
public enum Direction {

    N(0, 1) {
        @Override
        public Direction left() {
            return W;
        }

        @Override
        public Direction right() {
            return E;
        }
    },

    E(1, 0) {
        @Override
        public Direction right() {
            return S;
        }

        @Override
        public Direction left() {
            return N;
        }
    },

    S(0, -1) {
        @Override
        public Direction right() {
            return W;
        }

        @Override
        public Direction left() {
            return E;
        }
    },

    W(-1, 0) {
        @Override
        public Direction right() {
            return N;
        }

        @Override
        public Direction left() {
            return S;
        }
    };

    public abstract Direction right();

    public abstract Direction left();

    private final int positionOnX;
    private final int positionOnY;

    Direction(int positionOnX, int positionOnY) {
        this.positionOnX = positionOnX;
        this.positionOnY = positionOnY;
    }
}
