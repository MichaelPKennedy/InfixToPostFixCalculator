
public class AnyStack<ItemType> {
	ItemType[] stack;
	int sp;      //stack pointer
	

	// This section is the operator Stack
	public AnyStack(int maxSize) {      //this constructor method creates the stack, which is a char Array
		stack = (ItemType[])new Object[maxSize];
		sp= -1;

	}

	public void push(ItemType item) { //this method pushes an item onto the stack
		if(sp>=stack.length-1) {
			System.out.println("ERROR!! Stack Overflow");
			System.exit(1);
		}
		stack[++sp] = item;
	}

	public ItemType pop() throws Exception { //this method pops an item off of the stack
		if (empty()) {
			throw(new MyException("Stack underflow. sp= " +sp));
		}
		
		return stack[sp--];
	}
	public ItemType peek() { //this method peaks at the top of the stack
		if (empty()) {
			return (ItemType)((Character)('<'));
		}
		return stack[sp];
	}
	public boolean empty() {
		return sp<0;
	}
}
