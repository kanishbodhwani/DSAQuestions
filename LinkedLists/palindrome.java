public boolean isPalindrome(ListNode head) {
    ListNode mid = middleNode(head);
    ListNode headSecond = reverse(mid);
    ListNode reReverseHead = headSecond;

    while(head != null && headSecond != null) {
        if(head.value != headSecond.val) {
            break;
        }
        head = head.next;
        headSecond = headSecond.next;
    }
    reverse(reReverseHead);

    if(head == null || headSecond == null) {
        return true;
    } else {
        return false;
    }
}

public ListNode middleNode(ListNode head) {
    ListNode f = head;
    ListNode s = head;

    while(f != null && f.next != null) {
        f = f.next.next;
        s = s.next;
    }

    return s;
}

public void reverse() {
    if(size < 2) {
        return;
    }

    Node prev = null;
    Node present = head;
    Node next = present.next;

    while(present != null) {
        present.next = prev;
        prev = present;
        present = next;
        if(next != null) {
            next = next.next;
        }
    }
    head = prev;
}