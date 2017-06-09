package stack;

import sort.BankAccount;

public class DemoStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(12);
        stack.push(8);
        stack.push(22);
        stack.push(29);
        stack.push(13);
        stack.pop();
        for (Integer i: stack) {
            System.out.print(i + " ");
        }
        System.out.println("");

        ArrayStack<String> stacks = new ArrayStack<String>();
        stacks.push("g");
        stacks.push("n");
        stacks.push("a");
        stacks.push("h");
        stacks.push("t");
        stacks.push("asf");
        stacks.pop();

        for (Object s: stacks) {
            System.out.print(s + " ");
        }
        System.out.println("");

        Stack<BankAccount> arrayStack = new Stack<BankAccount>();
        arrayStack.push(new BankAccount(12000));
        arrayStack.push(new BankAccount(12202));
        arrayStack.push(new BankAccount(22000));
        arrayStack.push(new BankAccount(8000));
        arrayStack.push(new BankAccount(16000));
        for (BankAccount bankAccount: arrayStack) {
            System.out.print(bankAccount.getBalance() + " ");
        }
    }
}
