package stacks;

public class Demo {
    public static void main(String[] args) {
        StackOfString arrayStack = new ArrayStack();
        arrayStack.push("Bui");
        arrayStack.push("Manh");
        arrayStack.push("Thang");
        arrayStack.push("ETSP");
        arrayStack.pop();
        System.out.println(arrayStack.toString());

        StackOfString linkListStack = new LinkedListStack();
        linkListStack.push("Nghe");
        linkListStack.push("Cong");
        linkListStack.push("Hoc");
        linkListStack.push("Dai");
        linkListStack.push("Truong");
        linkListStack.push("Ha noi");
        linkListStack.pop();
        System.out.println(linkListStack.toString());
    }
}
