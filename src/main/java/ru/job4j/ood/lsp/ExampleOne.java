package ru.job4j.ood.lsp;

public class ExampleOne {
    private int count;

    public ExampleOne(int sum) {
        this.count = sum;
    }

    public int getCount() {
        return count;
    }

    public boolean isGifted(int count) {
        return count > 1;
    }

    public class InternetShop extends ExampleOne {
        public InternetShop(int count) {
            super(count);
        }

        @Override
        public boolean isGifted(int count) {
            return count > 10;
        }
    }
}

/*
   Усиление предусловия в подклассе.
*/
