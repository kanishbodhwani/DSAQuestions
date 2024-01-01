// O(n) complexity 
// fast and slow pointer - cycle detection
public boolean hasCycle() {
    ListNode fast = head;
    ListNode slow = head; 

    while(fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if(fast == slow) {
            return true;
        }
    }

    return false;
}


// Length of the cycle
public int length() {
    ListNode fast = head;
    ListNode slow = head; 

    while(fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if(fast == slow) {
            // calculate the length
            ListNode temp = slow;
            int length = 0;
            do{
                temp = temp.next;
                length++;
            } while(temp != slow);
            return length;
        }
    }

    return 0;
}


// Where the cycle is starting 
// return the start of the cycle

public ListNode detectCycle(ListNode head) {
    int length = 0;

    ListNode fast = head;
    ListNode slow = head; 

    while(fast != null && fast.next != null) {
        fast = fast.next.next;
        slow = slow.next;
        if(fast == slow) {
            length = lengthCycle(slow);
            break;
        }
    }

    if(length == 0) {
        return null;
    }

    ListNode f = head;
    ListNode s = head;

    while(length > 0) {
        s = s.next;
        length--;
    }

    // keep moving both forward and they will meet at cycle start
    while(f != s) {
        f = f.next;
        s = s.next;
    }

    return s;
}

// Happy Number 
public boolean isHappy(int n) {
    int slow = n;
    int fast = n;

    do {
        slow = findSquare(slow);
        fast = findSquare(findSquare(fast));
    } while(fast != slow)

    if(slow == 1) {
        return true;
    } 
    return false;
}

private int findSquare(int number) {
    int ans = 0;
    while(number > 0){
        int rem = number % 10;
        ans += rem * rem;
        number /= 10; 
    }
    return ans;
}

