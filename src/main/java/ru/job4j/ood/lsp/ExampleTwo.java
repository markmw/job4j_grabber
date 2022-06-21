package ru.job4j.ood.lsp;

public class ExampleTwo {
    private int sum;

    public ExampleTwo(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }

    public int discount() {
        if (sum > 1000) {
            sum -= 200;
        }
        return sum;
    }

    public class Outlet extends ExampleTwo {
        public Outlet(int sum) {
            super(sum);
        }

        @Override
        public int discount() {
            return getSum();
        }
    }
}

/*
   Ослабление постусловия в подклассе.
*/
