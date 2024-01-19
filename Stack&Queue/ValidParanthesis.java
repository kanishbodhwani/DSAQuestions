public static void main(String[] args) {

}

// Min Insertions
// ( should have )) of these
// Input (()))
// Output 1

public int minInsertions(String s) {
    Stack<Character> stack = new Stack<>();
    int count = 0;
    for(int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        if(ch == '(') {
            stack.push(ch);
        } else {
            if(!stack.isEmpty()) {
                if(i+1 < s.length() && s.charAt(i+1) == ')') {
                    stack.pop();
                    i++;
                } else {
                    stack.pop();
                    count += 1;
                }
            } else if(i+1 < s.length() && s.charAt(i+1) == ')') {
                count += 1;
                i++;
            } else {
                count += 2;
            }
        }
    }

    while(!stack.isEmpty()) {
        count += 2;
        stack.pop();
    }
    return count;
}


// Min add to make parenthesis valid
//  Input '(()'
// Output 1

public int minToAdd(String s) {
    Stack<Character> stack = new Stack<>();
    for(char ch: s.toCharArray()) {
        if(ch == ')') {
            if(!stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        } else {
            stack.push(ch);
        }
    }
    return stack.size();
}


// Valid Parenthesis
public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();

    for(char ch: s.toCharArray()) {
        if(ch == '(' || ch == '{' || ch == '[') {
            stack.push(ch);
        } else {
            if(ch == ')') {
                if(stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
            if(ch == '}') {
                if(stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
            if(ch == ']') {
                if(stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}