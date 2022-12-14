import java.util.Scanner;

public class InfixToPostfixConverter {

	public static void main(String[] args) {
		String inputEquation;                           //this is for the equation that the user enters 
		String postFix = ""; 							//this will be where the postFix equation will go
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Input your infix expression here: ");
		inputEquation= keyboard.nextLine();
		AnyStack <Character> operators = new AnyStack<Character>(inputEquation.length()); //create a Char stack to hold the operators 
		keyboard.close();
		String tempString = "";     // this is a temporary holding place for any numbers until a space or another operator is reached. This will be added to postFix String whenever the end of a number is reached 
		String tempString2 = "";
		
		System.out.println("Infix expression: " + inputEquation);
		for (int i=0; i<inputEquation.length(); i++) {         //this loop checks every index of the infix expression String one at a time 
			char peek = ' ';
			char secondPeek = ' ';
			switch(inputEquation.charAt(i)) {          //switch statement checks every case for the current index of the infix expression 
				
			 case ' ':                      //if a space is encountered, it will break out of the loop 
				 postFix += tempString;
				 tempString = "";
				 break;
			 
			
			 
			 case '(':
				 postFix += tempString;
				 postFix += " ";
				 tempString = "";
				 operators.push('(');
				 break;
				 
			 case '*':
				 postFix += tempString;
				 postFix += " ";
				 tempString = "";
				 peek = operators.peek();
				 if (peek == '*'|| peek == '/') {
					 postFix+= operators.pop();
					 secondPeek = operators.peek();              //after the operator is popped, the program peeks at the stack again to see if the operator below in the stack is of higher or equal value 
					 if (secondPeek == '*'|| secondPeek == '/') {
						 postFix+= operators.pop();
						 operators.push('*');
					 }else if (secondPeek == '(' || secondPeek == '+' || secondPeek == '-') {
						 operators.push('*');
					 }else if (secondPeek == '<') {
						 operators.push('*');
					 }	 
				 }else if (peek == '(' || peek == '+' || peek == '-') {
					 operators.push('*');
				 }else if (peek == '<') {
					 operators.push('*');
				 }
				 break;
			
			 case '/':
				 postFix += tempString;
				 postFix += " ";
				 tempString = "";
				 peek = operators.peek();
				 if (peek == '*'|| peek == '/') {
					 postFix+= operators.pop();
					 secondPeek = operators.peek();
					 if (secondPeek == '*'|| secondPeek == '/') {
						 postFix+= operators.pop();
						 operators.push('/');
					 }else if (secondPeek == '(' || secondPeek == '+' || secondPeek == '-') {
						 operators.push('/');
					 }else if (secondPeek == '<') {
						 operators.push('/');
					 }
				 }else if (peek == '(' || peek == '+' || peek == '-') {
					 operators.push('/');
				 }else if (peek == '<') {
					 operators.push('/');
				 }
				 break;
				 
			 case '+':
				 postFix += tempString;
				 postFix += " ";
				 tempString = "";
				 peek = operators.peek();
				 if (peek == '+' || peek == '-' || peek == '/' || peek == '*') {
					 postFix+= operators.pop();
					 secondPeek = operators.peek();
					 if (secondPeek == '+' || secondPeek == '-' || secondPeek == '/' || secondPeek == '*') {
						 postFix+= operators.pop();
						 operators.push('+');
					 }else if (secondPeek == '(') {
						 operators.push('+');
					 }else if (secondPeek == '<') {
						 operators.push('+');
					 }
				 }else if (peek == '(') {
					 operators.push('+');
				 }else if (peek == '<') {
					 operators.push('+');
				 }
				 break;
				 
			 case '-':
				 postFix += tempString;
				 postFix += " ";
				 tempString = "";
				 peek = operators.peek();
				 if (peek == '+' || peek == '-' || peek == '/' || peek == '*') {
					 postFix+= operators.pop();
					 secondPeek = operators.peek();
					 if (secondPeek == '+' || secondPeek == '-' || secondPeek == '/' || secondPeek == '*') {
						 postFix+= operators.pop();
						 operators.push('-');
					 }else if (secondPeek == '(') {
						 operators.push('-');
					 }else if (secondPeek == '<') {
						 operators.push('-');
					 }
				 }else if (peek == '(') {
					 operators.push('-');
				 }else if (peek == '<') {
					 operators.push('-');
				 }
				 break;
				 
			 case ')':						// this case will continue to pop operators off of the operator stack until it finds an opening parenthesis 
				 postFix += tempString;
				 postFix += " ";
				 tempString = "";
				 while (!operators.empty()) {
					peek = operators.peek();
				if (peek =='(') {
					operators.pop();
					break;
				}else postFix += operators.pop();
				}
				break;	 
				 
			 case '0':
				 tempString += '0';
				 break;
			
			 case '1':
				 tempString += '1';	
				 break;
				 
			 case '2':
				 tempString += '2';	 
				 break;
				 
			 case '3':
				 tempString += '3';
				 break;
				 
			 case '4':
				 tempString += '4';	
				 break;
				 
			 case '5':
				 tempString += '5';
				 break;
				 
			 case '6':
				 tempString += '6';
				 break;
				 
			 case '7':
				 tempString += '7';
				 break;
				 
			 case '8':
				 tempString += '8';
				 break;
			 
			 case '9':
				 tempString += '9';
				 break;
				 
			 	 
			}
			
				
				 
		}
		postFix +=tempString;        // This makes sure that any numbers on the very end of the Infix expression are not forgotten
		while (!operators.empty()) {  //this makes sure that all remaining operators in the operator stack are popped on to the end of the postFix expression
		postFix += operators.pop();
		}
		System.out.println("Postfix expression: " + postFix);
		
		AnyStack<Double> numbers = new AnyStack<Double>(postFix.length());//creates new double stack to hold integers
		
		for (int i=0; i<postFix.length(); i++) {   //loop checks through every character in the infix expression one at a time 
			
			
			switch(postFix.charAt(i)) {
			
			case '0':
				 tempString2 += '0';
				 break;
			
			 case '1':
				 tempString2 += '1';	
				 break;
				 
			 case '2':
				 tempString2 += '2';	 
				 break;
				 
			 case '3':
				 tempString2 += '3';
				 break;
				 
			 case '4':
				 tempString2 += '4';	
				 break;
				 
			 case '5':
				 tempString2 += '5';
				 break;
				 
			 case '6':
				 tempString2 += '6';
				 break;
				 
			 case '7':
				 tempString2 += '7';
				 break;
				 
			 case '8':
				 tempString2 += '8';
				 break;
			 
			 case '9':
				 tempString2 += '9';
				 break;
			
			 case ' ':
				 if (tempString2 != "" && tempString != " ") {
				 numbers.push(Double.parseDouble(tempString2));     //pushes the number stored in tempString2 as a whole number. If 9, 6, and then 4 had been stored in tempString2, hitting any non number will cause 964 to be pushed to the stack as a number 
				 }
				 tempString2 = "";
				 break;
				 
			 case '*':
				 if (tempString2 != "" && tempString != " ") {
				 numbers.push(Double.parseDouble(tempString2));
				 }
				 tempString2 = "";
				 double a = numbers.pop();
				 double b = numbers.pop();
				 double c = b*a;              	//after the top two numbers have been popped off the stack, the proper math operation is done and the result is pushed to the stack
				 numbers.push(c);
				 break;
				 
			 case '/':
				 if (tempString2 != "" && tempString != " ") {
				 numbers.push(Double.parseDouble(tempString2));
				 }
				 tempString2 = "";
				 double d = numbers.pop();
				 double e = numbers.pop();
				 double f = e/d;
				 numbers.push(f);
				 break;
				 
			 case '+':
				 if (tempString2 != "" && tempString != " ") {
				 numbers.push(Double.parseDouble(tempString2));
				 }
				 tempString2 = "";
				 double g = numbers.pop();
				 double h = numbers.pop();
				 double j = h+g;
				 numbers.push(j);
				 break;
				 
			 case '-':
				 if (tempString2 != "" && tempString != " ") {
				 numbers.push(Double.parseDouble(tempString2));
				 }
				 tempString2 = "";
				 double k = numbers.pop();
				 double l = numbers.pop();
				 double m = l-k;
				 numbers.push(m);
				 break;
				 
			}
			
		}
		double answer = numbers.pop();             //the answer should be the number left in the stack 
		System.out.println("The answer is " + answer);
	}
		
		
		
		
		



}


 












